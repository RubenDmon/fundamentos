/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import logica.Ciudad;

import conexion.Excepcion;
import conexion.Servidor;
/**
 *
 * @author rdmon
 */
public class ciudadDAO {
        public ciudadDAO(){
    }
    public void incluirCiudad(Ciudad ciudad) throws Excepcion {
      try {
      
        String strSQL = "INSERT INTO bicecity (k_idciudad,n_ciudad,o_horainicialserv,o_horafinalserv) VALUES(?,?,?,?)";
        //se llama a tomar conccion de servidor
        Connection conexion = Servidor.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
         prepStmt.setInt(1, ciudad.getIdCiudad()); 
        prepStmt.setString(2,ciudad.getnCiudad()); 
        prepStmt.setTime(3, Time.valueOf(ciudad.getHoraInicialServ())); 
        prepStmt.setTime(4, Time.valueOf(ciudad.getHoraFinalServ())); 
        prepStmt.executeUpdate();
        prepStmt.close();
        Servidor.getInstance().commit();
      } catch (SQLException e) {
           Servidor.getInstance().rollback();
           throw new Excepcion( "ciudadDAO", "No pudo crear la ciudad"+ e.getMessage());
      }  finally {
         Servidor.getInstance().liberarConexion();
      }
      
    }
    
    public void modificarEmpleado(){
      //implementar
    }
    
    public void eliminarEmpleado(){
      //implementar
    }
    
    
    }
        
       