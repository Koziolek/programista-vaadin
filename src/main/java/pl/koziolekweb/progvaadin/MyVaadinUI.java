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
		String simpleFrmCmpRtId = "Komponenty formularzy";
		componentTree.addItem(simpleFrmCmpRtId);
		componentTree.setChildrenAllowed(simpleFrmCmpRtId, true);
		setParent(componentTree, parentId, simpleFrmCmpRtId);
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new InputNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new TextAreaNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new PasswordNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new DateAndTimeNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new CheckboxNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleFrmCmpRtId, new OptionNode(splitPanel));

		addSelectNodes();

	}

	private void addSelectNodes() {
		String selectsNodeId = "Pola wyboru";
	}


	/**
	 * Gałąź podstawowych komponentów
	 *
	 * @param componentTree drzewo
	 * @param parentId      id korzenia
	 */
	private void prepareSimpleComponents(Tree componentTree, String parentId) {
		String simpleCmpRtId = "Komponenty Podstawowe";
		componentTree.addItem(simpleCmpRtId);
		componentTree.setChildrenAllowed(simpleCmpRtId, true);
		setParent(componentTree, parentId, simpleCmpRtId);
		addComponentNodeToTree(componentTree, simpleCmpRtId, new LabelNode(splitPanel));
		addComponentNodeToTree(componentTree, simpleCmpRtId, new LinkNode(splitPanel));
	}

	private void addComponentNodeToTree(Tree componentTree, String parentId, AbstractItemNode linkNode) {
		componentTree.addItem(linkNode);
		componentTree.setChildrenAllowed(linkNode, false);
		componentTree.addItemClickListener(linkNode);
		setParent(componentTree, parentId, linkNode);
	}

	/**
	 * ustawa rodzica
	 *
	 * @param componentTree drzewo
	 * @param parentId      id rodzica
	 * @param nodeId        id liścia
	 */
	private void setParent(Tree componentTree, String parentId, Object nodeId) {
		componentTree.setParent(nodeId, parentId);
	}

	private Panel fullWindowPanel() {
		Panel panel = new Panel();
		panel.setHeight(100, PERCENTAGE);
		panel.setWidth(100, PERCENTAGE);
		return panel;
	}

	private VerticalLayout prepareLayout() {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setHeight(100, PERCENTAGE);
		layout.setWidth(100, PERCENTAGE);
		return layout;
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false,
			ui = MyVaadinUI.class,
			widgetset = "pl.koziolekweb.progvaadin.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

}
