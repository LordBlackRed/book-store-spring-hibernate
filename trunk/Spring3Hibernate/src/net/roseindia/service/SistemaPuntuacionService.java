package net.roseindia.service;

import net.roseindia.model.Libro;
import net.roseindia.model.SistemaPuntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface SistemaPuntuacionService {
	boolean guardar(SistemaPuntuacion sistemaPuntuacion);

	int obtenerPuntuacion(Libro libro);

	int obtenerPuntuacionTotal(Libro libro);
}
