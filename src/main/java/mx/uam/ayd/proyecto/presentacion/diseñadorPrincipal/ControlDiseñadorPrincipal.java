package mx.uam.ayd.proyecto.presentacion.diseñadorPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.diseñadorPedidos.ControlDiseñadorPedidos;
import mx.uam.ayd.proyecto.presentacion.modificarDiseño.ControlModificarDiseño;

@Component
public class ControlDiseñadorPrincipal {
    
    @Autowired
    private VentanaDiseñadorPrincipal ventana;
    @Autowired
    private ControlDiseñadorPedidos controlDiseñadorPedidos;
    @Autowired
    private ControlModificarDiseño controlModificarDiseño;

    public void inicia(){
        ventana.muestra(this);
    }
    
    public void diseñadorPedidos(){
        controlDiseñadorPedidos.inicia();
    }

    public void modificarDiseños(){
        controlModificarDiseño.inicia();
    }

}
