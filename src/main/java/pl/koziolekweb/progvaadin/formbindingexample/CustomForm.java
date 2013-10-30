package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.formbindingexample.model.Human;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 14.10.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class CustomForm extends CustomComponent {

	private final FormLayout root;

	@PropertyId("firstName")
	private TextField firstName = new TextField("Imię");

	@PropertyId("lastName")
	private TextField lastName = new TextField("Nazwisko");

	@PropertyId("birthDate")
	private DateField birthDate = new DateField("Data urodzenia");

	@PropertyId("leftHanded")
	private CheckBox leftHanded = new CheckBox("Czy leworęczny");

	public CustomForm(Human human) {
		BeanFieldGroup<Human> binding = new BeanFieldGroup<Human>(Human.class);
		binding.setItemDataSource(human);
		binding.bindMemberFields(this);
		FieldGroupFieldFactory fieldFactory = new FieldGroupFieldFactory() {
			private FieldGroupFieldFactory def = new DefaultFieldGroupFieldFactory();

			@Override
			public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
				T field = def.createField(dataType, fieldType);
				if (field instanceof TextField)
					((TextField) field).setNullRepresentation("");
				return field;
			}
		};
		binding.setFieldFactory(fieldFactory);
		root = new FormLayout();
		firstName.setNullRepresentation("");
		addComponent(firstName);
		addComponent(lastName);
		addComponent(birthDate);
		addComponent(leftHanded);
		Field<?> street = binding.buildAndBind("Ulica", "address.street");
		addComponent(street);
		addComponent(binding.buildAndBind("Numer", "address.number"));
		addComponent(binding.buildAndBind("Miasto", "address.city"));
		setCompositionRoot(root);
	}

	private void addComponent(Component c) {
		root.addComponent(c);
	}

}
