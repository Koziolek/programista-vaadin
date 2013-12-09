package pl.koziolekweb.progvaadin.dao;

import pl.koziolekweb.progvaadin.exceptions.EntityExistException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public abstract class MapBasedAbstractDAO<T, ID> implements CrudDAO<T, ID> {

	private final Map<ID, T> entityRegister;

	protected MapBasedAbstractDAO() {
		this.entityRegister = getMap();
	}

	protected abstract Map<ID,T> getMap();

	protected abstract ID getId(T entity);

	@Override
	public ID add(T entity) {
		ID id = getId(entity);
		if (entityRegister.containsKey(id))
			throw new EntityExistException("Obiekt i tym ID istnieje");
		T put = entityRegister.put(id, entity);
		return id;
	}

	@Override
	public T get(ID entityId) {
		return entityRegister.get(entityId);
	}

	@Override
	public T update(T entity) {
		ID id = getId(entity);
		entityRegister.put(id, entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		entityRegister.remove(getId(entity));
	}

	@Override
	public Collection<T> all() {
		return entityRegister.values();
	}
}
