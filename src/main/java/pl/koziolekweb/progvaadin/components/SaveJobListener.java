package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import pl.koziolekweb.progvaadin.components.datacontainers.JobContainer;
import pl.koziolekweb.progvaadin.model.Job;

public class SaveJobListener implements Button.ClickListener {
	private BeanFieldGroup<Job> bfg;
	private JobContainer container;
	private Window parent;

	public SaveJobListener(BeanFieldGroup<Job> bfg) {
		this.bfg = bfg;
	}

	@Override
	public void buttonClick(Button.ClickEvent event) {
		try {
			bfg.commit();
			Job job = bfg.getItemDataSource().getBean();
			if (container.containsId(job))
				container.refreshItem(job.getName(), job);
			else
				container.addItem(job.getName(), job);
			parent.close();
		} catch (FieldGroup.CommitException e) {
			e.printStackTrace();
		}
	}

	public void setParentWindow(Window parent) {
		this.parent = parent;
	}

	public void setContainer(JobContainer container) {
		this.container = container;
	}
}
