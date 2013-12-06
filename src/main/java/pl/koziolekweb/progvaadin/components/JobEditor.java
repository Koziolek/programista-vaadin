package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.MyFieldFactory;
import pl.koziolekweb.progvaadin.model.Job;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class JobEditor extends CustomComponent {

	private final LocalizationHelper localizationHelper = LocalizationHelper.defaultInstance();
	private final FormLayout layout = new FormLayout();

	public JobEditor() {
		setCaption(localizationHelper.get(JobEditor.class.getName() + ".caption"));
		BeanFieldGroup<Job> bfg = new BeanFieldGroup<Job>(Job.class);
		bfg.setFieldFactory(new MyFieldFactory());
		layout.addComponent(bfg.buildAndBind(localizationHelper.get("job.name"), "name"));
		layout.addComponent(bfg.buildAndBind(localizationHelper.get("job.desc"), "description"));
		layout.addComponent(bfg.buildAndBind(localizationHelper.get("job.type"), "jobType", JobTypeSelect.class));

		setCompositionRoot(layout);
	}
}
