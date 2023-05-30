package vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

/**
 *
 * @author maiks
 */
public class Inicio_Vista extends JFrame{
    //declaracion paneles
    private JPanel pSup, pPrincipal, pInf;
    //declaracion imagen
    private ImageIcon iMapa;
    //declaracion labels
    private JLabel lTitulo, lMapa;
    //declaracion botones
    private JButton bEditar, bEstaciones, bViajes, bPlan, bEmpezar;
    
    //Declaracion del objeto controlador de la vista
    private Inicio_Component Inicio_Component;
    
    public Inicio_Vista(Inicio_Component Inicio_Component){
        super("Inicio");
        
        this.Inicio_Component = Inicio_Component;

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        setSize(650, 800);
        setLocationRelativeTo (null);
	setResizable(false);
        
        iMapa = new ImageIcon("resources/images/Mapa_Bogota_Inicio.png");
        
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
        
        lTitulo = new JLabel("Bienvenido");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lMapa = new JLabel();
        lMapa.setBounds(100, 50, 420, 420);
        lMapa.setIcon(new ImageIcon(iMapa.getImage().getScaledInstance(420, 420, Image.SCALE_AREA_AVERAGING)));
        pPrincipal.add(lMapa);
        
        bEditar = new JButton("Editar Perfil");
        bEditar.setBounds(260, 15, 120, 40);
        bEditar.setBackground(Color.WHITE);
        bEditar.setBorder(null);
        bEditar.setFont(new Font("Arial", Font.BOLD ,20 ));
        bEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bEditar.setFocusable(false);
        bEditar.addActionListener(Inicio_Component);
        pPrincipal.add(bEditar);
        
        bEstaciones = new JButton("Ver Estaciones");
        bEstaciones.setBounds(145, 500 , 178, 50);
        bEstaciones.setBackground(Color.WHITE);
        bEstaciones.setBorder(new RoundedBorder(40));
        bEstaciones.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bEstaciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bEstaciones.setFocusable(false);
        bEstaciones.addActionListener(Inicio_Component);
        pPrincipal.add(bEstaciones);
        
        bViajes = new JButton("Ver mis Viajes");
        bViajes.setBounds(335, 500 , 170, 50);
        bViajes.setBackground(Color.WHITE);
        bViajes.setBorder(new RoundedBorder(40));
        bViajes.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bViajes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bViajes.setFocusable(false);
        bViajes.addActionListener(Inicio_Component);
        pPrincipal.add(bViajes);
        
        bPlan = new JButton("Ver mi Plan");
        bPlan.setBounds(175, 570 , 150, 50);
        bPlan.setBackground(Color.WHITE);
        bPlan.setBorder(new RoundedBorder(40));
        bPlan.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bPlan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bPlan.setFocusable(false);
        bPlan.addActionListener(Inicio_Component);
        pPrincipal.add(bPlan);
        
        bEmpezar = new JButton("¡A rodar!");
        bEmpezar.setBounds(335, 570 , 130, 50);
        bEmpezar.setBackground(Color.WHITE);
        bEmpezar.setBorder(new RoundedBorder(40));
        bEmpezar.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bEmpezar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bEmpezar.setFocusable(false);
        bEmpezar.addActionListener(Inicio_Component);
        pPrincipal.add(bEmpezar);
        
        setVisible(true);
    }
    /*
    public static void main (String [] args ) {
	Inicio_Vista show = new Inicio_Vista();
    }
*/
    class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius-15, this.radius-15, this.radius, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    
}
