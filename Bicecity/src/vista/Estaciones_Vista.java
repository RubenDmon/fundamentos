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
public class Estaciones_Vista extends JFrame{
    private JPanel pSup, pPrincipal;
    private JLabel lTitulo;
    private JButton bVolver;
    
    public Estaciones_Vista(){
        super("Estaciones");
        
        //this.Estaciones_Component = Estaciones_Component;
        
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
        //pPrincipal.setLayout(null);
        pPrincipal.setBounds(0, 80, 650, 700);
        pPrincipal.setBackground(Color.WHITE);
        this.add(pPrincipal);
        
        lTitulo = new JLabel("Estaciones");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        bVolver =new JButton("Volver al inicio");
        bVolver.setFocusable(false);
        pPrincipal.add(bVolver);
        
        setVisible(true);
    }
    public static void main (String [] args ) {
	Estaciones_Vista show = new Estaciones_Vista();
    }
    
}
