package mx.uam.ayd.proyecto.presentacion.estatusPedido;


import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;


@SuppressWarnings("serial")
@Component
public class VentanaEstatusPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtPagoEnviado;
	private JTextField txtDiseando;
	private JTextField txtImprimiendo;
	private JTextField txtEnviado;
	private ControlEstatusPedido control;

	public VentanaEstatusPedido() {
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

		//Boton que abre el catalogo de diseños
		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.visualizarDiseños();
				} catch(Exception error){
					System.out.println("Error");	
				}
			}
		});


		//Boton perfil NECESARIO PARA HU:ESTATUS DEL PEDIDO NO BORRAR
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.perfil();
			}
		});
		btnPerfil.setBounds(414, 23, 65, 30);
		btnPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(btnPerfil);

		// Listenes para mandar a llamar al controlAgregarUsuario
		iniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control.agregarUsuario();

			}
		});
		
		//titulo estatus del pedido
		JLabel lblNewLabel = new JLabel("Estatus del pedido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 59, 190, 25);
		contentPane.add(lblNewLabel);
		
		//Titulo folio
		JLabel lblNewLabel_1 = new JLabel("Folio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 103, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		//Comienzan los titulos de los estatus del pedido
		txtPagoEnviado = new JTextField();
		txtPagoEnviado.setEditable(false);
		txtPagoEnviado.setText("| PAGO ENVIADO |");
		txtPagoEnviado.setBounds(10, 144, 107, 20);
		contentPane.add(txtPagoEnviado);
		txtPagoEnviado.setColumns(10);

		txtDiseando = new JTextField();
		txtDiseando.setEditable(false);
		txtDiseando.setText("| DISEÑANDO |");
		txtDiseando.setColumns(10);
		txtDiseando.setBounds(168, 144, 91, 20);
		contentPane.add(txtDiseando);
		
		txtImprimiendo = new JTextField();
		txtImprimiendo.setEditable(false);
		txtImprimiendo.setText("| IMPRIMIENDO |");
		txtImprimiendo.setColumns(10);
		txtImprimiendo.setBounds(302, 144, 97, 20);
		contentPane.add(txtImprimiendo);
		
		txtEnviado = new JTextField();
		txtEnviado.setEditable(false);
		txtEnviado.setText("| ENVIANDO |");
		txtEnviado.setColumns(10);
		txtEnviado.setBounds(438, 144, 78, 20);
		contentPane.add(txtEnviado);
		//Terminan los titulos del estatus del pedido

		JLabel lblNewLabel_1_2 = new JLabel("Adjuntar comprobante de pago");
		lblNewLabel_1_2.setBounds(10, 265, 213, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(233, 262, 89, 35);
		contentPane.add(btnNewButton);
		
	}

	public void muestra (ControlEstatusPedido control, int i) {
		//Obtenemos el FOLIO
		JLabel lblNewLabel_1_1 = new JLabel(control.conseguirFolio(i));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(53, 103, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		//Obtenemos el ESTADO DEL PAGO
		boolean pago=control.EstatusPago(i);
		//Checkbox PAGO ENVIADO
		JCheckBox chckbxEnviandoP = new JCheckBox("En proceso");
		chckbxEnviandoP.setEnabled(false);
		chckbxEnviandoP.setSelected(!pago);
		chckbxEnviandoP.setBounds(10, 171, 97, 23);
		contentPane.add(chckbxEnviandoP);
		
		JCheckBox chckbxEnviandoR = new JCheckBox("Realizado");
		chckbxEnviandoR.setEnabled(false);
		chckbxEnviandoR.setSelected(pago);
		chckbxEnviandoR.setBounds(10, 197, 97, 23);
		contentPane.add(chckbxEnviandoR);
		//Terminan checkbox PAGO ENVIADO

		//Obtenemos el ESTADO DEL ESTADO DEL DISEÑO
		boolean diseño=control.EstatusDisieño(i);
		//Checkbox DISEÑANDO
		JCheckBox chckbxDisP = new JCheckBox("En proceso");
		chckbxDisP.setEnabled(false);
		chckbxDisP.setSelected(!diseño);
		chckbxDisP.setBounds(168, 171, 97, 23);
		contentPane.add(chckbxDisP);

		JCheckBox chckbxDisR = new JCheckBox("Realizado");
		chckbxDisR.setEnabled(false);
		chckbxDisR.setSelected(diseño);
		chckbxDisR.setBounds(168, 197, 97, 23);
		contentPane.add(chckbxDisR);
		//Terminan checkbox DISEÑANDO

		//Obtenemos el ESTADO DE LA IMPRESION
		boolean impresion=control.EstatusImprimiendo(i);
		//Checkbox IMPRIMIENDO
		JCheckBox chckbxImpP = new JCheckBox("En proceso");
		chckbxImpP.setSelected(!impresion);
		chckbxImpP.setEnabled(false);
		chckbxImpP.setBounds(302, 171, 97, 23);
		contentPane.add(chckbxImpP);
		
		JCheckBox chckbxImpR = new JCheckBox("Realizado");
		chckbxImpR.setEnabled(false);
		chckbxImpR.setSelected(impresion);
		chckbxImpR.setBounds(302, 197, 97, 23);
		contentPane.add(chckbxImpR);
		//Terminan checkBox IMPRIMIENDO

		//Obtenemos el ESTADO DE EL ENVIO
		boolean envio=control.EstatusEnvio(i);
		//Checkbox ENVIANDO
		JCheckBox chckbxEnvP = new JCheckBox("En proceso");
		chckbxEnvP.setSelected(!envio);
		chckbxEnvP.setEnabled(false);
		chckbxEnvP.setBounds(438, 171, 97, 23);
		contentPane.add(chckbxEnvP);
		
		JCheckBox chckbxEnvR = new JCheckBox("Realizado");
		chckbxEnvR.setEnabled(false);
		chckbxEnvR.setSelected(envio);
		chckbxEnvR.setBounds(438, 197, 97, 23);
		contentPane.add(chckbxEnvR);
		//Terminan checkbox ENVIANDO
		this.control=control;
		setVisible(true);
		}
}
