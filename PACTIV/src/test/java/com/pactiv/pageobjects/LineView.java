package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class LineView {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.LINEVIEW_OBJECTREPOSITORY_PROPERTY));
	
	public static By linegraphicalview_blenderasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_BLENDERASSET"));
	public static By linegraphicalview_extruderasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_EXTRUDERASSET"));
	public static By linegraphicalview_hauloffasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_HAULOFF"));
	public static By linegraphicalview_thermoformerasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_THERMOFORMER"));
	public static By linegraphicalview_trimpressasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_TRIMPRESS"));
	public static By linegraphicalview_grinderasset = By.xpath(repository.getProperty("LINEGRAPHICALVIEW_GRINDER"));
	public static By assetabridgedview_blender = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_BLENDER"));
	public static By assetabridgedview_extruder = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_EXTRUDER"));
	public static By assetabridgedview_hauloff = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_HAULOFF"));
	public static By assetabridgedview_thermoformer = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_THERMOFORMER"));
	public static By assetabridgedview_trimpress = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_TRIMPRESS"));
	public static By assetabridgedview_grinder = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_GRINDER"));
	public static By line13_breadcrumbview = By.xpath(repository.getProperty("LINE13_BREADCRUMBVIEW"));
	public static By line1_breadcrumbview = By.xpath(repository.getProperty("LINE1_BREADCRUMBVIEW"));
	public static By line12_breadcrumbview = By.xpath(repository.getProperty("LINE12_BREADCRUMBVIEW"));
	public static By line10_breadcrumbview = By.xpath(repository.getProperty("LINE10_BREADCRUMBVIEW"));
	public static By line11_breadcrumbview = By.xpath(repository.getProperty("LINE11_BREADCRUMBVIEW"));
	public static By line14_breadcrumbview = By.xpath(repository.getProperty("LINE14_BREADCRUMBVIEW"));
	public static By line15_breadcrumbview = By.xpath(repository.getProperty("LINE15_BREADCRUMBVIEW"));
	public static By line16_breadcrumbview = By.xpath(repository.getProperty("LINE16_BREADCRUMBVIEW"));
	public static By line17_breadcrumbview = By.xpath(repository.getProperty("LINE17_BREADCRUMBVIEW"));
	public static By line18_breadcrumbview = By.xpath(repository.getProperty("LINE18_BREADCRUMBVIEW"));
	public static By assetabridgedview_alarms = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_ALARMS"));
	public static By assetabridgedview_alarmsvalue = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_ALARMSVALUE"));
	public static By assetabridgedview_warnings = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_WARNINGS"));
	public static By assetabridgedview_warningsvalue = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_WARNINGSVALUE"));
	public static By assetabridgedview_setpointsvalue = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_SETPOINTSVALUE"));
	public static By assetabridgedview_setpoints = By.xpath(repository.getProperty("ASSETABRIDGEDVIEW_SETPOINTS"));
	
}
