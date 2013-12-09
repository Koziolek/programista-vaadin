package pl.koziolekweb.progvaadin.model;

import pl.koziolekweb.progvaadin.LocalizationHelper;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.12.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public final class Job_ {

	public static final LocalizationHelper LOCALIZATION_HELPER = LocalizationHelper.defaultInstance();

	public static final String JOB_NAME = "job.name";
	public static final String JOB_DESC = "job.desc";
	public static final String JOB_TYPE = "job.type";
	public static final String JOB_ADD = "job.add";
	public static final String JOB_REFRESH = "job.refresh";
	public static final String JOB_EDIT = "job.edit";

	public static String JOB_NAME() {
		return LOCALIZATION_HELPER.get(JOB_NAME);
	}

	public static String JOB_DESC() {
		return LOCALIZATION_HELPER.get(JOB_DESC);
	}

	public static String JOB_TYPE() {
		return LOCALIZATION_HELPER.get(JOB_TYPE);
	}

	public static String JOB_ADD() {
		return LOCALIZATION_HELPER.get(JOB_ADD);
	}

	public static String JOB_REFRESH() {
		return LOCALIZATION_HELPER.get(JOB_REFRESH);
	}

	public static String JOB_EDIT() {
		return LOCALIZATION_HELPER.get(JOB_EDIT);
	}
}
