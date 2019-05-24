package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class MvrNotifications {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.MOORESVILLE_NOTIFICATIONS_OBJECTREPOSITORY_PROPERTY));
	public static By area_text = By.xpath(repository.getProperty("AREA_TEXT"));
	public static By asset_text = By.xpath(repository.getProperty("ASSET_TEXT"));
	public static By description_text = By.xpath(repository.getProperty("DESCRIPTION_TEXT"));
	public static By starttime_text = By.xpath(repository.getProperty("START_TIMETEXT"));
	public static By duration_text = By.xpath(repository.getProperty("DURATION_TEXT"));
	public static By setpoint_text = By.xpath(repository.getProperty("SETPOINT_TEXT"));
	public static By actual_text = By.xpath(repository.getProperty("ACTUAL_TEXT"));
	public static By ucllcl_text = By.xpath(repository.getProperty("UCLLCL_TEXT"));
	public static By status_text = By.xpath(repository.getProperty("STATUS_TEXT"));
}
