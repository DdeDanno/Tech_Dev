package mx.uam.ayd.proyecto.presentacion.principal;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;
import mx.uam.ayd.proyecto.presentacion.elegirCategoria.ControlElegirCategoria;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;

/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipal {

	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;
	
	@Autowired
	private ControlListarUsuarios controlListarUsuarios;

	@Autowired
	private ControlElegirCategoria controlElegirCategoria;

	@Autowired
	private VentanaPrincipal ventana;
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}

	//Cambia de ventana a elegirCategoria
	public void elegirCategoria(){
		controlElegirCategoria.inicia();
	}
	/**
	 * Método que arranca la historia de usuario "agregar usuario"
	 * 
	 */
	public void agregarUsuario() {
		
		controlAgregarUsuario.inicia();
		
	}
	
	/**
	 * Método que arranca la historia de usuario "listar usuarios"
	 * 
	 */
	public void listarUsuarios() {
		controlListarUsuarios.inicia();
	}
}
