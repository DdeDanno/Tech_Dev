package mx.uam.ayd.proyecto.presentacion.catalogoDiseños;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioDiseñoCliente;
import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;
import mx.uam.ayd.proyecto.presentacion.perfil.ControlPerfil;

@Component
public class ControlCatalogoDiseños {
    @Autowired
    private VentanaCatalogoDiseños ventana;

    @Autowired
    private ControlCarritoDeCompras controlCarritoDeCompras;

    @Autowired
    private ServicioDiseñoCliente servicioDiseñoCliente;

    @Autowired
	private ControlPerfil controlPerfil;

    public void inicia (){
        ventana.muestra(this);
    }

    public void carritoDeCompras(){
        controlCarritoDeCompras.inicia();
    }

    
    public void SubirArchivo() throws Exception{
        servicioDiseñoCliente.SubirArchivo();
    }

    //Inicia el flujo de entrar al perfil
	public void perfil(){
		controlPerfil.inicia();
	}
}
