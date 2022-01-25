package mx.uam.ayd.proyecto.presentacion.consultarInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlConsultarInventario {
    @Autowired
    private VentanaConsultarInventario ventana;

    public void inicia() {
        ventana.muestra(this);
    }

}
