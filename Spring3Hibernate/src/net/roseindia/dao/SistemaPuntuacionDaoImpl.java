package net.roseindia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.roseindia.enums.Enums;
import net.roseindia.model.Libro;
import net.roseindia.model.SistemaPuntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("sistemaPuntuacionDao")
public class SistemaPuntuacionDaoImpl implements SistemaPuntuacionDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void guardar(SistemaPuntuacion sistemaPuntuacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(sistemaPuntuacion);
	}

	@Override
	public SistemaPuntuacion obtenerSistemaPuntuacionPorLibroUsuario(SistemaPuntuacion sistemaPuntuacion) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SistemaPuntuacion.class);
		cr.add(Restrictions.eq(Enums.libro.toString(), sistemaPuntuacion.getLibro()));
		cr.add(Restrictions.eq(Enums.usuario.toString(), sistemaPuntuacion.getUsuario()));
		
		return (SistemaPuntuacion) cr.uniqueResult();
	}

	@Override
	public int obtenerPuntuacion(Libro libro) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SistemaPuntuacion.class);
		cr.add(Restrictions.eq(Enums.libro.toString(), libro));
		@SuppressWarnings("unchecked")
		List<SistemaPuntuacion> sistemaPuntuaciones = (List<SistemaPuntuacion>) cr.list();
		
		int sum = 0;
		
		for(SistemaPuntuacion sistemaPuntuacion: sistemaPuntuaciones){
			sum += sistemaPuntuacion.getPuntuacion().getPuntuacion();
		}
		
		return sum;
	}

	@Override
	public int obtenerPuntuacionTotal(Libro libro) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SistemaPuntuacion.class);
		cr.add(Restrictions.eq(Enums.libro.toString(), libro));
		
		return cr.list().size() * 5;
	}

}
