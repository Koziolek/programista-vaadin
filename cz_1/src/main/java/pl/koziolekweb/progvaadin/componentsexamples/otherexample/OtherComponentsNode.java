package pl.koziolekweb.progvaadin.componentsexamples.otherexample;

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
public class OtherComponentsNode extends AbstractNode {

	private final String name = "Komponenty Zasobów";
	private HorizontalSplitPanel target;

	public OtherComponentsNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new ImageNode(target));
		addComponentNodeToTree(componentTree, name, new FlashNode(target));
		addComponentNodeToTree(componentTree, name, new FrameNode(target));
		addComponentNodeToTree(componentTree, name, new EmbeddedNode(target));
		addComponentNodeToTree(componentTree, name, new NotificationNode(target));
	}

}
