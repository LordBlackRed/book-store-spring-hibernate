package net.roseindia.model;
// Generated 26-jun-2012 23:13:31 by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Entity
@Table(name="autor"
    ,catalog="gestionlibreria"
)
public class Autor  implements java.io.Serializable {

	private static final long serialVersionUID = -6423956859984621810L;
	private long id;
     private String nombre;
     @Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos;
	}

	private String apellidos;
     private Set<Libro> libros = new HashSet<Libro>(0);

    public Autor() {
    }

	
    public Autor(long id) {
        this.id = id;
    }
    public Autor(long id, String nombre, String apellidos, Set<Libro> libros) {
       this.id = id;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.libros = libros;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellidos", length=45)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autor")
    public Set<Libro> getLibros() {
        return this.libros;
    }
    
    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }




}


