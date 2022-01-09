package mx.uam.ayd.proyecto.presentacion.diseñadorEstatus;

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
import javax.swing.JComboBox;

public class VentanaDiseñadorEstatus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiseñadorEstatus frame = new VentanaDiseñadorEstatus();
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
	public VentanaDiseñadorEstatus() {
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
		
		JLabel lblDiseador = new JLabel("Pedido");
		lblDiseador.setForeground(SystemColor.textText);
		lblDiseador.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador.setBounds(10, 42, 73, 35);
		contentPane.add(lblDiseador);
		
		JLabel lblDiseador_1 = new JLabel("Folio num de folio");
		lblDiseador_1.setForeground(Color.BLACK);
		lblDiseador_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1.setBounds(10, 74, 174, 24);
		contentPane.add(lblDiseador_1);
		
		JLabel lblDiseador_2 = new JLabel("Modificar estatus del diseño");
		lblDiseador_2.setForeground(Color.BLACK);
		lblDiseador_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador_2.setBounds(10, 109, 256, 24);
		contentPane.add(lblDiseador_2);
		
		JButton btnNewButton = new JButton("Subir diseño");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(267, 110, 117, 24);
		contentPane.add(btnNewButton);
		
		JLabel lblDiseador_2_1 = new JLabel("Modificar estatus de la impresión");
		lblDiseador_2_1.setForeground(Color.BLACK);
		lblDiseador_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiseador_2_1.setBounds(10, 144, 256, 24);
		contentPane.add(lblDiseador_2_1);
		
		JLabel lblDiseador_2_2 = new JLabel("Finalizar pedido");
		lblDiseador_2_2.setForeground(Color.BLACK);
		lblDiseador_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador_2_2.setBounds(10, 188, 154, 24);
		contentPane.add(lblDiseador_2_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("En curso");
		comboBox.addItem("Completado");
		comboBox.setBounds(394, 110, 80, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("En curso");
		comboBox_1.addItem("Completado");
		comboBox_1.setBounds(267, 147, 80, 23);
		contentPane.add(comboBox_1);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTerminar.setBounds(163, 192, 117, 24);
		contentPane.add(btnTerminar);
		
	}
	}