package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Genero;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("generoDao")
public class GeneroDaoImpl implements GeneroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Genero> obtenerGeneros() {
		return (List<Genero>) sessionFactory.getCurrentSession()
				.createCriteria(Genero.class).list();
	}

	public Genero obtenerGenero(long idGenero) {
		return (Genero) sessionFactory.getCurrentSession().get(Genero.class, idGenero);
	}

}
