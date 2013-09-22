package org.sky31.petstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * {@link CommonDAO}的适配器
 * <p />
 * 1. 封装SqlMapClient基本方法<br />
 * 2. 若子类有扩张需求，提供扩展支持
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-10
 */
public abstract class AbstractDAO<T, Q> implements CommonDAO<T, Q> {
	
	@Autowired
	protected SqlMapClient sqlMapClient;

	@SuppressWarnings({ "hiding", "unchecked" })
	protected <T> T executeQueryForObject(String statementName, Object parameterObject) {
		try {
			return (T) sqlMapClient.queryForObject(statementName, parameterObject);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	protected <T> List<T> executeQueryForList(String statementName, Object parameterObject) {
		try {
			return sqlMapClient.queryForList(statementName, parameterObject);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected Long executeInsert(String statementName, Object parameterObject) {
		try {
			return (Long) sqlMapClient.insert(statementName, parameterObject);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected int executeUpdate(String statementName, Object parameterObject) {
		try {
			return sqlMapClient.update(statementName, parameterObject);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 设置sqlMapClient
	 * 
	 * @param sqlMapClient 要设置的sqlMapClient
	 */
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
}
