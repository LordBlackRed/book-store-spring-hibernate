package net.roseindia.dao;

import net.roseindia.model.Libro;
import net.roseindia.model.SistemaPuntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface SistemaPuntuacionDao {
	void guardar(SistemaPuntuacion sistemaPuntuacion);

	SistemaPuntuacion obtenerSistemaPuntuacionPorLibroUsuario(SistemaPuntuacion sistemaPuntuacion);
	
	int obtenerPuntuacion(Libro libro);

	int obtenerPuntuacionTotal(Libro libro);
}
