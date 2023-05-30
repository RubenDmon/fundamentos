/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author maiks
 */
public class EditarPerfil_Vista extends JFrame{
    
    private JPanel pSup, pPrincipal, pContenido;
    private JLabel lTitulo, lpNombre, lsNombre, lpApellido, lsApellido, leps, lcel;
    private JTextField primerNom, segundoNom, primerApellido, segundoApellido, cel;
    private JComboBox eps;
    private JButton bGuardar, bCancelar;
    
    private EditarPerfil_Component EditarPerfil_Component;
    
    public EditarPerfil_Vista(EditarPerfil_Component EditarPerfil_Component){
        super("Inicio");
        
        this.EditarPerfil_Component = EditarPerfil_Component;

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        setSize(650, 800);
        setLocationRelativeTo (null);
	setResizable(false);
        
        pSup = new JPanel();
	pSup.setLocation(0, 0);
	pSup.setSize(650, 80);
	pSup.setBackground(new Color(193, 167, 216));
        this.add(pSup);
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(null);
        pPrincipal.setBounds(0, 80, 650, 700);
        pPrincipal.setBackground(Color.WHITE);
        this.add(pPrincipal);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BoxLayout(pContenido, BoxLayout.Y_AXIS));
        pContenido.setBounds(100, 50, 430, 500);
        pContenido.setBackground(Color.WHITE);
        pPrincipal.add(pContenido);
        
        lTitulo = new JLabel("Editar Perfil");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lpNombre = new JLabel("Primer Nombre");
        primerNom = new JTextField();
        pContenido.add(lpNombre);
        pContenido.add(primerNom);
        
        lsNombre = new JLabel("Segundo Nombre");
        segundoNom = new JTextField();
        pContenido.add(lsNombre);
        pContenido.add(segundoNom);
        
        lpApellido = new JLabel("Primer Apellido");
        primerApellido = new JTextField();
        pContenido.add(lpApellido);
        pContenido.add(primerApellido);
        
        lsApellido = new JLabel("Segundo Apellido");
        segundoApellido = new JTextField();
        pContenido.add(lsApellido);
        pContenido.add(segundoApellido);
        
        leps = new JLabel("Seleccione EPS");
        eps = new JComboBox();
        eps.addItem("Cafesalud");
        eps.addItem("Coomeva");
        eps.addItem("Sura");
        eps.addItem("Famisanar");
        eps.addItem("Nueva EPS");
        eps.addItem("Salud Total");
        eps.addItem("Sanitas");
        eps.addItem("Compensar");
        eps.addItem("Aliansalud");
        eps.addItem("Medimas");
        eps.addItem("Otra");
        pContenido.add(leps);
        pContenido.add(eps);
        
        lcel = new JLabel("Celular");
        cel = new JTextField();
        pContenido.add(lcel);
        pContenido.add(cel);
        
        bGuardar = new JButton("Guardar");
        bCancelar = new JButton("Cancelar");
        pContenido.add(bGuardar);
        pContenido.add(bCancelar);
        
        setVisible(true);
    }
 
}
