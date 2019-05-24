package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class MvrProductionTrackingTool {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.MOORESVILLE_PRODUCTIONRUNTOOL_OBJECTREPOSITORY_PROPERTY));
	public static By pt_selectedline = By.xpath(repository.getProperty("PT_SELECTEDLINE"));
	public static By pt_productnametext = By.xpath(repository.getProperty("PT_PRODUCTNAMETEXT"));
	public static By pt_inputfield = By.xpath(repository.getProperty("PT_INPUTFIELD"));
	public static By pt_orderfield = By.xpath(repository.getProperty("PT_ORDERFIELD"));
	public static By pt_orderfieldtext = By.xpath(repository.getProperty("PT_ORDERFIELDTEXT"));
	public static By pt_startdate = By.xpath(repository.getProperty("PT_STARTDATE"));
	public static By pt_goldenoutperhourtext = By.xpath(repository.getProperty("PT_GOLDENOUTPERHOURTEXT"));
	public static By pt_goldenoutputfield = By.xpath(repository.getProperty("PT_GOLDENOUTPUTFIELD"));
	public static By pt_standardoutputfiled = By.xpath(repository.getProperty("PT_STANDARDOUTPUTFIELD"));
	public static By pt_totalcasesfield = By.xpath(repository.getProperty("PT_TOTALCASESFIELD"));
	public static By pt_casespalletfield = By.xpath(repository.getProperty("PT_CASESPALLETFIELD"));
	public static By pt_caseweightfield = By.xpath(repository.getProperty("PT_CASEWEIGHTFIELD"));
	public static By pt_tablesizefield = By.xpath(repository.getProperty("PT_TABLESIZEFIELD"));
	public static By pt_row4field = By.xpath(repository.getProperty("PT_ROW4FIELD"));
	public static By pt_row6field = By.xpath(repository.getProperty("PT_ROW6FIELD"));
	public static By pt_row64field = By.xpath(repository.getProperty("PT_ROW64FIELD"));
	public static By pt_standardoutputtext = By.xpath(repository.getProperty("PT_STANDARDOUTPUTTEXT"));
	public static By pt_totalcasestext = By.xpath(repository.getProperty("PT_TOTALCASESTEXT"));
	public static By pt_casesperpallettext = By.xpath(repository.getProperty("PT_CASESPERPALLETTEXT"));
	public static By pt_cpmtext = By.xpath(repository.getProperty("PT_CPMTEXT"));
	public static By pt_casesweighttext = By.xpath(repository.getProperty("PT_CASEWEIGHTTEXT"));
	public static By pt_tablesizetext = By.xpath(repository.getProperty("PT_TABLESIZETEXT"));
	public static By pt_confirmtext = By.xpath(repository.getProperty("PT_CONFIRMTEXT"));
	public static By pt_savedate = By.xpath(repository.getProperty("PT_STARTDATE"));
	public static By pt_dateselector = By.xpath(repository.getProperty("PT_DATESELECTOR"));
	public static By pt_donetext = By.xpath(repository.getProperty("PT_DONETEXT"));
	public static By pt_enddate = By.xpath(repository.getProperty("PT_ENDDATE"));
	public static By pt_enddatetext = By.xpath(repository.getProperty("PT_ENDDATETEXT"));
	public static By pt_todaytext = By.xpath(repository.getProperty("PT_TODAYTEXT"));
	public static By pt_cleartext = By.xpath(repository.getProperty("PT_CLEARTEXT"));
	
}
