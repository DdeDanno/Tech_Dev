package mx.uam.ayd.proyecto.presentacion.elegirCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.carritoDeCompras.ControlCarritoDeCompras;
import mx.uam.ayd.proyecto.presentacion.catalogoDiseños.ControlCatalogoDiseños;

@Component
public class ControlElegirCategoria {
    @Autowired
    private VentanaElegirCategoria ventana;

    @Autowired
    private ControlCatalogoDiseños controlCatalogoDiseños;

    @Autowired
    private ControlCarritoDeCompras controlCarritoDeCompras;

    public void inicia (){
        ventana.muestra(this);
    }

    public void elegirDiseño(){
        controlCatalogoDiseños.inicia();
    }

    public void carritoDeCompras (){
        controlCarritoDeCompras.inicia();
    }
}
