package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.converter.ConverterUtil;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;
import pl.koziolekweb.progvaadin.formbindingexample.model.Address;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 01.11.13
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
class MyFieldGroupFieldFactory implements FieldGroupFieldFactory {
	private FieldGroupFieldFactory def = new DefaultFieldGroupFieldFactory();

	@Override
	public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
		T field = def.createField(dataType, fieldType);
		if (field instanceof TextField)
			((TextField) field).setNullRepresentation("");
		if (field instanceof DateField)
			((DateField) field).setResolution(Resolution.DAY);

		System.out.println(dataType.getCanonicalName());

		return field;
	}
}
