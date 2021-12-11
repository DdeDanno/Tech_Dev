package mx.uam.ayd.proyecto.presentacion.perfil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
@Component
public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	private ControlPerfil control;

	public VentanaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMiAplicacin.setBounds(146, 0, 141, 36);
		contentPane.add(lblMiAplicacin);
		
		//Menu Navegacion
		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(10, 34, 404, 30);
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
		
		//titulo perfil
		JLabel lblNewLabel = new JLabel("Perfil");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 69, 54, 25);
		contentPane.add(lblNewLabel);
		
		//Titulo de bienvenida
		JLabel lblNewLabel_1 = new JLabel("¡Hola");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(74, 76, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		//Titulo de nombre
		JLabel lblNewLabel_2 = new JLabel("Carlos!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(110, 76, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		//Titulo pedidos
		JLabel lblNewLabel_1_1 = new JLabel("Pedidos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 105, 54, 14);
		contentPane.add(lblNewLabel_1_1);
		
		//Area con texto de los pedidos
		JTextArea txtrHolaMundoXd = new JTextArea("Hola\r\nmundo\r\nPrueba");
		txtrHolaMundoXd.setToolTipText("");
		txtrHolaMundoXd.setEditable(false);
		txtrHolaMundoXd.setBounds(23, 130, 174, 78);
		contentPane.add(txtrHolaMundoXd);
		
		//Scrollbar
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setToolTipText("");
		scrollBar.setBounds(10, 131, 11, 77);
		contentPane.add(scrollBar);
		
		//Titulo informacion
		JLabel lblNewLabel_1_1_1 = new JLabel("Información");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(235, 105, 115, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		//Botones de informacion
		JButton btnNewButton = new JButton("Informacion Personal");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(235, 131, 174, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInformacionDeLa = new JButton("Informacion de la cuenta");
		btnInformacionDeLa.setHorizontalAlignment(SwingConstants.LEFT);
		btnInformacionDeLa.setBounds(235, 170, 174, 23);
		contentPane.add(btnInformacionDeLa);
		//Terminan botones de informacion

	}

	public void muestra (ControlPerfil control) {
	this.control=control;
	setVisible(true);
	}
}