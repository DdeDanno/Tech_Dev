package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.elegirCategoria.ControlElegirCategoria;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
<<<<<<< HEAD
import mx.uam.ayd.proyecto.presentacion.catalogoDiseños.ControlCatalogoDiseños;
=======
import mx.uam.ayd.proyecto.presentacion.perfil.ControlPerfil;
>>>>>>> bbe4e553509aecbdd13eac4d36a923ac5e812b9a

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
<<<<<<< HEAD
	private ControlCatalogoDiseños controlCatalogoDiseños;
=======
	private ControlPerfil controlPerfil;
>>>>>>> bbe4e553509aecbdd13eac4d36a923ac5e812b9a

	@Autowired
	private VentanaPrincipal ventana;
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}

	//Inicia el flujo de elegir categoria
	public void elegirCategoria(){
		controlElegirCategoria.inicia();
	}

	//Inicia el flujo de entrar al perfil
	public void perfil(){
		controlPerfil.inicia();
	}

	/** Codigo del profesor:
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
<<<<<<< HEAD

	/**
	 * Método que arranca la historia de usuario "Visualizar diseños"
	 * 
	 */
	public void visualizarDiseños() {
		controlCatalogoDiseños.inicia();
	}
=======
	//Termina el codigo del profesor
>>>>>>> bbe4e553509aecbdd13eac4d36a923ac5e812b9a
}
