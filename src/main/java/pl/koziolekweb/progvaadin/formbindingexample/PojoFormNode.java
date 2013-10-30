package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalSplitPanel;
import pl.koziolekweb.progvaadin.AbstractItemNode;
import pl.koziolekweb.progvaadin.formbindingexample.model.Human;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 12.10.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class PojoFormNode extends AbstractItemNode {
	public PojoFormNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void onClick() {
		Form form = new Form();
		Human human = new Human();
		BeanItem<Human> humanBean = new BeanItem<Human>(human);
		form.setItemDataSource(humanBean);
		setExample(form);
		setSourceCode("Form form = new Form();" +
				"<br/>Human human = new Human();" +
				"<br/>BeanItem<Human> humanBean = new BeanItem<Human>(human);" +
				"<br/>form.setItemDataSource(humanBean);" +
				"<br/>form.getField(\"age\").setCaption(\"Wiek\");" +
				"<br/>form.getField(\"name\").setCaption(\"Imię\");");
		done();
	}

	@Override
	public String toString() {
		return "Prosty POJO";
	}
}

