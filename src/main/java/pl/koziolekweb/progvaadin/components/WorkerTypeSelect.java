package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Select;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.model.JobType;
import pl.koziolekweb.progvaadin.model.WorkerType;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class WorkerTypeSelect extends Select {

	private final LocalizationHelper localizationHelper;

	public WorkerTypeSelect() {
		super("Rodzaj pracownika");
		localizationHelper = LocalizationHelper.defaultInstance();
		Container container = prepareContainer();
		setContainerDataSource(container);
		for (WorkerType jt : WorkerType.values())
			setItemCaption(jt, localizationHelper.get(jt.name()));


	}

	private Container prepareContainer() {
		Container container = new IndexedContainer();
		container.addContainerProperty("name", JobType.class, null);
		for (WorkerType jt : WorkerType.values())
			container.addItem(jt);
		return container;
	}
}
