package pl.koziolekweb.progvaadin.componentsexamples.otherexample;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 05.10.13
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class FrameNode extends AbstractItemNode {
	public FrameNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ExternalResource webside = new ExternalResource("http://koziolekweb.pl");
		BrowserFrame frame = new BrowserFrame("Strona w ramce", webside);
		frame.setSizeFull();
		setExample(frame);
		setSourceCode("BrowserFrame frame = " +
			"new BrowserFrame(\"Strona w ramce\", webside);");
		done();
	}

	@Override
	public String toString() {
		return "Iframe";
	}
}
