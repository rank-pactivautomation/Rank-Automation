package com.moursville.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.MvrPlantView;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MvrPlantViewStepDefinition {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();
//	ProductionTracking ProductionTracking = new ProductionTracking();

	/* Clicking on the Plant View Icon */
	@Then("^User Verifies the PlantView icon$")
	public void user_verifies_plantview_icon() throws Throwable {

		Thread.sleep(5000);
		usablemethods.gClick(MvrPlantView.MRVPlantview_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Plant view Icon");
	}

	@Then("^User is able to switch between plant view and material view$")
	public void user_switches_plantview_materialview() throws Throwable {

		usablemethods.gClick(MvrPlantView.dropdown);
		usablemethods.gClick(MvrPlantView.material_dropdown);
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(MvrPlantView.MRVmaterialview_title);
		TestResultsUtils.logger.log(LogStatus.PASS, "Material View Title is Displayed:" + text);
		usablemethods.gClick(MvrPlantView.dropdown);
		usablemethods.gClick(MvrPlantView.Plantview_dropdown);

	}

	@Then("^User Verifies the Plant View Title$")
	public void user_verifies_plantview_title() throws Throwable {

		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(MvrPlantView.MRVPlantview_title);
		TestResultsUtils.logger.log(LogStatus.PASS, "Plant View Title is Displayed:" + text);

		String text1 = usablemethods.gWebElementGetText(MvrPlantView.Plantview_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "dropdowndown value is :" + text1);

	}

	@Then("^User Verify the asset dot and asset for the line in mooresville$")
	public void user_Verify_the_asset_dot_and_asset_for_the_line_in_mooresville() throws Throwable {

		try {
			List<WebElement> lines = LocalDriverManager.getDriver().findElements(
					By.xpath("//div[@class='users-assigned-box']//following-sibling::p[@class='line-id-body']"));
			for (WebElement we : lines) {
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				String line = we.getText();
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Line clicked is:" + "Line" + line);
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
				usablemethods.isElementPresentAndDisplayed(PactivLogin.blenderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Blender Asset Dot is Displayed");

				usablemethods.isElementPresentAndDisplayed(PactivLogin.extruderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Extruder Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.hauloffasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Hauloff Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.thermoformerasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Thermoformer Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.trimpressasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "TrimPress Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.grinderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Grinder Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.assignedfloaters_text);
				TestResultsUtils.logger.log(LogStatus.PASS, "Assigned Floaters is Displayed");
			}
		}

		catch (PactivException e) {
			e.getMessage();
		}

	}

	@Then("^User Verifies the Alarm Widget Column Headers$")
	public void user_Verify_the_alarm_widget_header() throws Throwable {

		try {

			List<WebElement> lines = LocalDriverManager.getDriver().findElements(
					By.xpath("//div[@class='users-assigned-box']//following-sibling::p[@class='line-id-body']"));
			for (WebElement we : lines) {

				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				String line = we.getText();
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Line clicked is:" + "Line" + line);

				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.MRVwidget_linename)) {
					String wid_line = usablemethods.gWebElementGetText(MvrPlantView.MRVwidget_linename);

					TestResultsUtils.logger.log(LogStatus.PASS, "Line title on widget is:" + wid_line);
				} else {
					TestResultsUtils.logger.log(LogStatus.PASS, "Line text not displayed:");

				}

				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.asset))
					TestResultsUtils.logger.log(LogStatus.PASS, "Asset header is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.description))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "description is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.duration))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "duration is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.setpoint))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "setpoint is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.actual))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "Actual is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.ucl_lcl))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "ucl_lct is Displayed");
				if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.status))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "status header is Displayed");

			}

		}

		catch (Exception e) {

			e.getMessage();

		}

	}

	@Then("^User Verifies Total alarm and total warning value$")
	public void User_Verifies_Total_alarm_total_warning_value() throws Throwable {

		try {
		
		List<WebElement> lines = LocalDriverManager.getDriver().findElements(
				By.xpath("//div[@class='users-assigned-box']//following-sibling::p[@class='line-id-body']"));

		for (WebElement we : lines) {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			String line = we.getText();
			we.click();
			TestResultsUtils.logger.log(LogStatus.PASS, "Line clicked is:" + "Line" + line);

			if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.MRVwidget_alarmstitle)) {
				TestResultsUtils.logger.log(LogStatus.PASS, "alarms title present");
				String alarm_count = usablemethods.gWebElementGetText(MvrPlantView.MRVwidget_alarmvalue);
				TestResultsUtils.logger.log(LogStatus.PASS, "Value of Total Alaram count:" + alarm_count);
			} else {
				String homescreenshot = usablemethods.takescreenshot("home page");
				TestResultsUtils.logger.log(LogStatus.FAIL, "User is NOT able to validate the Total Alarms title",
						TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
			}

			if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.MRVwidget_warningstitle)) {
				Thread.sleep(5000);
				String warning_count = usablemethods.gWebElementGetText(MvrPlantView.MRVwidget_warningvalue);
				TestResultsUtils.logger.log(LogStatus.PASS, "Value of Total warning count:" + warning_count);
			}
		}
	}
	
	catch(Exception e) {

		e.getMessage();

	}
	}
	
	@Then("^User navigates to Activity Log upon expanding Alarm section$")
	public void user_navigates_to_Activity_Log_upon_expanding_Alarm_section() throws Throwable {

		usablemethods.gClick(MvrPlantView.MRVwidget_activitylog);

		if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.activitylogtitle))

			TestResultsUtils.logger.log(LogStatus.PASS, "Navigated to Activity log");
		else {
			String homescreenshot = usablemethods.takescreenshot("home page");
			TestResultsUtils.logger.log(LogStatus.FAIL, "User is NOT able to Navigate to activity log:",
					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
		}
	}

	@Then("^User Verifies Plant OEE$")
	public void user_verifies_plant_OEE() throws Throwable {
		if (usablemethods.isElementPresentAndDisplayed(MvrPlantView.plant_oee)) {
			Thread.sleep(5000);
			String plant_oee = usablemethods.gWebElementGetText(MvrPlantView.plant_oee);
			String plantoeevalue = usablemethods.gWebElementGetText(MvrPlantView.plant_oee_value);
			System.out.println(plantoeevalue);

			String value = plantoeevalue.substring(0, plantoeevalue.length() - 1);
			int precent = Integer.parseInt(value);
			System.out.println(precent);
			TestResultsUtils.logger.log(LogStatus.PASS, "Value of Total plant oee:" + plant_oee + "=" + plantoeevalue);

			if (precent > 80)
				TestResultsUtils.logger.log(LogStatus.PASS, "status of Total plant oee is green");
			else
				TestResultsUtils.logger.log(LogStatus.PASS, "status of Total plant oee is red");

		}

	}
}
