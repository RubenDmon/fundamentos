/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author maiks
 */
public class EditarPerfil_Component implements ActionListener{
    
	private EditarPerfil_Vista EditarPerfil_Vista;
	private Inicio_Component Inicio_Component;
	
	public EditarPerfil_Component() {
            EditarPerfil_Vista = new EditarPerfil_Vista(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Cancelar")) {
                EditarPerfil_Vista.setVisible(false);
                if(Inicio_Component == null) {
                    Inicio_Component = new Inicio_Component();
		}
		else
                    Inicio_Component.getIncioTemplate().setVisible(true);
		EditarPerfil_Vista.setVisible(false);
            }
	}
}
