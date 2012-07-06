package net.roseindia.controller;

import java.util.HashMap;
import java.util.Map;

import net.roseindia.model.Autor;
import net.roseindia.service.AutorService;

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
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveArticle(@ModelAttribute("autor") Autor autor) {
		System.out.println("nombre: "+ autor.getNombre());
		System.out.println("apellidos: "+ autor.getApellidos());
		 autorService.save(autor);
		return new ModelAndView("redirect:/autores.html");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listArticles() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("autores",  autorService.obtenerAutores());

		return new ModelAndView("autoresList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addArticle(@ModelAttribute("autor") Autor autor,
			BindingResult result) {
		return new ModelAndView("addAutor");
	}

}