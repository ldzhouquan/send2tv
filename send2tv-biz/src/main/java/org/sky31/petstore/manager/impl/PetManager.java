package org.sky31.petstore.manager.impl;

import java.util.List;

import org.sky31.petstore.dao.CommonDAO;
import org.sky31.petstore.domain.PetDO;
import org.sky31.petstore.exception.ValidateException;
import org.sky31.petstore.manager.AbstractManager;
import org.sky31.petstore.model.PetQueryModel;
import org.sky31.petstore.util.StringUtils;

/**
 * PetManager
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-12
 */
public class PetManager extends AbstractManager<PetDO, PetQueryModel> {

	private CommonDAO<PetDO, PetQueryModel> petDAO;

	@Override
	public Long add(PetDO t) throws ValidateException {
		validate(t);
		return petDAO.insert(t);
	}

	@Override
	public PetDO get(Long id) {
		return petDAO.get(id);
	}

	@Override
	public List<PetDO> get(PetQueryModel queryModel) {
		return petDAO.get(queryModel);
	}

	@Override
	public Long count(PetQueryModel queryModel) {
		return petDAO.count(queryModel);
	}

	@Override
	public boolean update(PetDO t) throws ValidateException {
		if (t.getId() == null) {
			throw new ValidateException("id must be not null!");
		}
		return petDAO.update(t);
	}

	@Override
	public boolean delete(Long id) {
		return petDAO.delete(id);
	}

	@Override
	public void validate(PetDO t) throws ValidateException {
		if (t.getId() == null) {
			throw new ValidateException("id must be not null!");
		} else if (StringUtils.isBlank(t.getName())) {
			throw new ValidateException("name must be not null!");
		} else if (t.getType() == null) {
			throw new ValidateException("type must be not null!");
		} else if(t.getIsSelled()==null){
			throw new ValidateException("isSelled must be not null!");
		}
	}

	/**
	 * 设置petDAO
	 * 
	 * @param petDAO 要设置的petDAO
	 */
	public void setPetDAO(CommonDAO<PetDO, PetQueryModel> petDAO) {
		this.petDAO = petDAO;
	}
}
