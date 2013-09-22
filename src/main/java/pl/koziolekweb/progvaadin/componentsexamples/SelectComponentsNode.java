package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
class SelectComponentsNode extends AbstractComponentsNode {
	private final String name = "Pola wyboru";

	private HorizontalSplitPanel target;

	public SelectComponentsNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new SimpleSelectNode(target));
		addComponentNodeToTree(componentTree, name, new ListSelectNode(target));

	}
}
