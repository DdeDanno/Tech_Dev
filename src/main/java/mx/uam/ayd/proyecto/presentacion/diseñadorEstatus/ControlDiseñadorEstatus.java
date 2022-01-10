package mx.uam.ayd.proyecto.presentacion.diseñadorEstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlDiseñadorEstatus {
    @Autowired
    private VentanaDiseñadorEstatus ventana;

    public void inicia(){
        ventana.muestra(this);
    }
}
