package mx.uam.ayd.proyecto.presentacion.agregarUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.event.ApplicationListenerMethodAdapter;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import mx.uam.ayd.proyecto.negocio.modelo.Grupo;

@SuppressWarnings("serial")
@Component
public class VentanaAgregarUsuario extends JFrame {

	private JPanel contentPane;
	private ControlAgregarUsuario control;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldContraseña;
	private JTextField textFieldContraseña2;
	private JTextField textFieldCorreoInicioSesion;
	private JTextField textFieldContraseñaInicioSesion;
	private JComboBox<String> comboBoxGrupo;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * VentanaAgregarUsuario frame = new VentanaAgregarUsuario();
	 * frame.setVisible(true);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public VentanaAgregarUsuario() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creación de etiquetas

		JLabel lblCorreoInicioSesion = new JLabel(" Correo ");
		lblCorreoInicioSesion.setBounds(28, 40, 80, 16);
		contentPane.add(lblCorreoInicioSesion);

		JLabel lblContraseñaInicioSesion = new JLabel(" Contraseña ");
		lblContraseñaInicioSesion.setBounds(28, 70, 80, 16);
		contentPane.add(lblContraseñaInicioSesion);

		JLabel lblCorreo = new JLabel(" Correo: ");
		lblCorreo.setBounds(28, 180, 80, 16);
		contentPane.add(lblCorreo);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(28, 210, 120, 16);
		contentPane.add(lblContraseña);

		JLabel lblContraseña2 = new JLabel("Confirmación:");
		lblContraseña2.setBounds(28, 240, 120, 16);
		contentPane.add(lblContraseña2);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 270, 80, 16);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 300, 61, 16);
		contentPane.add(lblApellido);

		// Creación de los recuadros de textos

		textFieldCorreoInicioSesion = new JTextField();
		textFieldCorreoInicioSesion.setBounds(120, 40, 130, 25);
		contentPane.add(textFieldCorreoInicioSesion);

		textFieldContraseñaInicioSesion = new JTextField();
		textFieldContraseñaInicioSesion.setBounds(120, 70, 130, 25);
		contentPane.add(textFieldContraseñaInicioSesion);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(120, 180, 130, 25);
		contentPane.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(120, 210, 130, 25);
		contentPane.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);

		textFieldContraseña2 = new JTextField();
		textFieldContraseña2.setBounds(120, 240, 130, 25);
		contentPane.add(textFieldContraseña2);
		textFieldContraseña2.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 270, 130, 25);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(120, 300, 130, 25);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		// creación de los botones

		JButton btnInicioSesion = new JButton(" Iniciar Sesión ");
		/*
		 * Listener para comenzar la HU 5, Tiene que validar si el usuario es un
		 * Administrador o diseñador.
		 */

		btnInicioSesion.setBounds(120, 110, 140, 29);
		contentPane.add(btnInicioSesion);

		JButton btnAgregar = new JButton(" REGISTRARME ");

		btnAgregar.setBounds(28, 390, 140, 29);
		contentPane.add(btnAgregar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		btnCancelar.setBounds(200, 390, 117, 29);
		contentPane.add(btnCancelar);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(28, 330, 61, 16);
		contentPane.add(lblGrupo);

		comboBoxGrupo = new JComboBox<>();
		comboBoxGrupo.setBounds(120, 330, 130, 27);

		contentPane.add(comboBoxGrupo);

		// Listeners

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String contraseña = textFieldContraseña.getText();
				 * String contraseña2 = textFieldContraseña2.getText();
				 * 
				 * if (contraseña != contraseña2) {
				 * muestraDialogoConMensaje("No Coinciden las Contraseñas!!!");
				 * control.inicia();
				 * }
				 */

				if (textFieldNombre.getText().equals("") || textFieldApellido.getText().equals("")
						|| textFieldContraseña.getText().equals("") || textFieldContraseña2.getText().equals("")
						|| textFieldCorreo.getText().equals("")) {
					muestraDialogoConMensaje("Los Campos de texto  NO deben estar vacios");

				} else {
					control.agregaUsuario(textFieldNombre.getText(), textFieldApellido.getText(),
							(String) comboBoxGrupo.getSelectedItem(), textFieldCorreo.getText(),
							textFieldContraseña.getText(), textFieldContraseña2.getText());
				}
			}
		});
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCorreoInicioSesion.getText().equals("")
						|| textFieldContraseñaInicioSesion.getText().equals("")) {
					muestraDialogoConMensaje("Los campos de texto NO deben estar vacios");

				} else {
					control.EncontrarAdmin(lblCorreoInicioSesion.getText(), lblContraseñaInicioSesion.getText());
				}

				// control.EncontrarAdmin(lblCorreoInicioSesion.getText());
			}
		});

	}

	public void muestra(ControlAgregarUsuario control, List<Grupo> grupos) {

		this.control = control;

		// Inicializamos las lineas de texto vacías

		textFieldNombre.setText("");

		textFieldApellido.setText("");

		textFieldCorreo.setText("");

		textFieldContraseña.setText("");

		textFieldContraseña2.setText("");

		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

		for (Grupo grupo : grupos) {
			comboBoxModel.addElement(grupo.getNombre());
		}

		comboBoxGrupo.setModel(comboBoxModel);

		setVisible(true);

	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
