package mx.uam.ayd.proyecto.presentacion.elegirCategoria;

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

import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaElegirCategoria extends JFrame{
    private JPanel contentPane;
    private ControlElegirCategoria control;

    public VentanaElegirCategoria (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);
		// Barra de navegacion
		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(5, 20, 500, 30);
		contentPane.add(menuNav);
		JMenu menu1,menu2,menu3,menu4,menu5,menu6;
		menu1=new JMenu("Inicio");
		menuNav.add(menu1);
		menu2=new JMenu("Productos");
		menuNav.add(menu2);
		menu3=new JMenu("Diseños Previos");
		menuNav.add(menu3);
		menu4=new JMenu("¿Preguntas?");
		menuNav.add(menu4);
		menu5=new JMenu("Perfil");
		menuNav.add(menu5);
		menu6=new JMenu("Carrito");
		menuNav.add(menu6);
        //ELEGIR CATEGORIA  
        JLabel lblDiseño=new JLabel("ELEGIR CATEGORIA");
        lblDiseño.setBounds(28, 39, 160, 40);
        contentPane.add(lblDiseño);
		// Evento social 1
        JLabel lblEvento1=new JLabel("NEGOCIO");
        lblEvento1.setBounds(28, 70, 80, 16);
        contentPane.add(lblEvento1);
		// Evento social
		JLabel lblEvento2=new JLabel("FIESTA");
		lblEvento2.setBounds(170, 70, 80, 16);
		contentPane.add(lblEvento2);
		//Boton elegir 1
		JButton btnDiseño1 = new JButton("Elegir");
        btnDiseño1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.elegirDiseño();
			}
		});
		btnDiseño1.setBounds(28, 210, 90, 29);
		contentPane.add(btnDiseño1);
		//Boton elegir 2
		JButton btnDiseño2 = new JButton("Elegir");
        btnDiseño2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.elegirDiseño();
			}
		});
		btnDiseño2.setBounds(160, 210, 90, 29);
		contentPane.add(btnDiseño2);
		// Boton diseño cliente
        JButton btnDiseñoCliente = new JButton("Deseo hacer mi propio diseño");
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.carritoDeCompras();;
			}
		});
        btnDiseñoCliente.setBounds(273, 210, 210, 29);
		
		contentPane.add(btnDiseñoCliente);
		//Imagen 1
		BufferedImage bfimgn1;
		try {
			bfimgn1 = ImageIO.read(new File("C:\\imagen\\categoria_1.png"));
			JLabel imgn1= new JLabel(new ImageIcon(bfimgn1));
			imgn1.setBounds(10, 90, 120, 120);
			contentPane.add(imgn1);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Imagen 2
		BufferedImage bfimgn2;
		try {
			bfimgn2 = ImageIO.read(new File("C:\\imagen\\categoria_2.png"));
			JLabel imgn2= new JLabel(new ImageIcon(bfimgn2));
			imgn2.setBounds(150, 90, 120, 120);
			contentPane.add(imgn2);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

	


    public void muestra (ControlElegirCategoria control){
        this.control=control;
        setVisible(true);
    }
}
