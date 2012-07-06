package net.roseindia.service;

import java.util.List;

import net.roseindia.model.Editorial;

/**
 * @author Rafael de los Santos Guirado
 *
 */
public interface EditorialService {
	List<Editorial> obtenerEditoriales();

	void guardar(Editorial editorial);
}
