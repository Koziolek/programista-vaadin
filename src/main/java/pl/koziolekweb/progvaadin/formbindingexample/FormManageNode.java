package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.AbstractNode;
import pl.koziolekweb.progvaadin.resourceexamples.ExternalResourceNode;
import pl.koziolekweb.progvaadin.resourceexamples.ThemeResourceNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class FormManageNode extends AbstractNode {

	private final String name = "Formularze";
	private HorizontalSplitPanel target;

	public FormManageNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new PojoFormNode(target));
		addComponentNodeToTree(componentTree, name, new CustomFormNode(target));
	}

}
