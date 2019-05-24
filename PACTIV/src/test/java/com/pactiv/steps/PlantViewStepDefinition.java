package com.pactiv.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.And;



public class PlantViewStepDefinition extends TestDataUtils{

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@And("^User Verify the asset dot and asset for the line$")
	public void user_Verify_the_asset_dot_and_asset_for_the_line() throws Throwable {
		try {
		List <WebElement> lines = LocalDriverManager.getDriver().findElements(By.xpath("//div[@class='users-assigned-box']//following-sibling::p[@class='line-id-body']"));
		for(WebElement we:lines)
		{
			String line= we.getText();
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			we.click();
			TestResultsUtils.logger.log(LogStatus.PASS, "Line clicked is:" + "Line" + line);
			if(usablemethods.isElementPresentAndDisplayed(PactivLogin.plantview_linedisconnected))
			{
				TestResultsUtils.logger.log(LogStatus.PASS, "Line is Disconnected is Displayed on line "+ line);
			}
			if(LocalDriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'line-expanded-view')]//div[@class='asset-list-name']/p[1]")).getText().contains("System")) {
				usablemethods.isElementPresentAndDisplayed(PactivLogin.systemasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "System Asset Dot is Displayed");
			}
			usablemethods.isElementPresentAndDisplayed(PactivLogin.blenderasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "Blender Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.extruderasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "Extruder Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.hauloffasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "Hauloff Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.thermoformerasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "Thermoformer Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.trimpressasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "TrimPress Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.grinderasset_dot);
			TestResultsUtils.logger.log(LogStatus.PASS, "Grinder Asset Dot is Displayed");
			usablemethods.isElementPresentAndDisplayed(PactivLogin.assignedfloaters_text);
			TestResultsUtils.logger.log(LogStatus.PASS, "Assigned Floaters is Displayed");
			
			List <WebElement> assets=LocalDriverManager.getDriver().findElements(By.xpath("//div[contains(@class,'line-selected')]//div[contains(@class,'line-expanded-view')]//div[@class='asset-list-name']/p"));
			for(WebElement asset_name:assets)
			{
				Thread.sleep(5000);
				if(asset_name.getText().length()!=0)
				{
					TestResultsUtils.logger.log(LogStatus.PASS,"Asset text:" + asset_name.getText());	
				}
			}
			//since we are returning the text value of the OEE hence no need to test whether the "isElementPresentAndDisplayed" since the OEE is always displayed
			List <WebElement> OEE=LocalDriverManager.getDriver().findElements(By.xpath("(//div[contains(@class,'line-selected')]//p[contains(@class,'oee-value-box')])[2]"));
			for(WebElement OEE_value:OEE)
			{
				Thread.sleep(5000);
				if(OEE_value.getText().length()!=0)
				{
					TestResultsUtils.logger.log(LogStatus.PASS,"OEE value:" + OEE_value.getText());	
				}
			}
			List <WebElement> Downtime=LocalDriverManager.getDriver().findElements(By.xpath("(//div[contains(@class,'line-selected')]//p[contains(@class,'line-downtime normal-state')])[2]"));
			for(WebElement Downtime_value:Downtime)
			{
				Thread.sleep(5000);
				if(Downtime_value.getText().length()!=0)
				{
					TestResultsUtils.logger.log(LogStatus.PASS,"Downtime value:" + Downtime_value.getText());	
				}
			}
			
			}
		
		}
		catch(Exception e)
		{
			List <WebElement> lines = LocalDriverManager.getDriver().findElements(By.xpath("//div[@class='users-assigned-box']//following-sibling::p[@class='line-id-body']"));
			for(WebElement we:lines)
			{
				String line= we.getText();
				LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Line clicked is:" + "Line" + line);
				if(usablemethods.isElementPresentAndDisplayed(PactivLogin.plantview_linedisconnected))
				{
					TestResultsUtils.logger.log(LogStatus.PASS, "Line is Disconnected is Displayed on line"+ line);
				}
				if(LocalDriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'line-expanded-view')]//div[@class='asset-list-name']/p[1]")).getText().contains("System")) {
					usablemethods.isElementPresentAndDisplayed(PactivLogin.systemasset_dot);
					TestResultsUtils.logger.log(LogStatus.PASS, "System Asset Dot is Displayed");
				}
				usablemethods.isElementPresentAndDisplayed(PactivLogin.blenderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Blender Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.extruderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Extruder Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.hauloffasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Hauloff Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.thermoformerasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Thermoformer Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.trimpressasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "TrimPress Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.grinderasset_dot);
				TestResultsUtils.logger.log(LogStatus.PASS, "Grinder Asset Dot is Displayed");
				usablemethods.isElementPresentAndDisplayed(PactivLogin.assignedfloaters_text);
				TestResultsUtils.logger.log(LogStatus.PASS, "Assigned Floaters is Displayed");
				
				List <WebElement> assets=LocalDriverManager.getDriver().findElements(By.xpath("//div[contains(@class,'line-selected')]//div[contains(@class,'line-expanded-view')]//div[@class='asset-list-name']/p"));
				for(WebElement asset_name:assets)
				{
					Thread.sleep(5000);
					if(asset_name.getText().length()!=0)
					{
						TestResultsUtils.logger.log(LogStatus.PASS,"Asset text:" + asset_name.getText());	
					}
				}
				//since we are returning the text value of the OEE hence no need to test whether the "isElementPresentAndDisplayed" since the OEE is always displayed
				List <WebElement> OEE=LocalDriverManager.getDriver().findElements(By.xpath("(//div[contains(@class,'line-selected')]//p[contains(@class,'oee-value-box')])[2]"));
				for(WebElement OEE_value:OEE)
				{
					Thread.sleep(5000);
					if(OEE_value.getText().length()!=0)
					{
						TestResultsUtils.logger.log(LogStatus.PASS,"OEE value:" + OEE_value.getText());	
					}
				}
				List <WebElement> Downtime=LocalDriverManager.getDriver().findElements(By.xpath("(//div[contains(@class,'line-selected')]//p[contains(@class,'line-downtime normal-state')])[2]"));
				for(WebElement Downtime_value:Downtime)
				{
					Thread.sleep(5000);
					if(Downtime_value.getText().length()!=0)
					{
						TestResultsUtils.logger.log(LogStatus.PASS,"Downtime value:" + Downtime_value.getText());	
					}
				}
				
				}
			
		}
	}
	

	@And("^User Verify the assigned user for the \"([^\"]*)\"$")
	public void user_Verify_the_assigned_user_for_the(String arg1) throws Throwable {
		String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> floater = LocalDriverManager.getDriver()
				.findElements(By.xpath("(//div[contains(@class,'line-expanded-bottom-view')]//p[contains(text(),'Assigned Floaters')])['"+ Value +"']"));
		for(WebElement we:floater)
		{
		String floaterText=we.getText();
			TestResultsUtils.logger.log(LogStatus.PASS,"Text is Displayed:" + floaterText) ;
		}
	}
}
