package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class AssetAbridged {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_ASSETABRIDGED_OBJECTREPOSITORY_PROPERTY));
	public static By assetabridged_expandicon = By.xpath(repository.getProperty("ABRIDGEDVIEW_EXPANDICON"));
	public static By blenderdetailedview_header = By.xpath(repository.getProperty("BLENDERDETAILEDVIEW_HEADER"));
	public static By blender13b_header = By.xpath(repository.getProperty("BLENDER13B_HEADER"));
	public static By blender13c_header = By.xpath(repository.getProperty("BLENDER13C_HEADER"));
	public static By blender12b_header = By.xpath(repository.getProperty("BLENDER12B_HEADER"));
}
