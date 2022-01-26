package mx.uam.ayd.proyecto.presentacion.diseñadorPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.diseñadorPedidos.ControlDiseñadorPedidos;
import mx.uam.ayd.proyecto.presentacion.modificarDiseño.ControlModificarDiseño;
import mx.uam.ayd.proyecto.presentacion.mostrarVentas.ControlMostrarVentas;

@Component
public class ControlDiseñadorPrincipal {
    
    @Autowired
    private VentanaDiseñadorPrincipal ventana;
    @Autowired
    private ControlDiseñadorPedidos controlDiseñadorPedidos;
    @Autowired
    private ControlModificarDiseño controlModificarDiseño;
    @Autowired
    private ControlMostrarVentas controlMostrarVentas;

    public void inicia(){
        ventana.muestra(this);
    }
    
    public void diseñadorPedidos(){
        controlDiseñadorPedidos.inicia();
    }

    public void modificarDiseños(){
        controlModificarDiseño.inicia();
    }

    public void mostrarVentas(){
        controlMostrarVentas.inicia();
    }

}
