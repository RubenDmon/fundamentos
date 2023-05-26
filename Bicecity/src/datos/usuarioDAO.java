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
            incluirCuenta(user.getCuenta(),user.getIdUsuario());
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
    public void  incluirCuenta(Cuenta cuenta, String idUser) throws Excepcion {
        int id=contarUsuarios();
             try {
            
            String strSQL = "INSERT INTO cuenta (k_codigo,k_idusuario,v_saldoinicial,v_saldopend,o_estado) VALUES(?,?,?,?,?)";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);
            prepStmt.setString(2, idUser);
            prepStmt.setInt(3, cuenta.getSaldoIN());
            prepStmt.setInt(4, cuenta.getSaldoFN());
            prepStmt.setString(5, cuenta.getEstado());
       
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

    public void modificarEmpleado() {
        //implementar
    }

    public void eliminarEmpleado() {
        //implementar
    }

}
