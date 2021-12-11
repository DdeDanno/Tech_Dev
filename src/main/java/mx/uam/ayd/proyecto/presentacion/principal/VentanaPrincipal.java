package mx.uam.ayd.proyecto.presentacion.principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private ControlPrincipal control;
	@Autowired
	private ControlCarritoDeCompras controlCarritoDeCompras;
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
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
		//Titulo ventana
		JLabel lblDiseño=new JLabel("PRODUCTOS");
        lblDiseño.setBounds(10, 39, 80, 40);
        contentPane.add(lblDiseño);
		//Selecciona cantidad 1
		SpinnerModel model = new SpinnerNumberModel(0, 0, 20, 1);
		JSpinner spinnerCant1=new JSpinner(model);
		spinnerCant1.setBounds(15, 210, 60, 29);
		contentPane.add(spinnerCant1);
		//Selecciona cantidad 2
		SpinnerModel model2 = new SpinnerNumberModel(0, 0, 20, 1);
		JSpinner spinnerCant2=new JSpinner(model2);
		spinnerCant2.setBounds(265, 210, 60, 29);
		contentPane.add(spinnerCant2);
		//Menu Navegacion
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
					control.visualizarDiseños();
				} catch(Exception error){
					muestraDialogoConMensaje(error.getMessage());	
				}
			}
		});

		// Boton Agregar Producto 1 
		JButton btnProducto1 = new JButton("Agrega");
		btnProducto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					controlCarritoDeCompras.agregaCarrito((Integer)spinnerCant1.getValue(), "Volante");
					control.elegirCategoria();
				} catch(Exception error){
					muestraDialogoConMensaje(error.getMessage());	
				}
			}
		});
		btnProducto1.setBounds(120, 210, 80, 29);
		contentPane.add(btnProducto1);

		// Boton Agregar Producto 2 
		JButton btnProducto2 = new JButton("Agrega");
		btnProducto2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					controlCarritoDeCompras.agregaCarrito((Integer)spinnerCant2.getValue(),  "Lona");
					control.elegirCategoria();
				} catch(Exception error){
					muestraDialogoConMensaje(error.getMessage());	
				}
			}
		});
		btnProducto2.setBounds(350, 210, 80, 29);
		contentPane.add(btnProducto2);
		
		JButton btnAgregarUsuario = new JButton("Agregar usuario");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.agregarUsuario();
			}
		});
		btnAgregarUsuario.setBounds(250, 250, 178, 29);
		contentPane.add(btnAgregarUsuario);
		
		JButton btnListarUsuarios = new JButton("Listar usuarios");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.listarUsuarios();
			}
		});
		btnListarUsuarios.setBounds(15, 250, 178, 29);
		contentPane.add(btnListarUsuarios);
		
		//Inserta imagen producto 1
		BufferedImage bfimgn1;
		try {
			bfimgn1 = ImageIO.read(new File("C:\\imagen\\producto_1.png"));
			JLabel imgn1= new JLabel(new ImageIcon(bfimgn1));
			imgn1.setBounds(10, 35, 200, 200);
			contentPane.add(imgn1);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage bfimgn2;
		try {
			bfimgn2 = ImageIO.read(new File("C:\\imagen\\producto_2.png"));
			JLabel imgn2= new JLabel(new ImageIcon(bfimgn2));
			imgn2.setBounds(250, 35, 200, 200);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	public void muestra(ControlPrincipal control) {
		
		this.control = control;
		
		setVisible(true);
	}
}
