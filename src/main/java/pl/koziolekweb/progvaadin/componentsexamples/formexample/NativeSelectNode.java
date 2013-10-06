package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.NativeSelect;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 25.09.13
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class NativeSelectNode extends AbstractItemNode {

	public NativeSelectNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		NativeSelect nativeSelect = new NativeSelect();
		for (int i = 1; i < 10; i++)
		nativeSelect.addItem("Natywny select 1."+i);
		setExample(nativeSelect);
		setSourceCode("NativeSelect nativeSelect = new NativeSelect();" +
				"<br />for (int i = 1; i < 10; i++)" +
				"<br />nativeSelect.addItem(\"Natywny select 1.\"+i);");
		done();
	}

	@Override
	public String toString() {
		return "Natywny select";
	}
}