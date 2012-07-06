package net.roseindia.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.roseindia.dao.UsuarioDao;
import net.roseindia.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("usuarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public UsuarioServiceImpl() {

	}

	@Override
	public boolean guardar(Usuario usuario) {
		// Buscamos primeor si existe algœn usuario con el mismo nick dado de
		// alta en el sistema
		Usuario usuarioAux = usuarioDao.obtenerUsuario(usuario.getNick());
		if (usuarioAux == null) {
			usuarioDao.guardar(usuario);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioDao.obtenerUsuarios();
	}

	@Override
	public boolean loguearUsuario(Usuario usuario) {
		Usuario usuarioLogueado = usuarioDao.loguearUsuario(usuario);

		if (usuarioLogueado == null)
			return false;
		else
			return true;
	}

	@Override
	public void destruirSesion(Usuario usuario, HttpServletRequest request) {
		request.getSession().invalidate();
	}

	@Override
	public Usuario obtenerUsuario(Usuario usuario) {
		return usuarioDao.loguearUsuario(usuario);
	}

}
