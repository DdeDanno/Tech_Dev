package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@ExtendWith(MockitoExtension.class)
class ServicioUsuarioTest {

	// Al usar la anotación @Mock, el framework Mockito crea un sustituto
	// de la clase que regresa valores por default
	@Mock
	private UsuarioRepository usuarioRepository;

	@Mock
	private GrupoRepository grupoRepository;

	// Esta anotación hace que se inyecten todos los Mocks al módulo que quiero
	// probar para que no haya nullPointerException por que las dependencias
	// no están satisfechas en tiempo de pruebas
	@InjectMocks
	private ServicioUsuario servicio;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	 * @Test
	 * void testAgregaUsuario() {
	 * Usuario usuario = new Usuario();
	 * Grupo grupo = new Grupo();
	 * usuario.setNombre("Alberto");
	 * usuario.setApellido("Rodriguez");
	 * grupo.setNombre("Administrador");
	 * usuario.setCorreo("betoavektech94@gmail.com");
	 * usuario.setContraseña("qwerty");
	 * usuario.setContraseña2("qwerty");
	 * 
	 * // Caso Prueba mandar los datos correctos
	 * Usuario resultadoUsuario = servicio.agregaUsuario("Alberto", "Rodriguez",
	 * "Administrador",
	 * "betoavektech94@gmail.com",
	 * "qwerty", "qwerty");
	 * assertEquals(usuario, resultadoUsuario);
	 * 
	 * // Caso Prueba: Mandar datos erroneos o nulos
	 * resultadoUsuario = servicio.agregaUsuario(null, null, null, null, null,
	 * null);
	 * assertEquals(usuario, resultadoUsuario);
	 * 
	 * resultadoUsuario = servicio.agregaUsuario("12345", "345.2", "ninguno", "23",
	 * " ", " ");
	 * assertEquals(usuario, resultadoUsuario);
	 * }
	 */

	@Test
	void testEncontrarAdmin() {

		Usuario usuario = new Usuario();
		Grupo grupo = new Grupo();
		usuario.setNombre("Alberto");
		usuario.setApellido("Rodriguez");
		grupo.setNombre("Administrador");
		usuario.setCorreo("betoavektech94@gmal.com");
		usuario.setContraseña("qwerty");
		usuario.setContraseña2("qwerty");

		// Caso de Prueba: No hay Usuarios Registrados

		boolean resultadoUsuarios = servicio.EncontrarAdmin("betoavektech94@gmail.com", "qwerty");
		assertEquals(true, resultadoUsuarios);

		// Caso de Prueba: si existe el Usuario.
		resultadoUsuarios = servicio.EncontrarAdmin("betoavektch94@gmail.com", "qwerty");
		assertEquals(true, resultadoUsuarios);
	}

	@Test
	void testRecuperaUsuarios() {

		// Prueba 1: corroborar que regresa una lista vacía si no hay usuarios en la BD

		// en este momento, la invocación a usuarioRepository.findAll() regresa una
		// lista vacía
		List<Usuario> usuarios = servicio.recuperaUsuarios();

		assertTrue(usuarios.isEmpty());

		// Prueba 2: corroborar que regresa una lista con usuarios
		LinkedList<Usuario> lista = new LinkedList<>();

		// Tengo que crear un Iterable <Usuario> para que el método
		// usuarioRepository.findAll() no me regrese una lista vacía
		// cuando lo invoco
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Juan");
		usuario1.setApellido("Perez");

		Usuario usuario2 = new Usuario();
		usuario2.setNombre("María");
		usuario2.setApellido("Ramírez");

		lista.add(usuario1);
		lista.add(usuario2);

		// Al usar when, lo que hacemos es que definimos un comportamiento
		// para la invoación del método.
		// A partir de este punto, la invocación a usuarioRepository.findAll() ya
		// no me regresa una lista vacía, si no que me regresa una listaLigada
		// vista como Iterable que tiene dos elementos
		when(usuarioRepository.findAll()).thenReturn(lista);

		usuarios = servicio.recuperaUsuarios();

		assertEquals(2, usuarios.size()); // Corroboro que tenga dos elementos

	}

}
