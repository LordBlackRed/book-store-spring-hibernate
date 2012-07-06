package net.roseindia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.roseindia.enums.Enums;
import net.roseindia.model.Autor;
import net.roseindia.model.Editorial;
import net.roseindia.model.Genero;
import net.roseindia.model.Libro;
import net.roseindia.model.LibroUsuario;
import net.roseindia.model.Puntuacion;
import net.roseindia.model.SistemaPuntuacion;
import net.roseindia.model.Usuario;
import net.roseindia.service.AutorService;
import net.roseindia.service.EditorialService;
import net.roseindia.service.GeneroService;
import net.roseindia.service.LibroService;
import net.roseindia.service.LibroUsuarioService;
import net.roseindia.service.PuntuacionService;
import net.roseindia.service.SistemaPuntuacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Controller
@RequestMapping("/libros")
public class LibroControlador {

	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private GeneroService generoService;
	@Autowired
	private EditorialService editorialService;
	@Autowired
	private PuntuacionService puntuacionService;
	@Autowired
	private SistemaPuntuacionService sistemaPuntuacionService;
	@Autowired
	private LibroUsuarioService libroUsuarioService;

	@RequestMapping(value="inicio", method = RequestMethod.GET)
	public ModelAndView listArticles(@RequestParam("pag") int pag,
			@RequestParam("gen") long idGenero, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int fpp = 4;

		if (pag != 0) {
			request.getSession().setAttribute(
					Enums.puntuacionCorrecta.toString(), true);
		}
		if (pag == 0) {
			pag = 1;
		}
		List<Libro> libros = libroService.obtenerLibros(pag, fpp, idGenero);
		int numPaginas = libroService.obtenerNumPaginas(fpp, idGenero);
		List<Genero> generos = generoService.obtenerGeneros();

		// Recorremos la lista de libros y comparamos la longitud de la sinopsis
		// para que no nos muestre toda y asi estropear el css del index

		for (Libro l : libros) {
			if (l.getSinopsis().length() >= 100) {
				// Le a–adimos puntos suspensivos para dar a entender que
				// continua en detalles
				l.setSinopsis(l.getSinopsis().substring(0, 100).concat("..."));
			}
		}

		model.put(Enums.libros.toString(), libros);
		model.put(Enums.numPaginas.toString(), numPaginas);
		model.put(Enums.generos.toString(), generos);
		model.put(Enums.genero.toString(), idGenero);
		request.getSession().setAttribute(Enums.misLibros.toString(), false);

		return new ModelAndView("librosList", model);
	}

	@RequestMapping(value = "misLibros", method = RequestMethod.GET)
	public ModelAndView misLibros(@RequestParam("pag") int pag,
			@RequestParam("gen") long idGenero, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int fpp = 4;

		if (pag != 0) {
			request.getSession().setAttribute(
					Enums.puntuacionCorrecta.toString(), true);
		}
		if (pag == 0) {
			pag = 1;
		}

		Usuario usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());

		List<Libro> libros = libroUsuarioService.obtenerLibros(pag, fpp,
				idGenero, usuario);
		int numPaginas = libroUsuarioService.obtenerNumPaginas(fpp, idGenero,
				usuario);
		List<Genero> generos = generoService.obtenerGeneros();

		// Recorremos la lista de libros y comparamos la longitud de la sinopsis
		// para que no nos muestre toda y asi estropear el css del index

		for (Libro l : libros) {
			System.out.println(l.getTitulo());
			if (l.getSinopsis().length() >= 100) {
				// Le a–adimos puntos suspensivos para dar a entender que
				// continua en detalles
				l.setSinopsis(l.getSinopsis().substring(0, 100).concat("..."));
			}
		}

		model.put(Enums.libros.toString(), libros);
		model.put(Enums.numPaginas.toString(), numPaginas);
		model.put(Enums.generos.toString(), generos);
		model.put(Enums.genero.toString(), idGenero);

