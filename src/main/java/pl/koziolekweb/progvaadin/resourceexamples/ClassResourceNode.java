package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class ClassResourceNode extends AbstractItemNode {
	public ClassResourceNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ClassResource logo = new ClassResource("gpl-logo.jpg");
		Image image = new Image("Prosty obrazek", logo);
		setExample(image);
		setSourceCode("ClassResource logo = new ClassResource(\"gpl-logo.jpg\");" +
				"<br />Image image = new Image(\"Prosty obrazek\", logo);");
		done();

	}

	@Override
	public String toString() {
		return "Zasoby z classpath";
	}
}
