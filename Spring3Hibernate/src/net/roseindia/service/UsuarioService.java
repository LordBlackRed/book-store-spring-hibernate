package net.roseindia.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.roseindia.model.Usuario;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface UsuarioService {

	boolean guardar(Usuario usuario);

	List<Usuario> obtenerUsuarios();

	boolean loguearUsuario(Usuario usuario);

	void destruirSesion(Usuario usuario, HttpServletRequest request);

	Usuario obtenerUsuario(Usuario user);

}
