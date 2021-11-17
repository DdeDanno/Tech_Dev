package mx.uam.ayd.proyecto.negocio;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.CarritoRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Carrito;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Service
public class ServicioCarrito {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CarritoRepository carritoRepository;
    
    
    public Carrito agregaCarrito(int cantidad,String tipo_producto) throws Exception{
        
        // crea carrito
        Carrito carrito;
        Producto producto =null;
        carrito =new Carrito();
        carrito.setCantidad_producto(cantidad);
        carrito.setTipo_producto(tipo_producto);

        //Exception error, cuando agregamos 0 productos al carrito
        if(cantidad == 0){
            throw new Exception("Debe agregar al menos un Producto");
        }

        // conseguir el precio
        for(Producto element:productoRepository.findAll()){
            if(element.getTipo_producto() == tipo_producto){
                producto = element;
            }
        }
        carrito.setPrecio_ind(producto.getPrecio());
        carrito.setPrecio_tot(producto.getPrecio()*cantidad);
        carritoRepository.save(carrito);
        return carrito;
    }

    //muestra el carrito
    public String muestraCarrito(){
        Carrito carrito=null;
        for(Carrito element:carritoRepository.findAll()){
            if(element.getId_carrito() == 1){
                carrito = element;
            }
        }
        String carrito_compra=("Tipo: "+carrito.getTipo_producto().toString()+"\n"+"Catidad :"+carrito.getCantidad_producto()+"\n"+"Precio individual"+carrito.getPrecio_ind()+"\n"+"Precio total: "+carrito.getPrecio_tot());
        return carrito_compra;
    }
    
}
