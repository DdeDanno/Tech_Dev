package mx.uam.ayd.proyecto.presentacion.estatusPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.presentacion.catalogoDiseños.ControlCatalogoDiseños;
import mx.uam.ayd.proyecto.presentacion.perfil.ControlPerfil;

@Component
public class ControlEstatusPedido  {
    @Autowired
    private VentanaEstatusPedido ventanaEstatusPedido;
    @Autowired
    private ServicioPedido servicioPedido;
    @Autowired
	  private ControlCatalogoDiseños controlCatalogoDiseños;

	@Autowired
	private ControlPerfil controlPerfil;


    public void inicia(int i) {
		ventanaEstatusPedido.muestra(this, i);
	}
  
    public String conseguirFolio(int i){
      return servicioPedido.numFolio(i);
    }
    
    public boolean EstatusPago(int i){
      return servicioPedido.pago(i);
    }

    public boolean EstatusDisieño(int i){
      return servicioPedido.diseño(i);
    }

    public boolean EstatusImprimiendo(int i){
      return servicioPedido.imprimiendo(i);
    }
    public boolean EstatusEnvio(int i){
      return servicioPedido.envio(i);
    }

    //Inicia el flujo de entrar al perfil
	public void perfil(){
		controlPerfil.inicia();
	}
/**
	 * Método que arranca la historia de usuario "Visualizar diseños"
	 * 
	 */
	public void visualizarDiseños() {
		controlCatalogoDiseños.inicia();
	}
}
