package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class CheckboxNode extends AbstractItemNode {

	public CheckboxNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		CheckBox checkBox1 = new CheckBox("Nie zaznacznoy");
		CheckBox checkBox2 = new CheckBox("Zaznacznoy");
		checkBox2.setValue(true);
		VerticalLayout ll = new VerticalLayout();
		ll.addComponent(checkBox1);
		ll.addComponent(checkBox2);
		setExample(ll);
		setSourceCode("CheckBox checkBox1 = new CheckBox(\"Nie zaznacznoy\");" +
				"<br />CheckBox checkBox2 = new CheckBox(\"Zaznacznoy\");" +
				"<br />checkBox2.setValue(true);");
		done();

	}

	@Override
	public String toString() {
		return "Checkbox";
	}
}
