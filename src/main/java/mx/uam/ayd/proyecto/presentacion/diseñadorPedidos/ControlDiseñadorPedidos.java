package mx.uam.ayd.proyecto.presentacion.diseñadorPedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.conditional.ElseAction;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.presentacion.diseñadorEstatus.ControlDiseñadorEstatus;
import mx.uam.ayd.proyecto.presentacion.diseñadorEstatus.VentanaDiseñadorEstatus;

@Component
public class ControlDiseñadorPedidos {
    @Autowired
    private VentanaDiseñadorPedidos ventana;
    @Autowired
    private ControlDiseñadorEstatus controlDiseñadorEstatus;
    @Autowired
    private ServicioPedido servicioPedido;
    
    public void inicia(){
        ventana.muestra(this);
    }

    public String numpedido(int i){
        return servicioPedido.numFolio(i);  
    }
    
    public String estatusPago(int i){
        String estatus;
        if (servicioPedido.pago(i)==true)
        estatus= "COMPLETADO";
        else 
        estatus= "EN CURSO";
        return estatus;
    }

    public String estatusDis(int i){
        String estatus;
        if (servicioPedido.diseño(i)==true)
        estatus= "COMPLETADO";
        else 
        estatus= "EN CURSO";
        return estatus;
    }

    public String estatusImpresion(int i){
        String estatus;
        if (servicioPedido.imprimiendo(i)==true)
        estatus= "COMPLETADO";
        else 
        estatus= "EN CURSO";
        return estatus;
    }

    public VentanaDiseñadorEstatus diseñadorEstatus(int i){
        return controlDiseñadorEstatus.inicia(i);
    }
}
