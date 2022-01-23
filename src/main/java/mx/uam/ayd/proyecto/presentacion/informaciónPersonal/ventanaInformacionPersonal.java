package mx.uam.ayd.proyecto.presentacion.informaciónPersonal;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class ventanaInformacionPersonal extends JFrame{
    private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    
    public ventanaInformacionPersonal() {
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
		menu3=new JButton("DiseÃ±os");
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		iniSesion = new JButton("Registrarse");
		iniSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(iniSesion);
		menu4=new JButton("Carrito");
		menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu4);
		
		JLabel lblInformacinPersonal = new JLabel("Informaci\u00F3n Personal \u00A1Hola Carlos!");
		lblInformacinPersonal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformacinPersonal.setBounds(10, 47, 361, 36);
		contentPane.add(lblInformacinPersonal);
		
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
		lblDatosDeContacto_1_1.setBounds(10, 131, 187, 36);
		contentPane.add(lblDatosDeContacto_1_1);
		
		JLabel lblDatosDeContacto_1_2 = new JLabel("Tel\u00E9fono");
		lblDatosDeContacto_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeContacto_1_2.setBounds(10, 154, 187, 36);
		contentPane.add(lblDatosDeContacto_1_2);
		
		textField = new JTextField();
		textField.setBounds(95, 117, 164, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 141, 164, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 164, 164, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Actualizar informaci\u00F3n");
		btnNewButton.setBounds(20, 201, 155, 23);
		contentPane.add(btnNewButton);
				
	}
}
