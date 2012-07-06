package net.roseindia.model;

// Generated 26-jun-2012 23:13:31 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Entity
@Table(name = "libro", catalog = "gestionlibreria")
public class Libro implements java.io.Serializable {

	private static final long serialVersionUID = 6313378974610881396L;
	private long id;
	private Autor autor;
	private Editorial editorial;
	private Genero genero;
	private Integer isbn;
	private String titulo;
	private String urlImagen;
	private String sinopsis;
	private Date fechaPublicacion;
	private Integer pags;
	private Set<LibroUsuario> libroUsuarios = new HashSet<LibroUsuario>(0);
	private Set<SistemaPuntuacion> sistemaPuntuaciones = new HashSet<SistemaPuntuacion>(
			0);

	public Libro() {
	}

	public Libro(long id) {
		this.id = id;
	}

	public Libro(long id, Autor autor, Editorial editorial, Integer isbn,
			String titulo, String urlImagen, Integer pags,
			Set<LibroUsuario> libroUsuarios,
			Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.id = id;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.titulo = titulo;
		this.urlImagen = urlImagen;
		this.pags = pags;
		this.libroUsuarios = libroUsuarios;
		this.sistemaPuntuaciones = sistemaPuntuaciones;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAutor")
	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEditorial")
	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Column(name = "isbn")
	public Integer getIsbn() {
		return this.isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	@Column(name = "titulo", length = 45)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "urlImagen", length = 45)
	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	public Set<LibroUsuario> getLibroUsuarios() {
		return this.libroUsuarios;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", editorial="
				+ editorial + ", isbn=" + isbn + ", titulo=" + titulo
				+ ", urlImagen=" + urlImagen + ", libroUsuarios="
				+ libroUsuarios + "]";
	}

	public void setLibroUsuarios(Set<LibroUsuario> libroUsuarios) {
		this.libroUsuarios = libroUsuarios;
	}

	@Column(name = "fechaPublicacion")
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Column(name = "sinopsis", length = 200)
	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Column(name = "pags")
	public Integer getPags() {
		return pags;
	}

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
		Libro other = (Libro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setPags(Integer pags) {
		this.pags = pags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGenero")
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	public Set<SistemaPuntuacion> getSistemaPuntuaciones() {
		return sistemaPuntuaciones;
	}

	public void setSistemaPuntuaciones(
			Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.sistemaPuntuaciones = sistemaPuntuaciones;
	}

}
