package pl.koziolekweb.progvaadin.formbindingexample.model;

import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 12.10.13
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
public class Human {

	private String firstName;
	private String lastName;
	private Date birthDate;
	private boolean leftHanded;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isLeftHanded() {
		return leftHanded;
	}

	public void setLeftHanded(boolean leftHanded) {
		this.leftHanded = leftHanded;
	}

}
