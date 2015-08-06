package com.sws.rainbow.core.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	T findOne(PK pk) throws DataAccessException;

	List<T> findAll() throws DataAccessException;

	int delete(PK pk) throws DataAccessException;

	int insert(T entity) throws DataAccessException;

	int update(T entity) throws DataAccessException;
}
