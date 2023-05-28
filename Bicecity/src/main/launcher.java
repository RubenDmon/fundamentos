/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexion.Excepcion;
import logica.Gestor;
/**
 *
 * @author rdmon
 */
public class launcher {
        public static void main(String[] args) throws Excepcion {
       Gestor ges= new Gestor(); 
       //ges.incluirCiudad(0, "bogota", "10:00:00", "12:22:55");  
       
       //siempre este orden 
       //ges.incluirUser("102166", "CC","rube@gmail.com", "ruben","","Montoya","","Colombiana","2023-05-25","EPS","m", 313145,125);
       //ges.asociarPlan(3);
       
       ges.iniciar("102166");
      
        }
        
}