package net.roseindia.model;

// Generated 26-jun-2012 23:13:31 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Entity
@Table(name = "sistemaPuntuacion", catalog = "gestionlibreria")
public class SistemaPuntuacion implements java.io.Serializable {

	private static final long serialVersionUID = 2590541383687391320L;
	private long id;
	private Libro libro;
	private Usuario usuario;
	private Puntuacion puntuacion;

	public SistemaPuntuacion() {
	}

	public SistemaPuntuacion(long id) {
		this.id = id;
	}

	public SistemaPuntuacion(long id, Libro libro, Usuario usuario,
			Puntuacion puntuacion) {
		this.id = id;
		this.libro = libro;
		this.usuario = usuario;
		this.puntuacion = puntuacion;
	}

	public SistemaPuntuacion(Libro libro, Usuario usuario,
			Puntuacion puntuacion) {
		this.libro = libro;
		this.usuario = usuario;
		this.puntuacion = puntuacion;
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
	@JoinColumn(name = "idLibro")
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPuntuacion")
	public Puntuacion getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Puntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}

}
