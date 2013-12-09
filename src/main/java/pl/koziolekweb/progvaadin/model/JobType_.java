package pl.koziolekweb.progvaadin.model;

import pl.koziolekweb.progvaadin.LocalizationHelper;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 09.12.13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
public final class JobType_ {

	public static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();

	public static String getJOB_TYPE(String o) {
		return LOCALIZATION_HELPER.get(o);
	}
}
