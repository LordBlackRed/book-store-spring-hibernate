package net.roseindia.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.roseindia.enums.Enums;
import net.roseindia.model.Libro;
import net.roseindia.model.LibroUsuario;
import net.roseindia.model.Usuario;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Repository("libroUsuarioDao")
public class LibroUsuarioDaoImpl implements LibroUsuarioDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void guardar(LibroUsuario libroUsuario) {
		sessionFactory.getCurrentSession().saveOrUpdate(libroUsuario);
	}

	@Override
	public LibroUsuario obtenerLibroUsuario(Usuario usuario, Libro libro) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				LibroUsuario.class);
		cr.add(Restrictions.eq(Enums.libro.toString(), libro));
		cr.add(Restrictions.eq(Enums.usuario.toString(), usuario));

		return (LibroUsuario) cr.uniqueResult();
	}

	@Override
	public List<LibroUsuario> obtenerLibrosUsuario(Usuario usuario) {
		@SuppressWarnings("unchecked")
		List<LibroUsuario> librosUsuario = (List<LibroUsuario>) sessionFactory.getCurrentSession()
				.createCriteria(LibroUsuario.class)
				.add(Restrictions.eq(Enums.usuario.toString(), usuario)).list();
		
		for(LibroUsuario libroUsuario: librosUsuario){
			Hibernate.initialize(libroUsuario.getLibro());
			Hibernate.initialize(libroUsuario.getUsuario());
			Hibernate.initialize(libroUsuario.getLibro().getAutor());
			Hibernate.initialize(libroUsuario.getLibro().getEditorial());
			Hibernate.initialize(libroUsuario.getLibro().getGenero());
		}
		
		return librosUsuario;
	}

}
