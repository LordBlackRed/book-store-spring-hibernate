package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Usuario;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface UsuarioDao {

	void guardar(Usuario usuario);

	List<Usuario> obtenerUsuarios();

	Usuario loguearUsuario(Usuario usuario);

	Usuario obtenerUsuario(String nick);

}
