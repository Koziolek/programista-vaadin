package pl.koziolekweb.progvaadin.resourceexamples;

import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import pl.koziolekweb.progvaadin.AbstractItemNode;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.10.13
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
public class FileResourceNode extends AbstractItemNode {
	public FileResourceNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		String basePath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();
		FileResource logo = new FileResource(new File(basePath +
				"/WEB-INF/gpl-logo.jpg"));
		Image image = new Image("Prosty obrazek", logo);
		setExample(image);
		setSourceCode("String basePath = VaadinService.getCurrent()" +
				"<br />.getBaseDirectory().getAbsolutePath();" +
				"<br />FileResource logo = new FileResource(new File(basePath +" +
				"<br />\"/WEB-INF/gpl-logo.jpg\"));" +
				"<br />Image image = new Image(\"Prosty obrazek\", logo);");
		done();
	}

	@Override
	public String toString() {
		return "Zasoby plikowe";
	}
}
