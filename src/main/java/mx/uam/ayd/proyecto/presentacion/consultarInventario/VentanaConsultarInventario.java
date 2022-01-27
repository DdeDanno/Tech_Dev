package mx.uam.ayd.proyecto.presentacion.consultarInventario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.SystemColor;

import org.springframework.stereotype.Component;

@Component
public class VentanaConsultarInventario extends JFrame {
    private JPanel contentPane;

    private ControlConsultarInventario control;

    private JTextField textFieldNombreArticulo;
    private JTextField textFieldTotalPiezas;

    public VentanaConsultarInventario() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Nombre del personal
        JLabel lblName = new JLabel("Nombre");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblName.setBounds(430, 1, 244, 35);
        contentPane.add(lblName);

        // Nombre de la empresa
        JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
        lblMiAplicacin.setBounds(222, 0, 234, 36);
        contentPane.add(lblMiAplicacin);
        lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));

        // Panel de color y titulos
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

        JLabel lblInventario = new JLabel("Inventario.");
        lblInventario.setForeground(SystemColor.textText);
        lblInventario.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInventario.setBounds(10, 42, 256, 35);
        contentPane.add(lblInventario);

        // Jlabel
        JLabel lblNombreArticulo = new JLabel("Nombre del Artículo:");
        lblNombreArticulo.setBounds(20, 100, 120, 25);
        contentPane.add(lblNombreArticulo);

        JLabel lblTotalPiezas = new JLabel("Total de Piezas:");
        lblTotalPiezas.setBounds(20, 200, 110, 25);
        contentPane.add(lblTotalPiezas);

        // Cuadros de texto
        textFieldNombreArticulo = new JTextField();
        textFieldNombreArticulo.setBounds(150, 100, 150, 25);
        contentPane.add(textFieldNombreArticulo);

        textFieldTotalPiezas = new JTextField();
        textFieldTotalPiezas.setBounds(150, 200, 150, 25);
        contentPane.add(textFieldTotalPiezas);

        // Botones

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(350, 100, 117, 29);
        contentPane.add(btnCrear);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(350, 150, 117, 29);
        contentPane.add(btnBorrar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(350, 200, 117, 29);
        contentPane.add(btnActualizar);

        // Listeners para los botones
        // botón crear
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textFieldNombreArticulo.getText().equals("") || textFieldTotalPiezas.getText().equals("")) {
                    muestraDialogoConMensaje("Los Campos de texto NO deben estar vacios. ");
                } else {
                    control.CrearArticulo(textFieldNombreArticulo.getText(), textFieldTotalPiezas.getText());
                    textFieldNombreArticulo.setText("");
                    textFieldTotalPiezas.setText("");

                }
            }
        });

        // Botón Borrar
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textFieldNombreArticulo.getText().equals("")) {
                    muestraDialogoConMensaje("El Campo de Nombre NO debe esta vacio. ");
                } else {
                    control.BorraArticulo(textFieldNombreArticulo.getText());
                    textFieldNombreArticulo.setText("");
                    textFieldTotalPiezas.setText("");
                }

            }
        });

        // Botón Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textFieldNombreArticulo.getText().equals("") || textFieldTotalPiezas.getText().equals("")) {
                    muestraDialogoConMensaje("Los Campos de texto NO deben estar vacios. ");
                } else {
                    control.ActualizaArticulo(textFieldNombreArticulo.getText(), textFieldTotalPiezas.getText());
                    textFieldNombreArticulo.setText("");
                    textFieldTotalPiezas.setText("");
                }

            }
        });

    }

    public void muestraDialogoConMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }

    public void muestra(ControlConsultarInventario control) {
        this.control = control;
        setVisible(true);

        // Inicializo los cuadros de Texto

        textFieldNombreArticulo.setText("");
        textFieldTotalPiezas.setText("");
    }

}
