package net.roseindia.service;

import java.util.List;

import net.roseindia.dao.GeneroDao;
import net.roseindia.model.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("generoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroDao generoDao;

	public GeneroServiceImpl() {

	}

	@Override
	public List<Genero> obtenerGeneros() {
		return generoDao.obtenerGeneros();
	}

}
