package net.roseindia.dao;

import net.roseindia.model.Puntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface PuntuacionDao {

	void guardar(Puntuacion puntuacion);

	Puntuacion obtenerPuntuacion(int punt);
}
