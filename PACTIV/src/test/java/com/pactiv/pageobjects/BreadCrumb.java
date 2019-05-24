package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class BreadCrumb {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_BREADCRUMB_OBJECTREPOSITORY_PROPERTY));
	public static By breadcrumb_dropdown = By.xpath(repository.getProperty("BREADCRUMB_DROPDOWN"));
	public static By asset_dropdown = By.xpath(repository.getProperty("ASSET_DROPDOWN"));
	public static By blenderasset_dropdownvalue = By.xpath(repository.getProperty("BLENDERASSET_DROPDOWNVALUE"));
	public static By extruderasset_dropdownvalue = By.xpath(repository.getProperty("EXTRUDERASSET_DROPDOWNVALUE"));
	public static By hauloffasset_dropdownvalue = By.xpath(repository.getProperty("HAULOFFASSET_DROPDOWNVALUE"));
	public static By thermoformerasset_dropdownvalue = By.xpath(repository.getProperty("THERMOFORMERASSET_DROPDOWNVALUE"));
	public static By trimpressasset_dropdownvalue = By.xpath(repository.getProperty("TRIMPRESSASSET_DROPDOWNVALUE"));
	public static By grinderasset_dropdownvalue = By.xpath(repository.getProperty("GRINDERASSET_DROPDOWNVALUE"));
	public static By plantview_dropdownvalue = By.xpath(repository.getProperty("PLANTVIEW_BREADCRUMB"));
	public static By materialcontrolview_dropdownvalue = By.xpath(repository.getProperty("MATERIALCONTROLVIEW_BREADCRUMB"));
	public static By materialcontrolview_expandicon = By.xpath(repository.getProperty("MATERIALCONTROLVIEW_EXPANDICON"));
	
}
