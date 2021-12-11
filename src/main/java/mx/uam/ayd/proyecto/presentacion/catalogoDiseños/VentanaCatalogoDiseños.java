package mx.uam.ayd.proyecto.presentacion.catalogoDiseños;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Cursor;

import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import mx.uam.ayd.proyecto.presentacion.elegirCategoria.ControlElegirCategoria;

@SuppressWarnings ("serial")
@Component
public class VentanaCatalogoDiseños extends JFrame{
    private JPanel contentPane;
    private ControlCatalogoDiseños control;

    public VentanaCatalogoDiseños (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);

		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(5, 20, 500, 30);
		contentPane.add(menuNav);
		JMenu menu1,menu2,menu4,menu5,menu6;
		JButton menu3;
		menu1=new JMenu("Inicio");
		menuNav.add(menu1);
		menu2=new JMenu("Productos");
		menuNav.add(menu2);
		menu3=new JButton("Diseños");
		menu3.setBackground(Color.GRAY);
		menu3.setBorder(null);
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		menu4=new JMenu("¿Preguntas?");
		menuNav.add(menu4);
		menu5=new JMenu("Perfil");
		menuNav.add(menu5);
		menu6=new JMenu("Carrito");
		menuNav.add(menu6);

		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.inicia();
				} catch(Exception error){
					System.out.println("Error");	
				}
			}
		});

		JMenuBar menuClasificacion= new JMenuBar ();
		menuClasificacion.setBounds(90, 50, 500, 30);
		contentPane.add(menuClasificacion);
		JButton m1,m2,m3,m4;
		m1=new JButton("Todos");
		m1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m1.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m1);
		m2=new JButton("Eventos");
		m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m2.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m2);
		m3=new JButton("Negocios");
		m3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m3.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m3);
		m4=new JButton("Otros");
		m4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m4.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m4);


		JButton btnAgregar = new JButton("Agrega");
        btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.carritoDeCompras();
			}
		});
		btnAgregar.setBounds(100, 210, 90, 29);
		contentPane.add(btnAgregar);
		// Boton diseño cliente
        JButton btnDiseñoCliente = new JButton("Deseo hacer mi propio diseño");
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.carritoDeCompras();;
			}
		});
        btnDiseñoCliente.setBounds(273, 210, 210, 29);
		contentPane.add(btnDiseñoCliente);
		// Imagen
		BufferedImage bfimgn1;
		try {
			bfimgn1 = ImageIO.read(new File("C:\\imagen\\diseño_1.png"));
			JLabel imgn1= new JLabel(new ImageIcon(bfimgn1));
			imgn1.setBounds(85, 80, 120, 120);;
			contentPane.add(imgn1);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void muestra (ControlCatalogoDiseños control){
        this.control=control;
        setVisible(true);
    }
}
