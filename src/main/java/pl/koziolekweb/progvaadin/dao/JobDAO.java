package pl.koziolekweb.progvaadin.dao;

import pl.koziolekweb.progvaadin.model.Job;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 12:23
 * To change this template use File | Settings | File Templates.
 */
public class JobDAO extends MapBasedAbstractDAO<Job, String> {
	private static Map<String,Job> jobMap = new HashMap<String, Job>();

	@Override
	protected Map<String, Job> getMap() {
		return jobMap;
	}

	@Override
	protected String getId(Job entity) {
		return entity.getName();
	}
}
