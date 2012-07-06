package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Autor;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("autorDao")
public class AutorDaoImpl implements AutorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Autor autor) {
		sessionFactory.getCurrentSession().saveOrUpdate(autor);
	}

	public void update(Autor autor) {
		// getHibernateTemplate().update(autor);
	}

	public void delete(Autor autor) {
		// getHibernateTemplate().delete(autor);
	}

	public List<Autor> obtenerAutores() {
		@SuppressWarnings("unchecked")
		List<Autor> autores = (List<Autor>) sessionFactory.getCurrentSession()
				.createCriteria(Autor.class).list();

		return autores;
	}

	@Override
	public Autor obtenerAutor(long idAutor) {

		return (Autor) sessionFactory.getCurrentSession().get(Autor.class, idAutor);
	}

}
