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
public class PlanearViaje_Vista extends JFrame{
    private JPanel pSup, pPrincipal, pContenido;
    private JLabel lTitulo, lSubtitle1, lSubtitle2, lSubtitle3, lSubtitle4, lLocalidad, lEstacion, lAviso, lTexto;
    private JTextField tCodigo;
    private JComboBox cLocalidad, cEstacion;
    private JButton bRetirar, bVolver;
    private JRadioButton biciMec, biciElec;
    private ButtonGroup bicicletas;
    
    public PlanearViaje_Vista(){
        super("Planea tu viaje");
        
        //this.PlanearViaje_Component = PlanearViaje_Component;

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
        
        lTitulo = new JLabel("¿A donde iremos hoy?");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lSubtitle1 = new JLabel("Programa tu viaje");
        lSubtitle1.setBounds(80, 40, 400, 50);
        lSubtitle1.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle1);
        
        lLocalidad = new JLabel("Seleccione una localidad:");
        lLocalidad.setBounds(80, 70, 300, 50);
        cLocalidad = new JComboBox();
        cLocalidad.setBounds(80, 110, 200, 25);
        cLocalidad.addItem("Usaquén");
        cLocalidad.addItem("Chapinero");
        cLocalidad.addItem("Teusaquillo");
        cLocalidad.addItem("La Candelaria");
        cLocalidad.addItem("Barrios Unidos");
        cLocalidad.addItem("Santa Fe");
        pPrincipal.add(lLocalidad);
        pPrincipal.add(cLocalidad);
        
        lEstacion = new JLabel("Seleccione una estacion:");
        lEstacion.setBounds(80, 130, 300, 50);
        cEstacion = new JComboBox();
        cEstacion.setBounds(80, 170, 200, 25);
        cEstacion.addItem("1");
        cEstacion.addItem("2");
        cEstacion.addItem("3");
        cEstacion.addItem("4");
        cEstacion.addItem("5");
        cEstacion.addItem("6");
        pPrincipal.add(lEstacion);
        pPrincipal.add(cEstacion);
        
        lSubtitle2 = new JLabel("Selecciona un tipo de bicicleta");
        lSubtitle2.setBounds(80, 220, 500, 50);
        lSubtitle2.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle2);
        
        biciMec = new JRadioButton("Bicicleta mecanica");
        biciMec.setBounds(80, 270, 150, 25);
        biciMec.setBackground(Color.WHITE);
        biciElec = new JRadioButton("Bicicleta electrica");
        biciElec.setBounds(80, 300, 150, 25);
        biciElec.setBackground(Color.WHITE);
        bicicletas = new ButtonGroup();
        bicicletas.add(biciMec);
        bicicletas.add(biciElec);
        pPrincipal.add(biciMec);
        pPrincipal.add(biciElec);
        
        lSubtitle3 = new JLabel("Ingresa el codigo de la bicicleta");
        lSubtitle3.setBounds(80, 330, 500, 50);
        lSubtitle3.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle3);
        
        tCodigo = new JTextField("Codigo");
        tCodigo.setBounds(80, 380, 300, 30);
        pPrincipal.add(tCodigo);
        
        lSubtitle4 = new JLabel("¡Atención!");
        lSubtitle4.setBounds(250, 440, 400, 50);
        lSubtitle4.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle4);
        
        lTexto = new JLabel();
        lTexto.setText("<html>"+ "Recuerda que es necesario que estes en el punto fisico para desbloquear tu bicicleta ,ademas contaras con unos pocos minutos para retirarla antes que empiece a correr el tiempo de tu viaje." +"</html>");
        lTexto.setBounds(110, 500, 400, 50);
        pPrincipal.add(lTexto);
        
        bRetirar = new JButton("Retirar Bicicleta");
        bVolver = new JButton("Volver al inicio");
        bRetirar.setBounds(140, 580, 150, 30);
        bVolver.setBounds(320, 580, 150, 30);
        pPrincipal.add(bRetirar);
        pPrincipal.add(bVolver);
        
        
        setVisible(true);
        
    }
    public static void main (String [] args ) {
	PlanearViaje_Vista show = new PlanearViaje_Vista();
    }
}
