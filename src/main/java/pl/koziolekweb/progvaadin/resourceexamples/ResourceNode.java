package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.AbstractNode;
import pl.koziolekweb.progvaadin.componentsexamples.simpleexaple.LinkNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class ResourceNode extends AbstractNode {

	private final String name = "Zasoby zewnętrzne i skórki";
	private HorizontalSplitPanel target;

	public ResourceNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new ExternalResourceNode(target));
		addComponentNodeToTree(componentTree, name, new ThemeResourceNode(target));
	}

}
