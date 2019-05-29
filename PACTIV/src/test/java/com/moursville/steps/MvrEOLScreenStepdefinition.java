package com.moursville.steps;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.MvrEol;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;
public class MvrEOLScreenStepdefinition {
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);
	PactivLogin PactivLogin = new PactivLogin();
	ProductionTracking ProductionTracking = new ProductionTracking();

	TestResultsUtils testResultUtils = new TestResultsUtils();
	@Then("^User Verifies the Text on EOL Screen$")
	public void user_Verifies_the_Text_on_EOL_Screen() throws Throwable {
		Thread.sleep(5000);
		String text = usablemethods.gWebElementGetText(PactivLogin.eol_text);
		TestResultsUtils.logger.log(LogStatus.PASS, "EOL Home Page Title is Displayed:" + text);
		
		List<WebElement> line_number = LocalDriverManager.getDriver()
				.findElements(By.xpath("//button[contains(@class,'button-element textsize-2xl')]/span[3]"));
		
		System.out.println(line_number.size());
		int i=0;
			for (WebElement line_click : line_number) {
				List<WebElement> line_number1 = LocalDriverManager.getDriver()
						.findElements(By.xpath("//button[contains(@class,'button-element textsize-2xl')]/span[3]"));
				System.out.println(line_number1.get(i).getText());
				
//				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				line_number1.get(i).click();
				
				
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.line_text))
				TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line:" + (i+1));	
				TestResultsUtils.logger.log(LogStatus.PASS, "Verified Line Text ");
				
				
			
				if (usablemethods.isElementPresentAndDisplayed(PactivLogin.eol_oee_test)) 
				
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified OEE Text");
				
				if (usablemethods.isElementPresentAndDisplayed(PactivLogin.eol_total_downtime)) 
				
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified Total downtime Text");
				
				if (usablemethods.isElementPresentAndDisplayed(PactivLogin.eol_floatertext)) 
					
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified Floater text");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.downtime)) 
					
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified downtime title");
				
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.eohhour)) 
					
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified eoh title");

				if (usablemethods.isElementPresentAndDisplayed(MvrEol.prodname)) 
			
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified prodname title");

				if (usablemethods.isElementPresentAndDisplayed(MvrEol.goldencases)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified goldencases title");
		
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.expcases)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified expcases title");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.actualcases)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified actualcases title");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.targetcpm)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified  targetcpm header on table");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.actcpm)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified actcpm header on table");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.scrap)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified  scrap header on table");
				if (usablemethods.isElementPresentAndDisplayed(MvrEol.comments)) 
	
					TestResultsUtils.logger.log(LogStatus.PASS, "Verified comments header on table");
				
//				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(80000, TimeUnit.MILLISECONDS);
				//
				
				LocalDriverManager.getDriver()
				.findElement(By.xpath("//*[@id='root_navigation-89']/button/span[1]/img[1]")).click();
				
//				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(80000, TimeUnit.MILLISECONDS);
				
				
				
				
				i++; 
			}
			
	}
	
	@Then("^User logs out of EOL$")
	public void user_logsout_of_EOL_Screen() throws Throwable {
		Thread.sleep(5000);
	if (usablemethods.isElementPresentAndDisplayed(MvrEol.logout)) {
		usablemethods.gClick(MvrEol.logout);
		TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on logout button");
	} else {
		String homescreenshot = usablemethods.takescreenshot("home page");
		TestResultsUtils.logger.log(LogStatus.FAIL, "User is NOT able to click on logout button",
				TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
	}
	}
}
	
	
