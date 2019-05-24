package com.pactiv.steps;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.pageobjects.AssetAbridged;
import com.pactiv.pageobjects.BreadCrumb;
import com.pactiv.pageobjects.LineView;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.UploadProcessSheet;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.When;

public class AssetDetailedStepDefinition extends TestDataUtils {
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@When("^User Clicks on expand icon for asset abridged view$")
	public void user_Clicks_on_expand_icon_for_asset_abridged_view() throws Throwable {
		usablemethods.gClick(AssetAbridged.assetabridged_expandicon);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
	}
	@When("^User clicks on Blender Asset$")
	public void user_clicks_on_Blender_Asset() throws Throwable {
		Thread.sleep(5000);
		usablemethods.gClick(LineView.linegraphicalview_blenderasset);
		TestResultsUtils.logger.log(LogStatus.PASS, "Blender Asset is clicked");
	}
	@When("^User selects \"([^\"]*)\" from Line dropdown$")
	public void user_selects_from_Line_dropdown(String arg1) throws Throwable {
		usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
		String line_number=LocalTestDataManager.getTestDataHashMap().get(arg1);
		WebElement line= LocalDriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + line_number + "')]"));
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown value" + line.getText());
		line.click();
		
	}
	
	@When("^User selects the \"([^\"]*)\" filter$")
	public void user_selects_the_filter(String arg1) throws Throwable {
		if(usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast))
		{
			usablemethods.gClick(PactivLogin.alarm_toast);
			Thread.sleep(2000);
			usablemethods.gClick(BreadCrumb.asset_dropdown);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on asset dropdown");
			String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
			List<WebElement> asset = LocalDriverManager.getDriver()
					.findElements(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + Value + "')]"));
			for (WebElement we : asset) {
				String assetName = we.getText();
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Asset dropdown: " + assetName + " is clicked");
			}
		}else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple))
		{
			usablemethods.gClick(PactivLogin.alarm_toast_multiple);
			Thread.sleep(2000);
			usablemethods.gClick(BreadCrumb.asset_dropdown);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on asset dropdown");
			String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
			List<WebElement> asset = LocalDriverManager.getDriver()
					.findElements(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + Value + "')]"));
			for (WebElement we : asset) {
				String assetName = we.getText();
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Asset dropdown: " + assetName + " is clicked");
			}
		}
		else if(usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast))
		{
			usablemethods.gClick(PactivLogin.report_toast);
			Thread.sleep(2000);
			usablemethods.gClick(BreadCrumb.asset_dropdown);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on asset dropdown");
			String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
			List<WebElement> asset = LocalDriverManager.getDriver()
					.findElements(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + Value + "')]"));
			for (WebElement we : asset) {
				String assetName = we.getText();
				we.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Asset dropdown: " + assetName + " is clicked");
			}
		}
		else {
		Thread.sleep(5000);
		usablemethods.gClick(BreadCrumb.asset_dropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on asset dropdown");
		String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> asset = LocalDriverManager.getDriver()
				.findElements(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + Value + "')]"));
		for (WebElement we : asset) {
			String assetName = we.getText();
			we.click();
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Asset dropdown: " + assetName + " is clicked");
		}
		}
	}
	@When("^User verifies the Process Sheet data for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_verifies_the_Process_Sheet_data_for_and(String arg1, String arg2) throws Throwable {
		try {
	   List<String> list=jsonResponse(LocalTestDataManager.getTestDataHashMap().get(arg1), LocalTestDataManager.getTestDataHashMap().get(arg2));
	   TestResultsUtils.logger.log(LogStatus.PASS, "API data is:" + list);
	   int API_size=list.size();
	   TestResultsUtils.logger.log(LogStatus.PASS, "API data size is:" + API_size);
	   List<String> list1=readDataUI();
	   System.out.println(list1);
	   TestResultsUtils.logger.log(LogStatus.PASS, "UI data is:" + list1);
	   int UI_size= list1.size();
	   TestResultsUtils.logger.log(LogStatus.PASS, "UI data size is:" + UI_size);
	   if(API_size==UI_size)
	   {
		   System.out.println("Data is matching");
		   TestResultsUtils.logger.log(LogStatus.PASS, "Data is matching");
	   }
		if(list.equals(list1)) {
			System.out.println("Data is matching");
			TestResultsUtils.logger.log(LogStatus.PASS, "Data is matching");
		}
		else
		{
			list.removeAll(list1);
			System.out.println("Data is not matching" + list);
			TestResultsUtils.logger.log(LogStatus.PASS, "Data is not matching" + list);
		}
	   
	}
		catch(Exception e)
		{
			List<String> list=jsonResponse(LocalTestDataManager.getTestDataHashMap().get(arg1), LocalTestDataManager.getTestDataHashMap().get(arg2));
			   TestResultsUtils.logger.log(LogStatus.PASS, "API data is:" + list);
			   int API_size=list.size();
			   TestResultsUtils.logger.log(LogStatus.PASS, "API data size is:" + API_size);
			   List<String> list1=readDataUI();
			   System.out.println(list1);
			   TestResultsUtils.logger.log(LogStatus.PASS, "UI data is:" + list1);
			   int UI_size= list1.size();
			   TestResultsUtils.logger.log(LogStatus.PASS, "UI data size is:" + UI_size);
			   if(API_size==UI_size)
			   {
				   System.out.println("Data is matching");
				   TestResultsUtils.logger.log(LogStatus.PASS, "Data is matching");
			   }
				if(list.equals(list1)) {
					System.out.println("Data is matching");
					TestResultsUtils.logger.log(LogStatus.PASS, "Data is matching");
				}
				else
				{
					list.removeAll(list1);
					System.out.println("Data is not matching" + list);
					TestResultsUtils.logger.log(LogStatus.PASS, "Data is not matching" + list);
				}
			   
		}
	}
}
