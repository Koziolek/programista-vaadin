package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Window;
import pl.koziolekweb.progvaadin.JobFieldFactory;
import pl.koziolekweb.progvaadin.components.datacontainers.JobContainer;
import pl.koziolekweb.progvaadin.model.Job;

import static pl.koziolekweb.progvaadin.components.Commons_.OK;
import static pl.koziolekweb.progvaadin.components.ComponentCaptions_.JOB_EDITOR_CAPTION;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_DESC;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_NAME;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_TYPE;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class JobEditor extends CustomComponent {

	private final FormLayout layout = new FormLayout();
	private final BeanFieldGroup<Job> bfg;
	private final Button okButton;
	private final SaveJobListener saveJobListener;

	public JobEditor() {
		layout.setMargin(true);
		setCaption(JOB_EDITOR_CAPTION());
		bfg = new BeanFieldGroup<Job>(Job.class);
		bfg.setFieldFactory(new JobFieldFactory());
		layout.addComponent(bfg.buildAndBind(JOB_NAME(),
				"name"));
		layout.addComponent(bfg.buildAndBind(JOB_DESC(),
				"description", TextArea.class));
		layout.addComponent(bfg.buildAndBind(JOB_TYPE(),
				"jobType", JobTypeSelect.class));
		layout.setImmediate(true);

		okButton = new Button(OK());
		saveJobListener = new SaveJobListener(bfg);
		okButton.addClickListener(saveJobListener);

		layout.addComponent(okButton);
		setCompositionRoot(layout);
	}

	@Override
	public void attach() {
		super.attach();
		saveJobListener.setParentWindow((Window) getParent());
	}

	public void setContainer(JobContainer container) {
		saveJobListener.setContainer(container);
	}

	public void edit(Job job) {
		bfg.setItemDataSource(job);
	}
}

