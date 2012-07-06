package net.roseindia.controller;

import java.util.List;

import net.roseindia.model.Libro;
import net.roseindia.model.LibroUsuario;
import net.roseindia.model.Usuario;

public interface LibroUsuarioDao {

	void guardar(LibroUsuario libroUsuario);

	LibroUsuario obtenerLibroUsuario(Usuario usuario, Libro libro);

	List<LibroUsuario> obtenerLibrosUsuario(Usuario usuario);
}
