package mx.uam.ayd.proyecto.presentacion.actualizarInformación;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JTextField;
import java.awt.Choice;

@SuppressWarnings ("serial")
@Component
public class ventanaActualizarInformacion extends JFrame{
    private JPanel contentPane;
	private controlActualizarInformacion control;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField correo;
	private JTextField telefono;


    public ventanaActualizarInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(146, 0, 141, 36);
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblMiAplicacin);
		
		//Menu Navegacion
		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(10, 23, 500, 30);
		contentPane.add(menuNav);
		JButton menu1,menu2,menu3,menu4,iniSesion;
		
		menu1=new JButton("Inicio");
		menu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu1);
		menu2=new JButton("Productos");
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu2);
		menu3=new JButton("Diseños");
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		iniSesion = new JButton("Registrarse");
		iniSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(iniSesion);
		menu4=new JButton("Carrito");
		menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu4);
	
		JLabel lblDatosDeContacto = new JLabel("Datos de contacto");
		lblDatosDeContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto.setBounds(10, 74, 187, 36);
		contentPane.add(lblDatosDeContacto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(10, 107, 187, 36);
		contentPane.add(lblNombre);
		
		JLabel lblDatosDeContacto_1_1 = new JLabel("Correo");
		lblDatosDeContacto_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto_1_1.setBounds(10, 142, 187, 36);
		contentPane.add(lblDatosDeContacto_1_1);
		
		JLabel lblDatosDeContacto_1_2 = new JLabel("Teléfono");
		lblDatosDeContacto_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto_1_2.setBounds(10, 179, 187, 36);
		contentPane.add(lblDatosDeContacto_1_2);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApellido.setBounds(248, 107, 187, 36);
		contentPane.add(lblApellido);
		
	}

	public void muestra (controlActualizarInformacion control){
		//Recuperamos el nombre del cliente y lo escribimos como encabezado
		JLabel lblInformacinPersonal = new JLabel("Información Personal ¡Hola "+control.obtenerNombre()+"!");
		lblInformacinPersonal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformacinPersonal.setBounds(10, 47, 361, 36);
		contentPane.add(lblInformacinPersonal);
		//Recuperamos el nombre del cliente
		nombre = new JTextField(control.obtenerNombre());
		nombre.setBounds(90, 117, 139, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		//Recuperamos el apellido del cliente
		apellido = new JTextField(control.obtenerApellido());
		apellido.setColumns(10);
		apellido.setBounds(323, 117, 139, 20);
		contentPane.add(apellido);
		//Recuperamos el correo del cliente
		correo = new JTextField(control.obtenerCorreopart1());
		correo.setColumns(10);
		correo.setBounds(90, 154, 141, 20);
		contentPane.add(correo);
		//Recuperamos el telefono del cliente
		telefono = new JTextField(control.obtenerTelefono());
		telefono.setColumns(10);
		telefono.setBounds(90, 189, 141, 20);
		contentPane.add(telefono);
		//Para cambiar tipo de correo
		JComboBox correo_actualizar = new JComboBox();
		correo_actualizar.addItem("Seleccionar correo...");
		correo_actualizar.addItem("@hotmail.com");
		correo_actualizar.addItem("@gmail.com");
		correo_actualizar.addItem("@outlook.es");
		correo_actualizar.setBounds(237, 154, 160, 20);
		contentPane.add(correo_actualizar);

		//Boton para guardar informacion
		JButton btnNewButton = new JButton("Guardar información");
		btnNewButton.setBounds(309, 186, 153, 44);
		contentPane.add(btnNewButton);
				
		this.control=control;
		setVisible(true);
	}
}
