package mx.uam.ayd.proyecto.presentacion.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.catalogoDiseños.ControlCatalogoDiseños;
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
	@Autowired
	private ControlCatalogoDiseños controlCatalogoDiseños;
	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;

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

	/**
	 * Método que arranca la historia de usuario "agregar usuario"
	 * 
	 */
	public void agregarUsuario() {
		
		controlAgregarUsuario.inicia();
		
	}

	/**
	 * Método que arranca la historia de usuario "Visualizar diseños"
	 * 
	 */
	public void visualizarDiseños() {
		controlCatalogoDiseños.inicia();
	}
}
