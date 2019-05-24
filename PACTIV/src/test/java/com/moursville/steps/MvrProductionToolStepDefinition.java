package com.moursville.steps;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.MvrProductionTrackingTool;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MvrProductionToolStepDefinition extends TestDataUtils{
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	
	@Given("^User launches the Production Run Tool$")
	public void user_launches_the_Production_Run_Tool() throws Throwable {
		DriverConfig config = new DriverConfig();
		String URL = "https://" + "PlantManagerTest" + ":" + "test" + "@" + "bridgeviewfaiqa.pactiv.com:8443/Thingworx/Runtime/index.html#mashup=ProductionRunTool_Mashup";
		config.setUp("chrome", URL);
	
	}

	@Then("^User selects the \"([^\"]*)\" in production tracking tool$")
	public void user_selects_the_in_production_tracking_tool(String arg1) throws Throwable {
		Thread.sleep(5000);
//		config.driver.switchTo().frame(0);
		usablemethods.gClick(MvrProductionTrackingTool.pt_selectedline);
		String line = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> line_number = LocalDriverManager.getDriver()
				.findElements(By.xpath("//*[@cellvalue='" + line + "']"));
		
			for (WebElement line_click : line_number) {
				line_click.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line:" + line);
			}
		
	}
	@Then("^User enters the Product Name \"([^\"]*)\"$")
	public void user_enters_the_Product_Name(String arg1) throws Throwable {
		usablemethods.sendText(MvrProductionTrackingTool.pt_productnametext, LocalTestDataManager.getTestDataHashMap().get(arg1));
		TestResultsUtils.logger.log(LogStatus.PASS,
				"Product Name field text:" + LocalTestDataManager.getTestDataHashMap().get(arg1) + " is entered");
	}

	@Then("^User enters the Order Number$")
	public void user_enters_the_Order_Number() throws Throwable {

	}

	@Then("^User enters the Start Date$")
	public void user_enters_the_Start_Date() throws Throwable {

	}

	@Then("^User enters the End Date$")
	public void user_enters_the_End_Date() throws Throwable {

	}

	@Then("^User enters the Golden output per hour$")
	public void user_enters_the_Golden_output_per_hour() throws Throwable {

	}

	@Then("^User enters the Standard output per hour$")
	public void user_enters_the_Standard_output_per_hour() throws Throwable {

	}

	@Then("^User enters the Total number of cases$")
	public void user_enters_the_Total_number_of_cases() throws Throwable {

	}

	@Then("^User enters the Cases per pallet$")
	public void user_enters_the_Cases_per_pallet() throws Throwable {

	}

	@Then("^User enters the CPM$")
	public void user_enters_the_CPM() throws Throwable {

	}

	@Then("^User enters the Case Weight$")
	public void user_enters_the_Case_Weight() throws Throwable {

	}

	@Then("^User selects the Table Size$")
	public void user_selects_the_Table_Size() throws Throwable {

	}

	@Then("^User clicks on Confirm button$")
	public void user_clicks_on_Confirm_button() throws Throwable {

	}
}
