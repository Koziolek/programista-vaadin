package pl.koziolekweb.progvaadin.componentsexamples.treeexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.AbstractNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class TreeComponentsNode extends AbstractNode {

	private final String name = "Komponenty drzew";
	private HorizontalSplitPanel target;

	public TreeComponentsNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new TreeNode(target));
		addComponentNodeToTree(componentTree, name, new MenuNode(target));

	}

}
