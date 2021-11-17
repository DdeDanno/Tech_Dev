package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.CarritoRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Carrito;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@ExtendWith(MockitoExtension.class)
class ServicioCarritoTest {
    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private CarritoRepository carritoRepository;

    @InjectMocks
    private ServicioCarrito servicio;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    void AgregaCarritoTest() throws Exception{
        //Creo una lista para tener productos
        LinkedList <Producto> lista = new LinkedList <> ();
        //Producto 1
        Producto producto1=new Producto();
        producto1.setCategoria("Negocio");
        producto1.setNombre_diseño("Diseño Lena");
        producto1.setMaterial("Papel");
        producto1.setPrecio(180);
        producto1.setTamaño("10x180");
        producto1.setTipo_producto("Volante"); 

        productoRepository.save(producto1);

		// Producto 2
		Producto producto2=new Producto();
        producto2.setCategoria("Fiesta");
        producto2.setNombre_diseño("Diseño Lena");
        producto2.setMaterial("Lona");
        producto2.setPrecio(290);
        producto2.setTamaño("720x1080");
        producto2.setTipo_producto("Lona"); 
		
		lista.add(producto1);
		lista.add(producto2);
        when(productoRepository.findAll()).thenReturn(lista);

        // Prueba que se agrega un producto al carrito de manera satisfactoria
        Carrito carrito  = servicio.agregaCarrito(3, "Lona");
        assertNotNull(carrito);

        // Prueba que no se pueden agregar 0 productos al carrito
        Exception error = Assertions.assertThrows(Exception.class, () -> {
			servicio.agregaCarrito(0, "Lona");
		});
        System.out.println(error);
    }

    @Test
    void muestraCarritoTest() throws Exception{
        // Creo una lista para tener carrito
        LinkedList <Carrito> lista = new LinkedList <> ();
        //Creo el carrito
        Carrito carrito =new Carrito();
        carrito.setId_carrito(1);;
        carrito.setCantidad_producto(10);
        carrito.setPrecio_ind(160);
        carrito.setTipo_producto("Lona");
        carrito.setPrecio_tot(320);
        lista.add(carrito);

        when(carritoRepository.findAll()).thenReturn(lista);

        // Prueba que se muestre correctamente el carrito del usuario
        String resultado = servicio.muestraCarrito();
        System.out.println(resultado);
        assertNotNull(resultado);
    }

}
