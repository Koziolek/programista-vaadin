package pl.koziolekweb.progvaadin.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.12.13
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class Job {

	private Worker doneBy;
	private Date start;
	private Date end;
	private String name;
	private String description;

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	private JobType jobType;

	public Worker getDoneBy() {
		return doneBy;
	}

	public void setDoneBy(Worker doneBy) {
		this.doneBy = doneBy;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
