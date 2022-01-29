package mx.uam.ayd.proyecto.presentacion.informaciónPersonal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;


@SuppressWarnings ("serial")
@Component
public class ventanaInformacionPersonal extends JFrame{
    private JPanel contentPane;
	private controlInformacionPersonal control;
	private JTextField nombre;
	private JTextField correo;
	private JTextField telefono;
    
    public ventanaInformacionPersonal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);
		
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
		
		JLabel lblDatosDeContacto = new JLabel("Datos de contacto");
		lblDatosDeContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto.setBounds(10, 80, 187, 36);
		contentPane.add(lblDatosDeContacto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(10, 116, 187, 36);
		contentPane.add(lblNombre);
		
		JLabel lblDatosDeContacto_1_1 = new JLabel("Correo");
		lblDatosDeContacto_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto_1_1.setBounds(10, 163, 187, 36);
		contentPane.add(lblDatosDeContacto_1_1);
		
		JLabel lblDatosDeContacto_1_2 = new JLabel("Teléfono");
		lblDatosDeContacto_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto_1_2.setBounds(10, 210, 187, 36);
		contentPane.add(lblDatosDeContacto_1_2);
		
		JButton btnNewButton = new JButton("Actualizar información");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				control.actualizarInformación();
			}
		});
		btnNewButton.setBounds(50, 257, 170, 35);
		contentPane.add(btnNewButton);			
	}
	
	public void muestra (controlInformacionPersonal control){
		//Recupera el nombre del usuario y lo pinta como encabezado
		JLabel lblInformacinPersonal = new JLabel("Información Personal: ¡Hola "+control.obtenerNombre()+"!");
		lblInformacinPersonal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformacinPersonal.setBounds(10, 47, 361, 36);
		contentPane.add(lblInformacinPersonal);

		//Recupera el nombre del usuario
		nombre = new JTextField(control.obtenerNombre()+" "+control.obtenerApellido());
		nombre.setBounds(95, 127, 164, 20);
		contentPane.add(nombre);
		nombre.setEditable(false);
		nombre.setColumns(10);
		//Recupera el correo del usuario
		correo = new JTextField(control.obtenerCorreo());
		correo.setEditable(false);
		correo.setColumns(10);
		correo.setBounds(95, 173, 164, 20);
		contentPane.add(correo);
		//Recupera el telefono del cliente
		telefono = new JTextField(control.obtenerTelefono());
		telefono.setEditable(false);
		telefono.setColumns(10);
		telefono.setBounds(95, 220, 164, 20);
		contentPane.add(telefono);

		this.control=control;
		setVisible(true);
	}
}
