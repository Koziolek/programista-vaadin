package pl.koziolekweb.progvaadin;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.ui.Field;
import pl.koziolekweb.progvaadin.components.JobTypeSelect;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class JobFieldFactory implements FieldGroupFieldFactory {
	private DefaultFieldGroupFieldFactory dff = new DefaultFieldGroupFieldFactory();

	@Override
	public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
		T field = null;
		if (!dataType.isEnum())
			field = dff.createField(dataType, fieldType);

		if (field == null) {
			try {
				field = fieldType.newInstance();
			} catch (Exception e) {
				throw new FieldGroup.BindException("Could not create a field of type "
						+ fieldType, e);
			}
		}
		return field;
	}
}
