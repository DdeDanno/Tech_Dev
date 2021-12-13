package mx.uam.ayd.proyecto.presentacion.generarTicket;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCarrito;
import mx.uam.ayd.proyecto.negocio.ServicioVenta;

@Component
public class ControlGenerarTicket {
    
    @Autowired
    private VentanaGenerarTicket ventana;

    @Autowired
    private ServicioCarrito servicioCarrito;

    @Autowired
    private ServicioVenta servicioVenta;

    //Método que muestra la Ventana
    public void inicia (){
        ventana.muestra(this);
    }//Fin de inicia

    //Método que muestra los artículos del carrito
    public String muestraCarrito(){
        return servicioCarrito.muestraCarrito();
    }//Fin de muestra carrito

    //Método que genera el ticket
    public void imprimeTicket(){
        try {
            servicioVenta.creaFormato();
        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null, "Error al cargar el formato");
        }
        
    }
}
