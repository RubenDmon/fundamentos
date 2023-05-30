/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.SwingUtilities;

/**
 *
 * @author maiks
 */
public class prueba {
    public static void main (String [] args ) {
	Runnable runAplication = new Runnable() {
            @Override
            public void run() {
		Inicio_Component login = new Inicio_Component(); 
            }
	};
	SwingUtilities.invokeLater(runAplication);
    }
    
}
