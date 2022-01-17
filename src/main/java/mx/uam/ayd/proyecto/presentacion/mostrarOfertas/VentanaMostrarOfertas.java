package mx.uam.ayd.proyecto.presentacion.mostrarOfertas;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JOptionPane;

@Component
public class VentanaMostrarOfertas extends JFrame{

    /*
     * Declaración de las variables   
     */
    private JPanel contentPane;
    private JButton izquierda, derecha;
    public static JLabel label_imagenes;
    public static int numImagenes = 8;
    public int contador = 1;

    ImageIcon Imagen[] = new ImageIcon[numImagenes];

    @Autowired
    private ControlMostrarOfertas control;
    

    //Constructor de la clase
    public VentanaMostrarOfertas() {

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
        *   Definición del label, el que se encargará de mostrar las imágenes
        */
        label_imagenes = new JLabel();
        label_imagenes.setBounds(60, 35, 465, 300);
        label_imagenes.setBackground(Color.BLACK);
        label_imagenes.setOpaque(true);

            //Visor de imágenes
        for(int i=1; i<numImagenes+1; i++){
            Imagen[i-1] = new ImageIcon("Ofertas00" + i + ".jpg");
        }

            //Ajuste de la imagen
        Image imagenEscalada = Imagen[0].getImage().getScaledInstance(label_imagenes.getWidth(),
                label_imagenes.getHeight(), Image.SCALE_SMOOTH);
        
        Icon iconoEscalado = new ImageIcon(imagenEscalada);

        label_imagenes.setIcon(iconoEscalado);
        contentPane.add(label_imagenes);

        /*
        * Agregamos los botones que desplazarán las imágenes a la izquierda
        * o derecha, según lo requiera el cliente
        */
        izquierda = new JButton("<<");
        izquierda.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                try {
                    if(contador == 1){
                        contador = numImagenes-1;
                    }//fin del if

                    contador--;

                        //Ajuste de la imagen
                    Image imgEscalada = Imagen[contador].getImage().getScaledInstance(label_imagenes.getWidth(),
                            label_imagenes.getHeight(), Image.SCALE_SMOOTH);
        
                    Icon icnEscalado = new ImageIcon(imgEscalada);

                    label_imagenes.setIcon(icnEscalado);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al desplazar a la izquierda");
                }//Fin del try-catch
            }//Fin del actionPerformed
        });
        izquierda.setBounds(5, 130, 50, 50);
        contentPane.add(izquierda);

        derecha = new JButton(">>");
        derecha.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                try {
                    if(contador == numImagenes-2){
                        contador = 0;
                    }//Fin del if

                    contador++;
                    
                        //Ajuste de la imagen
                    Image imgEscalada1 = Imagen[contador].getImage().getScaledInstance(label_imagenes.getWidth(),
                        label_imagenes.getHeight(), Image.SCALE_SMOOTH);
        
                    Icon icnEscalado1 = new ImageIcon(imgEscalada1);

                    label_imagenes.setIcon(icnEscalado1);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al desplazar a la derecha");
                }//Fin del try-catch
            }//Fin del actionPerformed
        });
        derecha.setBounds(530, 130, 50, 50);
        contentPane.add(derecha);



    }//Fin del constructor

    //Método para mostrar la vista previa del total de la compra
    public void muestra (ControlMostrarOfertas control){
        this.control=control;
        setVisible(true);
    }//Fin del método muestra

}//Fin de la clase VentanaMostrarOfertas

