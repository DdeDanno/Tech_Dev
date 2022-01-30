package mx.uam.ayd.proyecto.presentacion.diseñadorPedidos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.diseñadorEstatus.VentanaDiseñadorEstatus;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@Component
public class VentanaDiseñadorPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField txtFolio1;
	private JTextField txtEstatusDiseño1;
	private JTextField txtEstatusPago1;
	private JTextField txtEstatusImpresion1;
	private JTextField txtFolio2;
	private JTextField txtEstatusDiseño2;
	private JTextField txtEstatusPago2;
	private JTextField txtEstatusImpresion2;

	private ControlDiseñadorPedidos control;
	public VentanaDiseñadorPedidos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nombre del personal
		JLabel lblName = new JLabel("Carlos");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(416, 2, 144, 35);
		contentPane.add(lblName);
		
		//Nombre de la empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(207, 0, 134, 36);
		contentPane.add(lblMiAplicacin);
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//Panel de color y titulos
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 1, 584, 38);
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
		lblDiseador_1.setBounds(10, 88, 34, 24);
		contentPane.add(lblDiseador_1);
		
		JLabel lblDiseador_1_1 = new JLabel("Estatus de pago");
		lblDiseador_1_1.setForeground(Color.BLACK);
		lblDiseador_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_1.setBounds(89, 88, 108, 24);
		contentPane.add(lblDiseador_1_1);
		
		JLabel lblDiseador_1_2 = new JLabel("Estatus del diseño");
		lblDiseador_1_2.setForeground(Color.BLACK);
		lblDiseador_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_2.setBounds(207, 88, 119, 24);
		contentPane.add(lblDiseador_1_2);
		
		JLabel lblDiseador_1_2_1 = new JLabel("Estatus de la impresión");
		lblDiseador_1_2_1.setForeground(Color.BLACK);
		lblDiseador_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiseador_1_2_1.setBounds(336, 88, 144, 24);
		contentPane.add(lblDiseador_1_2_1);

		//Terminan

		//Botones para abrir los pedidos
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDiseñadorEstatus ventana = control.diseñadorEstatus(1);
				ventana.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						txtEstatusDiseño1.setText(control.estatusDis(1));
						txtEstatusImpresion1.setText(control.estatusImpresion(1));
						
					}
				});
			}
		});
		btnNewButton.setBounds(497, 111, 63, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDiseñadorEstatus ventana = control.diseñadorEstatus(2);
				ventana.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						txtEstatusDiseño2.setText(control.estatusDis(2));
						txtEstatusImpresion2.setText(control.estatusImpresion(2));
						
					}
				});
			}
		});
		btnNewButton_1.setBounds(497, 160, 63, 35);
		contentPane.add(btnNewButton_1);
	}

	public void muestra(ControlDiseñadorPedidos control){

		//PEDIDOS HU 5
		//PEDIDO 1
		txtFolio1 = new JTextField();
		// Econtramos el folio y lo escribimos
		txtFolio1.setText(control.numpedido(1));
		txtFolio1.setEditable(false);
		txtFolio1.setBounds(10, 116, 70, 24);
		contentPane.add(txtFolio1);
		txtFolio1.setColumns(10);

		//Ponemos el estatus del pago 1
		txtEstatusPago1 = new JTextField();
		txtEstatusPago1.setEditable(false);
		txtEstatusPago1.setText(control.estatusPago(1));
		txtEstatusPago1.setColumns(10);
		txtEstatusPago1.setBounds(98, 116, 90, 24);
		contentPane.add(txtEstatusPago1);

		//Ponemos el estatus del diseño 1
		txtEstatusDiseño1 = new JTextField();
		txtEstatusDiseño1.setEditable(false);
		txtEstatusDiseño1.setText(control.estatusDis(1));
		txtEstatusDiseño1.setColumns(10);
		txtEstatusDiseño1.setBounds(221, 116, 90, 24);
		contentPane.add(txtEstatusDiseño1);
	
		//Ponemos el estauts de impresion
		txtEstatusImpresion1 = new JTextField();
		txtEstatusImpresion1.setEditable(false);
		txtEstatusImpresion1.setText(control.estatusImpresion(1));
		txtEstatusImpresion1.setColumns(10);
		txtEstatusImpresion1.setBounds(363, 116, 90, 24);
		contentPane.add(txtEstatusImpresion1);
		
		//PEDIDO 2
		txtFolio2 = new JTextField();
		txtFolio2.setEditable(false);
		txtFolio2.setText(control.numpedido(2));
		txtFolio2.setColumns(10);
		txtFolio2.setBounds(10, 165, 70, 24);
		contentPane.add(txtFolio2);
		
		txtEstatusPago2 = new JTextField();
		txtEstatusPago2.setEditable(false);
		txtEstatusPago2.setText(control.estatusPago(2));
		txtEstatusPago2.setColumns(10);
		txtEstatusPago2.setBounds(98, 165, 90, 24);
		contentPane.add(txtEstatusPago2);
		
		txtEstatusDiseño2 = new JTextField();
		txtEstatusDiseño2.setEditable(false);
		txtEstatusDiseño2.setText(control.estatusDis(2));
		txtEstatusDiseño2.setColumns(10);
		txtEstatusDiseño2.setBounds(221, 165, 90, 24);
		contentPane.add(txtEstatusDiseño2);
		
		txtEstatusImpresion2 = new JTextField();
		txtEstatusImpresion2.setEditable(false);
		txtEstatusImpresion2.setText(control.estatusImpresion(2));
		txtEstatusImpresion2.setColumns(10);
		txtEstatusImpresion2.setBounds(363, 165, 90, 24);
		contentPane.add(txtEstatusImpresion2);

		this.control=control;
		setVisible(true);
	}

}