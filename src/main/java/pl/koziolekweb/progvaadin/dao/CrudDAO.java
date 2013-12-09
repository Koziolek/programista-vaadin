package pl.koziolekweb.progvaadin.dao;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 */
public interface CrudDAO<T, ID> {

	ID add(T entity);
	T get(ID entityId);
	T update(T entity);
	void delete(T entity);
	Collection<T> all();

}
