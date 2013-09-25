package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TextField;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 01:57
 * To change this template use File | Settings | File Templates.
 */
public class InputNode extends AbstractItemNode {
	public InputNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		TextField textField = new TextField("Przykładowe pole");
		setExample(textField);
		setSourceCode("TextField textField = new TextField(\"Przykładowe pole\");");
		done();
	}

	@Override
	public String toString() {
		return "Pole tekstowe";
	}
}
