/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.ciudadDAO;
import conexion.Excepcion;

/**
 *
 * @author rdmon
 */

public class Gestor {
    private ciudadDAO ciudadDAO;
    private Ciudad ciudad;
    
    public Gestor() {
       ciudadDAO = new ciudadDAO();
    }
    public void incluirCiudad(int id, String nombre,String hi, String hf) throws Excepcion {
      ciudad = new Ciudad();
      ciudad.setIdCiudad(id);
      ciudad.setnCiudad(nombre);
      ciudad.setHoraInicialServ(hi);
      ciudad.setHoraFinalServ(hf);
      ciudadDAO.incluirCiudad(ciudad);
    }
}
