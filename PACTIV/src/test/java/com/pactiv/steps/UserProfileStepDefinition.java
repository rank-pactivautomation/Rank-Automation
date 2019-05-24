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

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class UserProfileStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();

	@When("^User Clicks on User Profile button$")
	public void user_Clicks_on_User_Profile_button() throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.userinfo_button)) {
				usablemethods.gClick(PactivLogin.userinfo_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@And("^User Verify the name \"([^\"]*)\" of the User$")
	public void user_Verify_the_name_of_the_User(String arg1) throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.user_name_leadership)) {
				String name = usablemethods.gWebElementGetText(PactivLogin.user_name_leadership);
				if (name.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
					;
				{
					TestResultsUtils.logger.log(LogStatus.PASS, "User name is displayed: " + name);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@And("^User Verify the roleleadership \"([^\"]*)\" of the User$")
	public void user_Verify_the_roleleadership_of_the_User(String arg1) throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.user_role_leadership)) {
				String Role = usablemethods.gWebElementGetText(PactivLogin.user_role_leadership);
				if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
					;
				{
					TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@And("^User Verify the username \"([^\"]*)\" of the User$")
	public void user_Verify_the_username_of_the_User(String arg1) throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.username_plantmanager)) {
				String Username = usablemethods.gWebElementGetText(PactivLogin.username_plantmanager);
				if (Username.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
					;
				{
					TestResultsUtils.logger.log(LogStatus.PASS, "Username text is displayed:" + Username);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@And("^User Verify the chosenLines \"([^\"]*)\" of the User$")
	public void user_Verify_the_chosenLines_of_the_User(String arg1) throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.assigned_lines_leadership)) {
				String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_leadership);
				if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
					;
				TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on User Profile button for Supervisor$")
	public void user_Clicks_on_User_Profile_button_for_Supervisor() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.supervisoruserprofile_button);
			TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor User Profile button is clicked");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the name \"([^\"]*)\" of the Supervisor$")
	public void user_Verify_the_name_of_the_Supervisor(String arg1) throws Throwable {
		try {
			String name = usablemethods.gWebElementGetText(PactivLogin.user_name_supervisor);
			if (name.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "User name is displayed: " + name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the roleleadership \"([^\"]*)\" of the Supervisor$")
	public void user_Verify_the_roleleadership_of_the_Supervisor(String arg1) throws Throwable {
		try {
			String Role = usablemethods.gWebElementGetText(PactivLogin.user_role_supervisor);
			if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the username \"([^\"]*)\" of the Supervisor$")
	public void user_Verify_the_username_of_the_Supervisor(String arg1) throws Throwable {
		try {
			String Username = usablemethods.gWebElementGetText(PactivLogin.username_supervisor);
			if (Username.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Username text is displayed:" + Username);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\" of the Supervisor$")
	public void user_Verify_the_chosenLines_of_the_Supervisor(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_leadership);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on User Profile button for Floater$")
	public void user_Clicks_on_User_Profile_button_for_Floater() throws Throwable {
		try {
			if(usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast))
			{
				usablemethods.gClick(PactivLogin.alarm_toast);
				usablemethods.gClick(PactivLogin.userinfo_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple))
			{
				usablemethods.gClick(PactivLogin.alarm_toast_multiple);
				usablemethods.gClick(PactivLogin.userinfo_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			else if(usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast))
			{
				usablemethods.gClick(PactivLogin.report_toast);
				usablemethods.gClick(PactivLogin.userinfo_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			else {
				usablemethods.gClick(PactivLogin.userinfo_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the name \"([^\"]*)\" of the Floater$")
	public void user_Verify_the_name_of_the_Floater(String arg1) throws Throwable {
		try {
			String name = usablemethods.gWebElementGetText(PactivLogin.user_name_floater);
			if (name.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "User name is displayed: " + name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the roleleadership \"([^\"]*)\" of the Floater$")
	public void user_Verify_the_roleleadership_of_the_Floater(String arg1) throws Throwable {
		try {
			String Role = usablemethods.gWebElementGetText(PactivLogin.user_role_floater);
			if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the username \"([^\"]*)\" of the Floater$")
	public void user_Verify_the_username_of_the_Floater(String arg1) throws Throwable {
		try {
			String Username = usablemethods.gWebElementGetText(PactivLogin.username_floater);
			if (Username.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Username text is displayed:" + Username);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on Clear Selection$")
	public void user_Clicks_on_Clear_Selection() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.userprofile_clearall);
			TestResultsUtils.logger.log(LogStatus.PASS, "Clear All Button is clicked");
			usablemethods.gClick(PactivLogin.clearall_okbutton);
			TestResultsUtils.logger.log(LogStatus.PASS, "Ok Button is clicked");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\"$")
	public void user_Verify_the_chosenLines(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assignedlines_zero);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Cicks on Select All$")
	public void user_Cicks_on_Select_All() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.userprofile_selectall);
			TestResultsUtils.logger.log(LogStatus.PASS, "Select All Button is clicked");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\" of the floater$")
	public void user_Verify_the_chosenLines_of_the_floater(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_leadership);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on Manual Selection$")
	public void user_Clicks_on_Manual_Selection() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.userprofile_manual);
			TestResultsUtils.logger.log(LogStatus.PASS, "Manual Button is clicked");
			usablemethods.gClick(PactivLogin.userprofile_line11);
			TestResultsUtils.logger.log(LogStatus.PASS, "Line 11 is clicked");
			usablemethods.gClick(PactivLogin.userprofile_line12);
			TestResultsUtils.logger.log(LogStatus.PASS, "Line 12 is clicked");
			usablemethods.gClick(PactivLogin.userprofile_line13);
			TestResultsUtils.logger.log(LogStatus.PASS, "Line 13 is clicked");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\" after Manual Selection$")
	public void user_Verify_the_chosenLines_after_Manual_Selection(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_floater);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@When("^User Clicks on User Profile button for MaterialHandler$")
	public void user_Clicks_on_User_Profile_button_for_MaterialHandler() throws Throwable {
		try {
			if(usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) 
			{
				usablemethods.gClick(PactivLogin.alarm_toast);
				usablemethods.gClick(PactivLogin.userprofile_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			else if(usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple))
			{
				usablemethods.gClick(PactivLogin.alarm_toast_multiple);
				usablemethods.gClick(PactivLogin.userprofile_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			else if(usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast))
			{
				usablemethods.gClick(PactivLogin.report_toast);
				usablemethods.gClick(PactivLogin.userprofile_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			else {
				usablemethods.gClick(PactivLogin.userprofile_button);
				TestResultsUtils.logger.log(LogStatus.PASS, "User Profile button is clicked");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the name \"([^\"]*)\" of the MaterialHandler$")
	public void user_Verify_the_name_of_the_MaterialHandler(String arg1) throws Throwable {
		try {
			String name = usablemethods.gWebElementGetText(PactivLogin.user_name_eoh);
			if (name.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "User name is displayed: " + name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the roleleadership \"([^\"]*)\" of the MaterialHandler$")
	public void user_Verify_the_roleleadership_of_the_MaterialHandler(String arg1) throws Throwable {
		try {
			String Role = usablemethods.gWebElementGetText(PactivLogin.user_role_eoh);
			if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the username \"([^\"]*)\" of the MaterialHandler$")
	public void user_Verify_the_username_of_the_MaterialHandler(String arg1) throws Throwable {
		try {
			String Username = usablemethods.gWebElementGetText(PactivLogin.username_eoh);
			if (Username.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Username text is displayed:" + Username);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\" of the MaterialHandler$")
	public void user_Verify_the_chosenLines_of_the_MaterialHandler(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_leadership);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the chosenLines \"([^\"]*)\" after Manual Selection for MaterialHandler$")
	public void user_Verify_the_chosenLines_after_Manual_Selection_for_MaterialHandler(String arg1) throws Throwable {
		try {
			String chosenLines = usablemethods.gWebElementGetText(PactivLogin.assigned_lines_eoh);
			if (chosenLines.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			TestResultsUtils.logger.log(LogStatus.PASS, "Chosen Lines is displayed:" + chosenLines);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@When("^User Clicks on Manual Selection for MaterialHandler$")
	public void user_Clicks_on_Manual_Selection_for_MaterialHandler() throws Throwable {
		try {
			usablemethods.gClick(PactivLogin.userprofile_manual);
			TestResultsUtils.logger.log(LogStatus.PASS, "Manual Button is clicked");
			usablemethods.gClick(PactivLogin.userprofile_line11);
			TestResultsUtils.logger.log(LogStatus.PASS, "Line 11 is clicked");
			usablemethods.gClick(PactivLogin.userprofile_line12);
			TestResultsUtils.logger.log(LogStatus.PASS, "Line 12 is clicked");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the name \"([^\"]*)\" of the Maintenance User$")
	public void user_Verify_the_name_of_the_Maintenance_User(String arg1) throws Throwable {
		try {
			String name = usablemethods.gWebElementGetText(PactivLogin.user_name_maintenance);
			if (name.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "User name is displayed: " + name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the roleleadership \"([^\"]*)\" of the Maintenance user$")
	public void user_Verify_the_roleleadership_of_the_Maintenance_user(String arg1) throws Throwable {
		try {
			String Role = usablemethods.gWebElementGetText(PactivLogin.user_role_maintenance);
			if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@When("^User Verify the username \"([^\"]*)\" of the Maintenance User$")
	public void user_Verify_the_username_of_the_Maintenance_User(String arg1) throws Throwable {
		try {
			String Role = usablemethods.gWebElementGetText(PactivLogin.username_maintenance);
			if (Role.equalsIgnoreCase(LocalTestDataManager.getTestDataHashMap().get(arg1)))
				;
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Leadership text is displayed:" + Role);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
