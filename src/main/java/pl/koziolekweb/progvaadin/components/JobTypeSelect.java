package pl.koziolekweb.progvaadin.components;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Select;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.model.JobType;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class JobTypeSelect extends Select {

	private final LocalizationHelper localizationHelper;

	public JobTypeSelect() {
		super("Rodzaj zadania");
		localizationHelper = LocalizationHelper.defaultInstance();
		Container container = prepareContainer();
		setContainerDataSource(container);
		for (JobType jt : JobType.values())
			setItemCaption(jt, localizationHelper.get(jt.name()));


	}



	private Container prepareContainer() {
		Container container = new IndexedContainer();
		container.addContainerProperty("name", JobType.class, null);
		for (JobType jt : JobType.values())
			container.addItem(jt);
		return container;
	}
}
