package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.OptionGroup;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class OptionNode extends AbstractItemNode {

	public OptionNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		OptionGroup optionGroup1 = new OptionGroup("Pierwsza grupa");
		optionGroup1.addItem("Opcja 1.1");
		optionGroup1.addItem("Opcja 1.2");
		optionGroup1.addItem("Opcja 1.3");
		OptionGroup optionGroup2 = new OptionGroup("Druga grupa");
		optionGroup2.addItem("Opcja 2.1");
		optionGroup2.addItem("Opcja 2.2");
		optionGroup2.addItem("Opcja 2.3");
		HorizontalLayout ll = new HorizontalLayout();
		ll.addComponent(optionGroup1);
		ll.addComponent(optionGroup2);
		ll.setSpacing(true);
		setExample(ll);
		setSourceCode("OptionGroup optionGroup1 = new OptionGroup(\"Pierwsza grupa\");" +
				"<br />optionGroup1.addItem(\"Opcja 1.1\");" +
				"<br />optionGroup1.addItem(\"Opcja 1.2\");" +
				"<br />optionGroup1.addItem(\"Opcja 1.3\");" +
				"<br />OptionGroup optionGroup2 = new OptionGroup(\"Druga grupa\");" +
				"<br />optionGroup2.addItem(\"Opcja 2.1\");" +
				"<br />optionGroup2.addItem(\"Opcja 2.2\");" +
				"<br />optionGroup2.addItem(\"Opcja 2.3\");");
		done();
	}

	@Override
	public String toString() {
		return "Opcje";
	}
}
