package mx.uam.ayd.proyecto.presentacion.actualizarInformación;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;

@Component
public class controlActualizarInformacion {
    @Autowired
    private ventanaActualizarInformacion ventana;
    @Autowired
    private ServicioCliente servicioCliente;

    public void inicia (){
        ventana.muestra(this);
    }

    public String obtenerNombre(){
        return servicioCliente.nombreCliente();
    }
    public String obtenerApellido(){
        return servicioCliente.apellidoCliente();
    }
    public String obtenerCorreo(){
        return servicioCliente.correoCliente();
    }
    public String obtenerTelefono(){
        return servicioCliente.telefonoCliente();
    }
}
