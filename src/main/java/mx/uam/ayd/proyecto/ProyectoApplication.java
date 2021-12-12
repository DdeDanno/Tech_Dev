package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

/**
 * probando el commit
 * Clase principal que arranca la aplicación
 * construida usando el principio de
 * inversión de control
 * 
 * Ejemplo de cambio en Rama
 * prueba de commit2
 * 
 * @author humbertocervantes
 *
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;

	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	/**
	 * 
	 * Método principal
	 * 
	 */
	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {

		inicializaBD();

		controlPrincipal.inicia();
	}

	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 * 
	 */
	public void inicializaBD() {

		// Producto 1
		Producto producto1 = new Producto();
		producto1.setCategoria("Negocio");
		producto1.setNombre_diseño("Diseño Lena");
		producto1.setMaterial("Papel");
		producto1.setPrecio(180);
		producto1.setTamaño("10x180");
		producto1.setTipo_producto("Volante");

		productoRepository.save(producto1);

		// Producto 2
		Producto producto2 = new Producto();
		producto2.setCategoria("Fiesta");
		producto2.setNombre_diseño("Diseño Lena");
		producto2.setMaterial("Lona");
		producto2.setPrecio(290);
		producto2.setTamaño("720x1080");
		producto2.setTipo_producto("Lona");
		productoRepository.save(producto2);
		
		//Creamos un primer pedido
		Pedido pedido1=new Pedido();
		pedido1.setFolio("11111111");
		pedido1.setEstatus_pago(true);
		pedido1.setEstatus_diseño(false);
		pedido1.setEstatus_imprimiendo(true);
		pedido1.setEstatus_enviado(false);
		pedidoRepository.save(pedido1);

		//Creamos un segundo pedido
		Pedido pedido2=new Pedido();
		pedido2.setFolio("729878950");
		pedido2.setEstatus_pago(true);
		pedido2.setEstatus_diseño(true);
		pedido2.setEstatus_imprimiendo(true);
		pedido2.setEstatus_enviado(false);
		pedidoRepository.save(pedido2);

		//Creamos un primer cliente
		Cliente cliente1=new Cliente();
		cliente1.setNombre("Daniel");
		cliente1.setTelefono("55917842");
		cliente1.setCorreo("cliente1@gmail.com");
		cliente1.setNum_pedidos(2);
		clienteRepository.save(cliente1);


	// Vamos a crear los dos grupos de usuarios
		Grupo grupoAdmin = new Grupo();
		grupoAdmin.setNombre("Administradores");
		grupoRepository.save(grupoAdmin);

		Grupo grupoOps = new Grupo();
		grupoOps.setNombre("Operadores");
		grupoRepository.save(grupoOps);

	}
}
