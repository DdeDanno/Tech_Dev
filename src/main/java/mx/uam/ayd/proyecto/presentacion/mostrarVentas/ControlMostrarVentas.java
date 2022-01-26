package mx.uam.ayd.proyecto.presentacion.mostrarVentas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.datos.PedidoRepository;

@Component
public class ControlMostrarVentas {
    @Autowired
    private VentanaMostrarVentas ventana;
    @Autowired
    PedidoRepository pedidoRepository;

    public void inicia (){
        ventana.muestra(this);
    }

    


}
