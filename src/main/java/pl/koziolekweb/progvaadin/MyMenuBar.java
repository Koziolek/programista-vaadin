package pl.koziolekweb.progvaadin;

import com.vaadin.server.Resource;
import com.vaadin.ui.MenuBar;

import static com.vaadin.server.Sizeable.Unit.PIXELS;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 20.09.13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */
public class MyMenuBar extends MenuBar {

	public MyMenuBar(Resource icon) {
		MenuItem menuItem = addItem("Moje Menu", icon, null);
		menuItem.addItem("Moje podmenu", null);
		setHeight(25, PIXELS);
	}
}
