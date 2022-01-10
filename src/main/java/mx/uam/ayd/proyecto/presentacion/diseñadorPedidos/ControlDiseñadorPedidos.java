package mx.uam.ayd.proyecto.presentacion.diseñadorPedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.diseñadorEstatus.ControlDiseñadorEstatus;

@Component
public class ControlDiseñadorPedidos {
    @Autowired
    private VentanaDiseñadorPedidos ventana;
    @Autowired
    private ControlDiseñadorEstatus controlDiseñadorEstatus;

    public void inicia(){
        ventana.muestra(this);
    }

    public void diseñadorEstatus(){
        controlDiseñadorEstatus.inicia();
    }
}
