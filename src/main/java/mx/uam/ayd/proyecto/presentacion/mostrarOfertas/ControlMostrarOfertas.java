package mx.uam.ayd.proyecto.presentacion.mostrarOfertas;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCarrito;
import mx.uam.ayd.proyecto.negocio.ServicioVenta;

@Component
public class ControlMostrarOfertas {
    
    @Autowired
    private VentanaMostrarOfertas ventana;

    //Método que muestra la Ventana
    public void inicia (){
        ventana.muestra(this);
    }//Fin de inicia

}//Fin de la clase ControlMostrarOfertas
