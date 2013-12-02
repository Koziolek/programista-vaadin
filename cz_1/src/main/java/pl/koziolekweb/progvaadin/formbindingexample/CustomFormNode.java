package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.AbstractItemNode;
import pl.koziolekweb.progvaadin.formbindingexample.model.Address;
import pl.koziolekweb.progvaadin.formbindingexample.model.Human;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 12.10.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class CustomFormNode extends AbstractItemNode {
	public CustomFormNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Human human = new Human();
		human.setFirstName("Jan");
		human.setLastName("Kowalski");
		Address address = new Address();
		address.setCity("Warszawa");
		human.setAddress(address);
		CustomForm form = new CustomForm(human);
		setExample(form);
		setSourceCode("");
		done();
	}

	@Override
	public String toString() {
		return "Własny formularz";
	}
}

