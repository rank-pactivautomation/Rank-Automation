package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class UploadProcessSheet {

	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_UPLOADPROCESSSHEET_OBJECTREPOSITORY_PROPERTY));
	public static By uploadprocesssheet = By.xpath(repository.getProperty("UPLOADPROCESSSHEET"));
//	public static By processsheetupload= By.xpath(repository.getProperty("PROCESSSHEETUPLOAD"));
//	public static By updatebutton = By.xpath(repository.getProperty("UPDATEBUTTON"));
	public static By uploadnewbutton = By.xpath(repository.getProperty("UPLOADNEWBUTTON"));
	public static By updatebutton = By.xpath(repository.getProperty("UPDATEBUTTON"));
//	public static By popupclosebutton = By.xpath(repository.getProperty("POPUPCLOSEBUTTON"));
	public static By choosefile = By.xpath(repository.getProperty("CHOOSEFILE"));
	public static By uploadbutton = By.xpath(repository.getProperty("UPLOADBUTTON"));
//	public static By duplicatefilename = By.xpath(repository.getProperty("DUPLICATEFILENAME"));
//	public static By browsebutton = By.xpath(repository.getProperty("BROWSE_BUTTON"));
//	public static By cancelbutton = By.xpath(repository.getProperty("CANCEL_BUTTON"));
//	public static By popupclosebutton1 = By.xpath(repository.getProperty("POPUPCLOSEBUTTON1"));
//	public static By duplicatefiledatamessage = By.xpath(repository.getProperty("DUPLICATEFILEDATAMESSAGE"));
//	public static By incorrectfilemessage = By.xpath(repository.getProperty("INCORRECTFILEMESSAGE"));
//	public static By incorrectproductname = By.xpath(repository.getProperty("INCORRECTPRODUCTNAME"));
	public static By processsheetmessage = By.xpath(repository.getProperty("PROCESSSHEET_MESSAGE"));
	public static By save_button = By.xpath(repository.getProperty("SAVE_BUTTON"));
//	public static By cancel_button = By.xpath(repository.getProperty("CANCEL_BUTTON"));
//	public static By invalidcharacter_message = By.xpath(repository.getProperty("INVALIDCHARACTER_MESSAGE"));
//	public static By newprocesssheetuploadmessage = By.xpath(repository.getProperty("NEWPROCESSSHEETUPLOADMESSAGE"));
//	public static By processsheet_uploadmessage = By.xpath(repository.getProperty("PROCESSSHEET_UPLOADMESSAGE"));
	public static By ok_buttonmessage = By.xpath(repository.getProperty("OK_BUTTONMESSAGE"));
//	public static By incorrectfilenumber_message = By.xpath(repository.getProperty("INCORRECTFILENUMBERMESSAGE"));
	public static By line4_expand = By.xpath(repository.getProperty("LINE4_EXPAND"));
	public static By line4_expandicon = By.xpath(repository.getProperty("LINE4_EXPANDICON"));
	public static By line4_lineviewtext = By.xpath(repository.getProperty("LINE4_LINEVIEWTEXT"));
	public static By line13_dropdown_line = By.xpath(repository.getProperty("LINE13_DROPDOWN_LINE"));
	public static By duplicate_filedatamessage = By.xpath(repository.getProperty("DUPLICATE_FILEDATAMESSAGE"));
	public static By incorrectproductname_message = By.xpath(repository.getProperty("INCORRECTPRODUCTNAME_MESSAGE"));
	public static By nofile_datamessage = By.xpath(repository.getProperty("NOFILEDATAMESSAGE"));
	public static By popup_closebutton = By.xpath(repository.getProperty("POPUP_CLOSEBUTTON"));
	public static By incorrect_filenumbermessage = By.xpath(repository.getProperty("INCORRECTFILENUMBERMESSAGE"));
}
