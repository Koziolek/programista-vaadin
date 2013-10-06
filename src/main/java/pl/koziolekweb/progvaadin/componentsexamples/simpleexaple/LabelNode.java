package pl.koziolekweb.progvaadin.componentsexamples.simpleexaple;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Komponent wyświetlający przykładowy Label.
 */
public class LabelNode extends AbstractItemNode {

	public LabelNode(HorizontalSplitPanel target) {
		super(target);
	}

	/**
	 * Tworzy prosty Label i umieszcza go w górnym panelu
	 * oraz jego kod źródłowy w dolnym
	 */
	@Override
	public void onClick() {
		Label label = new Label("Przykladowy napis");
		setExample(label);
		setSourceCode("Label label = new Label(\"Przykladowy napis\");");
		done();
	}

	@Override
	public String toString() {
		return "Label";
	}

}
