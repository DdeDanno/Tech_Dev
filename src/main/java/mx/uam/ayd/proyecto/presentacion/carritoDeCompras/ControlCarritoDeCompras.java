package mx.uam.ayd.proyecto.presentacion.carritoDeCompras;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCarrito;
import mx.uam.ayd.proyecto.negocio.ServicioDiseñoCliente;
import mx.uam.ayd.proyecto.negocio.modelo.Carrito;
import mx.uam.ayd.proyecto.presentacion.generarTicket.ControlGenerarTicket;

@Component
public class ControlCarritoDeCompras {
    @Autowired
    private VentanaCarritoDeCompras ventana;
    @Autowired
    private ServicioCarrito servicioCarrito;
    @Autowired
    private ServicioDiseñoCliente servicioDiseñoCliente;
    @Autowired
    private ControlGenerarTicket controlGenerarTicket;

    public void inicia (){
        ventana.muestra(this);
    }
	//Agrega al carrito el tipo de producto y la cantidad
	public Carrito agregaCarrito(int cantidad, String tipoProducto) throws Exception{
		return servicioCarrito.agregaCarrito(cantidad, tipoProducto);
	}

    //muestra carrito
    public String muestraCarritodeCompra(){
        return servicioCarrito.muestraCarrito();
    }

    public void SubirArchivo(){
        servicioDiseñoCliente.SubirArchivo();
    }

    //Muestra la ventana para generar el ticket
    public void generarTicket(){
        controlGenerarTicket.inicia();
    }

    //muestra ventana carrito
    public void muestraCarrito(){

    }

}

