package org.sky31.petstore.dao;

import java.util.List;

/**
 * 公共DAO接口
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-12
 */
public interface CommonDAO<T, Q> {
	
	/**
	 * 插入一条记录
	 * 
	 * @param t
	 */
	Long insert(T t);

	/**
	 * 通过ID获得一条记录
	 * 
	 * @param id
	 * @return
	 */
	T get(Long id);

	/**
	 * 通过queryModel获取一个结果集
	 * 
	 * @param queryModel
	 * @return
	 */
	List<T> get(Q queryModel);

	/**
	 * 通过queryModel获取结果数
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(Q queryModel);

	/**
	 * 更新一条记录
	 * 
	 * @param comment
	 * @return
	 */
	boolean update(T t);

	/**
	 * 删除一条记录（物理删除）
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Long id);

}
