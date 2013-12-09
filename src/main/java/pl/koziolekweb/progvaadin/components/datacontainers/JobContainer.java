package pl.koziolekweb.progvaadin.components.datacontainers;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import pl.koziolekweb.progvaadin.dao.JobDAO;
import pl.koziolekweb.progvaadin.model.Job;
import pl.koziolekweb.progvaadin.model.JobType;

import static pl.koziolekweb.progvaadin.model.Job_.JOB_DESC;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_NAME;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_TYPE;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 */
public class JobContainer extends IndexedContainer {

	private JobDAO jobDAO = new JobDAO();

	public JobContainer() {
		addContainerProperty(JOB_NAME(), String.class, null);
		addContainerProperty(JOB_DESC(), String.class, null);
		addContainerProperty(JOB_TYPE(), JobType.class, null);
		for (Job newJob : jobDAO.all()) {
			Item item = super.addItem(newJob);
			setItemProperties(newJob, item);

		}
	}

	public Item addItem(Object itemId, Job newJob) {
		Item item = super.addItem(newJob);
		setItemProperties(newJob, item);
		jobDAO.add(newJob);
		return item;
	}

	public Item refreshItem(Object itemId, Job newJob) {
		Job oldJob = jobDAO.get(itemId.toString());
		Item item = super.getItem(oldJob);
		Property itemProperty = item.getItemProperty(JOB_DESC());
		itemProperty.setValue(newJob.getDescription());
		item.getItemProperty(JOB_TYPE()).setValue(newJob.getJobType());
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
		return jobDAO.get(item.getItemProperty(JOB_NAME()).getValue().toString());
	}

	private void setItemProperties(Job newJob, Item item) {
		item.getItemProperty(JOB_NAME()).setValue(newJob.getName());
		item.getItemProperty(JOB_DESC()).setValue(newJob.getDescription());
		item.getItemProperty(JOB_TYPE()).setValue(newJob.getJobType());
	}
}
