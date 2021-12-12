package mx.uam.ayd.proyecto.presentacion.carritoDeCompras;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@SuppressWarnings("serial")
@Component
public class VentanaCarritoDeCompras extends JFrame{
    private JPanel contentPane;

    @Autowired
    private ControlCarritoDeCompras control;
    

    JRadioButton radio1,radio2,radio3;
    JButton button;

    public VentanaCarritoDeCompras (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        //Titulo
        JLabel lblDiseño=new JLabel("CARRITO");
        lblDiseño.setBounds(10, 10, 160, 40);
        contentPane.add(lblDiseño);
        // Seleccionar sucursal
        JLabel lblSucursal=new JLabel("Selecciona tu sucursal");
        lblSucursal.setBounds(300, 10, 160, 40);
        contentPane.add(lblSucursal);
        radio1=new JRadioButton();
        radio1.setText("Los reyes centro");
        radio1.setBounds(300,40,150,30);
        radio2=new JRadioButton();
        radio2.setText("La Magdalena");
        radio2.setBounds(300,70,120,30);
        radio3=new JRadioButton();
        radio3.setText("Ixtapaluca");
        radio3.setBounds(300,100,120,30);
        add(radio1);
        add(radio2);
        add(radio3);

        // Boton seleccionar archivo
        JButton btnSubirArchivo=new JButton("Selecciona archivo..");
        btnSubirArchivo.setBounds(130, 95, 150, 29);
		btnSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    control.SubirArchivo();
			}
		});

        // Boton de generar compra
        JButton btnGenerarCompra = new JButton("Generar compra");
        btnGenerarCompra.setBounds(90, 210, 150, 29);
		contentPane.add(btnGenerarCompra);
        //Botones de usuario
        JButton btnDatosDiseño = new JButton("Datos diseño");
        btnDatosDiseño.setBounds(5, 50, 120, 29);
		contentPane.add(btnDatosDiseño);
        JButton btnEspecificaciones = new JButton("Especificaciones");
        btnEspecificaciones.setBounds(5, 80, 120, 29);
		contentPane.add(btnEspecificaciones);
        JButton btnAdjuntarArchivo = new JButton("Adjuntar archivo");
        btnAdjuntarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                contentPane.add(btnSubirArchivo);
			}
		});
        btnAdjuntarArchivo.setBounds(5, 110, 120, 29);
		contentPane.add(btnAdjuntarArchivo);
        JButton btnDisPrevios = new JButton("Diseños previos");
        btnDisPrevios.setBounds(5, 140, 120, 29);
		contentPane.add(btnDisPrevios);
        JButton btnSubeTuProy = new JButton("Sube tu proyecto");
        btnSubeTuProy.setBounds(5, 170, 120, 29);
		contentPane.add(btnSubeTuProy);

    }

    public void muestra (ControlCarritoDeCompras control){
        this.control=control;
        
        // Texto descripcion carrito de compras
        JTextArea Cotizacion=new JTextArea(control.muestraCarritodeCompra());
        Cotizacion.setBounds(270, 130, 200, 100);;
        contentPane.add(Cotizacion);
        setVisible(true);
    }

}
