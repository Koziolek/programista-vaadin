package pl.koziolekweb.progvaadin.model;

import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 05.12.13
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class Task {

	private Date start;
	private Date end;

	private Job job;
	private Set<Worker> workers;

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Set<Worker> getWorkers() {
		return workers;
	}

	public void addWorker(Worker worker){
		workers.add(worker);
	}

	public void removeWorker(Worker worker){
		workers.remove(worker);
	}
}
