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
        ges.incluirCiudad(0, "bogota", "10:00:00", "12:22:55");       
}
}