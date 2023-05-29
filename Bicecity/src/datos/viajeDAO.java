/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import conexion.Excepcion;
import conexion.Servidor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import logica.Cuenta;
import logica.Viaje;
import datos.usuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author rdmon
 */
public class viajeDAO {
    
    

    public Viaje obtenerViaje(int idViaje) throws Excepcion {
        Viaje viaje = new Viaje();
        try {

            String strSQL = "SELECT * FROM viaje JOIN cuenta ON viaje.k_codigo=cuenta.k_codigo WHERE k_idviaje=?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, idViaje);

            ResultSet resultSet = prepStmt.executeQuery();

            if (resultSet.next()) {
                viaje.setIdViaje(idViaje);
                viaje.setCosto(resultSet.getInt("v_costo"));
                viaje.setDuracion(resultSet.getInt("v_costo"));
                viaje.setHoraF(resultSet.getString("o_horafinal"));
                viaje.setHoraI(resultSet.getString("o_horainicial"));
                viaje.setMinAd(resultSet.getInt("o_minadicional"));
                // Procesar el valor entero
            }
            prepStmt.close();
        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo obtener el id " + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }

        //ponerle plan asociado a la cuenta
        return viaje;
    }
        public ArrayList<Viaje> obtenerListaViajes(Cuenta cuenta) throws Excepcion {

        ArrayList<Viaje> arr= new ArrayList<>();
        try {

            String strSQL = "SELECT * FROM viaje Where k_codigo=? ;";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, cuenta.getCodigo());

            ResultSet resultSet = prepStmt.executeQuery();

             while (resultSet.next()) {
                 Viaje viaje = new Viaje();
                 viaje.setCosto(resultSet.getInt("v_costo"));
                 viaje.setDuracion(resultSet.getInt("o_duracion"));
                 viaje.setHoraF(resultSet.getString("o_horafinal"));
                 viaje.setHoraI(resultSet.getString("o_horainicial"));
                 viaje.setIdViaje(resultSet.getInt("k_idviaje"));
                 viaje.setMinAd(resultSet.getInt("o_minadicional"));
                arr.add(viaje);
            }
            prepStmt.close();
        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo obtener el historial " + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }

        //ponerle plan asociado a la cuenta
        return arr;
    }

    public int contarViajes() throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT COUNT(*) FROM viaje";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No se pudo contar los viajes" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }

    public int incluirViajeDesbloqueo(Cuenta cuenta) throws Excepcion {
        int count;
        try {
            count = contarViajes();

            String strSQL = "INSERT INTO viaje (k_idviaje,k_codigo,o_horainicial)VALUES(?,?,CURRENT_TIME)";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, count);
            prepStmt.setInt(2, cuenta.getCodigo());

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No pudo insertar el viaje" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }

        usuarioDAO u = new usuarioDAO();
        u.cambiarEst(cuenta);
        return count;
    }

    public void incluirViajeBloqueo(Cuenta cuenta,int vSacaBi) throws Excepcion {
        int mins;
        int minsad = 0;
        int costo = vSacaBi;
        try {
//para la prueba MAKE_TIME(23, 59, 0)
            String strSQL = "UPDATE viaje SET o_horafinal = CURRENT_TIME Where k_idviaje=?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, cuenta.getViaje().getIdViaje());

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No pudo terminar el viaje" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        mins = obtenerDuracion(cuenta);
        //aca ponemos lo del plan
        if (mins > cuenta.getPlan().gettMax()) {
            //resta
            minsad = mins - cuenta.getPlan().gettMax();
            costo = costo+obtenerCostoMinsAd(minsad, cuenta.getCodigo());
        }
        actualizarViajeBloqueo(mins, costo, minsad, cuenta.getViaje().getIdViaje());

        usuarioDAO u = new usuarioDAO();
        
        u.actualizarCuentaBloqueo(cuenta, costo);
        if (cuenta.getSaldo()-costo >= 0) {
            u.cambiarEst(cuenta);
        }
    }

    public int obtenerDuracion(Cuenta cuenta) throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT EXTRACT(HOUR FROM (o_horafinal - o_horainicial)) * 60 + EXTRACT(MINUTE FROM (o_horafinal - o_horainicial)) + EXTRACT(SECOND FROM (o_horafinal - o_horainicial)) / 60 AS minutos FROM viaje WHERE k_idviaje=?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, cuenta.getViaje().getIdViaje());
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No se pudo obtener la duracion del viaje" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }

    public int obtenerCostoMinsAd(int resta, int cod) throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT (v_minadicional*(?)) FROM plan JOIN plan_cuenta ON plan_cuenta.k_idplan=plan.k_idplan WHERE k_codigo= ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, resta);
            prepStmt.setInt(2, cod);
            ResultSet rs = prepStmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No se pudo obtener el costo del viaje" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }

    public void actualizarViajeBloqueo(int dur, int cost, int minad, int idViaje) throws Excepcion {
        try {

            String strSQL = "UPDATE viaje SET o_duracion=?,v_costo=?,o_minadicional =? WHERE k_idviaje = ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, dur);
            prepStmt.setInt(2, cost);
            prepStmt.setInt(3, minad);
            prepStmt.setInt(4, idViaje);

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No pudo actualizar el bloqueo" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
    }
       public int contarViajescuenta(int cod) throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT COUNT(*) FROM viaje WHERE k_codigo=?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, cod);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("viajeDAO", "No se pudo contar los viajes" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }

}
