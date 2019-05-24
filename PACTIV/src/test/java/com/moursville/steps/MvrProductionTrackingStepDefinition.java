package com.moursville.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.pageobjects.ReportLog;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class MvrProductionTrackingStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);
//    public static int count;
	TestResultsUtils testResultUtils = new TestResultsUtils();

	@Then("^User selects the Moursville shift$")
	public void user_selects_the_shift() throws Throwable {
		usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
		usablemethods.gClick(ProductionTracking.productiontracking_time2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");
	}
	
	
@Then("^User Clicks on \"([^\"]*)\" on Moursville ProductionTracking$")
public void user_Clicks_on_on_Moursville_ProductionTracking(String arg1) throws Throwable {
		String line = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> line_number = LocalDriverManager.getDriver()
				.findElements(By.xpath("//*[@cellvalue='" + line + "']"));
		for(int i=0; i<=line_number.size();i++) {
			for (WebElement line_click : line_number) {
				line_click.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line:" + line);
				
				if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
					usablemethods.gClick(PactivLogin.alarm_toast);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");
				} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
					usablemethods.gClick(PactivLogin.alarm_toast_multiple);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");
				} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
					usablemethods.gClick(PactivLogin.report_toast);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");
				} else {
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");;
				}
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			while(LocalDriverManager.getDriver().findElements(By.xpath("//div[contains(@id,'cell_ShiftDataRepeater_Mashup')]//div[contains(text(),'pending')]")).size()>0) {
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				LocalDriverManager.getDriver().findElement(By.xpath("//div[contains(@id,'cell_ShiftDataRepeater_Mashup')]//div[contains(text(),'pending')]")).click();
				System.out.print("clicked on pending");
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(80000, TimeUnit.MILLISECONDS);
				if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_resolve)) {
					usablemethods.gClick(ProductionTracking.productiontracking_resolve);
					TestResultsUtils.logger.log(LogStatus.PASS, "Resolve button is clicked");
					usablemethods.sendData(ProductionTracking.productiontracking_resolvecomment, "Resolve the diagnosis");
					TestResultsUtils.logger.log(LogStatus.PASS, "User adds the comment 'Resolve the diagnosis");
					usablemethods.gClick(ProductionTracking.productiontracking_resolvetick);
					TestResultsUtils.logger.log(LogStatus.PASS, "Resolve Tick Mark is clicked");
					usablemethods.gClick(ProductionTracking.productiontracking_adddiagnosis);
					TestResultsUtils.logger.log(LogStatus.PASS, "Add Diagnosis button is clicked");
					usablemethods.gClick(ProductionTracking.productiontracking_dropdown1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects the diagnosis value"
							+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_dropdown1));
				} else {
					usablemethods.gClick(ProductionTracking.productiontracking_adddiagnosis);
					TestResultsUtils.logger.log(LogStatus.PASS, "Add Diagnosis button is clicked");
					usablemethods.gClick(ProductionTracking.productiontracking_dropdown1);
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects the diagnosis value"
							+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_dropdown1));
				}
				usablemethods.gClick(ProductionTracking.productiontracking_selectrows);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Rows");
				if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_1trow)) {
					usablemethods.gClick(ProductionTracking.productiontracking_1trow);
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects 1T Row");
					usablemethods.gClick(ProductionTracking.productiontracking_update);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
				} 
				else if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_1row)) {
					usablemethods.gClick(ProductionTracking.productiontracking_1row);
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects 1 Row");
					usablemethods.gClick(ProductionTracking.productiontracking_update);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
				} 
				else {
					usablemethods.gClick(ProductionTracking.productiontracking_2trow);
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects 2T Row");
					usablemethods.gClick(ProductionTracking.productiontracking_update);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
				}
				usablemethods.sendText(ProductionTracking.productiontracking_actualcases, "5");
				TestResultsUtils.logger.log(LogStatus.PASS, "User enters the Actual Cases");
				usablemethods.gClick(ReportLog.reportlog_selectlevel1);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 1");
				usablemethods.gClick(ProductionTracking.productiontracking_selectlevel1_option);
				TestResultsUtils.logger.log(LogStatus.PASS, "User selects the DropDown value:"
						+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel1_option));
				usablemethods.gClick(ReportLog.reportlog_selectlevel2);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 2");
				usablemethods.gClick(ProductionTracking.productiontracking_selectlevel2_option);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:"
						+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel2_option));
				usablemethods.gClick(ReportLog.reportlog_selectlevel3);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 3");
				usablemethods.gClick(ProductionTracking.productiontracking_selectlevel3_option);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:"
						+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel3_option));
				usablemethods.gClick(ReportLog.reportlog_save);
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Save button");
			}
//			count++;
//			if(count==1)
//				break; 
			}
		
		}
	}
}
