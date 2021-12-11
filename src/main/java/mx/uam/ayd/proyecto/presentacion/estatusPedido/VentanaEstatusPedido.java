package mx.uam.ayd.proyecto.presentacion.estatusPedido;


import java.awt.Font;

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
		JLabel lblNewLabel = new JLabel("Estatus del pedido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 69, 190, 25);
		contentPane.add(lblNewLabel);
		
		//Titulo de bienvenida
		JLabel lblNewLabel_1 = new JLabel("Folio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 105, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("729878989");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(50, 105, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtPagoEnviado = new JTextField();
		txtPagoEnviado.setEditable(false);
		txtPagoEnviado.setText("| PAGO ENVIADO |");
		txtPagoEnviado.setBounds(10, 130, 97, 20);
		contentPane.add(txtPagoEnviado);
		txtPagoEnviado.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("En proceso");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(10, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxRealizado = new JCheckBox("Realizado");
		chckbxRealizado.setEnabled(false);
		chckbxRealizado.setBounds(10, 183, 97, 23);
		contentPane.add(chckbxRealizado);
		
		txtDiseando = new JTextField();
		txtDiseando.setEditable(false);
		txtDiseando.setText("| DISEÑANDO |");
		txtDiseando.setColumns(10);
		txtDiseando.setBounds(113, 130, 82, 20);
		contentPane.add(txtDiseando);
		
		txtImprimiendo = new JTextField();
		txtImprimiendo.setEditable(false);
		txtImprimiendo.setText("| IMPRIMIENDO |");
		txtImprimiendo.setColumns(10);
		txtImprimiendo.setBounds(205, 130, 91, 20);
		contentPane.add(txtImprimiendo);
		
		txtEnviado = new JTextField();
		txtEnviado.setEditable(false);
		txtEnviado.setText("| ENVIADO |");
		txtEnviado.setColumns(10);
		txtEnviado.setBounds(306, 130, 67, 20);
		contentPane.add(txtEnviado);
		
		JCheckBox chckbxRealizado_1 = new JCheckBox("Realizado");
		chckbxRealizado_1.setEnabled(false);
		chckbxRealizado_1.setBounds(109, 183, 97, 23);
		contentPane.add(chckbxRealizado_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("En proceso");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setEnabled(false);
		chckbxNewCheckBox_1.setBounds(109, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("En proceso");
		chckbxNewCheckBox_1_1.setSelected(true);
		chckbxNewCheckBox_1_1.setEnabled(false);
		chckbxNewCheckBox_1_1.setBounds(205, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxRealizado_1_1 = new JCheckBox("Realizado");
		chckbxRealizado_1_1.setEnabled(false);
		chckbxRealizado_1_1.setBounds(205, 183, 97, 23);
		contentPane.add(chckbxRealizado_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("En proceso");
		chckbxNewCheckBox_1_2.setSelected(true);
		chckbxNewCheckBox_1_2.setEnabled(false);
		chckbxNewCheckBox_1_2.setBounds(306, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxRealizado_1_2 = new JCheckBox("Realizado");
		chckbxRealizado_1_2.setEnabled(false);
		chckbxRealizado_1_2.setBounds(306, 183, 97, 23);
		contentPane.add(chckbxRealizado_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adjuntar comprobante de pago");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 202, 213, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(50, 227, 89, 23);
		contentPane.add(btnNewButton);
		
	}

	public void muestra (ControlEstatusPedido control) {
		this.control=control;
		setVisible(true);
		}
}
