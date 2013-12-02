package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.AbstractNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationResourceNode extends AbstractNode {

	private final String name = "Zasoby Aplikacji";
	private HorizontalSplitPanel target;

	public ApplicationResourceNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new FileResourceNode(target));
		addComponentNodeToTree(componentTree, name, new ClassResourceNode(target));
		addComponentNodeToTree(componentTree, name, new StreamResourceNode(target));
	}
}
