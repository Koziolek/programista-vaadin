package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TextArea;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 02:02
 * To change this template use File | Settings | File Templates.
 */
public class TextAreaNode extends AbstractItemNode {

	public TextAreaNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		TextArea textArea = new TextArea("Przykładowa TextArea");
		textArea.setRows(5);
		setExample(textArea);
		setSourceCode("TextArea textArea = new TextArea(\"Przykładowa TextArea\");" +
				"<br/>textArea.setRows(5);");
		done();
	}

	@Override
	public String toString() {
		return "Text Area";
	}
}
