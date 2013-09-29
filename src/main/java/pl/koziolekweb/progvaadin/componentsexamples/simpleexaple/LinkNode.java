package pl.koziolekweb.progvaadin.componentsexamples.simpleexaple;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Link;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 21.09.13
 * Time: 01:40
 * To change this template use File | Settings | File Templates.
 */
public class LinkNode extends AbstractItemNode {


	public LinkNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Link link = new Link("Clik me", new ExternalResource("http://koziolekweb.pl"));
		link.setTargetName("_blank");
		setExample(link);
		setSourceCode("Link link = new Link(\"Clik me\", new ExternalResource(\"http://koziolekweb.pl\"));</br>link.setTargetName(\"_blank\");");
		done();
	}

	@Override
	public String toString() {
		return "Link";
	}
}
