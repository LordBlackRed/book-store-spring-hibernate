package net.roseindia.dao;

import net.roseindia.model.Puntuacion;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("puntuacionDao")
public class PuntuacionDaoImpl implements PuntuacionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void guardar(Puntuacion puntuacion){
		sessionFactory.getCurrentSession().saveOrUpdate(puntuacion);
	}

	@Override
	public Puntuacion obtenerPuntuacion(int punt) {
		return (Puntuacion) sessionFactory.getCurrentSession().createCriteria(Puntuacion.class).add(Restrictions.eq("puntuacion", punt)).uniqueResult();
	}

}
