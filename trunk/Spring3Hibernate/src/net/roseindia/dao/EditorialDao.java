package net.roseindia.dao;

import java.util.List;

import net.roseindia.model.Editorial;

public interface EditorialDao {

	List<Editorial> obtenerEditoriales();

	Editorial obtenerEditorial(long idEditorial);
	
	void guardar(Editorial editorial);
}
