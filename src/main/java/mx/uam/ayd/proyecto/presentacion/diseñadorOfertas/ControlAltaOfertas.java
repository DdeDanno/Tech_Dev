package mx.uam.ayd.proyecto.presentacion.diseñadorOfertas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioOfertas;

@Component
public class ControlAltaOfertas {
    
    @Autowired
    private VentanaAltaOfertas ventana;

    @Autowired
    private ServicioOfertas servicioOfertas;

        //Método que muestra la Ventana
    public void inicia (){
        ventana.muestra(this);
    }//Fin de inicia

        /*
        *   Método que se conecta con la clase ServicioOfertas para hacer una búsqueda
        */
    public ImageIcon BuscaImagenes(){
        try {
            return servicioOfertas.BuscarImagenes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar las imagenes" + e);
            return null;
        }//Fin del try-catch
    }//Fin del método BuscaImagenes


}//Fin de la clase ABOfertas
