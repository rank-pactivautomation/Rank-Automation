package com.moursville.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MvrLoginStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();
//	ProductionTracking ProductionTracking = new ProductionTracking();


	@Given("^User launches the Moursville application$")
	public void user_launches_the_Moursville_application() throws Throwable {

		LaunchApp();
	}
	
	
	/* Once Application is launched Entering the User Name and Password*/

	@When("^User enters moursville Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_Username_and_Password(String arg1, String arg2) throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.Username_Field);
			TestResultsUtils.logger.log(LogStatus.PASS, "Username field is clicked");
			usablemethods.sendText(PactivLogin.Username_Field, LocalTestDataManager.getTestDataHashMap().get(arg1));
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Username field text:" + LocalTestDataManager.getTestDataHashMap().get(arg1) + " is entered");
			usablemethods.gClick(PactivLogin.password_field);
			TestResultsUtils.logger.log(LogStatus.PASS, "Password field is clicked");
			usablemethods.sendData(PactivLogin.password_field, LocalTestDataManager.getTestDataHashMap().get(arg2));
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Password field text:" + LocalTestDataManager.getTestDataHashMap().get(arg2) + " is entered");
		} catch (PactivException e) {
			e.getMessage();
		}
	}
	
	
	/* clicking on submit button */
	
	@Then("^User Clicks on the moursville Submit button$")
	public void user_clicks_on_moursville_submit_button() throws Throwable {
		usablemethods.gClick(PactivLogin.submit_button);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Submit button");	
		
	}
	
	/* User logs out of the application */
	
	@Then("^User should logout successfully from Mooresville$")
	public void logout() throws Throwable {
		Logout();	
}
}

