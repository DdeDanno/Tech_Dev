package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.DiseñadorRepository;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Diseñador;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.VentanaAgregarUsuario;

@Slf4j
@Service
public class ServicioUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private DiseñadorRepository diseñadorRepository;

	/**
	 * 
	 * Permite agregar un usuario
	 * 
	 * @param nombre
	 * @param apellido
	 * @param grupo
	 * @return
	 */
	public Usuario agregaUsuario(String nombre, String apellido, String nombreGrupo, String correo, String Contraseña,
			String Contraseña2) {

		// Regla de negocio: No se permite agregar dos usuarios con el mismo
		// nombre,apellido y correo.
		// Regla de negocio: La contraseña2 (de confirmación) debe ser igual a la
		// contraseña original.

		Usuario usuario = usuarioRepository.findByCorreo(correo);

		if (usuario != null) {
			throw new IllegalArgumentException("Este Correo ya esta asociado a un Usuario existente");
		}

		Grupo grupo = grupoRepository.findByNombre(nombreGrupo);

		if (grupo == null) {
			throw new IllegalArgumentException("No se encontró el grupo");
		}

		log.info("Agregando usuario nombre: " + nombre + " apellido:  " + apellido + "  correo: " + correo +
				"  Contrasena: " + Contraseña + " Confirmacion: " + Contraseña2);

		usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setCorreo(correo);
		usuario.setContraseña(Contraseña);
		usuario.setContraseña2(Contraseña2);

		usuarioRepository.save(usuario);

		grupo.addUsuario(usuario);

		grupoRepository.save(grupo);

		return usuario;

	}

	/**
	 * Recupera todos los usuarios existentes
	 * 
	 * @return Una lista con los usuarios (o lista vacía)
	 */
	public List<Usuario> recuperaUsuarios() {

		System.out.println("usuarioRepository = " + usuarioRepository);

		List<Usuario> usuarios = new ArrayList<>();

		for (Usuario usuario : usuarioRepository.findAll()) {
			usuarios.add(usuario);
		}

		return usuarios;
	}

	// iniciar sesión HU 6
	public boolean EncontrarAdmin(String correo, String Contraseña) {
		boolean verificador = true;

		Usuario usuario = usuarioRepository.findByCorreo(correo);

		if (usuario != null) {
			verificador = false;
			throw new IllegalArgumentException("Este Usuario NO existe");
		} else {
			verificador = true;
		}

		/*
		 * Usuario usuario = usuarioRepository.findByCorreo(correo);
		 * 
		 * if (usuario.getCorreo() == correo) {
		 * verificador = true;
		 * } else {
		 * verificador = false;
		 * // throw new IllegalArgumentException("Este Usuario NO existe");
		 * 
		 * }
		 */

		/*
		 * for (Diseñador element : diseñadorRepository.findAll()) {
		 * if (element.getCorreo() == correo) {
		 * verificador = true;
		 * } else
		 * verificador = false;
		 * }
		 */
		return verificador;
		// return usuario;
	}
}
