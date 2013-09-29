package pl.koziolekweb.progvaadin.componentsexamples.treeexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.MenuBar;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.09.13
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
public class MenuNode extends AbstractItemNode {
	public MenuNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		MenuBar menuBar = new MenuBar();
		String korzen = "Korzeń";
		String galaz1 = "Gałąź 1";
		String galaz2 = "Gałąź 2";
		String lisc = "Liść";

		MenuBar.MenuItem korzenItem = menuBar.addItem(korzen, null);
		MenuBar.MenuItem galaz1Item = korzenItem.addItem(galaz1, null);
		MenuBar.MenuItem galaz2Item = galaz1Item.addItem(galaz2, null);
		MenuBar.MenuItem liscItem = galaz2Item.addItem(lisc, null);

		setExample(menuBar);
		setSourceCode("");
		done();

	}

	@Override
	public String toString() {
		return "Pasek Menu";
	}
}
