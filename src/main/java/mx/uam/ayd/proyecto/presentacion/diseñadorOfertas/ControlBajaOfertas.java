package mx.uam.ayd.proyecto.presentacion.diseñadorOfertas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlBajaOfertas {

    @Autowired
    private VentanaBajaOfertas ventana;

        //Método que muestra la Ventana
    public void inicia (){
        ventana.muestra(this);
    }//Fin de inicia
    
}
