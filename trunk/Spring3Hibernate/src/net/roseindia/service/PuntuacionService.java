package net.roseindia.service;

import net.roseindia.model.Puntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface PuntuacionService {

	void guardar(Puntuacion puntuacion);

	Puntuacion obtenerPuntuacion(int punt);

}