		// Metemos un boleano en la sesion para no estropear aun mas la url
		// Significa que, si es true estamos navegando por la biblioteca
		// personal del usuario
		// Si es false son todos los libros registrados en el sistema
		request.getSession().setAttribute(Enums.misLibros.toString(), true);

		return new ModelAndView("librosList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addLibro(@ModelAttribute("libro") Libro libro,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Autor> autores = autorService.obtenerAutores();
		List<Genero> generos = generoService.obtenerGeneros();
		List<Editorial> editoriales = editorialService.obtenerEditoriales();

		model.put("autores", autores);
		model.put("generos", generos);
		model.put("editoriales", editoriales);

		return new ModelAndView("addLibro", model);
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public ModelAndView guardarLibro(@ModelAttribute("libro") Libro libro,
			@RequestParam("idAutor") long idAutor,
			@RequestParam("idEditorial") long idEditorial,
			@RequestParam("idGenero") long idGenero) {
		libroService.guardar(libro, idAutor, idEditorial, idGenero);
		return new ModelAndView("redirect:/inicio.html?pag=1&gen=0");
	}

	@RequestMapping(value = "/puntua", method = RequestMethod.GET)
	public ModelAndView puntuarLibro(@RequestParam("lib") long idLibro,
			@RequestParam("punt") int punt, HttpServletRequest request) {
		Libro libro = libroService.obtenerLibro(idLibro);
		Puntuacion puntuacion = puntuacionService.obtenerPuntuacion(punt);

		Usuario usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());
		SistemaPuntuacion sistemaPuntuacion = new SistemaPuntuacion(libro,
				usuario, puntuacion);
		boolean puntuacionCorrecta = sistemaPuntuacionService
				.guardar(sistemaPuntuacion);

		// Lo metemos en la sesion para no tener que pasarlo por request y
		// estropear aun mas la url
		// Ademas si hacemos por request tendriamos que pasarle siempre a la url
		// dicho valor para que el metodo
		// de obtener todos los libros (el principal) pueda leer siempre ese
		// valor, al igual que pasa con el genero
		request.getSession().setAttribute(Enums.puntuacionCorrecta.toString(),
				puntuacionCorrecta);
		if (puntuacionCorrecta)
			return new ModelAndView("redirect:/libros/inicio.html?pag=1&gen=0");
		else
			return new ModelAndView("redirect:/libros/inicio.html?pag=0&gen=0");
	}

	@RequestMapping(value = "/detalles", method = RequestMethod.GET)
	public ModelAndView detallesLibro(@RequestParam("lib") long idLibro) {
		Libro libro = libroService.obtenerLibro(idLibro);
		int puntuacion = sistemaPuntuacionService.obtenerPuntuacion(libro);
		int puntuacionTotal = sistemaPuntuacionService
				.obtenerPuntuacionTotal(libro);
		List<Genero> generos = generoService.obtenerGeneros();

		Map<String, Object> model = new HashMap<String, Object>();

		model.put(Enums.libro.toString(), libro);
		model.put(Enums.puntuacion.toString(), puntuacion);
		model.put(Enums.puntuacionTotal.toString(), puntuacionTotal);
		model.put(Enums.generos.toString(), generos);

		return new ModelAndView("detallesLibro", model);
	}

	@RequestMapping(value = "/addLibroUsuario", method = RequestMethod.GET)
	public ModelAndView addLibroUsuario(@RequestParam("lib") long idLibro,
			HttpServletRequest request) {
		Libro libro = libroService.obtenerLibro(idLibro);
		Usuario usuario = (Usuario) request.getSession().getAttribute(
				Enums.usuario.toString());

		LibroUsuario libroUsuario = new LibroUsuario(usuario, libro);
		boolean error = libroUsuarioService.guardar(libroUsuario);

		request.getSession().setAttribute(Enums.error.toString(), error);

		return new ModelAndView("redirect:/libros/detalles.html?lib=" + idLibro);
	}

}