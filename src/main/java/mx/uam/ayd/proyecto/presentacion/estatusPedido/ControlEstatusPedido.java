package mx.uam.ayd.proyecto.presentacion.estatusPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlEstatusPedido {
    @Autowired
    private VentanaEstatusPedido ventanaEstatusPedido;

    public void inicia() {
		ventanaEstatusPedido.muestra(this);
	}
}
