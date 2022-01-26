package mx.uam.ayd.proyecto.presentacion.consultarInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioArticulo;

@Component
public class ControlConsultarInventario {
    @Autowired
    private VentanaConsultarInventario ventana;

    @Autowired
    private ServicioArticulo servicioArticulo;

    public void inicia() {
        ventana.muestra(this);
    }

    public void CrearArticulo(String NombreArticulo, String TotalPiezas) {
        try {
            servicioArticulo.CrearArticulo(NombreArticulo, TotalPiezas);
            ventana.muestraDialogoConMensaje("Articulo agregado Exitosamente!!! :)");

        } catch (Exception ex) {
            ventana.muestraDialogoConMensaje("Error al agregar Articulo: " + ex.getMessage());
        }
    }

    public void BorraArticulo(String NombreArticulo) {
        try {
            servicioArticulo.BorraArticulo(NombreArticulo);
            ventana.muestraDialogoConMensaje("Articulo Borrado Exitosamente!!! :)");

        } catch (Exception ex) {
            ventana.muestraDialogoConMensaje("Error al Borrar Articulo: " + ex.getMessage());
        }

    }

    public void ActualizaArticulo(String NombreArticulo, String TotalPiezas) {
        try {
            servicioArticulo.ActualizaArticulo(NombreArticulo, TotalPiezas);
            ventana.muestraDialogoConMensaje("Articulo Actualizado Exitosamente!!! :)");

        } catch (Exception ex) {
            ventana.muestraDialogoConMensaje("Error al Actualizar Articulo: " + ex.getMessage());
        }
    }

}
