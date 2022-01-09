package mx.uam.ayd.proyecto.presentacion.diseñadorPedidos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class VentanaDiseñadorPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtCompletado;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiseñadorPedidos frame = new VentanaDiseñadorPedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDiseñadorPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(330, 1, 144, 35);
		contentPane.add(lblName);
		
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(172, 0, 134, 36);
		contentPane.add(lblMiAplicacin);
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 1, 484, 38);
		contentPane.add(panel);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setForeground(SystemColor.text);
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblAdministrador);
		
		JLabel lblDiseador = new JLabel("Pedidos");
		lblDiseador.setForeground(SystemColor.textText);
		lblDiseador.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador.setBounds(10, 42, 256, 35);
		contentPane.add(lblDiseador);
		
		JLabel lblDiseador_1 = new JLabel("Folio");
		lblDiseador_1.setForeground(Color.BLACK);
		lblDiseador_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1.setBounds(10, 74, 34, 24);
		contentPane.add(lblDiseador_1);
		
		JLabel lblDiseador_1_1 = new JLabel("Estatus de pago");
		lblDiseador_1_1.setForeground(Color.BLACK);
		lblDiseador_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_1.setBounds(65, 74, 108, 24);
		contentPane.add(lblDiseador_1_1);
		
		JLabel lblDiseador_1_2 = new JLabel("Estatus del diseño");
		lblDiseador_1_2.setForeground(Color.BLACK);
		lblDiseador_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_2.setBounds(175, 74, 119, 24);
		contentPane.add(lblDiseador_1_2);
		
		JLabel lblDiseador_1_2_1 = new JLabel("Estatus de la impresión");
		lblDiseador_1_2_1.setForeground(Color.BLACK);
		lblDiseador_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_2_1.setBounds(292, 74, 144, 24);
		contentPane.add(lblDiseador_1_2_1);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.setBounds(407, 102, 63, 24);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setText("12315315");
		textField.setBounds(4, 102, 63, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtCompletado = new JTextField();
		txtCompletado.setText("Completado");
		txtCompletado.setColumns(10);
		txtCompletado.setBounds(199, 102, 81, 24);
		contentPane.add(txtCompletado);
		
		textField_1 = new JTextField();
		textField_1.setText("Completado");
		textField_1.setColumns(10);
		textField_1.setBounds(87, 102, 81, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Completado");
		textField_2.setColumns(10);
		textField_2.setBounds(316, 102, 81, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("12315315");
		textField_3.setColumns(10);
		textField_3.setBounds(4, 137, 63, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Completado");
		textField_4.setColumns(10);
		textField_4.setBounds(87, 137, 81, 24);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Completado");
		textField_5.setColumns(10);
		textField_5.setBounds(199, 137, 81, 24);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("Completado");
		textField_6.setColumns(10);
		textField_6.setBounds(316, 137, 81, 24);
		contentPane.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.setBounds(407, 137, 63, 24);
		contentPane.add(btnNewButton_1);
	}
}