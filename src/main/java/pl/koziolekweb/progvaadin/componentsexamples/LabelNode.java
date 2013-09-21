package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalSplitPanel;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;

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
