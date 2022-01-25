package mx.uam.ayd.proyecto.presentacion.diseñadorPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.consultarInventario.ControlConsultarInventario;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class VentanaDiseñadorPrincipal extends JFrame {
	private JPanel contentPane;
	private ControlDiseñadorPrincipal control;

	@Autowired
	private ControlConsultarInventario controlConsultarInventario;

	public VentanaDiseñadorPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nombre del personal
		JLabel lblName = new JLabel("Nombre");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(330, 1, 144, 35);
		contentPane.add(lblName);

		// Nombre de la empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(172, 0, 134, 36);
		contentPane.add(lblMiAplicacin);
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));

		// Panel de color y titulos
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
		// Terminan

		// Boton para ver los pedidos de la sucursal
		JButton btnNewButton = new JButton("Ver pedidos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.diseñadorPedidos();
			}
		});
		btnNewButton.setBounds(20, 139, 117, 35);
		contentPane.add(btnNewButton);

		// HU-06-iniciar-sesión
		// Boton para ver el Inventario de la sucursal
		JButton btnInventario = new JButton("Inventario");
		btnInventario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.consultarInventario();
			}
		});
		btnInventario.setBounds(180, 139, 117, 35);
		contentPane.add(btnInventario);

		// Boton para ver los Diseños de la sucursal

		// Boton para modificar los diseños

		JButton btnDiseños = new JButton("Diseños");
		btnDiseños.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDiseños.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aqui poner el control para llamar a la ventana de los Diseños

			}
		});
		btnDiseños.setBounds(340, 139, 117, 35);
		contentPane.add(btnDiseños);

		// Boton para ver las Ventas de la sucursal
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui poner el control para llamar a la ventana de las ventas
			}
		});
		btnVentas.setBounds(20, 195, 117, 35);
		contentPane.add(btnVentas);

		// Boton para ver las Ofertas de la sucursal
		JButton btnOfertas = new JButton("¡OFERTAS!");
		btnOfertas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui poner el control para llamar a la ventana de las ofertas
			}
		});
		btnOfertas.setBounds(180, 195, 117, 35);
		contentPane.add(btnOfertas);

		// Boton para ver las Compras de la sucursal
		JButton btnCompras = new JButton("Compras");
		btnCompras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui poner el control para llamar a la ventana de las compras
			}
		});
		btnCompras.setBounds(340, 195, 117, 35);
		contentPane.add(btnCompras);
	}

	public void muestra(ControlDiseñadorPrincipal control) {
		this.control = control;
		setVisible(true);
	}
}