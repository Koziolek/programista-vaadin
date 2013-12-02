package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.AbstractItemNode;
import pl.koziolekweb.progvaadin.helpers.DynamicImage;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class StreamResourceNode extends AbstractItemNode {
	public StreamResourceNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		StreamResource logo = new StreamResource(new DynamicImage("1", 100, 100), "/tmp/img.png");
		Image image = new Image("Prosty obrazek", logo);
		setExample(image);
		setSourceCode("StreamResource logo = new StreamResource(new DynamicImage(\"1\", 100, 100), \"/tmp/img.png\");" +
				"<br />Image image = new Image(\"Prosty obrazek\", logo);");
		done();
	}

	@Override
	public String toString() {
		return "Zasoby dynamiczne";
	}
}
