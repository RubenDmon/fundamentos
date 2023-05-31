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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author maiks
 */
public class InicioAdmin_Vista extends JFrame{
    //declaracion paneles
    private JPanel pSup, pPrincipal, pInf;
    //declaracion imagen
    private ImageIcon iMapa;
    //declaracion labels
    private JLabel lTitulo, lMapa;
    //declaracion botones
    private JButton bEditar, bRegistrarE, bVerE;
    
    //Declaracion del objeto controlador de la vista
    private Inicio_Component Inicio_Component;
    
    public InicioAdmin_Vista(){
        super("Inicio");
        
        //this.Inicio_Component = Inicio_Component;

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
        
        bRegistrarE = new JButton("Registrar estaciones");
        bRegistrarE.setBounds(110, 520 , 230, 50);
        bRegistrarE.setBackground(Color.WHITE);
        bRegistrarE.setBorder(new RoundedBorder(40));
        bRegistrarE.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bRegistrarE.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistrarE.setFocusable(false);
        bRegistrarE.addActionListener(Inicio_Component);
        pPrincipal.add(bRegistrarE);
        
        bVerE = new JButton("Ver estaciones");
        bVerE.setBounds(350, 520 , 182, 50);
        bVerE.setBackground(Color.WHITE);
        bVerE.setBorder(new RoundedBorder(40));
        bVerE.setFont(new Font("Arial", Font.PLAIN ,17 ));
        bVerE.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVerE.setFocusable(false);
        bVerE.addActionListener(Inicio_Component);
        pPrincipal.add(bVerE);
        
        setVisible(true);
    }
    
    public static void main (String [] args ) {
	InicioAdmin_Vista show = new InicioAdmin_Vista();
    }

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
