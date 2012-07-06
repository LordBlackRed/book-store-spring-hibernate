package net.roseindia.model;

import java.io.Serializable;
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
@Table(name = "genero", catalog = "gestionlibreria")
public class Genero implements Serializable {

	private static final long serialVersionUID = 349020107880179580L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private long id;
	private String genero;
	private Set<Libro> libros = new HashSet<Libro>(0);

	public Genero() {

	}

	public Genero(long id, String genero) {
		super();
		this.id = id;
		this.genero = genero;
	}

	public Genero(long id, String genero, Set<Libro> libros) {
		super();
		this.id = id;
		this.genero = genero;
		this.libros = libros;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "genero", length = 45)
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

}
