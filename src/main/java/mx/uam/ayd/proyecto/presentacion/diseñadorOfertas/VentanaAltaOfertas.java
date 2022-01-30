package mx.uam.ayd.proyecto.presentacion.diseñadorOfertas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentanaAltaOfertas extends JFrame {

    @Autowired
    private ControlAltaOfertas control;

    public LinkedList <Icon> listaIconos = new LinkedList <>();

    private JPanel contentPane;
    private JButton botonBuscar, botonAceptar, botonCancelar, botonTerminar;
    public static JLabel label_imagenes;

    //Constructor de la clase
    public VentanaAltaOfertas(){

        //Para que la ventana anterior no se cierre al cerrar esta ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        /*
        * Definición del panel principal
        */
        setBounds(400, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        /*
        *   Agregamos el label que mostrará la imagen que agregamos
        */
        label_imagenes = new JLabel();
        label_imagenes.setBounds(60, 40, 465, 250);
        label_imagenes.setBackground(Color.WHITE);
        label_imagenes.setOpaque(true);
        contentPane.add(label_imagenes);


        /*
        * Agregamos el funcionamiento de los botones según la elección
        */
        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                /* 
                * Recibimos la imagen en un objeto de tipo Image para poder escalarlo
                * al tamaño de nuestro label, después se convierte a tipo Icon para 
                * poder ser mostrado en el label
                */

                Image imagen = control.BuscaImagenes().getImage().getScaledInstance(
                    label_imagenes.getWidth(), label_imagenes.getHeight(), Image.SCALE_SMOOTH);
                
                Icon icono = new ImageIcon(imagen);
                
                label_imagenes.setIcon(icono);

            }//Fin del ActionPerformed
        });//Fin del ActionListener
        botonBuscar.setBounds(5,5,80,30);
        contentPane.add(botonBuscar);


        botonTerminar = new JButton("Terminar");
        botonTerminar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                /**
                 * Enviamos la lista para que después pueda ser mostrada en la
                 * ventana mostrar ofertas y se cierra la ventana actual
                 */
                setVisible(false);
            }
        });//Fin del botonTerminar
        botonTerminar.setBounds(420, 5, 90, 30);
        contentPane.add(botonTerminar);


        botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                /*
                * Tomamos la imagen y la insertamos en la lista, además
                * le notificamos al usuario si se guardo con éxito o no
                */
                listaIconos.add(label_imagenes.getIcon());
                label_imagenes.setIcon(null);

            }//Fin del ActionPerformed
        });//Fin del ActionListener
        botonAceptar.setBounds(150, 300, 80, 25);
        contentPane.add(botonAceptar);


        botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                /**
                 * Se limpia el label
                 */
                label_imagenes.setIcon(null);

            }//Fin del ActionPerformed
        });//Fin del ActionListener
        botonCancelar.setBounds(350, 300, 90, 25);
        contentPane.add(botonCancelar);

    }//Fin del constructor

    //Método para mostrar la ventana de altas
    public void muestra (ControlAltaOfertas control){
        this.control=control;
        setVisible(true);
    }//Fin del método muestra
    
}
