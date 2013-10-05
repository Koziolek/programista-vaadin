package pl.koziolekweb.progvaadin.componentsexamples.resouceexample;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Flash;
import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.10.13
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class FlashNode extends AbstractItemNode {
	public FlashNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		ExternalResource swfFile = new ExternalResource("http://samples.mplayerhq.hu/SWF/test.swf");
		Flash flash = new Flash("Przykaldowa animacja", swfFile);
		setExample(flash);
		setSourceCode("Flash flash = new Flash(\"Przykaldowa animacja\", swfFile);");
		done();
	}

	@Override
	public String toString() {
		return "Animacja Flash";
	}
}
