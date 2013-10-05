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
		String korzen = "Korzeń";
		String galaz1 = "Gałąź 1";
		String galaz2 = "Gałąź 2";
		String lisc = "Liść";

		Tree treeRoot = new Tree("Proste drzewo");
		treeRoot.addItem(korzen);
		treeRoot.addItem(galaz1);
		treeRoot.addItem(galaz2);
		treeRoot.addItem(lisc);
		treeRoot.setChildrenAllowed(korzen, true);
		treeRoot.setChildrenAllowed(galaz1, true);
		treeRoot.setChildrenAllowed(galaz2, false);
		treeRoot.setChildrenAllowed(lisc, false);
		treeRoot.setParent(galaz1, korzen);
		treeRoot.setParent(lisc, galaz1);
		treeRoot.setParent(galaz2, korzen);

		setExample(treeRoot);
		setSourceCode("Tree treeRoot = new Tree(\"Proste drzewo\");" +
				"<br />treeRoot.addItem(korzen);"+
				"<br />treeRoot.addItem(galaz1);"+
				"<br />treeRoot.addItem(galaz2);"+
				"<br />treeRoot.addItem(lisc);"+
				"<br />treeRoot.setChildrenAllowed(korzen, true);"+
				"<br />treeRoot.setChildrenAllowed(galaz1, true);"+
				"<br />treeRoot.setChildrenAllowed(galaz2, false);"+
				"<br />treeRoot.setChildrenAllowed(lisc, false);"+
				"<br />treeRoot.setParent(galaz1, korzen);"+
				"<br />treeRoot.setParent(lisc, galaz1);"+
				"<br />treeRoot.setParent(galaz2, korzen);");
		done();
	}

	@Override
	public String toString() {
		return "Drzewko";
	}
}
