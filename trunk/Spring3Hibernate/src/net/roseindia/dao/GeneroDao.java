package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Genero;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface GeneroDao {

	List<Genero> obtenerGeneros();

	Genero obtenerGenero(long idGenero);
}
