package pl.koziolekweb.progvaadin.componentsexamples.resouceexample;

import com.vaadin.server.Page;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 05.10.13
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class NotificationNode extends AbstractItemNode {
	public NotificationNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Notification notification = new Notification("Informacja", "To jest notyfikacja", Notification.Type.TRAY_NOTIFICATION);
		notification.show(Page.getCurrent());
		setSourceCode("Notification notification = new Notification(\"Informacja\", \"To jest notyfikacja\", Notification.Type.TRAY_NOTIFICATION);\n" +
				"<br />notification.show(Page.getCurrent());");
		done();
	}

	@Override
	public String toString() {
		return "Notyfikacje";
	}
}
