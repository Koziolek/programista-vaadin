package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.componentsexamples.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class FormComponentsNode extends AbstractComponentsNode {

	private final String name = "Komponenty formularzy";

	private HorizontalSplitPanel target;

	public FormComponentsNode(HorizontalSplitPanel target) {
		this.target = target;
	}

	@Override
	public void attachToTree(Tree componentTree, Object parentId) {
		componentTree.addItem(name);
		componentTree.setChildrenAllowed(name, true);
		setParent(componentTree, parentId, name);
		addComponentNodeToTree(componentTree, name, new InputNode(target));
		addComponentNodeToTree(componentTree, name, new TextAreaNode(target));
		addComponentNodeToTree(componentTree, name, new PasswordNode(target));
		addComponentNodeToTree(componentTree, name, new DateAndTimeNode(target));
		addComponentNodeToTree(componentTree, name, new CheckboxNode(target));
		addComponentNodeToTree(componentTree, name, new OptionNode(target));
		addSelectNodes(componentTree, name);
		addComponentNodeToTree(componentTree, name, new RichTextAreaNode(target));
		addComponentNodeToTree(componentTree, name, new UploadNode(target));
		addComponentNodeToTree(componentTree, name, new SliderNode(target));
	}

	private void addSelectNodes(Tree componentTree, String parentId) {
		new SelectComponentsNode(target).attachToTree(componentTree, name);
	}

}

