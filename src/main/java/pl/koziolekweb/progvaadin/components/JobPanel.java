package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.components.datacontainers.JobContainer;
import pl.koziolekweb.progvaadin.model.Job;

import java.util.Collection;

import static pl.koziolekweb.progvaadin.model.Job_.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class JobPanel extends CustomComponent {

	public static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();
	private final VerticalLayout root;
	private final HorizontalLayout buttonPanel;
	private final Table jobList;
	private JobContainer jobContainer;

	public JobPanel() {
		Panel panel = new Panel();
		setCompositionRoot(panel);
		root = new VerticalLayout();
		panel.setContent(root);

		jobList = new Table(LOCALIZATION_HELPER.get("jobTab.caption"));
		jobList.setSizeFull();
		jobList.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				Window window = new Window(LOCALIZATION_HELPER.get(JOB_DESC));
				Job job = jobContainer.toJob(event.getItem());
				window.setContent(new JobViewer(job));
				window.center();
				UI.getCurrent().addWindow(window);
			}
		});
		jobList.addPropertySetChangeListener(new Container.PropertySetChangeListener() {
			@Override
			public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
				Container container = event.getContainer();
				Collection<?> itemIds = container.getItemIds();
				for(final Object o : itemIds){
					Property edit = jobList.getItem(o).getItemProperty("edit");
					Button editButton = new Button(LOCALIZATION_HELPER.get(JOB_EDIT));
					editButton.addClickListener(new Button.ClickListener() {
						@Override
						public void buttonClick(Button.ClickEvent event) {
							Window window = new Window(LOCALIZATION_HELPER.get(JOB_DESC));
							JobEditor content = new JobEditor();
							content.setContainer(jobContainer);
							window.setContent(content);
							content.edit((Job)o);
							window.center();
							UI.getCurrent().addWindow(window);
						}
					});
					edit.setValue(editButton);
				}
			}
		});
		jobList.setImmediate(true);
		buttonPanel = new HorizontalLayout();
		Button addButton = new Button(LOCALIZATION_HELPER.get(JOB_ADD));
		addButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				Window window = new Window(LOCALIZATION_HELPER.get(JOB_DESC));
				JobEditor jobEditor = new JobEditor();
				jobEditor.setContainer(jobContainer);
				window.setContent(jobEditor);
				window.center();
				UI.getCurrent().addWindow(window);
			}
		});
		buttonPanel.addComponent(addButton);
		buttonPanel.addComponent(new Button(LOCALIZATION_HELPER.get(JOB_REFERESH)));
		buttonPanel.setSizeFull();
		root.addComponent(jobList);
		root.addComponent(buttonPanel);
	}

	@Override
	public void attach() {
		super.attach();
		jobContainer = new JobContainer();
		jobList.setContainerDataSource(jobContainer);
		Collection<?> containerPropertyIds = jobContainer.getContainerPropertyIds();
		jobList.addContainerProperty("edit", Button.class, null);
		for (Object o : containerPropertyIds) {
			jobList.setColumnHeader(o, LOCALIZATION_HELPER.get(o.toString()));
		}
		jobList.setColumnHeader("edit", " ");
	}
}

