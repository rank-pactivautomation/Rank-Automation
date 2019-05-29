package com.pactiv.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ReportLog;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class ReportPageStepDefinition {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@Then("^User verify the Line Level Reports Title on Report Page$")
	public void user_verify_the_Line_Level_Reports_Title_on_Report_Page() throws Throwable {
		String linelevelreports = usablemethods.gWebElementGetText(ReportLog.linelevelreports);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + linelevelreports);
	}

	@Then("^User verify Review & Submit Button is displayed$")
	public void user_verify_Review_Submit_Button_is_displayed() throws Throwable {
		usablemethods.isElementPresentAndDisplayed(ReportLog.reviewsubmit);
		TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is Displayed");
	}

	@Then("^User Clicks on Reveiw & Submit Button for first row$")
	public void user_Clicks_on_Reveiw_Submit_Button_for_first_row() throws Throwable {
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
			usablemethods.gClick(PactivLogin.alarm_toast);
			Thread.sleep(2000);
			usablemethods.gClick(ReportLog.reviewsubmit);
			TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			Thread.sleep(2000);
			usablemethods.gClick(ReportLog.reviewsubmit);
			TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
		} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
			usablemethods.gClick(PactivLogin.report_toast);
			Thread.sleep(2000);
			usablemethods.gClick(ReportLog.reviewsubmit);
			TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
		} else {
			usablemethods.gClick(ReportLog.reviewsubmit);
			TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
		}
	}

	@Then("^User verify Shift OEE text is displayed$")
	public void user_verify_Shift_OEE_text_is_displayed() throws Throwable {
		String shift_oee_text = usablemethods.gWebElementGetText(ReportLog.reportlog_shiftoee);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + shift_oee_text);
	}

	@Then("^User verify the values for Shift OEE$")
	public void user_verify_the_values_for_Shift_OEE() throws Throwable {
		String shift_oee_value = usablemethods.gWebElementGetText(ReportLog.reportlog_shiftoeevalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + shift_oee_value);
	}

	@Then("^User verify Cases Produced text is displayed$")
	public void user_verify_Cases_Produced_text_is_displayed() throws Throwable {
		String cases_value = usablemethods.gWebElementGetText(ReportLog.reportlog_cases);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + cases_value);
	}

	@Then("^User verify the values for Cases Produced$")
	public void user_verify_the_values_for_Cases_Produced() throws Throwable {
		String cases_value = usablemethods.gWebElementGetText(ReportLog.reportlog_casesvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + cases_value);
	}

	@Then("^User verify Total Downtime text is displayed$")
	public void user_verify_Total_Downtime_text_is_displayed() throws Throwable {
		String reportlog_downtime = usablemethods.gWebElementGetText(ReportLog.reportlog_downtime);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text displayed on Report Log Page is:" + reportlog_downtime);
	}

	@Then("^User verify the Total Downtime value is displayed$")
	public void user_verify_the_Total_Downtime_value_is_displayed() throws Throwable {
		String reportlog_downtimevalue = usablemethods.gWebElementGetText(ReportLog.reportlog_downtimevalue);
		TestResultsUtils.logger.log(LogStatus.PASS,
				"The text displayed on Report Log Page is:" + reportlog_downtimevalue);
	}

	@Then("^User Clicks on Manual Selection for floater$")
	public void user_Clicks_on_Manual_Selection_for_floater() throws Throwable {
		usablemethods.gClick(PactivLogin.userprofile_manual);
		TestResultsUtils.logger.log(LogStatus.PASS, "Manual Button is clicked");
		usablemethods.gClick(PactivLogin.userprofile_line10);
		TestResultsUtils.logger.log(LogStatus.PASS, "Line 2 is clicked");
	}

	@Then("^User sorts the reports by date filter$")
	public void user_sorts_the_reports_by_date_filter() throws Throwable {
		usablemethods.gClick(ReportLog.reportpage_date);
		TestResultsUtils.logger.log(LogStatus.PASS, "Date is sorted");
	}

	@Then("^User verify the incomplete reports$")
	public void user_verify_the_incomplete_reports() throws Throwable {
		List<WebElement> incomplete = LocalDriverManager.getDriver()
				.findElements(By.xpath("//span[contains(@class,'incomplete-button')]"));
		for (WebElement we : incomplete) {
//			String incompleteText = we.getText();
//			TestResultsUtils.logger.log(LogStatus.PASS, "Incomplete Text is displayed"+incompleteText);
			if (we.isDisplayed() == false) {
				WebElement review = LocalDriverManager.getDriver()
						.findElement(By.xpath("(//button[contains(text(),'Review & Submit')])[6]"));
				review.click();
				usablemethods.gClick(ReportLog.reportlog_submit);
			} else {
				WebElement review_complete = LocalDriverManager.getDriver().findElement(By.xpath(
						"//span[contains(@class,'incomplete-button')]//following::button[contains(text(),'Review & Submit')]"));
				review_complete.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Review&Submit button is clicked");
				List<WebElement> edit = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[contains(@id,'cell_ReportReviewCollectionV2_Mashup')]/img"));
				for (WebElement editButton : edit) {
					editButton.click();
					usablemethods.sendText(ReportLog.reportlog_actualcases_value, "10");
					usablemethods.gClick(ReportLog.reportlog_selectlevel1);
					WebElement asset_name = LocalDriverManager.getDriver()
							.findElement(By.xpath("(//div[contains(@class,'downtime-container')]//select)[1]/option[2]"));
							asset_name.click();
							usablemethods.gClick(ReportLog.reportlog_selectlevel2);
							WebElement level2_name = LocalDriverManager.getDriver().findElement(
									By.xpath("(//div[contains(@class,'downtime-container')]//select)[2]/option[2]"));
									level2_name.click();
									usablemethods.gClick(ReportLog.reportlog_selectlevel3);
									WebElement level3_name = LocalDriverManager.getDriver().findElement(By
											.xpath("(//div[contains(@class,'downtime-container')]//select)[3]/option[2]"));
											level3_name.click();
											usablemethods.gClick(ReportLog.reportlog_save);
										}
									}
								}
							}	
	}

