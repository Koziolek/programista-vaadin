package pl.koziolekweb.progvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.componentsexamples.formexample.FormComponentsNode;
import pl.koziolekweb.progvaadin.componentsexamples.otherexample.OtherComponentsNode;
import pl.koziolekweb.progvaadin.componentsexamples.simpleexaple.SimpleComponentsNode;
import pl.koziolekweb.progvaadin.componentsexamples.treeexample.TreeComponentsNode;
import pl.koziolekweb.progvaadin.resourceexamples.ApplicationResourceNode;
import pl.koziolekweb.progvaadin.resourceexamples.ResourceNode;

import javax.servlet.annotation.WebServlet;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;

@Theme("mytheme")
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

		splitPanel.setFirstComponent(prepareExamplesTree());

		panel.setContent(splitPanel);

		layout.addComponent(panel);
	}

	/**
	 * przygotowuje drzewo
	 */
	private Tree prepareExamplesTree() {
		Tree examplesTree = new Tree();
		componentsNode(examplesTree);
		resourceNode(examplesTree);
		return examplesTree;
	}

	private String resourceNode(Tree examplesTree) {
		String resourceRootItemId = "Drzewo zasobów";
		examplesTree.addItem(resourceRootItemId);
		examplesTree.setChildrenAllowed(resourceRootItemId, true);
		prepareResourceComponents(examplesTree, resourceRootItemId);
		prepareApplicationResourceComponents(examplesTree, resourceRootItemId);
		return resourceRootItemId;
	}

	private void prepareApplicationResourceComponents(Tree examplesTree, String parentId) {
		new ApplicationResourceNode(splitPanel).attachToTree(examplesTree, parentId);
	}

	private void prepareResourceComponents(Tree examplesTree, String parentId) {
		new ResourceNode(splitPanel).attachToTree(examplesTree, parentId);
	}


	private String componentsNode(Tree examplesTree) {
		String componentRootItemId = "Drzewo komponentów";
		examplesTree.addItem(componentRootItemId);
		examplesTree.setChildrenAllowed(componentRootItemId, true);
		prepareSimpleComponents(examplesTree, componentRootItemId);
		prepareFormComponents(examplesTree, componentRootItemId);
		prepareTreeComponents(examplesTree, componentRootItemId);
		prepareOtherComponents(examplesTree, componentRootItemId);
		return componentRootItemId;
	}

	private void prepareOtherComponents(Tree examplesTree, String parentId) {
		new OtherComponentsNode(splitPanel).attachToTree(examplesTree, parentId);
	}

	private void prepareTreeComponents(Tree examplesTree, String parentId) {
		new TreeComponentsNode(splitPanel).attachToTree(examplesTree, parentId);
	}

	private void prepareFormComponents(Tree examplesTree, String parentId) {
		new FormComponentsNode(splitPanel).attachToTree(examplesTree, parentId);
	}

	/**
	 * Gałąź podstawowych komponentów
	 *
	 * @param examplesTree drzewo
	 * @param parentId      id korzenia
	 */
	private void prepareSimpleComponents(Tree examplesTree, String parentId) {
		new SimpleComponentsNode(splitPanel).attachToTree(examplesTree, parentId);
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
