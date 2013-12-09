package pl.koziolekweb.progvaadin.components;

import pl.koziolekweb.progvaadin.LocalizationHelper;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 09.12.13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class ComponentCaptions_ {
	private static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();
	private static final String JOB_EDITOR_CAPTION = JobEditor.class.getName() + ".caption";
	private static final String JOB_TAB_CAPTION = "jobTab.caption";

	public static String JOB_EDITOR_CAPTION() {
		return LOCALIZATION_HELPER.get(JOB_EDITOR_CAPTION);
	}

	public static String JOB_TAB_CAPTION() {
		return LOCALIZATION_HELPER.get(JOB_TAB_CAPTION);
	}


}
