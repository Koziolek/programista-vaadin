package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.RichTextArea;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 25.09.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class RichTextAreaNode extends AbstractItemNode {
	public RichTextAreaNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		RichTextArea richTextArea = new RichTextArea("Edytor tekstu");
		richTextArea.setValue("<h1>Hello</h1> Vaadin");
		setExample(richTextArea);
		setSourceCode("RichTextArea richTextArea = new RichTextArea(\"Edytor tekstu\");" +
				"<br />richTextArea.setValue(\"&lt;h1>Hello&lt;/h1> Vaadin\");");
		done();
	}

	@Override
	public String toString() {
		return "Edytor tekstu";
	}
}
