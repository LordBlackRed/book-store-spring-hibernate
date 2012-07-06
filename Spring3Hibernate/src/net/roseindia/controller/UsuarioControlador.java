package net.roseindia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.roseindia.enums.Enums;
import net.roseindia.model.Genero;
import net.roseindia.model.Usuario;
import net.roseindia.service.GeneroService;
import net.roseindia.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GeneroService generoService;

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public ModelAndView guardarUsuario(
			@ModelAttribute("usuario") Usuario usuario,
			HttpServletRequest request) {
		boolean error = usuarioService.guardar(usuario);
		
		request.getSession().setAttribute(Enums.error.toString(), error);
		
		return new ModelAndView("redirect:/libros/inicio.html?pag=1&gen=0");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listUsuarios() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("usuarios", usuarioService.obtenerUsuarios());

		return new ModelAndView("usuariosList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario,
			BindingResult result) {
		List<Genero> generos = generoService.obtenerGeneros();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(Enums.generos.toString(), generos);

		return new ModelAndView("addUsuario", model);
	}

	@RequestMapping(value = "/loguear", method = RequestMethod.POST)
	public ModelAndView loguearUsuario(@ModelAttribute("usuario") Usuario user,
			BindingResult result, HttpServletRequest request) {
		boolean correcto = usuarioService.loguearUsuario(user);

		if (correcto) {
			// Obtenemos todos los datos del usuario para meterlo en la sesion
			Usuario usuario = usuarioService.obtenerUsuario(user);
			request.getSession()
					.setAttribute(Enums.usuario.toString(), usuario);
		} else {
			request.getSession().setAttribute(Enums.loginFail.toString(), true);
		}
		return new ModelAndView("redirect:/libros/inicio.html?pag=1&gen=0");
	}

	@RequestMapping(value = "/destruirSesion", method = RequestMethod.GET)
	public ModelAndView destruirSesion(HttpServletRequest request) {
		Usuario usuario = (Usuario) request.getSession()
				.getAttribute("usuario");
		usuarioService.destruirSesion(usuario, request);
		return new ModelAndView("redirect:/libros/inicio.html?pag=1&gen=0");
	}

}