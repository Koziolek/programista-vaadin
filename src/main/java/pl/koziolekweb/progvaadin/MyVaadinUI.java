package pl.koziolekweb.progvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.componentsexamples.*;

import javax.servlet.annotation.WebServlet;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;

@Theme("runo")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	private VerticalLayout layout;
	private Panel panel;
	private HorizontalSplitPanel splitPanel;

	@Override
	protected void init(VaadinRequest request) {
		layout = prepareLayout();
		setContent(layout);
		panel = fullWindowPanel();

		splitPanel = new HorizontalSplitPanel();
		splitPanel.setSplitPosition(25, PERCENTAGE);
		splitPanel.setLocked(true);

		splitPanel.setFirstComponent(prepareComponentTree());

		panel.setContent(splitPanel);

		layout.addComponent(panel);
	}

	/**
	 * przygotowuje drzewo
	 */
	private Tree prepareComponentTree() {
		Tree componentTree = new Tree();
		String rootItemId = "Drzewo komponentów";
		componentTree.addItem(rootItemId);
		componentTree.setChildrenAllowed(rootItemId, true);
		prepareSimpleComponents(componentTree, rootItemId);
		prepareFormComponents(componentTree, rootItemId);
		componentTree.expandItemsRecursively(rootItemId);
		return componentTree;
	}

	private void prepareFormComponents(Tree componentTree, String parentId) {
		new FormComponentsNode(splitPanel).attachToTree(componentTree, parentId);


	}

	/**
	 * Gałąź podstawowych komponentów
	 *
	 * @param componentTree drzewo
	 * @param parentId      id korzenia
	 */
	private void prepareSimpleComponents(Tree componentTree, String parentId) {
		new SimpleComponentsNode(splitPanel).attachToTree(componentTree, parentId);
	}

	private Panel fullWindowPanel() {
		Panel panel = new Panel();
		panel.setSizeFull();
		return panel;
	}

	private VerticalLayout prepareLayout() {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		return layout;
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false,
			ui = MyVaadinUI.class,
			widgetset = "pl.koziolekweb.progvaadin.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

}
