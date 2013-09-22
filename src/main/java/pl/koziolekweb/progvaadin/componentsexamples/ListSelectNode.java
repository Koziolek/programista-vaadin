package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 22.09.13
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class ListSelectNode extends AbstractItemNode {

	public ListSelectNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ListSelect listSelect = new ListSelect();
		listSelect.setRows(5);
		for (int i = 1; i < 100; i++)
			listSelect.addItem("Opcja 1." + i);

		setExample(listSelect);
		setSourceCode("");
		done();
	}

	@Override
	public String toString() {
		return "Lista wyboru";
	}
}
