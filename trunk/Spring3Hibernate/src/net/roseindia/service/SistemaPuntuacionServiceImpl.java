package net.roseindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.roseindia.dao.SistemaPuntuacionDao;
import net.roseindia.model.Libro;
import net.roseindia.model.SistemaPuntuacion;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("sistemaPuntuacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SistemaPuntuacionServiceImpl implements SistemaPuntuacionService {

	@Autowired
	SistemaPuntuacionDao sistemaPuntuacionDao;

	@Override
	public boolean guardar(SistemaPuntuacion sistemaPuntuacion) {
		// Buscamos si dicho usuario ha puntuado ya el libro en concreto para
		// que asi no pueda volver a puntuar
		SistemaPuntuacion sistemaPuntuacionLibroUsuario = sistemaPuntuacionDao
				.obtenerSistemaPuntuacionPorLibroUsuario(sistemaPuntuacion);

		if (sistemaPuntuacionLibroUsuario == null) {
			sistemaPuntuacionDao.guardar(sistemaPuntuacion);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int obtenerPuntuacion(Libro libro) {
		return sistemaPuntuacionDao.obtenerPuntuacion(libro);
	}

	@Override
	public int obtenerPuntuacionTotal(Libro libro) {
		return sistemaPuntuacionDao.obtenerPuntuacionTotal(libro);
	}

}
