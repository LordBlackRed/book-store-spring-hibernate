package net.roseindia.service;

import net.roseindia.dao.PuntuacionDao;
import net.roseindia.model.Puntuacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("puntuacionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PuntuacionServiceImpl implements PuntuacionService {

	@Autowired
	private PuntuacionDao puntuacionDao;

	public PuntuacionServiceImpl() {

	}
	public void guardar(Puntuacion puntuacion) {
		puntuacionDao.guardar(puntuacion);
	}
	@Override
	public Puntuacion obtenerPuntuacion(int punt) {
		return puntuacionDao.obtenerPuntuacion(punt);
	}

}
