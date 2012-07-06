package net.roseindia.service;

import java.util.List;

import net.roseindia.dao.AutorDao;
import net.roseindia.model.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("autorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	private
	AutorDao autorDao;
	
	public AutorServiceImpl(){
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Autor autor) {
		autorDao.save(autor);
	}

	public void update(Autor autor) {
		autorDao.update(autor);
	}

	public void delete(Autor autor) {
		autorDao.delete(autor);
	}

	public Autor obtenerAutor(long idAutor) {
		return autorDao.obtenerAutor(idAutor);
	}

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

	public List<Autor> obtenerAutores() {
		return autorDao.obtenerAutores();
	}

}
