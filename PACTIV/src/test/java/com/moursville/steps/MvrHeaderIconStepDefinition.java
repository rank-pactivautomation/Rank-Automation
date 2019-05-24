package com.moursville.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.SeleniumNGSuite;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MvrHeaderIconStepDefinition extends TestDataUtils{
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	
	/* Navigation to Production Tracking Screen by clicking on the icon */
	
	@Then("^User Clicks on  Moursville Production Tracking Icon for Floater$")
	public void user_clicks_on_Moursville_ProductionTrackingIcon_floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.production_icon_plant);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Notification Icon");
	}
	
	/* Verifying the Production Tracking Page Title*/

	@Then("^User verify the title on Moursville Production Tracking Page for Floater$")
	public void user_verify_the_title_on_Moursville_Production_Tracking_Page_for_floater() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.productiontracking_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "Production Tracking Title is Displayed:" + text);
	}
	
	
	/* Navigation to Report Log Screen */
	
	@Then("^User Clicks on Moursville Report Icon for Floater$")
	public void user_Clicks_on_Moorsville_Report_Icon_for_Floater() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.notifications_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on Report Log Icon");
	}
	
	
	/* Downloading the Production Scrapping report*/
	
	@Then("^User Clicks On Download Production Tracking Scrapped Report$")
	public void user_Clicks_On_Download_Production_Tracking_Scrapped_Report() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.production_download_report);
		
		Thread.sleep(5000);
		usablemethods.gClick(PactivLogin.download_report);
		usablemethods.gClick(PactivLogin.close);

	}
	
	
	/* Verifying the report log title */
	
	@Then("^User verify the Moursville title on Report Page$")
	public void user_verify_the_Moursville_title_on_Report_Page() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.reporttext_log);
		TestResultsUtils.logger.log(LogStatus.PASS, "Report Log Title is Displayed:" + text);
	}
	
	
	/* Downloading the production tracking report */
		
		@Then("^User Clicks on Download Production Tracking Report Button$")
		public void user_Clicks_on_Download_Production_Tracking_Report_Button() throws Throwable {
			usablemethods.gClick(PactivLogin.production_report);
//			usablemethods.gClick(PactivLogin.time_dropdown);
			/*usablemethods.gClick(PactivLogin.report_date);*/
			usablemethods.gClick(PactivLogin.prod_download);
			usablemethods.gClick(PactivLogin.close);
			usablemethods.gClick(ProductionTracking.downtime_reason_drop);
//			usablemethods.gClick(ProductionTracking.downtime_reason_drop_bycases);

		}
		

	
}
