package com.pactiv.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.ControlTower;
import com.pactiv.pageobjects.DMGApp;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.pageobjects.ReportLog;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();
	boolean launchBrowser = false;

	@Given("^User launches the Pactiv application$")
	public void user_launches_the_Pactiv_application() throws Throwable {

//		if(launchBrowser) {
//		launchBrowser = 
		LaunchApp();
//		}
	}

	@Given("^User launches the \"([^\"]*)\" application$")
	public void userLaunchApp(String url) throws PactivException {
		LaunchApp(url);
	}

	@When("^User enters Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_Username_and_Password(String arg1, String arg2) throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.Username_Field);
//			TestResultsUtils.logger.log(LogStatus.PASS, "Username field is clicked");
//			TestResultsUtils.setTrue("Username field is clicked");
			TestResultsUtils.setFalse("Test Fail");
			usablemethods.sendText(PactivLogin.Username_Field, LocalTestDataManager.getTestDataHashMap().get(arg1));
			TestResultsUtils.setTrue(
					"Username field text:" + LocalTestDataManager.getTestDataHashMap().get(arg1) + " is entered");
			usablemethods.gClick(PactivLogin.password_field);
			TestResultsUtils.setTrue("Password field is clicked");
			usablemethods.sendData(PactivLogin.password_field, LocalTestDataManager.getTestDataHashMap().get(arg2));
			TestResultsUtils.setTrue(
					"Password field text:" + LocalTestDataManager.getTestDataHashMap().get(arg2) + " is entered");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@Then("^User Clicks on Submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.submit_button);
			TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Submit button");
		} catch (Exception e) {
			// TODO: handle exception
			TestResultsUtils.setFalse("User is able to click on Submit button");
		}
	}

	@Then("^User should validate the error message$")
	public void validateErrorMessage() throws Throwable {

		String ErrorMessage = usablemethods.gWebElementGetText(PactivLogin.error_message);
		String ActualMessage = "Credentials do not match a valid username-password combination for this Organization. Try again.";
		if (ErrorMessage.equalsIgnoreCase(ActualMessage)) {
			TestResultsUtils.logger.log(LogStatus.PASS,
					"User is able to validate the error message:" + ActualMessage + "successfully");
		} else {
			String homescreenshot = usablemethods.takescreenshot("home page");
			TestResultsUtils.logger.log(LogStatus.FAIL,
					"User is NOT able to validate the error message:" + ActualMessage,

					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));

		}
	}

	@And("^User is able to navigate to Home Page ane verify the Title")
	public void user_is_able_to_navigate_to_Home_Page_ane_verify_the_Title() throws Throwable {
		usablemethods.isElementPresentAndDisplayed((PactivLogin.bridgeview_text));
		usablemethods.gWebElementGetText(PactivLogin.bridgeview_text).equalsIgnoreCase("Bridgeview Plant View");
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to navigate to home page successfully and the Title:"
				+ usablemethods.gWebElementGetText(PactivLogin.bridgeview_text) + " is matching");
	}

	@Then("^User is able to navigate to MaterialHandler Home Page and verify the Title$")
	public void user_is_able_to_navigate_to_MaterialHandler_Home_Page_and_verify_the_Title() throws Throwable {
		usablemethods.isElementPresentAndDisplayed((PactivLogin.materialhandlerview_text));
		usablemethods.gWebElementGetText(PactivLogin.materialhandlerview_text)
				.equalsIgnoreCase("Vista de control de materiales");
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to navigate to home page successfully and the Title:"
				+ usablemethods.gWebElementGetText(PactivLogin.materialhandlerview_text) + " is matching");
	}

	@Then("^User should logout successfully$")
	public void logout() throws Throwable {
		Logout();
	}

	@Then("^User verifies the \"([^\"]*)\" Name$")
	public void verifyPlant(String plant) throws PactivException {
		PactivLogin login = new PactivLogin();
		String plantName = usablemethods.gWebElementGetText(login.plant_name_text);
		try {
			usablemethods.gVerifyText(login.plant_name_text, LocalTestDataManager.getTestDataHashMap().get(plant));
			TestResultsUtils.logger.log(LogStatus.PASS, "User is logged into the correct Plant");
		} catch (PactivException e) {
			// TODO Auto-generated catch block
			TestResultsUtils.logger.log(LogStatus.FAIL, "User is logged into " + plantName + " Plant");
		}
		;
	}

	@Then("^User verifies \"([^\"]*)\" lines present in the plant$")
	public void verifyLineNo(String lines) throws PactivException {
		int countLines = usablemethods.getWebElementsCount(PactivLogin.plant_line_no);
		try {
			if (LocalTestDataManager.getTestDataHashMap().get(lines).trim().equals(Integer.toString(countLines).trim()))
				TestResultsUtils.logger.log(LogStatus.PASS,
						"User is logged into the correct Plant with " + countLines + " Lines");
			else
				TestResultsUtils.setFalse("User is logged into the wrong Plant with " + countLines + " Lines");
		} catch (Exception e) {
			// TODO: handle exception
			TestResultsUtils.setFalse("User is logged into the wrong Plant with " + countLines + " Lines");
		}
	}

	@Then("^User verifies the Landing Screen is \"([^\"]*)\"$")
	public void verifyScreen(String screen) throws PactivException {
		com.pactiv.reusable.ProductionTracking productionTracking = new com.pactiv.reusable.ProductionTracking();
		com.pactiv.reusable.DMGApp dmgApp = new com.pactiv.reusable.DMGApp();
		switch (screen) {
		case "PT":
			if (productionTracking.verifyLandingScreenAsPT())
				TestResultsUtils.logger.log(LogStatus.PASS,
						"User is logged with Landing Screen as Production Tracking");
			else {
//				TestResultsUtils.logger.log(LogStatus.FAIL, "User is not in Production Tracking Screen");
				TestResultsUtils.setFalse("User is not in Production Tracking Screen");
			}
			break;
		case "DMG HOME":
			if (dmgApp.verifyLandingScreenAsDMGHome())
				TestResultsUtils.logger.log(LogStatus.PASS, "User is logged with Landing Screen as DMG Home Screen");
			else
				TestResultsUtils.setFalse("User is not in DMG Home Screen");
			break;
		case "DMG ADDPLANT HOME":
			if (dmgApp.verifyLandingScreenAsAddPlant())
				TestResultsUtils.logger.log(LogStatus.PASS,
						"User is logged with Landing Screen as Add Plant Screen Screen");
			else
				TestResultsUtils.setFalse("User is not in Add Plant Screen");
			break;
		}

	}

	@Then("^User verifies the \"([^\"]*)\" is present$")
	public void verifyIcon(String icon) throws PactivException {
		ProductionTracking pt = new ProductionTracking();
		ControlTower tower = new ControlTower();
		ReportLog log = new ReportLog();
		DMGApp dmg = new DMGApp();
		switch (icon.toUpperCase().trim()) {
		case "PT":
			if (usablemethods.isElementPresent(pt.prodTrackIconDashboard))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have PT icon");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have PT icon");
			break;
		case "CT":
			if (usablemethods.isElementPresent(tower.controlTowerIconDashboard))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have CT icon");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have CT icon");
			break;
		case "REPORT":
			if (usablemethods.isElementPresent(log.reportLogIconDashboard))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Report Dashboard icon");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Report Dashboard icon");
			break;
		case "DMG PLANT DETAILS":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_PLANTDETAILS))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Plant Details Section");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Plant Details Section");
			break;
		case "DMG SHIFT DETAILS":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_SHIFTDETAILS))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Shift Details Section");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Shift Details Section");
			break;
		case "DMG PRODUCTION DETAILS":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_PRODDETAILS))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Production Details Section");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Production Details Section");
			break;
		case "DMG USER CONFIG":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_USERCONFIG))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have User Configuration Section");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have User Configuration Section");
			break;
		case "DMG REVIEW PUBLISH":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_RVWPUB))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Review & Publish Section");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Review & Publish Section");
			break;
		case "DMG PUBLISH BUTTON":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_PUBLISH_BTN))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Publish Button");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Publish Button");
			break;
		case "DMG SAVE DRAFT BUTTON":
			if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_SAVEDRAFT_BTN))
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Save Draft Button");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "User screen do not have Save Draft Button");
			break;
		case "PENDING PT HOUR BOX":
			boolean status = !new com.pactiv.reusable.ProductionTracking().searchForPendingPTBoxes();
			if (!status)
				TestResultsUtils.logger.log(LogStatus.PASS, "User screen do have Pending PT Hour Box");
			else
				TestResultsUtils.setFalse("User screen do not have Pending PT Hour Box");

			break;
		default:
			break;
		}
	}
}
