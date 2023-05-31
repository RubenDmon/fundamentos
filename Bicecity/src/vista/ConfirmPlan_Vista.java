/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author maiks
 */
public class ConfirmPlan_Vista extends JFrame {
    
    private JPanel pPrincipal;
    private ImageIcon iIcon;
    private JLabel lIcon, lTitulo, lSubtitle, label;
    private JButton bContinuar;
    
    public ConfirmPlan_Vista(){
        super("Registrar nuevos objetos");
        
        //this.RegistroBici_Component = RegistroBici_Component;

	setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 800);
        setLocationRelativeTo (null);
	setResizable(false);
        
        pPrincipal = new JPanel();
        pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.Y_AXIS));
        pPrincipal.setBounds(0, 80, 650, 700);
        pPrincipal.setBackground(Color.WHITE);
        this.add(pPrincipal);
        
        lTitulo = new JLabel("¡Felicidades!");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pPrincipal.add(lTitulo);
        
        iIcon = new ImageIcon("resources/images/Bicicleta_Confirmacion_Plan.png");
        lIcon = new JLabel();
        lIcon.setIcon(new ImageIcon(iIcon.getImage().getScaledInstance(550, 400, Image.SCALE_AREA_AVERAGING)));
        pPrincipal.add(lIcon);
        
        lSubtitle = new JLabel("Haz adquirido tu plan");
        lSubtitle.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle);
        
        label = new JLabel("Presiona el boton para empezar a viajar");
        pPrincipal.add(label);
        
        bContinuar = new JButton("¡A rodar!");
        pPrincipal.add(bContinuar);
        
        setVisible(true);
        
    }
    
    public static void main (String [] args ) {
	ConfirmPlan_Vista show = new ConfirmPlan_Vista();
    }
    
}

