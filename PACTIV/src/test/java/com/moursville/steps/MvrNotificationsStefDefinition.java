package com.moursville.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.pageobjects.MvrMaterialControl;
import com.pactiv.pageobjects.MvrNotifications;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Then;

public class MvrNotificationsStefDefinition {
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	@Then("^User navigates to the Notifications page$")
	public void user_navigates_to_the_Notifications_page() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.activity_icon_plant);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notifications Icon");
	}

	@Then("^User verify the details on the Notifications page$")
	public void user_verify_the_details_on_the_Notifications_page() throws Throwable {
		String areatext = usablemethods.gWebElementGetText(MvrNotifications.area_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + areatext);
		String assettext = usablemethods.gWebElementGetText(MvrNotifications.asset_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + assettext);
		String descriptiontext = usablemethods.gWebElementGetText(MvrNotifications.description_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + descriptiontext);
		String starttimetext = usablemethods.gWebElementGetText(MvrNotifications.starttime_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + starttimetext);
		String durationtext = usablemethods.gWebElementGetText(MvrNotifications.duration_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + durationtext);
		String setpointtext = usablemethods.gWebElementGetText(MvrNotifications.setpoint_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + setpointtext);
		String actualtext = usablemethods.gWebElementGetText(MvrNotifications.actual_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + actualtext);
		String ucllcltext = usablemethods.gWebElementGetText(MvrNotifications.ucllcl_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + ucllcltext);
		String statustext = usablemethods.gWebElementGetText(MvrNotifications.status_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "The text field displayed is:" + statustext);
	}
}
