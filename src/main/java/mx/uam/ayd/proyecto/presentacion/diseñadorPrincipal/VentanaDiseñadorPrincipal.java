package mx.uam.ayd.proyecto.presentacion.diseñadorPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDiseñadorPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiseñadorPrincipal frame = new VentanaDiseñadorPrincipal();
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
	public VentanaDiseñadorPrincipal() {
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
		
		JLabel lblDiseador = new JLabel("Diseñador ¡Hola Carlos!");
		lblDiseador.setForeground(SystemColor.textText);
		lblDiseador.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador.setBounds(10, 42, 256, 35);
		contentPane.add(lblDiseador);
		
		JLabel lblDiseador_1 = new JLabel("Suc. Av. Ermita #43");
		lblDiseador_1.setForeground(Color.BLACK);
		lblDiseador_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1.setBounds(10, 74, 256, 24);
		contentPane.add(lblDiseador_1);
		
		JLabel lblDiseador_2 = new JLabel("Visualizar pedidos");
		lblDiseador_2.setForeground(Color.BLACK);
		lblDiseador_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador_2.setBounds(10, 109, 256, 24);
		contentPane.add(lblDiseador_2);
		
		JButton btnNewButton = new JButton("Ver pedidos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(20, 139, 117, 35);
		contentPane.add(btnNewButton);
	}
}