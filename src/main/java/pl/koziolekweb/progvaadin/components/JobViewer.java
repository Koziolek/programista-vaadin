package pl.koziolekweb.progvaadin.components;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import pl.koziolekweb.progvaadin.LocalizationHelper;
import pl.koziolekweb.progvaadin.model.Job;

import static pl.koziolekweb.progvaadin.model.Job_.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 */
public class JobViewer extends CustomComponent {

	private static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();

	private final GridLayout root;

	public JobViewer(Job job) {
		root = new GridLayout(2, 3);
		root.setMargin(true);
		root.setSpacing(true);
		setCompositionRoot(root);
		addRow(LOCALIZATION_HELPER.get(JOB_NAME), job.getName(), 0);
		addRow(LOCALIZATION_HELPER.get(JOB_DESC), job.getDescription(), 1);
		addRow(LOCALIZATION_HELPER.get(JOB_TYPE), job.getJobType().toString(), 2);
	}

	private void addRow(String label, String value, int row){
		root.addComponent(new Label(label), 0, row);
		root.addComponent(new Label(value), 1, row);
	}
}
