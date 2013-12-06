package pl.koziolekweb.progvaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Validator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.javatuples.Pair;
import pl.koziolekweb.progvaadin.components.JobEditor;
import pl.koziolekweb.progvaadin.components.JobTypeSelect;
import pl.koziolekweb.progvaadin.components.WorkerTypeSelect;
import pl.koziolekweb.progvaadin.model.JobType;
import pl.koziolekweb.progvaadin.model.WorkerType;
import pl.koziolekweb.progvaadin.validators.JobToWorkerValidator;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	private JobTypeSelect jobTypeSelect;
	private WorkerTypeSelect workerTypeSelect;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "pl.koziolekweb.progvaadin.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		layout.addComponent(new JobEditor());
	}

}
