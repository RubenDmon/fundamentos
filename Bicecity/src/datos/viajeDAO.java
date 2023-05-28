/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import conexion.Excepcion;
import conexion.Servidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rdmon
 */
public class viajeDAO {
    
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
}
