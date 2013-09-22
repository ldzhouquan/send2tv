package org.sky31.petstore.dao.impl;

import java.util.List;

import org.sky31.petstore.dao.AbstractDAO;
import org.sky31.petstore.domain.PetDO;
import org.sky31.petstore.model.PetQueryModel;

/**
 * Pet表操作DAO
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-10
 */
public class PetDAO extends AbstractDAO<PetDO, PetQueryModel> {

	@Override
	public Long insert(PetDO t) {
		return executeInsert("pet.dao.insert", t);
	}

	@Override
	public PetDO get(Long id) {
		return executeQueryForObject("pet.dao.queryById", id);
	}

	@Override
	public List<PetDO> get(PetQueryModel queryModel) {
		return executeQueryForList("pet.dao.query", queryModel);
	}

	@Override
	public Long count(PetQueryModel queryModel) {
		return executeQueryForObject("pet.dao.count", queryModel);
	}

	@Override
	public boolean update(PetDO t) {
		executeUpdate("pet.dao.update", t);
		return Boolean.TRUE;
	}

	@Override
	public boolean delete(Long id) {
		executeUpdate("pet.dao.delete", id);
		return Boolean.TRUE;
	}

}
