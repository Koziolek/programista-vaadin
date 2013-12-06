package pl.koziolekweb.progvaadin;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 06.12.13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class LocalizationHelper {

	private final ResourceBundle labels;
	private final Locale locale;

	public LocalizationHelper(Locale locale) {
		this.locale = locale;
		this.labels = ResourceBundle.getBundle("pl.koziolekweb.progvaadin.names", locale);
	}

	public String get(String name){
		if(!labels.containsKey(name))
			return name;
		return labels.getString(name);
	}

	public static LocalizationHelper defaultInstance(){
		return new LocalizationHelper(Locale.getDefault());
	}
}
