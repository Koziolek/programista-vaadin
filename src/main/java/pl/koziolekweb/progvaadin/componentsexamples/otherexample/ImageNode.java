package pl.koziolekweb.progvaadin.componentsexamples.otherexample;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.AbstractItemNode;
import pl.koziolekweb.progvaadin.helpers.DynamicImage;

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
		StreamResource pngImage = new StreamResource(new DynamicImage("1", 100, 100), "/tmp/img.png");
		Image image = new Image("Prosty obrazek", pngImage);
		setExample(image);
		setSourceCode("Image image = new Image(\"Prosty obrazek\", pngImage);");
		done();
	}

	@Override
	public String toString() {
		return "Grafika";
	}
}
