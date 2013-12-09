package pl.koziolekweb.progvaadin.components.datacontainers;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import pl.koziolekweb.progvaadin.dao.JobDAO;
import pl.koziolekweb.progvaadin.model.Job;
import pl.koziolekweb.progvaadin.model.JobType;

import static pl.koziolekweb.progvaadin.model.Job_.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 */
public class JobContainer extends IndexedContainer {
	private JobDAO jobDAO = new JobDAO();

	public JobContainer() {
		addContainerProperty(JOB_NAME, String.class, null);
		addContainerProperty(JOB_DESC, String.class, null);
		addContainerProperty(JOB_TYPE, JobType.class, null);
		for (Job j : jobDAO.all()) {
			Item item = super.addItem(j);
			item.getItemProperty(JOB_NAME).setValue(j.getName());
			item.getItemProperty(JOB_DESC).setValue(j.getDescription());
			item.getItemProperty(JOB_TYPE).setValue(j.getJobType());

		}
	}

	@Override
	public Item addItem(Object itemId) {
		Item item = super.addItem(itemId);
		Job job = (Job) itemId;
		item.getItemProperty(JOB_NAME).setValue(job.getName());
		item.getItemProperty(JOB_DESC).setValue(job.getDescription());
		item.getItemProperty(JOB_TYPE).setValue(job.getJobType());
		jobDAO.add(job);
		return item;
	}

	public Item refreshItem(Object itemId, Job newJob) {
		Job oldJob = jobDAO.get(itemId.toString());
		Item item = super.getItem(oldJob);
		Job job = toJob(item);
		Property itemProperty = item.getItemProperty(JOB_DESC);
		System.out.println(item + " " + itemProperty + " " + newJob);
		itemProperty.setValue(newJob.getDescription());
		item.getItemProperty(JOB_TYPE).setValue(newJob.getJobType());
		jobDAO.update(newJob);
		return item;
	}

	@Override
	public boolean removeItem(Object itemId) {
		boolean b = super.removeItem(itemId);
		jobDAO.delete((Job) itemId);
		return b;
	}

	public Job toJob(Item item) {
		return jobDAO.get(item.getItemProperty(JOB_NAME).getValue().toString());
	}
}
