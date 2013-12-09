package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.components.datacontainers.JobContainer;
import pl.koziolekweb.progvaadin.model.Job;

import java.util.Collection;

import static com.vaadin.data.Container.ItemSetChangeListener;
import static com.vaadin.data.Container.PropertySetChangeListener;
import static com.vaadin.event.ItemClickEvent.ItemClickListener;
import static com.vaadin.ui.Button.ClickListener;
import static pl.koziolekweb.progvaadin.components.ComponentCaptions_.JOB_TAB_CAPTION;
import static pl.koziolekweb.progvaadin.model.JobType_.getJOB_TYPE;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_ADD;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_DESC;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_EDIT;
import static pl.koziolekweb.progvaadin.model.Job_.JOB_REFRESH;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class JobPanel extends CustomComponent {

	private final VerticalLayout root;
	private final HorizontalLayout buttonPanel;
	private final Table jobList;
	private JobContainer jobContainer;

	public JobPanel() {
		Panel panel = new Panel();
		setCompositionRoot(panel);
		root = new VerticalLayout();
		panel.setContent(root);

		jobList = new Table(JOB_TAB_CAPTION());
		jobList.setSizeFull();
		jobList.addItemClickListener(new JobTableItemClickListener());
		ItemPropertySetChangeListener itemPropertySetChangeListener = new ItemPropertySetChangeListener();
		jobList.addPropertySetChangeListener(itemPropertySetChangeListener);
		jobList.addItemSetChangeListener(itemPropertySetChangeListener);
		jobList.setImmediate(true);
		buttonPanel = new HorizontalLayout();
		Button addButton = new Button(JOB_ADD());
		addButton.addClickListener(new EditButtonClickListener(new Job()));
		buttonPanel.addComponent(addButton);
		buttonPanel.addComponent(new Button(JOB_REFRESH()));
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
			jobList.setColumnHeader(o, getJOB_TYPE(o.toString()));
		}
		jobList.setColumnHeader("edit", " ");

	}

	private class ItemPropertySetChangeListener implements ItemSetChangeListener, PropertySetChangeListener {
		@Override
		public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
			Container container = event.getContainer();
			addEditButtons(container);
		}

		@Override
		public void containerItemSetChange(Container.ItemSetChangeEvent event) {
			Container container = event.getContainer();
			addEditButtons(container);
		}

		private void addEditButtons(Container container) {
			Collection<?> itemIds = container.getItemIds();
			for (final Object o : itemIds) {
				Property edit = jobList.getItem(o).getItemProperty("edit");
				Button editButton = new Button(JOB_EDIT());
				editButton.addClickListener(new EditButtonClickListener((Job) o));
				edit.setValue(editButton);
			}
		}
	}

	private class JobTableItemClickListener implements ItemClickListener {
		@Override
		public void itemClick(ItemClickEvent event) {
			Window window = new Window(JOB_DESC());
			Job job = jobContainer.toJob(event.getItem());
			window.setContent(new JobViewer(job));
			window.center();
			UI.getCurrent().addWindow(window);
		}
	}

	private class EditButtonClickListener implements ClickListener {
		private final Job job;

		public EditButtonClickListener(Job job) {
			this.job = job;
		}

		@Override
		public void buttonClick(Button.ClickEvent event) {
			Window window = new Window(JOB_DESC());
			JobEditor content = new JobEditor();
			content.setContainer(jobContainer);
			window.setContent(content);
			content.edit(job);
			window.center();
			UI.getCurrent().addWindow(window);
		}
	}
}

