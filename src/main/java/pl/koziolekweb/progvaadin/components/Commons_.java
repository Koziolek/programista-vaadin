package pl.koziolekweb.progvaadin.components;

import pl.koziolekweb.progvaadin.LocalizationHelper;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 09.12.13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class Commons_ {
	private static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();
	private static final String OK = "ok";

	public static String OK(){
		return LOCALIZATION_HELPER.get(OK);
	}
}
