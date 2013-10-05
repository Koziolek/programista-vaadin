package pl.koziolekweb.progvaadin.componentsexamples.resouceexample;

import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;
import pl.koziolekweb.progvaadin.helpers.ListImageResource;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.10.13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public class ImageNode extends AbstractItemNode {
	public ImageNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Image image = new Image("Prosty obrazek", new StreamResource(new ListImageResource("1", 100, 100), "/tmp/img.png"));
		setExample(image);
		setSourceCode("Image image = new Image(\"Prosty obrazek\", new StreamResource(new ListImageResource(\"1\", 100, 100), \"/tmp/img.png\"));");
		done();
	}

	@Override
	public String toString() {
		return "Grafika";
	}
}
