package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.MyFieldFactory;
import pl.koziolekweb.progvaadin.components.datacontainers.JobContainer;
import pl.koziolekweb.progvaadin.model.Job;

import static com.vaadin.ui.Button.ClickListener;
import static pl.koziolekweb.progvaadin.model.Job_.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class JobEditor extends CustomComponent {

	public static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();
	private final FormLayout layout = new FormLayout();
	private final BeanFieldGroup<Job> bfg;
	private final Button okButton;
	private final SaveJobListener saveJobListener;
	private JobContainer container;

	public JobEditor() {
		layout.setMargin(true);
		setCaption(LOCALIZATION_HELPER.get(JobEditor.class.getName() + ".caption"));
		bfg = new BeanFieldGroup<Job>(Job.class);
		bfg.setFieldFactory(new MyFieldFactory());
		layout.addComponent(bfg.buildAndBind(LOCALIZATION_HELPER.get(JOB_NAME), "name"));
		layout.addComponent(bfg.buildAndBind(LOCALIZATION_HELPER.get(JOB_DESC), "description", TextArea.class));
		layout.addComponent(bfg.buildAndBind(LOCALIZATION_HELPER.get(JOB_TYPE), "jobType", JobTypeSelect.class));
		layout.setImmediate(true);

		okButton = new Button("OK");
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
		this.container = container;
		saveJobListener.setContainer(container);
	}

	public void edit(Job job) {
		bfg.setItemDataSource(job);
	}

}

