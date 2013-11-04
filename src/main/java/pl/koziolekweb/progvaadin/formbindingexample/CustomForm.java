package pl.koziolekweb.progvaadin.formbindingexample;

import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.validator.AbstractStringValidator;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import pl.koziolekweb.progvaadin.formbindingexample.model.Human;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 14.10.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class CustomForm extends CustomComponent {

	private final FormLayout root;

	private BeanFieldGroup<Human> binding;

	private Button commit = new Button("Wyślij");
	private Button discard = new Button("Anuluj");
	private Field<?> firstName;
	private Field<?> lastName;
	private Field<?> birthDate;
	private Field<?> leftHanded;
	private Field<?> street;
	private Field<?> number;
	private Field<?> city;


	public CustomForm(Human human) {
		binding = new BeanFieldGroup<Human>(Human.class);
		binding.setItemDataSource(human);
		binding.setFieldFactory(new MyFieldGroupFieldFactory());
		root = new FormLayout();
		buildAndBindFileds();
		addListeners();
		addValidators();
		addButtonListeners();
		addComponentsToForm();
		setCompositionRoot(root);
	}

	private void addButtonListeners() {
		commit.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				try {
					if (binding.isValid()) {
						binding.commit();
					}
				} catch (FieldGroup.CommitException e) {
					e.printStackTrace();
				}
				System.out.println(binding.getItemDataSource().getBean());
			}
		});
		discard.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				binding.discard();
			}
		});
	}

	private void addValidators() {
		lastName.addValidator(new AbstractStringValidator("Nazwisko za krótkie") {

			@Override
			protected boolean isValidValue(String value) {
				return value.length() > 2;
			}
		});
	}

	private void addListeners() {
		birthDate.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(Property.ValueChangeEvent event) {
				((DateField) birthDate).setComponentError(null);
				Date now = new Date();
				Date date = (Date) event.getProperty().getValue();
				if (date.getTime() > now.getTime()) {
					((DateField) birthDate).setComponentError(new UserError("Niepoprawna data"));
				}

			}
		});
	}

	private void addComponentsToForm() {
		addComponent(firstName);
		addComponent(lastName);
		addComponent(birthDate);
		addComponent(leftHanded);
		addComponent(street);
		addComponent(number);
		addComponent(city);
		addComponent(commit);
		addComponent(discard);
	}

	private void buildAndBindFileds() {
		firstName = binding.buildAndBind("Imię", "firstName");
		lastName = binding.buildAndBind("Nazwisko", "lastName");
		birthDate = binding.buildAndBind("Data urodzenia", "birthDate");
		leftHanded = binding.buildAndBind("Czy leworęczny", "leftHanded");
		street = binding.buildAndBind("Ulica", "address.street");
		number = binding.buildAndBind("Numer", "address.number");
		city = binding.buildAndBind("Miasto", "address.city");
		firstName.setRequired(true);
		lastName.setRequired(true);
		city.setRequired(true);
	}

	private void addComponent(Component c) {
		root.addComponent(c);
	}

}

