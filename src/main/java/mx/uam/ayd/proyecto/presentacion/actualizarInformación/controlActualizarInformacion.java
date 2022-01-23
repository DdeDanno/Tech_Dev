package mx.uam.ayd.proyecto.presentacion.actualizarInformación;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

@Component
public class controlActualizarInformacion {
    @Autowired
    private ventanaActualizarInformacion ventana;


    public void inicia (){
        ventana.muestra(this);
    }

}
