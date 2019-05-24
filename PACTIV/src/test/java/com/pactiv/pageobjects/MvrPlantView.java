package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class MvrPlantView {
	
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.MOORESVILLE_PLANTVIEW_OBJECTREPOSITORY_PROPERTY ));
	 public static By MRVPlantview_icon = By.xpath(repository.getProperty("PLANTVIEW_ICON"));
	 public static By MRVPlantview_title = By.xpath(repository.getProperty("PLANTVIEW_TITLE"));
	 public static By Plantview_dropdown = By.xpath(repository.getProperty("PLANTVIEW_DROP"));
	
	 public static By dropdown = By.xpath(repository.getProperty("DROPDOWN"));
	 public static By material_dropdown = By.xpath(repository.getProperty("MATERIAL_DROP"));
	 public static By MRVmaterialview_title = By.xpath(repository.getProperty("MATERIAL_TITLE"));
	 public static By MRVwidget_linename = By.xpath(repository.getProperty("WIDGET_LINENAME"));
	 
	 public static By MRVwidget_alarmstitle = By.xpath(repository.getProperty("WIDGET_TOTAL_ALARMS_TITLE"));
	 public static By MRVwidget_warningstitle = By.xpath(repository.getProperty("WIDGET_TOTALWARNINGS_TITLE"));
	 public static By MRVwidget_alarmvalue = By.xpath(repository.getProperty("WIDGET_TOTAL_ALARMS_VALUE"));
	 public static By MRVwidget_warningvalue = By.xpath(repository.getProperty("WIDGET_TOTAL_WARNINGS_VALUE"));
	 public static By MRVwidget_activitylog = By.xpath(repository.getProperty("WIDGET_ACTIVITY_EXPAND"));
	 public static By activitylogtitle = By.xpath(repository.getProperty("ACTIVITYLOG_TITLE"));
	 public static By plant_oee = By.xpath(repository.getProperty("PLANT_OEE"));
	 public static By plant_oee_value = By.xpath(repository.getProperty("OEE_VALUE"));
	 
	 public static By asset = By.xpath(repository.getProperty("ASSET"));
	 public static By description = By.xpath(repository.getProperty("DESCRIPTION"));
	 public static By duration = By.xpath(repository.getProperty("DURATION"));
	 public static By setpoint = By.xpath(repository.getProperty("SETPOINT"));
	 public static By actual = By.xpath(repository.getProperty("ACTUAL"));
	 public static By ucl_lcl = By.xpath(repository.getProperty("UCL/LCL"));
	 public static By status = By.xpath(repository.getProperty("STATUS"));	
	 
	 
	 
		
		
}
