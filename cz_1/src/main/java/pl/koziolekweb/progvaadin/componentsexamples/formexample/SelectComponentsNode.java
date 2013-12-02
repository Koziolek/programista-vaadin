package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.AbstractNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
class SelectComponentsNode extends AbstractNode {
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
		addComponentNodeToTree(componentTree, name, new SelectNode(target));
		addComponentNodeToTree(componentTree, name, new ListSelectNode(target));
		addComponentNodeToTree(componentTree, name, new NativeSelectNode(target));
		addComponentNodeToTree(componentTree, name, new TwinColSelectNode(target));


	}
}
