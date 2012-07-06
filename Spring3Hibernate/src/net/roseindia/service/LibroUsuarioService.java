package net.roseindia.service;

import java.util.List;

import net.roseindia.model.Libro;
import net.roseindia.model.LibroUsuario;
import net.roseindia.model.Usuario;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface LibroUsuarioService {

	boolean guardar(LibroUsuario libroUsuario);

	List<Libro> obtenerLibros(int pag, int fpp, long idGenero, Usuario usuario);

	int obtenerNumPaginas(int fpp, long idGenero, Usuario usuario);
}
