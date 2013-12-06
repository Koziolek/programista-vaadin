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

	private String name;
	private String description;
	private JobType jobType;

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
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
