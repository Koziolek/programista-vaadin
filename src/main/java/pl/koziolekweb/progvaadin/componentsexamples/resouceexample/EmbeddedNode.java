package pl.koziolekweb.progvaadin.componentsexamples.resouceexample;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 05.10.13
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class EmbeddedNode extends AbstractItemNode {
	public EmbeddedNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ExternalResource svgFile = new ExternalResource("http://upload.wikimedia.org/wikipedia/commons/8/84/Example.svg");
		Embedded embedded = new Embedded("", svgFile);
		embedded.setMimeType("image/svg+xml");
		setExample(embedded);
		setSourceCode("Embedded embedded = new Embedded(\"\", svgFile);" +
				"<br />embedded.setMimeType(\"image/svg+xml\");");
		done();
	}

	@Override
	public String toString() {
		return "Embedded";
	}
}
