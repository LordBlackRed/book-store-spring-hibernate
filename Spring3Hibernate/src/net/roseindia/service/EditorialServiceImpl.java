package net.roseindia.service;

import java.util.List;

import net.roseindia.dao.EditorialDao;
import net.roseindia.model.Editorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rafael de los Santos Guirado
 *
 */
@Service("editorialService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialDao editorialDao;

	public EditorialServiceImpl() {

	}

	@Override
	public List<Editorial> obtenerEditoriales() {
		return editorialDao.obtenerEditoriales();
	}

	@Override
	public void guardar(Editorial editorial) {
		editorialDao.guardar(editorial);
	}

}
