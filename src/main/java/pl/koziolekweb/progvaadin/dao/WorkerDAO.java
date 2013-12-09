package pl.koziolekweb.progvaadin.dao;

import pl.koziolekweb.progvaadin.model.Worker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public class WorkerDAO extends MapBasedAbstractDAO<Worker, String> {
	private static Map<String,Worker> workerMap = new HashMap<String, Worker>();

	@Override
	protected Map<String, Worker> getMap() {
		return workerMap;
	}

	@Override
	protected String getId(Worker entity) {
		return entity.getName();
	}
}
