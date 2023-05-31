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
public class MetodoPago_Vista extends JFrame{
    private JPanel pSup, pPrincipal, pContenido;
    private JLabel lTitulo, lSubtitle, lTitular, lNumTarjeta, lFechaVen, lCVC;
    private JTextField tTitular, tNumTarjeta, tFechaVen, tCVC;
    private JButton vComprar, bVolver;
    
    public MetodoPago_Vista(){
        super("Inicio");
        
        //this.MetodoPago_Component = MetodoPago_Component;

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
        pContenido.setBounds(100, 50, 370, 400);
        pContenido.setBackground(Color.WHITE);
        pPrincipal.add(pContenido);
        
        lTitulo = new JLabel("Metodo de pago");
	lTitulo.setForeground(Color.BLACK);
	lTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN ,40 ));
        pSup.add(lTitulo);
        
        lSubtitle = new JLabel("Tarjeta debito o credito");
        lSubtitle.setFont(new Font("Arial", Font.BOLD ,27 ));
        pContenido.add(lSubtitle);
        
        lTitular = new JLabel("Nombre del titular de la tarjeta: ");
        tTitular = new JTextField();
        pContenido.add(lTitular);
        pContenido.add(tTitular);
        
        lNumTarjeta = new JLabel("Numero de la tarjeta: ");
        tNumTarjeta = new JTextField("XXXX-XXXX");
        pContenido.add(lNumTarjeta);
        pContenido.add(tNumTarjeta);
        
        lFechaVen = new JLabel("Fecha de vencimiento: ");
        tFechaVen = new JTextField("MM/AA");
        pContenido.add(lFechaVen);
        pContenido.add(tFechaVen);
        
        lCVC = new JLabel("CVC/CVV");
        tCVC = new JTextField("MM/AA");
        pContenido.add(lCVC);
        pContenido.add(tCVC);
        
        vComprar = new JButton("Completar compra");
        pContenido.add(vComprar);
        bVolver = new JButton("Volver a la lista de planes");
        pContenido.add(bVolver);
        setVisible(true);
        
    }
    public static void main (String [] args ) {
	MetodoPago_Vista show = new MetodoPago_Vista();
    }
}
