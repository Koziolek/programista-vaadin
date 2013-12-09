package pl.koziolekweb.progvaadin.dao;

import pl.koziolekweb.progvaadin.model.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class TaskDAO extends MapBasedAbstractDAO<Task, String> {
	private static Map<String,Task> taskMap = new HashMap<String, Task>();

	@Override
	protected Map<String, Task> getMap() {
		return taskMap;
	}

	@Override
	protected String getId(Task entity) {
		return entity.getTaskName();
	}
}
