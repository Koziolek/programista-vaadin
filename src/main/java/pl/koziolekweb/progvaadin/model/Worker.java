package pl.koziolekweb.progvaadin.model;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.12.13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class Worker {

	private String name;
	private long salary;
	private WorkerType typ;

	public Worker() {
	}

	public Worker(String name, long salary, WorkerType typ) {
		this.name = name;
		this.salary = salary;
		this.typ = typ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public WorkerType getTyp() {
		return typ;
	}

	public void setTyp(WorkerType typ) {
		this.typ = typ;
	}
}
