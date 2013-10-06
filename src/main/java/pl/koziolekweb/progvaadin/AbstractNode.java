package pl.koziolekweb.progvaadin;

import com.vaadin.ui.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractNode {
	protected void setParent(Tree componentTree, Object parentId, Object nodeId) {
		componentTree.setParent(nodeId, parentId);
	}

	protected void addComponentNodeToTree(Tree componentTree, Object parentId, AbstractItemNode linkNode) {
		componentTree.addItem(linkNode);
		componentTree.setChildrenAllowed(linkNode, false);
		componentTree.addItemClickListener(linkNode);
		setParent(componentTree, parentId, linkNode);
	}

	public abstract void attachToTree(Tree componentTree, Object parentId);
}
