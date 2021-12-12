package mx.uam.ayd.proyecto.presentacion.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.presentacion.estatusPedido.ControlEstatusPedido;

@Component
public class ControlPerfil {

	@Autowired
	private VentanaPerfil ventana;
	@Autowired
	private ControlEstatusPedido controlEstatusPedido;
	@Autowired
	private ServicioCliente servicioCliente;
	@Autowired
	private ServicioPedido servicioPedido;

	public void inicia() {
		ventana.muestra(this);
	}
	// Inicia el estatus del pedido
	public void estatusPedido (int i){
		controlEstatusPedido.inicia(i);
	}
	//Consigue el nombre del cliente
	public String conseguirNombre (){
		return servicioCliente.nombreCliente();
	}
	//Recupera el numero de pedidos existentes
	public int pedidosExistentes(){
		return servicioCliente.numPedidos();
	}
	//Recupera el FOLIO
	public String recuperaFolio(int i){
		return servicioPedido.numFolio(i);
	}
}
