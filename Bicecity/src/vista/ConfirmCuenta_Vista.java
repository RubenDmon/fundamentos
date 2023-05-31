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
public class ConfirmCuenta_Vista extends JFrame {
    
    private JPanel pPrincipal;
    private ImageIcon iIcon;
    private JLabel lIcon, lTitulo, lSubtitle, label;
    private JButton bContinuar;
    
    public ConfirmCuenta_Vista(){
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
        
        iIcon = new ImageIcon("resources/images/Bicileta_Confirmacion_Cuenta.png");
        lIcon = new JLabel();
        lIcon.setIcon(iIcon);
        pPrincipal.add(lIcon);
        
        lSubtitle = new JLabel("¡Cuenta Creada!");
        lSubtitle.setFont(new Font("Arial", Font.BOLD ,27 ));
        pPrincipal.add(lSubtitle);
        
        label = new JLabel("Presiona el boton para continuar");
        pPrincipal.add(label);
        
        bContinuar = new JButton("Continuar");
        pPrincipal.add(bContinuar);
        
        setVisible(true);
        
    }
    
    public static void main (String [] args ) {
	ConfirmCuenta_Vista show = new ConfirmCuenta_Vista();
    }
    
}
