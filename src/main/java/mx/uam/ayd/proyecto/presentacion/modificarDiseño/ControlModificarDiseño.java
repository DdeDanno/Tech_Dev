package mx.uam.ayd.proyecto.presentacion.modificarDiseño;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioDiseñoCliente;
import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;
import mx.uam.ayd.proyecto.presentacion.perfil.ControlPerfil;

@Component
public class ControlModificarDiseño {
    @Autowired
    private VentanaModificarDiseño ventana;
    @Autowired
    private ControlCarritoDeCompras controlCarritoDeCompras;
    @Autowired
    private ServicioDiseñoCliente servicioDiseñoCliente;
    @Autowired 
    private ControlPerfil controlPerfil;

    public void inicia(){
        ventana.muestra(this);
    }

    public void carritoDeCompras(){
        controlCarritoDeCompras.inicia();
    }

    public void SubirArchivo() throws Exception{
        servicioDiseñoCliente.SubirArchivo();
    }

    public void perfil(){
        controlPerfil.inicia();
    }

}
