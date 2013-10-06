package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;
import pl.koziolekweb.progvaadin.AbstractItemNode;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class DateAndTimeNode extends AbstractItemNode {
	public DateAndTimeNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		DateField dateField = new DateField("Kalendarz");
		dateField.setDateFormat("dd-MM-yyyy HH:mm");
		dateField.setValue(new Date());
		PopupDateField popupDateField = new PopupDateField();
		popupDateField.setDateFormat("dd-MM-yyyy hh:mm");
		popupDateField.setValue(new Date());
		popupDateField.setResolution(Resolution.HOUR);


		VerticalLayout ll = new VerticalLayout();
		ll.addComponent(dateField);
		ll.addComponent(popupDateField);
		setExample(ll);

		setSourceCode("DateField dateField = new DateField(\"Kalendarz\");" +
				"<br />dateField.setDateFormat(\"dd-MM-yyyy hh:mm\");" +
				"<br />dateField.setValue(new Date());" +
				"<br />PopupDateField popupDateField = new PopupDateField();" +
				"<br />popupDateField.setDateFormat(\"dd-MM-yyyy hh:mm\");" +
				"<br />popupDateField.setValue(new Date());" +
				"<br />popupDateField.setResolution(Resolution.HOUR)");
		done();
	}

	@Override
	public String toString() {
		return "Data i czas";
	}
}
