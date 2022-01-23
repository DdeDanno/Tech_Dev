package mx.uam.ayd.proyecto.presentacion.informaciónPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.presentacion.actualizarInformación.controlActualizarInformacion;

@Component
public class controlInformacionPersonal {
    @Autowired
    private ventanaInformacionPersonal ventana;
    @Autowired
    private controlActualizarInformacion controlActualizarInformacion;
    @Autowired
    private ServicioCliente servicioCliente;

    public void inicia (){
        ventana.muestra(this);
    }
    
    public void actualizarInformación (){
        controlActualizarInformacion.inicia();
    }

    public String obtenerNombre(){
        return servicioCliente.nombreCliente();
    }
}
