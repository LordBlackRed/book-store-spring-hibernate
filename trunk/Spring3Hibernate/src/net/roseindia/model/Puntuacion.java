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
@Table(name = "puntuacion", catalog = "gestionlibreria")
public class Puntuacion implements java.io.Serializable {

	private static final long serialVersionUID = -5371787869734309636L;

	@Override
	public String toString() {
		return "Puntuacion [id=" + id + ", puntuacion="
				+ puntuacion + "]";
	}

	private long id;
	private Integer puntuacion;
	private Set<SistemaPuntuacion> sistemaPuntuaciones = new HashSet<SistemaPuntuacion>(
			0);

	public Puntuacion() {
	}

	public Puntuacion(long id) {
		this.id = id;
	}

	public Puntuacion(long id, Integer puntuacion) {
		this.id = id;
		this.puntuacion = puntuacion;
	}

	public Puntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Puntuacion(long id, Integer puntuacion,
			Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.id = id;
		this.puntuacion = puntuacion;
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

	@Column(name = "puntuacion")
	public Integer getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntuacion")
	public Set<SistemaPuntuacion> getSistemaPuntuaciones() {
		return sistemaPuntuaciones;
	}

	public void setSistemaPuntuaciones(
			Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.sistemaPuntuaciones = sistemaPuntuaciones;
	}

}
