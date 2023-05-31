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
public class RegistroBici_Vista extends JFrame{
    
    private JPanel pSup, pPrincipal, pEstaciones, pBicicletas;
    private JLabel lTitulo, lSubtitle1, lnomEstacion, lLocalidad, lcodLocalidad, lcodEstacion, ldirEstacion;
    private JLabel lSubtitle2, ltipoBici, lcodBici, lAsigEstacion;
    private JButton  bGuardarEst, bGuardarBici, bGuardar, bVolver;
    private JTextField tnomEstacion, tcodEstacion, tdirEstacion, tcodBici;
    private JComboBox cAsigLocalidad, cTipoBici, cAsigEstacion;
    
    public RegistroBici_Vista(){
        super("Registrar nuevos objetos");
        
        //this.RegistroBici_Component = RegistroBici_Component;

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
        
        pEstaciones = new JPanel();
        pEstaciones.setLayout(new BoxLayout(pEstaciones, BoxLayout.Y_AXIS));
        pEstaciones.setBounds(130, 40, 370, 270);
        pEstaciones.setBackground(Color.WHITE);
        pPrincipal.add(pEstaciones);
        
        lTitulo = new JLabel("Registrar bicicletas y estaciones");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lSubtitle1 = new JLabel("Registrar Estacion");
        lSubtitle1.setFont(new Font("Arial", Font.BOLD ,27 ));
        pEstaciones.add(lSubtitle1);
        
        lnomEstacion = new JLabel("Nombre de la estacion");
        tnomEstacion = new JTextField();
        pEstaciones.add(lnomEstacion);
        pEstaciones.add(tnomEstacion);
        
        lLocalidad = new JLabel("Asignar Localidad");
        cAsigLocalidad = new JComboBox();
        cAsigLocalidad.addItem("Usaquén");
        cAsigLocalidad.addItem("Chapinero");
        cAsigLocalidad.addItem("Teusaquillo");
        cAsigLocalidad.addItem("La Candelaria");
        cAsigLocalidad.addItem("Barrios Unidos");
        cAsigLocalidad.addItem("Santa Fe");
        pEstaciones.add(lLocalidad);
        pEstaciones.add(cAsigLocalidad);        
        
        lcodLocalidad = new JLabel("Codigo de la localidad");
        tcodEstacion = new JTextField();
        pEstaciones.add(lcodLocalidad);
        pEstaciones.add(tcodEstacion);
        
        lcodEstacion = new JLabel("Codigo de la estacion");
        tnomEstacion = new JTextField();
        pEstaciones.add(lcodEstacion);
        pEstaciones.add(tnomEstacion);
        
        ldirEstacion = new JLabel("Direccion de la estacion");
        tdirEstacion = new JTextField();
        pEstaciones.add(ldirEstacion);
        pEstaciones.add(tdirEstacion);
        
        bGuardarEst = new JButton("Guardar");
        pEstaciones.add(bGuardarEst);
        
        pBicicletas = new JPanel();
        pBicicletas.setLayout(new BoxLayout(pBicicletas, BoxLayout.Y_AXIS));
        pBicicletas.setBounds(130, 340, 370, 180);
        pBicicletas.setBackground(Color.WHITE);
        pPrincipal.add(pBicicletas);
        
        lSubtitle2 = new JLabel("Registrar Bicicleta");
        lSubtitle2.setFont(new Font("Arial", Font.BOLD ,27 ));
        pBicicletas.add(lSubtitle2);
        
        ltipoBici = new JLabel("Tipo de bicicleta");
        cTipoBici = new JComboBox();
        cTipoBici.addItem("Mecanica");
        cTipoBici.addItem("Electrica");
        pBicicletas.add(ltipoBici);
        pBicicletas.add(cTipoBici);
        
        lcodBici = new JLabel("Codigo de la bicicleta");
        tcodBici = new JTextField();
        pBicicletas.add(lcodBici);
        pBicicletas.add(tcodBici);
        
        lAsigEstacion = new JLabel("Asignar Estacion");
        cAsigEstacion = new JComboBox();
        cAsigEstacion.addItem("1");
        cAsigEstacion.addItem("2");
        cAsigEstacion.addItem("3");
        cAsigEstacion.addItem("4");
        cAsigEstacion.addItem("5");
        cAsigEstacion.addItem("6");
        pBicicletas.add(lAsigEstacion);
        pBicicletas.add(cAsigEstacion);
        
        bGuardarBici = new JButton("Guardar");
        pBicicletas.add(bGuardarBici);
        
        bGuardar = new JButton("Guardar todo y salir");
        bGuardar.setBounds(150, 550 , 170, 30);
        pPrincipal.add(bGuardar);
        bVolver = new JButton("Volver al inicio");
        bVolver.setBounds(350, 550 , 130, 30);
        pPrincipal.add(bVolver);
        
        setVisible(true);
        
    }
    public static void main (String [] args ) {
	RegistroBici_Vista show = new RegistroBici_Vista();
    }
    
}
