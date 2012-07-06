package net.roseindia.model;

// Generated 26-jun-2012 23:13:31 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Entity
@Table(name = "editorial", catalog = "gestionlibreria")
public class Editorial implements java.io.Serializable {

	private static final long serialVersionUID = 1661996928533020980L;

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", libros="
				+ libros + "]";
	}

	private long id;
	private String nombre;
	private String url;
	private Set<Libro> libros = new HashSet<Libro>(0);

	public Editorial() {
	}

	public Editorial(long id) {
		this.id = id;
	}

	public Editorial(long id, String nombre, String url, Set<Libro> libros) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.libros = libros;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial")
	public Set<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

}
