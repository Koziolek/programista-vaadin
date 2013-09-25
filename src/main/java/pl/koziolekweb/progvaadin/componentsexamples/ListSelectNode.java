package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.*;

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
		for (int i = 1; i < 10; i++)
			listSelect.addItem("Opcja 1." + i);

		ListSelect listMultiSelect = new ListSelect();
		listMultiSelect.setRows(5);
		listMultiSelect.setMultiSelect(true);
		listMultiSelect.setNewItemsAllowed(true);
		for (int i = 1; i < 10; i++)
			listMultiSelect.addItem("Opcja 2." + i);


		VerticalLayout ll = new VerticalLayout();
		ll.addComponent(listSelect);
		ll.addComponent(listMultiSelect);
		setExample(ll);
		setSourceCode("ListSelect listSelect = new ListSelect();" +
				"<br />listSelect.setRows(5);" +
				"<br />for (int i = 1; i < 10; i++)" +
				"<br />listSelect.addItem(\"Opcja 1.\" + i);" +
				"<br />" +
				"<br />ListSelect listMultiSelect = new ListSelect();" +
				"<br />listMultiSelect.setRows(5);" +
				"<br />listMultiSelect.setMultiSelect(true);" +
				"<br />listMultiSelect.setNewItemsAllowed(true);" +
				"<br />for (int i = 1; i < 10; i++)" +
				"<br />listMultiSelect.addItem(\"Opcja 1.\" + i);");
		done();
	}

	@Override
	public String toString() {
		return "Lista wyboru";
	}
}
