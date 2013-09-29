package pl.koziolekweb.progvaadin.componentsexamples.treeexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.09.13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode extends AbstractItemNode {
	public TreeNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		Tree treeRoot = new Tree("Proste drzewo");
		String korzen = "Korzeń";

		treeRoot.addItem(korzen);
		treeRoot.setChildrenAllowed(korzen, true);

		String galaz1 = "Gałąź 1";
		treeRoot.addItem(galaz1);
		treeRoot.setChildrenAllowed(galaz1, true);

		String galaz2 = "Gałąź 2";
		treeRoot.addItem(galaz2);
		treeRoot.setChildrenAllowed(galaz2, false);

		String lisc = "Liść";
		treeRoot.addItem(lisc);
		treeRoot.setChildrenAllowed(lisc, false);

		treeRoot.setParent(galaz1, korzen);
			treeRoot.setParent(lisc, galaz1);
		treeRoot.setParent(galaz2, korzen);

		setExample(treeRoot);
		setSourceCode("");
		done();
	}

	@Override
	public String toString() {
		return "Drzewko";
	}
}
