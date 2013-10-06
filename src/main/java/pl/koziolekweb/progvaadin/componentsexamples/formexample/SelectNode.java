package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Select;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("deprecation")
class SelectNode extends AbstractItemNode {

	public SelectNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Select select = new Select();
		for (int i = 1; i < 10; i++)
			select.addItem("Prosty select 1." + i);

		setExample(select);
		setSourceCode("Select select = new Select();" +
				"<br />for (int i = 1; i < 10; i++)" +
				"<br />select.addItem(\"Prosty select 1.\"+i);");
		done();
	}

	@Override
	public String toString() {
		return "Prosty select";
	}
}
