package com.pactiv.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class HeaderIconStepDefinition extends TestDataUtils{
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@Then("^User verify the title on Dashboard Page$")
	public void user_verify_the_title_on_Dashboard_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.bridgeview_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Dashboard Title is Displayed:" + text);

	}

	@Then("^User Clicks on Production Tracking Icon$")
	public void user_Clicks_on_Production_Tracking_Icon() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.production_icon_plant);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notification Icon");
	}

	@Then("^User verify the title on Production Tracking Page$")
	public void user_verify_the_title_on_Production_Tracking_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.productiontracking_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Production Tracking Title is Displayed:" + text);
	}

	@Then("^User Clicks on Activity Log Icon$")
	public void user_Clicks_on_Activity_Log_Icon() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.activity_icon_plant);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Activity Log Icon");
	}

	@Then("^User verify the title on Activity Log Page$")
	public void user_verify_the_title_on_Activity_Log_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.activitylog_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Activity Log Title is Displayed:" + text);
	}

	@Then("^User Clicks on Notifications Icon$")
	public void user_Clicks_on_Notifications_Icon() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.notifications_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notifications Icon");
	}

	@Then("^User verify the title on Notifications Page$")
	public void user_verify_the_title_on_Notifications_Page() throws Throwable {
		Thread.sleep(10000);
		String text = usablemethods.gWebElementGetText(PactivLogin.notifications_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Notifications Title is Displayed:" + text);
	}

	@Then("^User verify the title on User Profile Page$")
	public void user_verify_the_title_on_User_Profile_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.userprofile_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User Profile Title is Displayed:" + text);
	}

	@Then("^User Clicks on Report Icon$")
	public void user_Clicks_on_Report_Icon() throws Throwable {
		usablemethods.gClick(PactivLogin.reportlog_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Report Icon");
	}

	@Then("^User verify the title on Report Page$")
	public void user_verify_the_title_on_Report_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.reporttext_log);
		TestResultsUtils.logger.log(LogStatus.PASS, "Report Log Title is Displayed:" + text);
	}

	@Then("^User verify the title on Production Tracking Page for Supervisor$")
	public void user_verify_the_title_on_Production_Tracking_Page_for_Supervisor() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.productiontracking_text_supervisor);
		TestResultsUtils.logger.log(LogStatus.PASS, "Production Tracking Title is Displayed:" + text);
	}

	@Then("^User Clicks on Activity Log Icon for Maintenance$")
	public void user_Clicks_on_Activity_Log_Icon_for_Maintenance() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.activity_materialicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Activity Log Icon");
	}


	@Then("^User Clicks on Notifications Icon for Maintenance$")
	public void user_Clicks_on_Notifications_Icon_for_Maintenance() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.notification_materialicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notifications Icon");
	}
	@Then("^User Clicks on Activity Log Icon for Floater$")
	public void user_Clicks_on_Activity_Log_Icon_for_Floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.notification_materialicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Activity Log Icon");
	}

	@Then("^User Clicks on Notifications Icon for Floater$")
	public void user_Clicks_on_Notifications_Icon_for_Floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.activity_icon_plant);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notifications Icon");
	}

	@Then("^User Clicks on Report Icon for Floater$")
	public void user_Clicks_on_Report_Icon_for_Floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.notifications_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Report Log Icon");
	}
	@Then("^User Clicks on Production Tracking Icon for Floater$")
	public void user_Clicks_on_Production_Tracking_Icon_for_Floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.activity_materialicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Production Tracking Icon");
	}
	@Then("^User verify the title on Dashboard Page for MaterialHandler$")
	public void user_verify_the_title_on_Dashboard_Page_for_MaterialHandler() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.materialhandlerview_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Dashboard Title is Displayed:" + text);
	}

	@Then("^User verify the title on Activity Log Page for MaterialHandler$")
	public void user_verify_the_title_on_Activity_Log_Page_for_MaterialHandler() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.activity_text_materialhandler);
		TestResultsUtils.logger.log(LogStatus.PASS, "Activity Log Title is Displayed:" + text);
	}

	@Then("^User verify the title on Notifications Page for MaterialHandler$")
	public void user_verify_the_title_on_Notifications_Page_for_MaterialHandler() throws Throwable {
		Thread.sleep(10000);
		String text = usablemethods.gWebElementGetText(PactivLogin.notifications_text_materialhandler);
		TestResultsUtils.logger.log(LogStatus.PASS, "Notofications Title is Displayed:" + text);
	}

	




}
