package mx.uam.ayd.proyecto.presentacion.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.estatusPedido.ControlEstatusPedido;

@Component
public class ControlPerfil {

	@Autowired
	private VentanaPerfil ventana;
	@Autowired
	private ControlEstatusPedido controlEstatusPedido;
	
	public void inicia() {
		ventana.muestra(this);
	}
	
	public void estatusPedido (){
		controlEstatusPedido.inicia();
	}


}
