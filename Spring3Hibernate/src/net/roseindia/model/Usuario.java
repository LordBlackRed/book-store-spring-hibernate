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
@Table(name = "usuario", catalog = "gestionlibreria")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -7860220704320459025L;

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nick=" + nick + ", password="
				+ password + ", libroUsuarios=" + libroUsuarios + "]";
	}

	private long id;
	private String nick;
	private String password;
	private Set<LibroUsuario> libroUsuarios = new HashSet<LibroUsuario>(0);
	private Set<SistemaPuntuacion> sistemaPuntuaciones = new HashSet<SistemaPuntuacion>(
			0);

	public Usuario() {
	}

	public Usuario(long id) {
		this.id = id;
	}

	public Usuario(long id, String nick, String password,
			Set<LibroUsuario> libroUsuarios, Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.id = id;
		this.nick = nick;
		this.password = password;
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

	@Column(name = "nick", length = 45)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<LibroUsuario> getLibroUsuarios() {
		return this.libroUsuarios;
	}

	public void setLibroUsuarios(Set<LibroUsuario> libroUsuarios) {
		this.libroUsuarios = libroUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<SistemaPuntuacion> getSistemaPuntuaciones() {
		return sistemaPuntuaciones;
	}

	public void setSistemaPuntuaciones(
			Set<SistemaPuntuacion> sistemaPuntuaciones) {
		this.sistemaPuntuaciones = sistemaPuntuaciones;
	}

}
