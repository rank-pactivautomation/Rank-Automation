package com.pactiv.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.ControlTower;
import com.pactiv.pageobjects.LineView;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.UploadProcessSheet;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.When;

public class LineViewStepDefinition extends TestDataUtils {
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@When("^User verify the assets in the Line view$")
	public void user_verify_the_assets_in_the_Line_view() throws Throwable {
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
			usablemethods.addPageLoadTimeout();
			usablemethods.gClick(PactivLogin.alarm_toast);
		List<WebElement> line = LocalDriverManager.getDriver().findElements(By.xpath(
				"//div[contains(@class,'objbox')]//td[contains(@class,'twdhtmlxcell')]/div[contains(text(),'LINE')]"));
		for (WebElement we : line) {
			usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
			String line_number=we.getText();
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown" + ":LINE" + line_number);
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			we.click();
			String blenderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + blenderAsset);
			String extruderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_extruderasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + extruderAsset);
			String hauloffAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_hauloffasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + hauloffAsset);
			String thermoformerAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + thermoformerAsset);
			String trimpressAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + trimpressAsset);
			String grinderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
			TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + grinderAsset);
			}
		}
		else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
			usablemethods.addPageLoadTimeout();
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			List<WebElement> line = LocalDriverManager.getDriver().findElements(By.xpath(
					"//div[contains(@class,'objbox')]//td[contains(@class,'twdhtmlxcell')]/div[contains(text(),'LINE')]"));
			for (WebElement we : line) {
				usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
				String line_number=we.getText();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown" + ":LINE" + line_number);
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				we.click();
				String blenderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + blenderAsset);
				String extruderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_extruderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + extruderAsset);
				String hauloffAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_hauloffasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + hauloffAsset);
				String thermoformerAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + thermoformerAsset);
				String trimpressAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + trimpressAsset);
				String grinderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + grinderAsset);
				}
			}
		else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
			usablemethods.addPageLoadTimeout();
			usablemethods.gClick(PactivLogin.report_toast);
			usablemethods.gClick(ControlTower.shiftdropdown_icon);
			List<WebElement> line = LocalDriverManager.getDriver().findElements(By.xpath(
					"//div[contains(@class,'objbox')]//td[contains(@class,'twdhtmlxcell')]/div[contains(text(),'LINE')]"));
			for (WebElement we : line) {
				usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
				String line_number=we.getText();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown" + ":LINE" + line_number);
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				we.click();
				String blenderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + blenderAsset);
				String extruderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_extruderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + extruderAsset);
				String hauloffAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_hauloffasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + hauloffAsset);
				String thermoformerAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + thermoformerAsset);
				String trimpressAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + trimpressAsset);
				String grinderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + grinderAsset);
				}
		}
		else {
			List<WebElement> line = LocalDriverManager.getDriver().findElements(By.xpath(
					"//div[contains(@class,'objbox')]//td[contains(@class,'twdhtmlxcell')]/div[contains(text(),'LINE')]"));
			WebDriverWait wait=new WebDriverWait(LocalDriverManager.getDriver(),10);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'objbox')]//td[contains(@class,'twdhtmlxcell')]/div[contains(text(),'LINE')]")));
			for (WebElement we : line) {
				usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
				String line_number=we.getText();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown" + ":LINE" + line_number);
				Thread.sleep(5000);
//				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				we.click();
				String blenderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + blenderAsset);
				String extruderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_extruderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + extruderAsset);
				String hauloffAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_hauloffasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + hauloffAsset);
				String thermoformerAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + thermoformerAsset);
				String trimpressAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + trimpressAsset);
				String grinderAsset = usablemethods.gWebElementGetText(LineView.linegraphicalview_blenderasset);
				TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed:" + grinderAsset);
				}
		}
	}

	@When("^User verify the asset abridged view data for Blender Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Blender_Asset() throws Throwable {
		usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
		usablemethods.gClick(LineView.line13_breadcrumbview);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line 13 dropdown value");
		usablemethods.gClick(LineView.linegraphicalview_blenderasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Blender Asset is clicked");
		String blender = usablemethods.gWebElementGetText(LineView.assetabridgedview_blender);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + blender);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
//		usablemethods.isElementPresentAndDisplayed(LineView.assetabridgedview_alarmsvalue);
//		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
//		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
//		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}
	
	@When("^User verify the asset abridged view data for Extruder Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Extruder_Asset() throws Throwable {
		usablemethods.gClick(LineView.linegraphicalview_extruderasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Extruder Asset is clicked");
		String extruder = usablemethods.gWebElementGetText(LineView.assetabridgedview_extruder);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + extruder);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
//		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
//		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
//		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}

	@When("^User verify the asset abridged view data for Haul off Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Haul_off_Asset() throws Throwable {
		usablemethods.gClick(LineView.linegraphicalview_hauloffasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Haul Off Asset is clicked");
		String hauloff = usablemethods.gWebElementGetText(LineView.assetabridgedview_hauloff);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + hauloff);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
//		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
//		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
//		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}

	@When("^User verify the asset abridged view data for Thermoformer Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Thermoformer_Asset() throws Throwable {
		usablemethods.gClick(LineView.linegraphicalview_thermoformerasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Thermoformer Asset is clicked");
		String thermoformer = usablemethods.gWebElementGetText(LineView.assetabridgedview_thermoformer);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + thermoformer);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
//		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
//		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}

	@When("^User verify the asset abridged view data for Trim Press Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Trim_Press_Asset() throws Throwable {
		usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
		usablemethods.gClick(LineView.line13_breadcrumbview);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line 13 dropdown value");
		usablemethods.gClick(LineView.linegraphicalview_trimpressasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Trim Press Asset is clicked");
		String trimpress = usablemethods.gWebElementGetText(LineView.assetabridgedview_trimpress);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + trimpress);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}

	@When("^User verify the asset abridged view data for Grinder Asset$")
	public void user_verify_the_asset_abridged_view_data_for_Grinder_Asset() throws Throwable {
		usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
		usablemethods.gClick(LineView.line13_breadcrumbview);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line 13 dropdown value");
		usablemethods.gClick(LineView.linegraphicalview_grinderasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Grinder Asset is clicked");
		String grinder = usablemethods.gWebElementGetText(LineView.assetabridgedview_grinder);
		TestResultsUtils.logger.log(LogStatus.PASS, "Asset displayed in asset abridged view:" + grinder);
		String alarms_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarms);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Text is displayed:" + alarms_text);
		String alarms_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_alarmsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Alarm Value is displayed:" + alarms_value);
		String warnings_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_warnings);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Text is displayed:" + warnings_text);
		String warnings_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_warningsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Warning Value is displayed:" + warnings_value);
		String setpoints_text = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpoints);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Text is displayed:" + setpoints_text);
		String setpoints_value = usablemethods.gWebElementGetText(LineView.assetabridgedview_setpointsvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Set Points Value is displayed:" + setpoints_value);
	}

}
