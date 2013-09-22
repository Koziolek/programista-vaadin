package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Select;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("deprecation")
class SimpleSelectNode extends AbstractItemNode {

	public SimpleSelectNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Select simpleSelect = new Select();
		simpleSelect.addItem("Prosty select 1.1");
		simpleSelect.addItem("Prosty select 1.2");
		setExample(simpleSelect);
		setSourceCode("Select simpleSelect = new Select();" +
				"<br />simpleSelect.addItem(\"Prosty select 1.1\");" +
				"<br />simpleSelect.addItem(\"Prosty select 1.2\");");
		done();
	}

	@Override
	public String toString() {
		return "Prosty select";
	}
}
