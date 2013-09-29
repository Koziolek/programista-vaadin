package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TwinColSelect;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 25.09.13
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
public class TwinColSelectNode extends AbstractItemNode {
	public TwinColSelectNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		TwinColSelect twinColSelect = new TwinColSelect("Wybór dwukolumnowy");
		for (int i = 1; i < 10; i++)
			twinColSelect.addItem("Opjca 1." + i);
		setExample(twinColSelect);
		setSourceCode("TwinColSelect twinColSelect = new TwinColSelect();" +
				"<br />for (int i = 1; i < 10; i++)" +
				"<br />twinColSelect.addItem(\"Opjca 1.\" + i);");
		done();
	}

	@Override
	public String toString() {
		return "TwinColSelect";
	}
}

