/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author maiks
 */
public class Inicio_Component implements ActionListener{
    private Inicio_Vista Inicio_Vista;
    private EditarPerfil_Component EditarPerfil_Component;
    
    public Inicio_Component() {
	Inicio_Vista = new Inicio_Vista(this);
	}
    
    @Override
	public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Editar Perfil")) {			
		EditarPerfil_Component = new EditarPerfil_Component();
		Inicio_Vista.setVisible(false);
            }
           
	}
 
    public Inicio_Vista getIncioTemplate() {
	return Inicio_Vista;
    }
    
}
