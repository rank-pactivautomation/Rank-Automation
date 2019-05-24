package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class MvrEol {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.MOORESVILLE_EOL_OBJECTREPOSITORY_PROPERTY ));
	 public static By downtime = By.xpath(repository.getProperty("TABLE_DOWNTIME"));
	 public static By eohhour = By.xpath(repository.getProperty("TABLE_EOHOUR"));
	 public static By prodname = By.xpath(repository.getProperty("TABLE_PRODNAME"));
	 public static By goldencases = By.xpath(repository.getProperty("TABLE_GOLDENCASES"));  
	 public static By expcases = By.xpath(repository.getProperty("TABLE_EXPCASES"));
	 public static By actualcases = By.xpath(repository.getProperty("TABLE_ACTUAL"));
	 public static By targetcpm = By.xpath(repository.getProperty("TABLE_TARGETCPM"));
	 public static By actcpm = By.xpath(repository.getProperty("TABLE_ACTCPM"));
	 public static By scrap = By.xpath(repository.getProperty("TABLE_SCRAP"));
	 public static By comments = By.xpath(repository.getProperty("TABLE_COMMENTS"));
	 public static By line_text = By.xpath(repository.getProperty("LINE_TEXT"));
	 public static By logout = By.xpath(repository.getProperty("LOGOUT"));
}

