package pl.koziolekweb.progvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import pl.koziolekweb.progvaadin.components.JobPanel;
import pl.koziolekweb.progvaadin.components.JobTypeSelect;
import pl.koziolekweb.progvaadin.components.WorkerTypeSelect;
import pl.koziolekweb.progvaadin.dao.JobDAO;
import pl.koziolekweb.progvaadin.dao.WorkerDAO;
import pl.koziolekweb.progvaadin.model.Job;
import pl.koziolekweb.progvaadin.model.Worker;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import static pl.koziolekweb.progvaadin.model.JobType.*;
import static pl.koziolekweb.progvaadin.model.WorkerType.*;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	public static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();
	private JobTypeSelect jobTypeSelect;
	private WorkerTypeSelect workerTypeSelect;
	private VerticalLayout root;

	@Override
	protected void init(VaadinRequest request) {
		root = new VerticalLayout();
		root.setMargin(true);
		TabSheet tabs = prepareTabs();
		setContent(root);
		root.addComponent(tabs);
	}

	private TabSheet prepareTabs() {
		TabSheet tabs = new TabSheet();
		addJobsTab(tabs);
		addWorkerTab(tabs);
		addTaskTab(tabs);

		return tabs;
	}

	private void addTaskTab(TabSheet tabs) {
		tabs.addTab(new Panel(), LOCALIZATION_HELPER.get("taskTab.caption"));
	}

	private void addWorkerTab(TabSheet tabs) {
		tabs.addTab(new Panel(), LOCALIZATION_HELPER.get("workerTab.caption"));
	}

	private void addJobsTab(TabSheet tabs) {
		tabs.addTab(new JobPanel(), LOCALIZATION_HELPER.get("jobTab.caption"));
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "pl.koziolekweb.progvaadin.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@WebListener
	public static class DAOInit implements ServletContextListener {
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			JobDAO jd = new JobDAO();
			jd.add(new Job("j001", "Opieranie się o betoniarkę", HAND_WORK));
			jd.add(new Job("b001", "Przekładanie papierów", OFFICE_WORK));
			jd.add(new Job("a001", "Lansowanie się", ART_WORK));
			WorkerDAO wd = new WorkerDAO();
			wd.add(new Worker("Zenek", 1600, BLUE_COLLAR));
			wd.add(new Worker("Irenka", 1600, WHITE_COLLAR));
			wd.add(new Worker("Vincento", 16000, ARTST));

			System.out.println("Start");
		}

		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			//To change body of implemented methods use File | Settings | File Templates.
		}
	}

}
