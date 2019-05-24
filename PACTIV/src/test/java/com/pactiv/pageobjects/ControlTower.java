package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class ControlTower {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_CONTROLTOWER_OBJECTREPOSITORY_PROPERTY));
	public static By controltower_icon = By.xpath(repository.getProperty("CONTROLTOWER_ICON"));
	public static By blendinsights_line13 = By.xpath(repository.getProperty("BLENDINSIGHTS_LINE13"));
	public static By column1_blendinsightsheader = By.xpath(repository.getProperty("COLUMN1_BLENDINSIGHTSHEADER"));
	public static By column3_blendinsightsheader3 = By.xpath(repository.getProperty("COLUMN3_BLENDINSIGHTSHEADER3"));
	public static By column1_dropdown = By.xpath(repository.getProperty("COLUMN1_DROPDDOWN"));
	public static By column1_dropdownvalue1 = By.xpath(repository.getProperty("COLUMN1_DROPDOWNVALUE1"));
	public static By column1_dropdownvalue2 = By.xpath(repository.getProperty("COLUMN1_DROPDOWNVALUE2"));
	public static By column1_dropdownvalue3 = By.xpath(repository.getProperty("COLUMN1_DROPDOWNVALUE3"));
	public static By column1_dropdownvalue4 = By.xpath(repository.getProperty("COLUMN1_DROPDOWNVALUE4"));
	public static By column1_dropdownvalue5 = By.xpath(repository.getProperty("COLUMN1_DROPDOWNVALUE5"));
	public static By shiftdropdown_icon = By.xpath(repository.getProperty("SHIFTDROPDOWN_ICON"));
	public static By currentshift_dropdownvalue = By.xpath(repository.getProperty("CURRENTSHIFT_DROPDOWNVALUE"));
	public static By previousshift_dropdownvalue = By.xpath(repository.getProperty("PREVIOUSSHIFT_DROPDOWNVALUE"));
	public static By column2_dropdown = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE"));
	public static By column2_dropdownvalue1 = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE1"));
	public static By column2_dropdownvalue2 = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE2"));
	public static By column2_dropdownvalue3 = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE3"));
	public static By column2_dropdownvalue4 = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE4"));
	public static By column2_dropdownvalue5 = By.xpath(repository.getProperty("COLUMN2_DROPDOWNVALUE3"));
	public static By column2filter2_dropdown = By.xpath(repository.getProperty("COLUMN2FILTER2_DROPDOWN"));
	public static By column2filter2_dropdownvalue1 = By.xpath(repository.getProperty("COLUMN2FILTER2_DROPDOWNVALUE1"));
	public static By column2filter2_dropdownvalue2 = By.xpath(repository.getProperty("COLUMN2FILTER2_DROPDOWNVALUE2"));
	public static By column2filter2_dropdownvalue3 = By.xpath(repository.getProperty("COLUMN2FILTER2_DROPDOWNVALUE3"));
	public static By productioninsights_header1 = By.xpath(repository.getProperty("PRODUCTIONINSIGHTS_HEADER1"));
	public static By productioninsights_downtimeheader1 = By.xpath(repository.getProperty("PRODUCTIONINSIGHTS_DOWNTIMEHEADER1"));
	public static By productioninsights_downtimeheader2 = By.xpath(repository.getProperty("PRODUCTIONINSIGHTS_DOWNTIMEHEADER2"));
	public static By productioninsights_oeeheader1 = By.xpath(repository.getProperty("PRODUCTIONINSIGHTS_OEEHEADER1"));
	public static By productioninsights_oeeheader2 = By.xpath(repository.getProperty("PRODUCTIONINSIGHTS_OEEHEADER2"));
	public static By pt_column1_dropdownvalue1 = By.xpath(repository.getProperty("PT_COLUMN1_DROPDOWNALUE1"));
	public static By pt_column1_dropdownvalue2 = By.xpath(repository.getProperty("PT_COLUMN1_DROPDOWNVALUE2"));
	public static By pt_column1_dropdownvalue3 = By.xpath(repository.getProperty("PT_COLUMN1_DROPDOWNVALUE3"));
	public static By blendchangeevents_header = By.xpath(repository.getProperty("BLENDCHANGEEVENTS_HEADER"));
	public static By blendalarms_header = By.xpath(repository.getProperty("BLENDALARMS_HEADER"));
	public static By line_assignment = By.xpath(repository.getProperty("LINEASSIGNMENT"));
	public final By controlTowerIconDashboard = By.xpath(repository.getProperty("CONTROLTOWER_ICON_DASHBOARD"));
	
}
