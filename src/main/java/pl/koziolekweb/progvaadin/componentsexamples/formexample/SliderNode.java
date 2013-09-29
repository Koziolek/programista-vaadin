package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.09.13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class SliderNode extends AbstractItemNode {
	public SliderNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Slider verticalSlider = new Slider("Pionowy Slider");
		verticalSlider.setMin(0.0);
		verticalSlider.setMax(13.0);
		verticalSlider.setResolution(1);
		verticalSlider.setOrientation(SliderOrientation.VERTICAL);

		Slider horizontalSlider = new Slider("Poziomy Slider");
		horizontalSlider.setMin(0.0);
		horizontalSlider.setMax(13.0);
		horizontalSlider.setResolution(1);
		horizontalSlider.setWidth(130, Sizeable.Unit.PIXELS);
		horizontalSlider.setOrientation(SliderOrientation.HORIZONTAL);

		VerticalLayout ll = new VerticalLayout();
		ll.addComponent(verticalSlider);
		ll.addComponent(horizontalSlider);
		setExample(ll);
		setSourceCode("Slider verticalSlider = new Slider(\"Pionowy Slider\");" +
				"<br />verticalSlider.setMin(0.0);" +
				"<br />verticalSlider.setMax(13.0);" +
				"<br />verticalSlider.setResolution(1);" +
				"<br />verticalSlider.setOrientation(SliderOrientation.VERTICAL);" +
				"<br />" +
				"<br />Slider horizontalSlider = new Slider(\"Poziomy Slider\");" +
				"<br />horizontalSlider.setMin(0.0);" +
				"<br />horizontalSlider.setMax(13.0);" +
				"<br />horizontalSlider.setResolution(1);" +
				"<br />horizontalSlider.setWidth(130, Sizeable.Unit.PIXELS);" +
				"<br />horizontalSlider.setOrientation(SliderOrientation.HORIZONTAL);");
		done();
	}

	@Override
	public String toString() {
		return "Slider";
	}
}
