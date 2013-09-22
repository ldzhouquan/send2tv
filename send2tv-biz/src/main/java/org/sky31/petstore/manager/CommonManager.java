package org.sky31.petstore.manager;

import java.util.List;

import org.sky31.petstore.exception.ValidateException;

/**
 * 通用Mannager接口，暴露给WEB层使用<br />
 * 封装DAO层，特别是封装需要对多个表进行操作时的动作
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-12
 */
public interface CommonManager<T, Q> {

	/**
	 * 插入一条记录
	 * 
	 * @param t
	 */
	Long add(T t) throws ValidateException;

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
	 * @param t
	 * @return
	 */
	boolean update(T t) throws ValidateException;

	/**
	 * 删除一条记录（物理删除）
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Long id);

	/**
	 * 参数校验
	 * 
	 * @param t
	 * @throws ValidateException
	 */
	void validate(T t) throws ValidateException;

}
