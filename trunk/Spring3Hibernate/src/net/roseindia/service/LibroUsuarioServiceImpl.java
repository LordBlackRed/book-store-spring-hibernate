package net.roseindia.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.roseindia.controller.LibroUsuarioDao;
import net.roseindia.dao.GeneroDao;
import net.roseindia.model.Genero;
import net.roseindia.model.Libro;
import net.roseindia.model.LibroUsuario;
import net.roseindia.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("libroUsuarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LibroUsuarioServiceImpl implements LibroUsuarioService {

	@Autowired
	private LibroUsuarioDao libroUsuarioDao;
	@Autowired
	private GeneroDao generoDao;

	public LibroUsuarioServiceImpl() {

	}

	@Override
	public boolean guardar(LibroUsuario libroUsuario) {

		LibroUsuario libroUsuarioAux = libroUsuarioDao.obtenerLibroUsuario(
				libroUsuario.getUsuario(), libroUsuario.getLibro());
		// Si existe NO se introduce en la bd
		if (libroUsuarioAux == null) {
			libroUsuarioDao.guardar(libroUsuario);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Libro> obtenerLibros(int pag, int fpp, long idGenero,
			Usuario usuario) {
		// Si idGenero = 0 significa que no se va a filtrar por ningun genero
		List<LibroUsuario> librosUsuario = libroUsuarioDao
				.obtenerLibrosUsuario(usuario);
		int comienzo = (fpp * pag) - fpp;
		int fin = fpp;
		List<Libro> libros = new ArrayList<Libro>();
		if(comienzo == 0){
			--fin;
		}
		if (idGenero == 0) {

			for (int i = comienzo; i <= fin; i++) {

				try {
					libros.add(librosUsuario.get(i).getLibro());
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}

		} else {
			Genero genero = generoDao.obtenerGenero(idGenero);
			Iterator<LibroUsuario> it = librosUsuario.iterator();
			List<LibroUsuario> librosUsuarioAux = new ArrayList<LibroUsuario>();
			librosUsuarioAux.addAll(librosUsuario);
			
			while (it.hasNext()) {
				LibroUsuario libroUsuario = it.next();
				if (libroUsuario.getLibro().getGenero().getId() != genero.getId()) {
					librosUsuarioAux.remove(libroUsuario);
				}
			}

			for (int i = comienzo; i <= fin; i++) {
				try {
					libros.add(librosUsuarioAux.get(i).getLibro());
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}

		}

		return libros;
	}

	public int obtenerNumPaginas(int fpp, long idGenero, Usuario usuario) {
		// Si idGenero = 0 significa que no se va a filtrar por ningun genero
				int numLibros = 0;
				List<LibroUsuario> librosUsuario = libroUsuarioDao
						.obtenerLibrosUsuario(usuario);
				if(idGenero == 0){
					numLibros = librosUsuario.size();
				}else{
					Genero genero = generoDao.obtenerGenero(idGenero);
					
					for(LibroUsuario libroUsuario: librosUsuario){
						if(libroUsuario.getLibro().getGenero().equals(genero)){
							numLibros++;
						}
					}
					
				}
				double numero = (double) numLibros / (double) fpp;
				String val = String.valueOf(numero);
				BigDecimal big = new BigDecimal(val);
				big = big.setScale(0, RoundingMode.UP);

				int numPaginas = big.intValue();

				return numPaginas;
			}
}
