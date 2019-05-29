package com.pactiv.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.ControlTower;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class ControlTowerStepDefinition extends TestDataUtils {
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@Then("^User Clicks on Control Tower Icon$")
	public void user_Clicks_on_Control_Tower_Icon() throws Throwable {
		usablemethods.gClick(ControlTower.controltower_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Control Tower Icon");
	}

	@Then("^User verify the Blend Insights header in Column One$")
	public void user_verify_the_Blend_Insights_header_in_Column_One() throws Throwable {
		String text = usablemethods.gWebElementGetText(ControlTower.column1_blendinsightsheader);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 header is displayed:" + text);
	}

	@Then("^User verify the Blend Insights header in Column Three$")
	public void user_verify_the_Blend_Insights_header_in_Column_Three() throws Throwable {
		String text = usablemethods.gWebElementGetText(ControlTower.column3_blendinsightsheader3);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 3 header is displayed:" + text);
	}

	@Then("^User Clicks on Dropdown Icon in Column One$")
	public void user_Clicks_on_Dropdown_Icon_in_Column_One() throws Throwable {
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 Dropdown is clicked");
	}

	@Then("^User selects the dropdown value$")
	public void user_selects_the_dropdown_value() throws Throwable {
		String DropDownValue1 = usablemethods.gWebElementGetText(ControlTower.column1_dropdownvalue1);
		usablemethods.gClick(ControlTower.column1_dropdownvalue1);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropDownValue1);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 Dropdown is clicked");
		String DropDownValue2 = usablemethods.gWebElementGetText(ControlTower.column1_dropdownvalue2);
		usablemethods.gClick(ControlTower.column1_dropdownvalue2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 2:" + DropDownValue2);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 Dropdown is clicked");
		String DropDownValue3 = usablemethods.gWebElementGetText(ControlTower.column1_dropdownvalue3);
		usablemethods.gClick(ControlTower.column1_dropdownvalue3);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 3:" + DropDownValue3);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 Dropdown is clicked");
		String DropDownValue4 = usablemethods.gWebElementGetText(ControlTower.column1_dropdownvalue4);
		usablemethods.gClick(ControlTower.column1_dropdownvalue4);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 4:" + DropDownValue4);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 1 Dropdown is clicked");
		String DropDownValue5 = usablemethods.gWebElementGetText(ControlTower.column1_dropdownvalue5);
		usablemethods.gClick(ControlTower.column1_dropdownvalue5);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 5:" + DropDownValue5);

	}

	@Then("^User selects the shift filter$")
	public void user_selects_the_shift_filter() throws Throwable {
		usablemethods.addPageLoadTimeout();
		Thread.sleep(5000);
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
			usablemethods.addPageLoadTimeout();
			usablemethods.gClick(PactivLogin.alarm_toast);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.previousshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Previous Shift DropDown");
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.currentshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Current shift DropDown");
			Thread.sleep(5000);
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
			usablemethods.addPageLoadTimeout();
			Thread.sleep(5000);
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.previousshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Previous Shift DropDown");
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.currentshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Current shift DropDown");
			Thread.sleep(5000);
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
			usablemethods.addPageLoadTimeout();
			Thread.sleep(5000);
			usablemethods.gClick(PactivLogin.report_toast);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.previousshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Previous Shift DropDown");
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.currentshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Current shift DropDown");
			Thread.sleep(5000);
		} else {
			usablemethods.addPageLoadTimeout();
			Thread.sleep(5000);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.previousshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Previous Shift DropDown");
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the shift DropDown");
			usablemethods.gClick(ControlTower.currentshift_dropdownvalue);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on the Current shift DropDown");
			Thread.sleep(5000);
		}
	}

	@Then("^User selects the dropdown value in Column Two$")
	public void user_selects_the_dropdown_value_in_Column_Two() throws Throwable {
		usablemethods.gClick(ControlTower.column2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Dropdown is clicked");
		String DropDownValue2 = usablemethods.gWebElementGetText(ControlTower.column2_dropdownvalue2);
		usablemethods.gClick(ControlTower.column2_dropdownvalue2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 2:" + DropDownValue2);
		usablemethods.gClick(ControlTower.column2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Dropdown is clicked");
//		String DropDownValue1=usablemethods.gWebElementGetText(ControlTower.column2_dropdownvalue1);
//		usablemethods.gClick(ControlTower.column2_dropdownvalue1);
//		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropDownValue1);
		usablemethods.gClick(ControlTower.column2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Dropdown is clicked");
		String DropDownValue3 = usablemethods.gWebElementGetText(ControlTower.column2_dropdownvalue3);
		usablemethods.gClick(ControlTower.column2_dropdownvalue3);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 3:" + DropDownValue3);
		usablemethods.gClick(ControlTower.column2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Dropdown is clicked");
		String DropDownValue4 = usablemethods.gWebElementGetText(ControlTower.column2_dropdownvalue4);
		usablemethods.gClick(ControlTower.column2_dropdownvalue4);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 4:" + DropDownValue4);
		usablemethods.gClick(ControlTower.column2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Dropdown is clicked");
		String DropDownValue5 = usablemethods.gWebElementGetText(ControlTower.column2_dropdownvalue5);
		usablemethods.gClick(ControlTower.column2_dropdownvalue5);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 5:" + DropDownValue5);
	}

	@Then("^User selects the second dropdown value in Column Two$")
	public void user_selects_the_second_dropdown_value_in_Column_Two() throws Throwable {
		usablemethods.gClick(ControlTower.column2filter2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Filter 2 is clicked");
		String DropDownValue1 = usablemethods.gWebElementGetText(ControlTower.column2filter2_dropdownvalue1);
		usablemethods.gClick(ControlTower.column2filter2_dropdownvalue1);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropDownValue1);
		usablemethods.gClick(ControlTower.column2filter2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Filter 2 is clicked");
		String DropDownValue2 = usablemethods.gWebElementGetText(ControlTower.column2filter2_dropdownvalue2);
		usablemethods.gClick(ControlTower.column2filter2_dropdownvalue2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 2:" + DropDownValue2);
		usablemethods.gClick(ControlTower.column2filter2_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Column 2 Filter 2 is clicked");
		String DropDownValue3 = usablemethods.gWebElementGetText(ControlTower.column2filter2_dropdownvalue3);
		usablemethods.gClick(ControlTower.column2filter2_dropdownvalue3);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 3:" + DropDownValue3);
	}

	@Then("^User verify the title Blend Change Events in Column Two$")
	public void user_verify_the_title_Blend_Change_Events_in_Column_Two() throws Throwable {
		String blendchangevents_title = usablemethods.gWebElementGetText(ControlTower.blendchangeevents_header);
		TestResultsUtils.logger.log(LogStatus.PASS, "The title displayed in Column Two is:" + blendchangevents_title);
	}

	@Then("^User verify the title Blend Alarms in Column Two$")
	public void user_verify_the_title_Blend_Alarms_in_Column_Two() throws Throwable {
		String blendalarms_title = usablemethods.gWebElementGetText(ControlTower.blendalarms_header);
		TestResultsUtils.logger.log(LogStatus.PASS, "The header displayed in Column Two is:" + blendalarms_title);
	}

	@Then("^User Clicks on Production Insights in Column Three$")
	public void user_Clicks_on_Production_Insights_in_Column_Three() throws Throwable {
		usablemethods.gClick(ControlTower.productioninsights_header1);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Production Insights in Column Three");
	}

	@Then("^user selects the dropdown value in Column One$")
	public void user_selects_the_dropdown_value_in_Column_One() throws Throwable {
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown");
		String DropdownValue1 = usablemethods.gWebElementGetText(ControlTower.pt_column1_dropdownvalue1);
		usablemethods.gClick(ControlTower.pt_column1_dropdownvalue1);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropdownValue1);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown");
		String DropdownValue2 = usablemethods.gWebElementGetText(ControlTower.pt_column1_dropdownvalue2);
		usablemethods.gClick(ControlTower.pt_column1_dropdownvalue2);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropdownValue2);
		usablemethods.gClick(ControlTower.column1_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown");
		String DropdownValue3 = usablemethods.gWebElementGetText(ControlTower.pt_column1_dropdownvalue3);
		usablemethods.gClick(ControlTower.pt_column1_dropdownvalue3);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on DropDown value 1:" + DropdownValue3);

	}

	@Then("^User Clicks on Line Assignment button$")
	public void user_Clicks_on_Line_Assignment_button() throws Throwable {
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
			usablemethods.gClick(PactivLogin.alarm_toast);
			usablemethods.gClick(ControlTower.line_assignment);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on line assignment");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			usablemethods.gClick(ControlTower.line_assignment);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on line assignment");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
			usablemethods.gClick(PactivLogin.report_toast);
			usablemethods.gClick(ControlTower.line_assignment);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on line assignment");
		} else {
			usablemethods.gClick(ControlTower.line_assignment);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on line assignment");
		}

	}

	@Then("^User selects the floater to assign all lines$")
	public void user_selects_the_floater_to_assign_all_lines() throws Throwable {
		List<WebElement> floater = LocalDriverManager.getDriver()
				.findElements(By.xpath("//div[contains(@id,'shiftFloaters')]//span[2]"));
		for (WebElement we : floater) {
			String floaterName = we.getText();
			we.click();
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on shift floater initials: " + floaterName);
			List<WebElement> assignsAll = LocalDriverManager.getDriver().findElements(
					By.xpath("//div[contains(@id,'shiftFloaters')]//span[3]/span[contains(text(),'Assign All')]"));
			for (WebElement assign : assignsAll) {
				assign.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Assign All button");
				List<WebElement> Close = LocalDriverManager.getDriver().findElements(
						By.xpath("//div[contains(@id,'shiftFloaters')]//span[3]/span[contains(text(),'Close')]"));
				for (WebElement close : Close) {
					if (close.isDisplayed()) {
						close.click();
						TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Close button");
					}
				}
			}
		}
	}

	@Then("^User Assigns all Lines$")
	public void user_Assigns_all_Lines() throws Throwable {

	}

	@Then("^User verify all lines are assigned$")
	public void user_verify_all_lines_are_assigned() throws Throwable {

	}

	@Then("^User Clicks on Clear All$")
	public void user_Clicks_on_Clear_All() throws Throwable {

	}

	@Then("^User Clicks on Few lines$")
	public void user_Clicks_on_Few_lines() throws Throwable {

	}

	@Then("^User verify few lines are assigned$")
	public void user_verify_few_lines_are_assigned() throws Throwable {

	}

}
