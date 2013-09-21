package pl.koziolekweb.progvaadin.componentsexamples;

import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalSplitPanel;

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
		DateField dateField = new DateField();
		dateField.setDateFormat("dd-MM-yyyy hh:mm");
		dateField.setValue(new Date());
		setExample(dateField);
		setSourceCode("DateField dateField = new DateField();" +
				"<br/>dateField.setDateFormat(\"dd-MM-yyyy hh:mm\");" +
				"<br/>dateField.setValue(new Date());");
		done();
	}

	@Override
	public String toString() {
		return "Data i czas";
	}
}
