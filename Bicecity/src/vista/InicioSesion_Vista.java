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
public class InicioSesion_Vista extends JFrame{
    
    private JPanel pSup, pPrincipal, pContenido;
    private JLabel lTitulo, lSubtitle, l1,l2;
    private JTextField nIdentificacion;
    private JButton bIniciar, bRegistrar;
    
    public InicioSesion_Vista(){
        super("Inicio de sesion");
        
        //this.InicioSesion_Component = InicioSesion_Component;

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
        pPrincipal.setBounds(0, 80, 650, 680);
        pPrincipal.setBackground(Color.WHITE);
        this.add(pPrincipal);
        
        pContenido = new JPanel();
        pContenido.setLayout(new BoxLayout(pContenido, BoxLayout.Y_AXIS));
        pContenido.setBounds(100, 200, 430, 150);
        pContenido.setBackground(Color.WHITE);
        pPrincipal.add(pContenido);
        
        lTitulo = new JLabel("Bienvenido a BiciCity");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lSubtitle = new JLabel("¡Nos alegra verte por aquí!");
        lSubtitle.setFont(new Font("Arial", Font.BOLD ,27 ));
        pContenido.add(lSubtitle);
        l1 = new JLabel("Ingresa tu correo electronico y constraseña para empezar a rodar");
        pContenido.add(l1);
        l2 = new JLabel("Numero de indentificacion");
        pContenido.add(l2);
        nIdentificacion = new JTextField();
        pContenido.add(nIdentificacion);
        bIniciar = new JButton("Iniciar sesion");
        pContenido.add(bIniciar);
        bRegistrar = new JButton("Registrarse");
        pContenido.add(bRegistrar);
        
        setVisible(true);
        
    }
    
    public static void main (String [] args ) {
	InicioSesion_Vista show = new InicioSesion_Vista();
    }
    
}
