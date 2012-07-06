package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Editorial;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("editorialDao")
public class EditorialDaoImpl implements EditorialDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Editorial> obtenerEditoriales() {
		return (List<Editorial>) sessionFactory.getCurrentSession()
				.createCriteria(Editorial.class).list();
	}

	@Override
	public Editorial obtenerEditorial(long idEditorial) {
		return (Editorial)sessionFactory.getCurrentSession().get(Editorial.class, idEditorial);
	}

	@Override
	public void guardar(Editorial editorial) {
		sessionFactory.getCurrentSession().saveOrUpdate(editorial);
		
	}

}
