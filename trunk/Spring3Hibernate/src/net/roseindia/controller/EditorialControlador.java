package net.roseindia.controller;

import java.util.HashMap;
import java.util.Map;

import net.roseindia.model.Editorial;
import net.roseindia.service.EditorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Controller 
@RequestMapping("/editoriales")
public class EditorialControlador {

	@Autowired
	private EditorialService editorialService;

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public ModelAndView guardarEditorial(@ModelAttribute("editorial") Editorial editorial) {
		System.out.println("nombre: "+ editorial.getNombre());
		 editorialService.guardar(editorial);
		return new ModelAndView("redirect:/editoriales.html");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listArticles() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editoriales",  editorialService.obtenerEditoriales());

		return new ModelAndView("editorialesList", model);
	}

}