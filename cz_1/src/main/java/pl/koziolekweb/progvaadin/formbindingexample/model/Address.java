package pl.koziolekweb.progvaadin.formbindingexample.model;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.10.13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public class Address {

	private String street;
	private Integer number;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", number=" + number +
				", city='" + city + '\'' +
				'}';
	}
}
