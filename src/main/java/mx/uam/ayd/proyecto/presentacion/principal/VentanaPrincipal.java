package mx.uam.ayd.proyecto.presentacion.principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;
import mx.uam.ayd.proyecto.presentacion.mostrarOfertas.ControlMostrarOfertas;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
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

	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;

	@Autowired 
	private ControlMostrarOfertas controlMostrarOfertas;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * VentanaPrincipal frame = new VentanaPrincipal();
	 * frame.setVisible(true);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 600, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);
		// Titulo ventana
		JLabel lblDiseño = new JLabel("PRODUCTOS");
		lblDiseño.setBounds(10, 39, 80, 40);
		contentPane.add(lblDiseño);
		// Selecciona cantidad 1
		SpinnerModel model = new SpinnerNumberModel(0, 0, 20, 1);
		JSpinner spinnerCant1 = new JSpinner(model);
		spinnerCant1.setBounds(15, 210, 60, 29);
		contentPane.add(spinnerCant1);
		// Selecciona cantidad 2
		SpinnerModel model2 = new SpinnerNumberModel(0, 0, 20, 1);
		JSpinner spinnerCant2 = new JSpinner(model2);
		spinnerCant2.setBounds(265, 210, 60, 29);
		contentPane.add(spinnerCant2);
		// Menu Navegacion
		JMenuBar menuNav = new JMenuBar();
		menuNav.setBounds(10, 23, 600, 30);
		contentPane.add(menuNav);
		JButton menu1, menu2, menu3, menu4, menu5, iniSesion;

		menu1 = new JButton("Inicio");
		menu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu1);
		menu2 = new JButton("Productos");
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu2);
		menu3 = new JButton("Diseños");
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		iniSesion = new JButton("Registrarse");
		iniSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(iniSesion);
		menu4 = new JButton("Carrito");
		menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu4);
		menu5 = new JButton("Ofertas");
		menu5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu5);

		// Boto que abre el catalogo de diseños
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.visualizarDiseños();
				} catch (Exception error) {
					muestraDialogoConMensaje(error.getMessage());
				}
			}
		});

		// Estoy haciendo una prueba de la rama - Daniel

		// Boton perfil NECESARIO PARA HU:ESTATUS DEL PEDIDO NO BORRAR
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.perfil();
			}
		});
		btnPerfil.setBounds(414, 23, 65, 30);
		btnPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(btnPerfil);

		// Boton Agregar Producto 1
		JButton btnProducto1 = new JButton("Agrega");
		btnProducto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlCarritoDeCompras.agregaCarrito((Integer) spinnerCant1.getValue(), "Volante");
					control.visualizarDiseños();
				} catch (Exception error) {
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
				try {
					controlCarritoDeCompras.agregaCarrito((Integer) spinnerCant2.getValue(), "Lona");
					control.visualizarDiseños();
				} catch (Exception error) {
					muestraDialogoConMensaje(error.getMessage());
				}
			}
		});
		btnProducto2.setBounds(350, 210, 80, 29);
		contentPane.add(btnProducto2);

		// Listenes para mandar a llamar al controlAgregarUsuario
		iniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controlAgregarUsuario.inicia();

			}
		});

		JButton btnListarUsuarios = new JButton("Listar usuarios");

		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.listarUsuarios();
			}
		});
		btnListarUsuarios.setBounds(15, 250, 178, 29);
		contentPane.add(btnListarUsuarios);

		/*
		 * Botón que despliega todas las ofertas actuales
		 */
		menu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlMostrarOfertas.inicia();
				} catch (Exception error) {
					muestraDialogoConMensaje(error.getMessage());
				}
			}
		});

		// Inserta imagen producto 1
		BufferedImage bfimgn1;
		try {
			bfimgn1 = ImageIO.read(new File("src\\main\\resources\\imgDiseños\\lona.jpg"));
			JLabel imgn1 = new JLabel(new ImageIcon(bfimgn1));
			imgn1.setBounds(50, 100, 200, 100);
			contentPane.add(imgn1);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage bfimgn2;
		try {
			bfimgn2 = ImageIO.read(new File("src\\main\\resources\\imgDiseños\\tazas-impresas.jpg"));
			JLabel imgn2 = new JLabel(new ImageIcon(bfimgn2));
			imgn2.setBounds(250, 100, 200, 100);
			contentPane.add(imgn2);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public void muestra(ControlPrincipal control) {

		this.control = control;

		setVisible(true);
	}
}
