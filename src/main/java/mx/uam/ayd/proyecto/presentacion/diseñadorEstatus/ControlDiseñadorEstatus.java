package mx.uam.ayd.proyecto.presentacion.diseñadorEstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPedido;

@Component
public class ControlDiseñadorEstatus {
    @Autowired
    private VentanaDiseñadorEstatus ventana;
    @Autowired
    private ServicioPedido servicioPedido;

    public void inicia(int i){
        ventana.muestra(this,i);
    }
    
    public String numpedido(int i){
        return servicioPedido.numFolio(i);  
    }

    public void actualizarDiseño(String estatus, int i){
        servicioPedido.actualizarDis(estatus, i);
    }

    public void actualizarImpresion(String estatus, int i){
        servicioPedido.actualizarImp(estatus, i);
    }
}
