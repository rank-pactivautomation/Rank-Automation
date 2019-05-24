package com.pactiv.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.DMGApp;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class DMGUserAppStep {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	DMGApp dmg = new DMGApp();

	@Then("^User clicks on the \"([^\"]*)\" Button$")
	public void user_clicks_on_the_something_button(String button) throws PactivException {
		switch (button) {
		case "Add Plant":
			if (usablemethods.gClick(dmg.DMG_ADDPLANT_BTN))
				TestResultsUtils.logger.log(LogStatus.PASS, "Add Plant Button is clicked");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "Add Plant Button is not clicked");
			break;
		case "Back":
			if (usablemethods.gClick(dmg.DMG_ADDPLANT_BACK_BTN))
				TestResultsUtils.logger.log(LogStatus.PASS, "Add Plant Button is clicked");
			else
				TestResultsUtils.logger.log(LogStatus.FAIL, "Add Plant Button is not clicked");
			break;

		default:
			break;
		}

	}
}