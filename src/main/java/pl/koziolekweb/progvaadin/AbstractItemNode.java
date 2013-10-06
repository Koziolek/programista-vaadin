package pl.koziolekweb.progvaadin;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;

/**
 * Logika wyświetlania elementów
 * w naszym drzewie komponentów.
 */
public abstract class AbstractItemNode
		implements TreeItemNode, ItemClickEvent.ItemClickListener {

	private final HorizontalSplitPanel target;

	private final VerticalSplitPanel internalSplitPanel;

	private final Panel internal;


	public AbstractItemNode(HorizontalSplitPanel target) {
		this.target = target;
		this.internal = new Panel();
		this.internal.setHeight(100, PERCENTAGE);
		this.internal.setWidth(100, PERCENTAGE);
		this.internalSplitPanel = new VerticalSplitPanel();
		this.internalSplitPanel.setSplitPosition(50, PERCENTAGE);
		this.internalSplitPanel.setLocked(true);
		this.internal.setContent(this.internalSplitPanel);
	}

	/**
	 * Ustawia przykładowy komponent w górnym panelu.
	 *
	 * @param c przkładowy komponent.
	 */
	protected void setExample(Component c) {
		VerticalLayout p = new VerticalLayout();
		p.setSizeFull();
		p.addComponent(c);
		internalSplitPanel.setFirstComponent(p);
	}

	/**
	 * Ustawia kod źródłowy w dolnym panelu.
	 *
	 * @param s kod źródłowy
	 */
	protected void setSourceCode(String s) {
		Label source = new Label(s);
		source.setContentMode(ContentMode.HTML);
		internalSplitPanel.setSecondComponent(source);
	}

	/**
	 * Wywolaj ta metodę po ustawieniu komponentu
	 * i kodu źródłowego. W prawym panelu zostanie
	 * umieszczony panel z kodem źródlowym i komponentem.
	 */
	protected void done() {
		target.setSecondComponent(internal);
	}

	/**
	 * W momencie kliknięcia w element drzewa sprawdza
	 * czy id elementu i ten obiekt są tożsame i wywołuje
	 * #onClick.
	 * @param event
	 */
	@Override
	public void itemClick(ItemClickEvent event) {
		if (event.getItemId() == this)
			onClick();
	}
}
