/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import logica.Usuario;
import logica.Cuenta;
import logica.Plan;

import datos.planDAO;

import conexion.Excepcion;
import conexion.Servidor;

/**
 *
 * @author rdmon
 */
public class usuarioDAO {

    public usuarioDAO() {
    }

    public void incluirUsuario(Usuario user) throws Excepcion {
        try {

            String strSQL = "INSERT INTO usuario (k_idusuario, i_tipoid, n_correo, n_nombre1, n_nombre2, n_apellido1, n_apellido2, n_nacionalidad, f_nacimiento, n_eps, i_sexo, v_celular) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, user.getIdUsuario());
            prepStmt.setString(2, user.getTipoId());
            prepStmt.setString(3, user.getCorreo());
            prepStmt.setString(4, user.getNombre1());
            prepStmt.setString(5, user.getNombre2());
            prepStmt.setString(6, user.getApellido1());
            prepStmt.setString(7, user.getApellido2());
            prepStmt.setString(8, user.getNacionalidad());
            String dateString = user.getNacimiento(); // El string de fecha que deseas convertir
            LocalDate localDate = LocalDate.parse(dateString);
            Date sqlDate = Date.valueOf(localDate);
            prepStmt.setDate(9, sqlDate);
            prepStmt.setString(10, user.getEps());
            prepStmt.setString(11, user.getSexo());
            prepStmt.setInt(12, user.getCelular());

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("usuarioDAO", "No pudo crear el usuario" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
// aca iria el de cuenta 
        incluirCuenta(user.getCuenta(), user.getIdUsuario());
    }

    public int contarUsuarios() throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT COUNT(*) FROM usuario";
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
            throw new Excepcion("usuarioDAO", "No no se pudo contar los usuarios" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }

    public void incluirCuenta(Cuenta cuenta, String idUser) throws Excepcion {
        int id = contarUsuarios();
        try {

            String strSQL = "INSERT INTO cuenta (k_codigo,k_idusuario,v_saldo,o_estado) VALUES(?,?,?,?)";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);
            prepStmt.setString(2, idUser);
            prepStmt.setInt(3, cuenta.getSaldo());
            prepStmt.setString(4, cuenta.getEstado());

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();
        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo crear la cuenta" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
    }

    public void asociarPlan(int idCuenta, int plan) throws Excepcion {
        try {

            String strSQL = "INSERT INTO plan_cuenta (k_idplan,k_codigo) VALUES(?,?)";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, plan);
            prepStmt.setInt(2, idCuenta);

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("usuarioDAO", "No pudo asociar el plan a la cuenta" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
    }
/*
    public int obtenerIdCuenta(String iduser) throws Excepcion {
        int id = 0;
        try {

            String strSQL = "SELECT k_codigo FROM cuenta WHERE k_idusuario = ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, iduser);

            ResultSet resultSet = prepStmt.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("k_codigo");
                // Procesar el valor entero
            } else {
                // No se encontraron filas en el ResultSet, manejar según sea necesario
                throw new Excepcion("cuentaDAO", "No pudo obtener el id ");
            }

            prepStmt.close();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo obtener el id " + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return id;
    }*/

    public Usuario obtenerUsuario(String idUser) throws Excepcion {
        Usuario user = new Usuario();
        try {

            String strSQL = "SELECT * FROM usuario WHERE k_idusuario = ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, idUser);

            ResultSet resultSet = prepStmt.executeQuery();

            if (resultSet.next()) {
                user.setIdUsuario(idUser);
                user.setTipoId(resultSet.getString("i_tipoid"));
                user.setCorreo(resultSet.getString("n_correo"));
                user.setNombre1(resultSet.getString("n_nombre1"));
                user.setNombre2(resultSet.getString("n_nombre2"));
                user.setApellido1(resultSet.getString("n_apellido1"));
                user.setApellido2(resultSet.getString("n_apellido2"));
                user.setNacionalidad(resultSet.getString("n_nacionalidad"));
                user.setNacimiento(resultSet.getString("f_nacimiento"));
                user.setEps(resultSet.getString("n_eps"));
                user.setSexo(resultSet.getString("i_sexo"));
                user.setCelular(resultSet.getInt("v_celular"));
                // Procesar el valor entero
            }

            prepStmt.close();

        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo obtener el id " + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        user.setCuenta(obtenerCuenta(idUser));
        return user;
    }

    public Cuenta obtenerCuenta(String idUser) throws Excepcion {
        Cuenta cuenta = new Cuenta();
        int cod=0;
        try {

            String strSQL = "SELECT * FROM cuenta WHERE k_idusuario = ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, idUser);

            ResultSet resultSet = prepStmt.executeQuery();

            if (resultSet.next()) {
                cod=resultSet.getInt("k_codigo");
                cuenta.setCodigo(cod);
                cuenta.setEstado(resultSet.getString("o_estado"));
                cuenta.setSaldo(resultSet.getInt("v_saldo"));
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
        planDAO plan=new planDAO();
        cuenta.setPlan(plan.obtenerPlan(cod));
        
        return cuenta;
    }
    public void actualizarCuentaBloqueo(Cuenta cuenta,int saldo) throws Excepcion {
        try {
            String strSQL = "UPDATE cuenta SET v_saldo=v_saldo-? WHERE k_codigo=?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, saldo);
            prepStmt.setInt(2, cuenta.getCodigo());

            prepStmt.executeUpdate();
            prepStmt.close();
            Servidor.getInstance().commit();
        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo actualizar la cuenta de bloqueo" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
    }
    
    
        public void cambiarEst(Cuenta cuenta) throws Excepcion {

        if (cuenta.getEstado().equals("ACTI")) {
            try {
                String strSQL = "UPDATE cuenta SET o_estado='DESA' WHERE k_codigo=? ";
                //se llama a tomar conccion de servidor

                Connection conexion = Servidor.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

                prepStmt.setInt(1, cuenta.getCodigo());

                prepStmt.executeUpdate();
                prepStmt.close();
                Servidor.getInstance().commit();

            } catch (SQLException e) {
                Servidor.getInstance().rollback();
                throw new Excepcion("cuentaDAO", "No pudo actualizar la cuenta" + e.getMessage());
            } finally {
                Servidor.getInstance().liberarConexion();
            }

        } else {
            try {
                String strSQL = "UPDATE cuenta SET o_estado='ACTI' WHERE k_codigo=? ;";
                //se llama a tomar conccion de servidor

                Connection conexion = Servidor.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

                prepStmt.setInt(1, cuenta.getCodigo());

                prepStmt.executeUpdate();
                prepStmt.close();
                Servidor.getInstance().commit();

            } catch (SQLException e) {
                Servidor.getInstance().rollback();
                throw new Excepcion("viajeDAO", "No pudo actualizar la cuenta" + e.getMessage());
            } finally {
                Servidor.getInstance().liberarConexion();
            }
        }
    }
            public int obtenerVPlan(int cod) throws Excepcion {
        int count = 0;
        try {

            String strSQL = "SELECT v_base FROM plan JOIN plan_cuenta ON plan_cuenta.k_idplan=plan.k_idplan WHERE k_codigo=?";
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
            throw new Excepcion("usuarioDAO", "No no se pudo contar los usuarios" + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }
        return count;
    }
            
            
public void modificarCuenta(Usuario user,String nombre1,String nombre2,String apellido1,String apellido2,String eps,int cel) throws Excepcion {

            try {
                String strSQL = "UPDATE usuario SET n_nombre1=?,n_nombre2=?,n_apellido1=?,n_apellido2=?,n_eps=?,v_celular=? WHERE k_idusuario=?";
                //se llama a tomar conccion de servidor
                
                Connection conexion = Servidor.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

                prepStmt.setString(1, nombre1);
                prepStmt.setString(2, nombre2);
                prepStmt.setString(3, apellido1);
                prepStmt.setString(4, apellido2);
                prepStmt.setString(5, eps);
                prepStmt.setInt(6,cel);
                prepStmt.setString(7,user.getIdUsuario());
                
                prepStmt.executeUpdate();
                prepStmt.close();
                Servidor.getInstance().commit();

            } catch (SQLException e) {
                Servidor.getInstance().rollback();
                throw new Excepcion("cuentaDAO", "No pudo actualizar la cuenta" + e.getMessage());
            } finally {
                Servidor.getInstance().liberarConexion();
            }

     
    }
}
