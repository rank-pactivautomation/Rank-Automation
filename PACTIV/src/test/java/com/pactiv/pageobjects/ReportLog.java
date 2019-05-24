package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class ReportLog {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_REPORTLOG_OBJECTREPOSITORY_PROPERTY));
	public static By linelevelreports = By.xpath(repository.getProperty("LINELEVELREPORTS"));
	public static By reviewsubmit = By.xpath(repository.getProperty("REPORTLOG_REVIEWSUBMIT"));
	public static By reportlog_shiftoee = By.xpath(repository.getProperty("REPORTLOG_SHIFTOEE"));
	public static By reportlog_shiftoeevalue = By.xpath(repository.getProperty("REPORTLOG_SHIFTOEEVALUE"));
	public static By reportlog_casesvalue = By.xpath(repository.getProperty("REPORTLOG_CASESVALUE"));
	public static By reportlog_cases = By.xpath(repository.getProperty("REPORTLOG_CASESVALUE"));
	public static By reportlog_downtimevalue = By.xpath(repository.getProperty("REPORTLOG_DOWNTIMEVALUE"));
	public static By reportlog_downtime = By.xpath(repository.getProperty("REPORTLOG_DOWNTIME"));
	public static By reportpage_date = By.xpath(repository.getProperty("REPORTPAGE_DATE"));
	public static By reportlog_incomplete = By.xpath(repository.getProperty("REPORTLOG_INCOMPLETE"));
	public static By reportlog_submit = By.xpath(repository.getProperty("REPORTLOG_SUBMITBUTTON"));
	public static By reportlog_reviewsubmit_incomplete= By.xpath(repository.getProperty("REPORTLOG_REVIEWSUBMIT_INCOMPLETE"));
	public static By reportlog_actualcases_value= By.xpath(repository.getProperty("REPORTLOG_ACTUALCASES_VALUE"));
	public static By reportlog_adddiagnosis= By.xpath(repository.getProperty("REPORTLOG_ADDDIAGNOSIS"));
	public static By reportlog_selectlevel1= By.xpath(repository.getProperty("REPORTLOG_SELECTLEVEL1"));
	public static By reportlog_selectlevel2= By.xpath(repository.getProperty("REPORTLOG_SELECTLEVEL2"));
	public static By reportlog_selectlevel3= By.xpath(repository.getProperty("REPORTLOG_SELECTLEVEL3"));
	public static By reportlog_save= By.xpath(repository.getProperty("REPORTLOG_SAVE"));
}
