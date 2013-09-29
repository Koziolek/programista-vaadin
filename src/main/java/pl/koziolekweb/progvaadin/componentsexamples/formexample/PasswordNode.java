package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.PasswordField;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
public class PasswordNode extends AbstractItemNode {

	public PasswordNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		PasswordField passwordField = new PasswordField("Przykładowe hasło");
		setExample(passwordField);
		setSourceCode("PasswordField passwordField = new PasswordField(\"Przykładowe hasło\");");
		done();
	}

	@Override
	public String toString() {
		return "Pole Hasła";
	}
}
