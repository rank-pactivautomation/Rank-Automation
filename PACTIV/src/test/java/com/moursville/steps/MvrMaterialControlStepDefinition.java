package com.moursville.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.BreadCrumb;
import com.pactiv.pageobjects.MvrMaterialControl;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class MvrMaterialControlStepDefinition extends TestDataUtils {
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();

	@Then("^User navigates to the Material Control View$")
	public void user_navigates_to_the_Material_Control_View() throws Throwable {
		usablemethods.gClick(BreadCrumb.breadcrumb_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Breadcrumb dropdown field is clicked");
		usablemethods.gClick(BreadCrumb.materialcontrolview_dropdownvalue);
		TestResultsUtils.logger.log(LogStatus.PASS, "Material Control View dropdown field is clicked");
	}

	@Then("^User clicks on expand icon on Alarms Warning section$")
	public void user_clicks_on_expand_icon_on_Alarms_Warning_section() throws Throwable {
		usablemethods.gClick(BreadCrumb.materialcontrolview_expandicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "Material Control View Expand Icon is clicked");
	}

	@Then("^User is navigated to Activity Log Page$")
	public void user_is_navigated_to_Activity_Log_Page() throws Throwable {
		usablemethods.gClick(PactivLogin.notification_materialicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Activity Log Icon");
	}

	@Then("^User verify the line dots \"([^\"]*)\" on Material Control View$")
	public void user_verify_the_line_dots_on_Material_Control_View(String arg1) throws Throwable {
		String line = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> line_number = LocalDriverManager.getDriver()
				.findElements(By.xpath("//*[@cellvalue='" + line + "']"));
		for (int i = 0; i <= line_number.size(); i++) {
			for (WebElement line_click : line_number) {
				line_click.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line:" + line);
			}

		}
	}

	@Then("^User verify the line number One on Material Control View$")
	public void user_verify_the_line_number_One_on_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 1");
	}

	@Then("^User verify the Asset Details on Material Control View$")
	public void user_verify_the_Asset_Details_on_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender1b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender1B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender1c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender1C");
		usablemethods.gClick(MvrMaterialControl.blender1d_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender1D");

	}

	@Then("^User verify the line number twelve in Material Control View$")
	public void user_verify_the_line_number_twelve_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line12_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 12");
	}

	@Then("^User verify the Asset Details for line twelve in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_twelve_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender12b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender12B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");		
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		
	}
	@Then("^User verify the line number thirteen in Material Control View$")
	public void user_verify_the_line_number_thirteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line13_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 13");
	}

	@Then("^User verify the Asset Details for line thirteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_thirteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender13b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender13B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");		
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
	}

	@Then("^User verify the line number fourteen in Material Control View$")
	public void user_verify_the_line_number_fourteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line14_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 14");
	}

	@Then("^User verify the Asset Details for line fourteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_fourteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender14b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender14B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");		
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender14c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender14C");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		String activetext = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + activetext);
	}

	@Then("^User verify the line number fifteen in Material Control View$")
	public void user_verify_the_line_number_fifteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line15_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 15");
	}

	@Then("^User verify the Asset Details for line fifteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_fifteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender15b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender15B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");		
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender15c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender15C");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		String activetext = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + activetext);
	}

	@Then("^User verify the line number sixteen in Material Control View$")
	public void user_verify_the_line_number_sixteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line16_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 16");
	}

	@Then("^User verify the Asset Details for line sixteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_sixteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender16b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender16B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		usablemethods.gClick(MvrMaterialControl.vacuumpump4_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 4");		
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender16c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender16C");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		String activetext = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + activetext);
		usablemethods.gClick(MvrMaterialControl.blender16c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender16C");
		String hoppertrain_text2 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text2);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		String activewarningtext = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + activewarningtext);
		usablemethods.gClick(MvrMaterialControl.blender16d_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender16D");
		String hoppertrain_text3 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text3);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		String activewarningtext1 = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + activewarningtext1);
		
	}

	@Then("^User verify the line number seventeen in Material Control View$")
	public void user_verify_the_line_number_seventeen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line17_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 17");
	}

	@Then("^User verify the Asset Details for line seventeen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_seventeen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender17b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender17B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
	}

	@Then("^User verify the line number eighteen in Material Control View$")
	public void user_verify_the_line_number_eighteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line18_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 18");
	}

	@Then("^User verify the Asset Details for line eighteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_eighteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender18b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender18B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender18c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender18C");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		String text1 = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text1);
	}

	@Then("^User verify the line number nineteen in Material Control View$")
	public void user_verify_the_line_number_nineteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line19_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 19");
	}

	@Then("^User verify the Asset Details for line nineteen in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_nineteen_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender19b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender19B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
	}

	@Then("^User verify the line number twenty in Material Control View$")
	public void user_verify_the_line_number_twenty_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line20_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 20");
	}

	@Then("^User verify the Asset Details for line twenty in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_twenty_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender20b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender20B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
	}

	@Then("^User verify the line number twenty one in Material Control View$")
	public void user_verify_the_line_number_twenty_one_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line21_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 21");
	}

	@Then("^User verify the Asset Details for line twenty one in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_twenty_one_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender21b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender21B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender21c_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender21C");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump3_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 3");
		usablemethods.gClick(MvrMaterialControl.vacuumpump4_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 4");		
		String text1 = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text1);
		usablemethods.gClick(MvrMaterialControl.blender21d_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender21d");
		String hoppertrain_text2 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text2);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");		
		String text2 = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text2);
		
	}
	

	@Then("^User verify the line number twenty two in Material Control View$")
	public void user_verify_the_line_number_twenty_two_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line22_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 22");
	}

	@Then("^User verify the Asset Details for line twenty two in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_twenty_two_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender22b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender22B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender22a_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender22A");
		String hoppertrain1_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain1_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		String text1 = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text1);
	}

	@Then("^User verify the line number twenty three in Material Control View$")
	public void user_verify_the_line_number_twenty_three_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.line23_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 23");
	}

	@Then("^User verify the Asset Details for line twenty three in Material Control View$")
	public void user_verify_the_Asset_Details_for_line_twenty_three_in_Material_Control_View() throws Throwable {
		usablemethods.gClick(MvrMaterialControl.blender23b_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender23B");
		String hoppertrain_text = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
		usablemethods.gClick(MvrMaterialControl.vacuumpump1_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 1");
		usablemethods.gClick(MvrMaterialControl.vacuumpump2_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Vacuum Pump 2");
		usablemethods.gClick(MvrMaterialControl.regrindbin_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Regrind Bin");
		usablemethods.gClick(MvrMaterialControl.bha_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on BHA");
		String text = usablemethods.gWebElementGetText(MvrMaterialControl.activealarms_warningstext);
		TestResultsUtils.logger.log(LogStatus.PASS, "Active Alarms & Warnings Text is Displayed:" + text);
		usablemethods.gClick(MvrMaterialControl.blender23a_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Blender23A");
		String hoppertrain_text1 = usablemethods.gWebElementGetText(MvrMaterialControl.hoppertrain_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Hopper Train text is Displayed:" + hoppertrain_text1);
		usablemethods.gClick(MvrMaterialControl.mainhopper_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Main Hopper Train");
	}

}
