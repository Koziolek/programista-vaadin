package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
public class ExternalResourceNode extends AbstractItemNode {
	public ExternalResourceNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ExternalResource webside = new ExternalResource("http://koziolekweb.pl");
		BrowserFrame frame = new BrowserFrame("Strona w ramce", webside);
		frame.setSizeFull();
		setExample(frame);
		setSourceCode("ExternalResource webside = new ExternalResource(\"http://koziolekweb.pl\");" +
				"<br />BrowserFrame frame = new BrowserFrame(\"Strona w ramce\", webside);");
		done();
	}

	@Override
	public String toString() {
		return "Zasoby zewnętrzne";
	}
}
