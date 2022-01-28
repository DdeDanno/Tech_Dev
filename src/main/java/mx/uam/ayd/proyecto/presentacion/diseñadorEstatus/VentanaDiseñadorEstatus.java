package mx.uam.ayd.proyecto.presentacion.diseñadorEstatus;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JComboBox;

@Component
public class VentanaDiseñadorEstatus extends JFrame {

	private JPanel contentPane;
	private ControlDiseñadorEstatus control;

	public VentanaDiseñadorEstatus() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nombre del personal
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(330, 1, 144, 35);
		contentPane.add(lblName);
		
		//Nombre de la empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(172, 0, 134, 36);
		contentPane.add(lblMiAplicacin);
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//Panel de color y titulos
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
		
		JLabel lblDiseador_2 = new JLabel("Modificar estatus del diseño");
		lblDiseador_2.setForeground(Color.BLACK);
		lblDiseador_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiseador_2.setBounds(10, 109, 256, 24);
		contentPane.add(lblDiseador_2);
		//Terminan 

		//Boton para subir diseño
		JButton btnNewButton = new JButton("Subir diseño");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.subirArchivo();
			}
		});
		btnNewButton.setBounds(267, 110, 117, 24);
		contentPane.add(btnNewButton);
		
		//Titulos para modificar los estatus de los pedidos
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

	}
	
	public void muestra(ControlDiseñadorEstatus control, int i){
		JLabel lblFolio = new JLabel("Folio num de folio: "+control.numpedido(i));
		lblFolio.setForeground(Color.BLACK);
		lblFolio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFolio.setBounds(10, 74, 190, 24);
		contentPane.add(lblFolio);

		//Para cambiar el estatus del pedido dos botones
		JComboBox estatus_diseño = new JComboBox();
		estatus_diseño.addItem("En curso");
		estatus_diseño.addItem("Completado");
		estatus_diseño.setBounds(394, 110, 80, 23);
		contentPane.add(estatus_diseño);
		
		JComboBox estatus_Impresion = new JComboBox();
		estatus_Impresion.addItem("En curso");
		estatus_Impresion.addItem("Completado");
		estatus_Impresion.setBounds(267, 147, 80, 23);
		contentPane.add(estatus_Impresion);
		//Termina para modificar los estatus de los botones

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.actualizarDiseño(estatus_diseño.getSelectedItem().toString(),i);
				control.actualizarImpresion(estatus_Impresion.getSelectedItem().toString(),i);
				JOptionPane.showMessageDialog(null,"Se actualizo con exito");
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(163, 192, 117, 24);
		contentPane.add(btnActualizar);

		this.contentPane.updateUI();
		this.control=control;
		setVisible(true);
	}

	}