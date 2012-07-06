package net.roseindia.service;

import java.util.List;

import net.roseindia.model.Autor;


/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface AutorService {
	
	void save(Autor autor);
	void update(Autor autor);
	void delete(Autor autor);
	Autor obtenerAutor(long idAutor);
	List<Autor> obtenerAutores();

}
