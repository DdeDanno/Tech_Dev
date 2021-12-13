package mx.uam.ayd.proyecto.presentacion.perfil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import lombok.var;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
@Component
public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	private ControlPerfil control;
	public int btnIncremento=1;
	public VentanaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
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

		//Boto que abre el catalogo de diseños
		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.visualizarDiseños();
				} catch(Exception error){
					System.out.println("Error");
				}
			}
		});

		// Listenes para mandar a llamar al controlAgregarUsuario
		iniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control.agregarUsuario();

			}
		});
		
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
		
		//Titulo pedidos
		JLabel lblNewLabel_1_1 = new JLabel("Pedidos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 105, 54, 14);
		contentPane.add(lblNewLabel_1_1);

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
	//Recupera el nombre del cliente y lo escribe
	JLabel lblNewLabel_2 = new JLabel(control.conseguirNombre());
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel_2.setBounds(110, 76, 70, 14);
	
	//Recupera el numero de pedidos existentes
	int existentes=control.pedidosExistentes();
	int aumento1=129, aumento2=130;
	JButton[] btnDetalles = new JButton[existentes];
	//CREAMOS LOS BOTONES DE DETALLES Y LOS FOLIOS DE LOS PEDIDOS
	for (int i=0;i<existentes;i++){
		//CREAMOS BOTONES DE DETALLES
		btnDetalles[i]=new JButton("Detalles");
		btnDetalles[i].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			control.estatusPedido(1);
		}
	});
	btnDetalles[i].setHorizontalAlignment(SwingConstants.LEADING);
	btnDetalles[i].setBounds(140, aumento1, 85, 25);
	contentPane.add(btnDetalles[i]);
	//Folios de los pedidos
	//Recupera el numero de FOLIO
	JTextArea txtPedido1_1 = new JTextArea(control.recuperaFolio(i+1));
	txtPedido1_1.setEditable(false);
	txtPedido1_1.setBounds(58, aumento2, 82, 25);
	contentPane.add(txtPedido1_1);

	//Comienzan a mostrarse los pedidos
	JTextArea txtFolio1 = new JTextArea("Folio");
	txtFolio1.setEditable(false);
	txtFolio1.setBounds(20, aumento2, 35, 25);
	contentPane.add(txtFolio1);

	//Incrementamos las variables
	aumento1=aumento1+27;
	aumento2=aumento2+26;
	btnIncremento++;
	}

	//Terminan de mostrarse los pedidos 
	contentPane.add(lblNewLabel_2);
	setVisible(true);
	}
}