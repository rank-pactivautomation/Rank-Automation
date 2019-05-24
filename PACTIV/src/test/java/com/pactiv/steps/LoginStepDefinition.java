package com.pactiv.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.config.SeleniumNGSuite;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
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
	boolean launchBrowser = false;

	@Given("^User launches the Pactiv application$")
	public void user_launches_the_Pactiv_application() throws Throwable {

//		if(launchBrowser) {
				launchBrowser=LaunchApp();
//		}
	}

	@When("^User enters Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_Username_and_Password(String arg1, String arg2) throws Throwable {
		try {
		
				usablemethods.sendText(PactivLogin.Username_Field, LocalTestDataManager.getTestDataHashMap().get(arg1));
				TestResultsUtils.logger.log(LogStatus.PASS,
						"Username field text:" + LocalTestDataManager.getTestDataHashMap().get(arg1) + " is entered");
				usablemethods.sendData(PactivLogin.password_field, LocalTestDataManager.getTestDataHashMap().get(arg2));
				TestResultsUtils.logger.log(LogStatus.PASS,
						"Password field text:" + LocalTestDataManager.getTestDataHashMap().get(arg2) + " is entered");

			
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@Then("^User Clicks on Submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		
			usablemethods.gClick(PactivLogin.submit_button);
			TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Submit button");
		
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
}
