package mx.uam.ayd.proyecto.presentacion.estatusPedido;


import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		menuNav.setBounds(10, 23, 395, 30);
		contentPane.add(menuNav);
		JButton menu1,menu2,menu3,menu4;
		
		menu1=new JButton("Inicio");
		menu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu1.setBackground(Color.CYAN);
		menuNav.add(menu1);
		menu2=new JButton("Productos");
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu2.setBackground(Color.CYAN);
		menuNav.add(menu2);
		menu3=new JButton("Diseños");
		menu3.setBackground(Color.CYAN);
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		menu4=new JButton("Carrito");
		menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu4.setBackground(Color.CYAN);
		menuNav.add(menu4);

		//Botón para entrar al perfil
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.perfil();
			}
		});
		btnPerfil.setBounds(414, 23, 65, 30);
		btnPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPerfil.setBackground(Color.CYAN);
		contentPane.add(btnPerfil);

		//Botón para entrar a visualizar los diseños
		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.visualizarDiseños();
				} catch(Exception error){
					muestraDialogoConMensaje(error.getMessage());	
				}
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
		lblNewLabel_1.setBounds(10, 91, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		//Comienzan los titulos de los estatus del pedido
		txtPagoEnviado = new JTextField();
		txtPagoEnviado.setEditable(false);
		txtPagoEnviado.setText("| PAGO ENVIADO |");
		txtPagoEnviado.setBounds(10, 116, 107, 20);
		contentPane.add(txtPagoEnviado);
		txtPagoEnviado.setColumns(10);

		txtDiseando = new JTextField();
		txtDiseando.setEditable(false);
		txtDiseando.setText("| DISEÑANDO |");
		txtDiseando.setColumns(10);
		txtDiseando.setBounds(143, 116, 91, 20);
		contentPane.add(txtDiseando);
		
		txtImprimiendo = new JTextField();
		txtImprimiendo.setEditable(false);
		txtImprimiendo.setText("| IMPRIMIENDO |");
		txtImprimiendo.setColumns(10);
		txtImprimiendo.setBounds(257, 116, 97, 20);
		contentPane.add(txtImprimiendo);
		
		txtEnviado = new JTextField();
		txtEnviado.setEditable(false);
		txtEnviado.setText("| ENVIANDO |");
		txtEnviado.setColumns(10);
		txtEnviado.setBounds(377, 116, 78, 20);
		contentPane.add(txtEnviado);
		//Terminan los titulos del estatus del pedido

		JLabel lblNewLabel_1_2 = new JLabel("Adjuntar comprobante de pago");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 196, 213, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(234, 199, 89, 23);
		contentPane.add(btnNewButton);
		
	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

	public void muestra (ControlEstatusPedido control, int i) {
		//Obtenemos el FOLIO
		JLabel lblNewLabel_1_1 = new JLabel(control.conseguirFolio(i));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(50, 91, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		//Obtenemos el ESTADO DEL PAGO
		boolean pago=control.EstatusPago(i);
		//Checkbox PAGO ENVIADO
		JCheckBox chckbxEnviandoP = new JCheckBox("En proceso");
		chckbxEnviandoP.setEnabled(false);
		chckbxEnviandoP.setSelected(!pago);
		chckbxEnviandoP.setBounds(10, 143, 97, 23);
		contentPane.add(chckbxEnviandoP);
		
		JCheckBox chckbxEnviandoR = new JCheckBox("Realizado");
		chckbxEnviandoR.setEnabled(false);
		chckbxEnviandoR.setSelected(pago);
		chckbxEnviandoR.setBounds(10, 169, 97, 23);
		contentPane.add(chckbxEnviandoR);
		//Terminan checkbox PAGO ENVIADO

		//Obtenemos el ESTADO DEL ESTADO DEL DISEÑO
		boolean diseño=control.EstatusDisieño(i);
		//Checkbox DISEÑANDO
		JCheckBox chckbxDisP = new JCheckBox("En proceso");
		chckbxDisP.setEnabled(false);
		chckbxDisP.setSelected(!diseño);
		chckbxDisP.setBounds(137, 143, 97, 23);
		contentPane.add(chckbxDisP);

		JCheckBox chckbxDisR = new JCheckBox("Realizado");
		chckbxDisR.setEnabled(false);
		chckbxDisR.setSelected(diseño);
		chckbxDisR.setBounds(137, 169, 97, 23);
		contentPane.add(chckbxDisR);
		//Terminan checkbox DISEÑANDO

		//Obtenemos el ESTADO DE LA IMPRESION
		boolean impresion=control.EstatusImprimiendo(i);
		//Checkbox IMPRIMIENDO
		JCheckBox chckbxImpP = new JCheckBox("En proceso");
		chckbxImpP.setSelected(!impresion);
		chckbxImpP.setEnabled(false);
		chckbxImpP.setBounds(257, 143, 97, 23);
		contentPane.add(chckbxImpP);
		
		JCheckBox chckbxImpR = new JCheckBox("Realizado");
		chckbxImpR.setEnabled(false);
		chckbxImpR.setSelected(impresion);
		chckbxImpR.setBounds(257, 169, 97, 23);
		contentPane.add(chckbxImpR);
		//Terminan checkBox IMPRIMIENDO

		//Obtenemos el ESTADO DE EL ENVIO
		boolean envio=control.EstatusEnvio(i);
		//Checkbox ENVIANDO
		JCheckBox chckbxEnvP = new JCheckBox("En proceso");
		chckbxEnvP.setSelected(!envio);
		chckbxEnvP.setEnabled(false);
		chckbxEnvP.setBounds(377, 143, 97, 23);
		contentPane.add(chckbxEnvP);
		
		JCheckBox chckbxEnvR = new JCheckBox("Realizado");
		chckbxEnvR.setEnabled(false);
		chckbxEnvR.setSelected(envio);
		chckbxEnvR.setBounds(377, 169, 97, 23);
		contentPane.add(chckbxEnvR);
		//Terminan checkbox ENVIANDO
		this.control=control;
		setVisible(true);
		}
}
