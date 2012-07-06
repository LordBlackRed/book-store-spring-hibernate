package net.roseindia.dao;

import java.util.List;

import net.roseindia.enums.Enums;
import net.roseindia.model.Genero;
import net.roseindia.model.Libro;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libroDao")
public class LibroDaoImpl implements LibroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Libro> obtenerLibros(int pag, int fpp) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Libro.class);

		// Paginacion
		cr.setFirstResult((fpp * pag) - fpp);
		cr.setMaxResults(fpp);
		cr.addOrder(Order.asc("fechaPublicacion"));

		@SuppressWarnings("unchecked")
		List<Libro> libros = (List<Libro>) cr.list();
		// Si lo quito da pete ya que no lo carga en la se3sion
		for (Libro l : libros) {
			Hibernate.initialize(l.getAutor());
		}
		return libros;
	}

	@Override
	public void guardar(Libro libro) {
		sessionFactory.getCurrentSession().saveOrUpdate(libro);
	}

	@Override
	public int obtenerNumPaginas() {
		// Count con criteria
		return ((Integer) sessionFactory.getCurrentSession()
				.createCriteria(Libro.class)
				.setProjection((Projections.rowCount())).list().get(0))
				.intValue();
	}

	@Override
	public List<Libro> obtenerLibros(int pag, int fpp, Genero genero) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Libro.class);

		// Filtrado por genero

		cr.add(Restrictions.eq(Enums.genero.toString(), genero));
		// Paginacion
		cr.setFirstResult((fpp * pag) - fpp);
		cr.setMaxResults(fpp);

		@SuppressWarnings("unchecked")
		List<Libro> libros = (List<Libro>) cr.list();
		// Si lo quito da pete ya que no lo carga en la se3sion
		for (Libro l : libros) {
			Hibernate.initialize(l.getAutor());
		}
		return libros;
	}

	@Override
	public int obtenerNumPaginas(Genero genero) {
		// Count con criteria
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Libro.class);
		cr.add(Restrictions.eq(Enums.genero.toString(), genero));
		cr.setProjection(Projections.rowCount());
		return ((Integer) cr.list().get(0)).intValue();
	}

	@Override
	public Libro obtenerLibro(long idLibro) {
		Libro libro = (Libro) sessionFactory.getCurrentSession().load(Libro.class, idLibro);
		
		Hibernate.initialize(libro.getAutor());
		Hibernate.initialize(libro.getEditorial());
		
		return libro;
	}

}
