package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Genero;
import net.roseindia.model.Libro;


/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface LibroDao {

	List<Libro> obtenerLibros(int pag, int fpp);

	void guardar(Libro libro);

	int obtenerNumPaginas();

	List<Libro> obtenerLibros(int pag, int fpp, Genero genero);

	int obtenerNumPaginas(Genero genero);

	Libro obtenerLibro(long idLibro);

}
