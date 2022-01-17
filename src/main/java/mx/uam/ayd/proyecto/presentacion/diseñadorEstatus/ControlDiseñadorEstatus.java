package mx.uam.ayd.proyecto.presentacion.diseñadorEstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioDiseñoAdmin;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;

@Component
public class ControlDiseñadorEstatus {
    private VentanaDiseñadorEstatus ventana;
    @Autowired
    private ServicioPedido servicioPedido;
    @Autowired
    private ServicioDiseñoAdmin servicioDiseñoAdmin;

    public ControlDiseñadorEstatus(){
    }
    public VentanaDiseñadorEstatus inicia(int i){
        ventana = new VentanaDiseñadorEstatus();
        ventana.muestra(this,i);
        return ventana;
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

    public void subirArchivo(){
        servicioDiseñoAdmin.SubirArchivo();
    }
}
