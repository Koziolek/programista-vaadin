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

	SaveJobListener(BeanFieldGroup<Job> bfg) {
		this.bfg = bfg;
	}

	void setParentWindow(Window parent) {
		this.parent = parent;
	}

	@Override
	public void buttonClick(Button.ClickEvent event) {
		try {
			bfg.commit();
			container.refreshItem(bfg.getItemDataSource().getBean().getName(), bfg.getItemDataSource().getBean());
			parent.close();
		} catch (FieldGroup.CommitException e) {
			e.printStackTrace();
		}
	}

	void setContainer(JobContainer container) {
		this.container = container;
	}
}
