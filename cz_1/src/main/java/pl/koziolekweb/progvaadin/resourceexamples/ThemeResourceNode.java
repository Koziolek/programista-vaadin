package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public class ThemeResourceNode extends AbstractItemNode {
	public ThemeResourceNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ThemeResource logo = new ThemeResource("gpl-logo.jpg");
		Image image = new Image("Prosty obrazek", logo);
		setExample(image);
		setSourceCode("ThemeResource logo = new ThemeResource(\"gpl-logo.jpg\");" +
				"<br />Image image = new Image(\"Prosty obrazek\", logo);");
		done();
	}

	@Override
	public String toString() {
		return "Zasoby skórki";
	}

}
