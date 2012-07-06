package net.roseindia.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import net.roseindia.dao.AutorDao;
import net.roseindia.dao.EditorialDao;
import net.roseindia.dao.GeneroDao;
import net.roseindia.dao.LibroDao;
import net.roseindia.model.Autor;
import net.roseindia.model.Editorial;
import net.roseindia.model.Genero;
import net.roseindia.model.Libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("libroService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroDao libroDao;

	@Autowired
	private AutorDao autorDao;

	@Autowired
	private EditorialDao editorialDao;

	@Autowired
	private GeneroDao generoDao;

	public LibroServiceImpl() {

	}

	@Override
	public List<Libro> obtenerLibros(int pag, int fpp, long idGenero) {
		// Si idGenero = 0 significa que no se va a filtrar por ningun genero
		if (idGenero == 0) {
			return libroDao.obtenerLibros(pag, fpp);
		} else {
			Genero genero = generoDao.obtenerGenero(idGenero);
			return libroDao.obtenerLibros(pag, fpp, genero);
		}
	}

	@Override
	public void guardar(Libro libro, long idAutor, long idEditorial,
			long idGenero) {

		Autor autor = autorDao.obtenerAutor(idAutor);
		Editorial editorial = editorialDao.obtenerEditorial(idEditorial);
		Genero genero = generoDao.obtenerGenero(idGenero);

		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setGenero(genero);

		libro.setFechaPublicacion(new Date());

		libroDao.guardar(libro);
	}

	@Override
	public int obtenerNumPaginas(int fpp, long idGenero) {
		// Si idGenero = 0 significa que no se va a filtrar por ningun genero
		int numLibros = 0;
		if(idGenero == 0){
			numLibros = libroDao.obtenerNumPaginas();
		}else{
			Genero genero = generoDao.obtenerGenero(idGenero);
			numLibros = libroDao.obtenerNumPaginas(genero);
		}
		System.out.println("numLibros " + numLibros);
		double numero = (double) numLibros / (double) fpp;
		System.out.println("numero: " + numero);
		String val = String.valueOf(numero);
		BigDecimal big = new BigDecimal(val);
		big = big.setScale(0, RoundingMode.UP);

		int numPaginas = big.intValue();

		return numPaginas;
	}

	@Override
	public Libro obtenerLibro(long idLibro) {

		return libroDao.obtenerLibro(idLibro);
	}


}
