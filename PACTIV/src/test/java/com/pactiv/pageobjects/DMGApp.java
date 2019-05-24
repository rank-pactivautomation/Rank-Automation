package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class DMGApp {
	public String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_CPT_DMG_OBJECTREPOSITORY_PROPERTY));

	public final By DMG_HOME_LOGO = By.xpath(repository.getProperty("DMG_HOME_LOGO"));
	public final By DMG_HOME_LOGOTEXT = By.xpath(repository.getProperty("DMG_HOME_LOGOTEXT"));
	public final By DMG_ADDPLANT_BTN = By.xpath(repository.getProperty("DMG_ADDPLANT_BTN"));
	public final By DMG_ADDPLANT_HOME_LOGO = By.xpath((repository.getProperty("DMG_ADDPLANT_HOME_LOGO")));
	public final By DMG_ADDPLANT_PLANTDETAILS = By.xpath(repository.getProperty("DMG_ADDPLANT_PLANTDETAILS"));
	public final By DMG_ADDPLANT_SHIFTDETAILS = By.xpath(repository.getProperty("DMG_ADDPLANT_SHIFTDETAILS"));
	public final By DMG_ADDPLANT_PRODDETAILS = By.xpath(repository.getProperty("DMG_ADDPLANT_PRODDETAILS"));
	public final By DMG_ADDPLANT_USERCONFIG = By.xpath(repository.getProperty("DMG_ADDPLANT_USERCONFIG"));
	public final By DMG_ADDPLANT_RVWPUB = By.xpath(repository.getProperty("DMG_ADDPLANT_RVWPUB"));
	public final By DMG_ADDPLANT_PUBLISH_BTN = By.id(repository.getProperty("DMG_ADDPLANT_PUBLISH_BTN"));
	public final By DMG_ADDPLANT_SAVEDRAFT_BTN = By.xpath(repository.getProperty("DMG_ADDPLANT_SAVEDRAFT_BTN"));
	public final By DMG_ADDPLANT_BACK_BTN = By.xpath(repository.getProperty("DMG_ADDPLANT_BACK_BTN"));
}
