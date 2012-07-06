package net.roseindia.dao;

import java.util.List;

import net.roseindia.enums.Enums;
import net.roseindia.model.Usuario;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void guardar(Usuario usuario) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuarios() {

		return (List<Usuario>) sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class).list();
	}

	@Override
	public Usuario loguearUsuario(Usuario usuario) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		cr.add(Restrictions.eq("nick", usuario.getNick()));
		cr.add(Restrictions.eq("password", usuario.getPassword()));
		
		return (Usuario) cr.uniqueResult();
	}

	@Override
	public Usuario obtenerUsuario(String nick) {
		return (Usuario) sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq(Enums.nick.toString(), nick))
				.uniqueResult();
	}

}
