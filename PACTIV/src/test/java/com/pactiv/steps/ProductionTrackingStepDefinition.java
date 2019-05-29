package com.pactiv.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.SetFactoryBean;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.pageobjects.ReportLog;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductionTrackingStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	ProductionTracking ProductionTracking = new ProductionTracking();
	PactivLogin PactivLogin = new PactivLogin();
	com.pactiv.reusable.ProductionTracking PTFunctions = new com.pactiv.reusable.ProductionTracking();

	@Then("^User Clicks on Pending box$")
	public void user_Clicks_on_Pending_box() throws Throwable {
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
			usablemethods.gClick(PactivLogin.alarm_toast);
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			usablemethods.gClick(ProductionTracking.productiontracking_pending);
			TestResultsUtils.logger.log(LogStatus.PASS, "Pending box is clicked");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			usablemethods.gClick(ProductionTracking.productiontracking_pending);
			TestResultsUtils.logger.log(LogStatus.PASS, "Pending box is clicked");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
			usablemethods.gClick(PactivLogin.report_toast);
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			usablemethods.gClick(ProductionTracking.productiontracking_pending);
			TestResultsUtils.logger.log(LogStatus.PASS, "Pending box is clicked");
		} else {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			usablemethods.gClick(ProductionTracking.productiontracking_pending);
			TestResultsUtils.logger.log(LogStatus.PASS, "Pending box is clicked");
		}
	}

	@Then("^User Clicks on Add Diagnosis$")
	public void user_Clicks_on_Add_Diagnosis() throws Throwable {
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

	}

	@Then("^User Clicks on Select Row$")
	public void user_Clicks_on_Select_Row() throws Throwable {
		usablemethods.gClick(ProductionTracking.productiontracking_selectrows);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Rows");
		if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_1trow)) {
			usablemethods.gClick(ProductionTracking.productiontracking_1trow);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects 1T Row");
			usablemethods.gClick(ProductionTracking.productiontracking_update);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
		} else if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_1row)) {
			usablemethods.gClick(ProductionTracking.productiontracking_1row);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects 1 Row");
			usablemethods.gClick(ProductionTracking.productiontracking_update);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
		} else {
			usablemethods.gClick(ProductionTracking.productiontracking_2trow);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects 2T Row");
			usablemethods.gClick(ProductionTracking.productiontracking_update);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
		}
	}

	@Then("^User selects the shift$")
	public void user_selects_the_shift() throws Throwable {
		usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
		usablemethods.gClick(ProductionTracking.productiontracking_time2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time DropDown Value");
	}

	@Then("^User Clicks on \"([^\"]*)\" on ProductionTracking$")
	public void user_Clicks_on_on_ProductionTracking(String arg1) throws Throwable {
		String line = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> line_number = LocalDriverManager.getDriver()
				.findElements(By.xpath("//*[@cellvalue='" + line + "']"));
		for (int i = 0; i <= line_number.size(); i++) {
			for (WebElement line_click : line_number) {
				line_click.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line:" + line);
				if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
					usablemethods.gClick(PactivLogin.alarm_toast);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time2);
					TestResultsUtils.logger.log(LogStatus.PASS,
							"User clicks on Production Tracking Time DropDown Value");
				} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
					usablemethods.gClick(PactivLogin.alarm_toast_multiple);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time2);
					TestResultsUtils.logger.log(LogStatus.PASS,
							"User clicks on Production Tracking Time DropDown Value");
				} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
					usablemethods.gClick(PactivLogin.report_toast);
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time2);
					TestResultsUtils.logger.log(LogStatus.PASS,
							"User clicks on Production Tracking Time DropDown Value");
				} else {
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					usablemethods.gClick(ProductionTracking.productiontracking_timedropdown);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Tracking Time Dropdown");
					usablemethods.gClick(ProductionTracking.productiontracking_time2);
					TestResultsUtils.logger.log(LogStatus.PASS,
							"User clicks on Production Tracking Time DropDown Value");
					;
				}

				while (LocalDriverManager.getDriver().findElements(By
						.xpath("//div[contains(@id,'cell_ShiftDataRepeater_Mashup')]//div[contains(text(),'pending')]"))
						.size() > 0) {
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					LocalDriverManager.getDriver().findElement(By.xpath(
							"//div[contains(@id,'cell_ShiftDataRepeater_Mashup')]//div[contains(text(),'pending')]"))
							.click();
					LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_resolve)) {
						usablemethods.gClick(ProductionTracking.productiontracking_resolve);
						TestResultsUtils.logger.log(LogStatus.PASS, "Resolve button is clicked");
						usablemethods.sendData(ProductionTracking.productiontracking_resolvecomment,
								"Resolve the diagnosis");
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
					} else if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_1row)) {
						usablemethods.gClick(ProductionTracking.productiontracking_1row);
						TestResultsUtils.logger.log(LogStatus.PASS, "User selects 1 Row");
						usablemethods.gClick(ProductionTracking.productiontracking_update);
						TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Update button");
					} else {
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
					TestResultsUtils.logger.log(LogStatus.PASS, "User selects the DropDown value:" + usablemethods
							.gWebElementGetText(ProductionTracking.productiontracking_selectlevel1_option));
					usablemethods.gClick(ReportLog.reportlog_selectlevel2);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 2");
					usablemethods.gClick(ProductionTracking.productiontracking_selectlevel2_option);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:" + usablemethods
							.gWebElementGetText(ProductionTracking.productiontracking_selectlevel2_option));
					usablemethods.gClick(ReportLog.reportlog_selectlevel3);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 3");
					usablemethods.gClick(ProductionTracking.productiontracking_selectlevel3_option);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:" + usablemethods
							.gWebElementGetText(ProductionTracking.productiontracking_selectlevel3_option));
					usablemethods.gClick(ReportLog.reportlog_save);
					TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Save button");
				}

			}

		}
	}

	@Then("^User Enters the Actual Cases$")
	public void user_Enters_the_Actual_Cases() throws Throwable {
		usablemethods.sendText(ProductionTracking.productiontracking_actualcases, "5");
		TestResultsUtils.logger.log(LogStatus.PASS, "User enters the Actual Cases");
	}

	@Then("^User Clicks on Select LevelOne$")
	public void user_Clicks_on_Select_LevelOne() throws Throwable {
		usablemethods.gClick(ReportLog.reportlog_selectlevel1);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 1");
		usablemethods.gClick(ProductionTracking.productiontracking_selectlevel1_option);
		TestResultsUtils.logger.log(LogStatus.PASS, "User selects the DropDown value:"
				+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel1_option));
	}

	@Then("^User Clicks on Select LevelTwo$")
	public void user_Clicks_on_Select_LevelTwo() throws Throwable {
		usablemethods.gClick(ReportLog.reportlog_selectlevel2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 2");
		usablemethods.gClick(ProductionTracking.productiontracking_selectlevel2_option);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:"
				+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel2_option));
	}

	@Then("^User Clicks on Select LevelThree$")
	public void user_Clicks_on_Select_LevelThree() throws Throwable {
		usablemethods.gClick(ReportLog.reportlog_selectlevel3);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Select Level 3");
		usablemethods.gClick(ProductionTracking.productiontracking_selectlevel3_option);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown Value:"
				+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_selectlevel3_option));
	}

	@Then("^User Clicks on Save button on ProductionTracking$")
	public void user_Clicks_on_Save_button_on_ProductionTracking() throws PactivException {
		usablemethods.gClick(ReportLog.reportlog_save);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Save button");
	}

	@When("^User enters Actual cases as \"([^\"]*)\"$")
	public void enterActualCases(String cases) throws PactivException {
		PTFunctions.clearOldDiagnosis();
		boolean status = PTFunctions.enterActualCases(cases);
		if (status)
			TestResultsUtils.setTrue("User enters the Actual Cases");
		else
			TestResultsUtils.setFalse("User is unable to enter the Actual Cases");

	}

	@When("^User clicks on the \"([^\"]*)\" in Production Tracking screen$")
	public void clicksOn(String option) throws PactivException {
		switch (option) {
		case "PENDING PT HOUR BOX":
			try {
//				usablemethods.waitByTime(10000);
				usablemethods.gClick(ProductionTracking.PRODUCTIONTRACK_PENDING);
				TestResultsUtils.logger.log(LogStatus.PASS,
						"User clicks on the Pending Hour PT Box in Production Tracking screen");
			} catch (PactivException e) {
				// TODO: handle exception
				e.printStackTrace();
//				TestResultsUtils.logger.log(LogStatus.FAIL,
//						"User is unable to click on the Pending Hour PT Box in Production Tracking screen");
				TestResultsUtils
						.setFalse("User is unable to click on the Pending Hour PT Box in Production Tracking screen");
			}
			break;
		case "SAVE":
			if (PTFunctions.clickOnSave()) 
				TestResultsUtils.setTrue("User clicks on the Save in Production Tracking screen");
			else
				TestResultsUtils.setFalse("User is unable to click on the Save in Production Tracking screen");
			break;
		default:
			break;
		}
	}

	@When("^User selects Downntime Reasons for \"([^\"]*)\" as \"([^\"]*)\"$")
	public void downtimeReasons(String drpdwn, String value) throws PactivException {
		switch (drpdwn.toUpperCase()) {
		case "LEVEL 1":
			usablemethods.selectOption(
					usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L1_DRPDWN), value);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 1 Downtime Reasons");
			break;
		case "LEVEL 2":
			usablemethods.selectOption(
					usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L2_DRPDWN), value);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 2 Downtime Reasons");
			break;
		case "LEVEL 3":
			usablemethods.selectOption(
					usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L3_DRPDWN), value);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 3 Downtime Reasons");
			break;
		default:
			TestResultsUtils.logger.log(LogStatus.FAIL, "User is unable to select the downtime reasons");
			break;
		}
	}

	@When("^User selects Downntime Reasons for \"([^\"]*)\"$")
	public void downtimeReasons(String drpdwn) throws PactivException {
		switch (drpdwn.toUpperCase()) {
		case "LEVEL 1":
			usablemethods
					.selectOption(usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L1_DRPDWN));
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 1 Downtime Reasons");
			break;
		case "LEVEL 2":
			usablemethods
					.selectOption(usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L2_DRPDWN));
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 2 Downtime Reasons");
			break;
		case "LEVEL 3":
			usablemethods
					.selectOption(usablemethods.getWebElement(ProductionTracking.PRODUCTIONTRACK_DOWNTIME_L3_DRPDWN));
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the Level 3 Downtime Reasons");
			break;
		default:
//			TestResultsUtils.logger.log(LogStatus.FAIL, "User is unable to select the downtime reasons");
			TestResultsUtils.setFalse("User is unable to select the downtime reasons");
			break;
		}
	}

	@When("^User clicks on Add Scrapping Button$")
	public void user_clicks_on_add_scrapping_button() throws PactivException {
		try {
			PTFunctions.addDiagnosis();
		} catch (PactivException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TestResultsUtils.setFalse("User is unable to Add Scrapping Rows");
			throw new PactivException(e);
		}

	}

	@When("^User enters Scrapping Details as \"([^\"]*)\"$")
	public void user_enters_scrapping_details_as_something(String details) throws PactivException {
		try {
			PTFunctions.addScrappingDetails(details);
		} catch (PactivException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TestResultsUtils.setFalse("User is unable to enter Scrapping Details");
			throw new PactivException(e);
		}
	}

}
