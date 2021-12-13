package mx.uam.ayd.proyecto.presentacion.estatusPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPedido;

@Component
public class ControlEstatusPedido  {
    @Autowired
    private VentanaEstatusPedido ventanaEstatusPedido;
    @Autowired
    private ServicioPedido servicioPedido;

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
}
