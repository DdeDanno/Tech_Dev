package mx.uam.ayd.proyecto.presentacion.diseñadorOfertas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentanaBajaOfertas extends JFrame{

    @Autowired
    ControlBajaOfertas control;

    private JPanel contentPane;
    public static  JLabel label_imagenes;

    //Constructor de la clase
    public VentanaBajaOfertas(){

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
        label_imagenes.setBounds(60, 35, 465, 300);
        label_imagenes.setBackground(Color.BLACK);
        label_imagenes.setOpaque(true);
        contentPane.add(label_imagenes);

    }//Fin del constructor

    //Método para mostrar la ventana de bajas
    public void muestra (ControlBajaOfertas control){
        this.control=control;
        setVisible(true);
    }//Fin del método muestra
    
}//Fin de la clase VentanaBajaOfertas
