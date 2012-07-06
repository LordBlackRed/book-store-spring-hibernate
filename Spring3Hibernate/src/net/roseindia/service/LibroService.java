package net.roseindia.service;

import java.util.List;

import net.roseindia.model.Libro;


/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface LibroService {

	List<Libro> obtenerLibros(int pag, int fpp, long idGenero);

	void guardar(Libro libro, long idAutor, long idEditorial, long idGenero);

	int obtenerNumPaginas(int fpp, long idGenero);

	Libro obtenerLibro(long idLibro);

}
