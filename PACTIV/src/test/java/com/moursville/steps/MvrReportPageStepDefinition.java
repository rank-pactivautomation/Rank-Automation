package com.moursville.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.ProductionTracking;
import com.pactiv.pageobjects.ReportLog;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class MvrReportPageStepDefinition {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	PactivLogin PactivLogin = new PactivLogin();
	ProductionTracking ProductionTracking = new ProductionTracking();
	private String strDate;

	public static String floater_text = null;
	public static String report_history_date=null;;
	public static String sup_actual_text = null;
	public static String sup_report_text = null;


	@Then("^User verify the incomplete reports for floater$")
	public void user_verify_the_incomplete_reports() throws Throwable {
		List<WebElement> incomplete = LocalDriverManager.getDriver()
				.findElements(By.xpath("//span[contains(@class,'incomplete-button')]"));
		for (WebElement we : incomplete) {
//			String incompleteText = we.getText();
//			TestResultsUtils.logger.log(LogStatus.PASS, "Incomplete Text is displayed"+incompleteText);
			if (we.isDisplayed() == false) {
				WebElement review = LocalDriverManager.getDriver()
						.findElement(By.xpath("(//button[contains(text(),'Review & Submit')])[6]"));
				review.click();
				usablemethods.gClick(ReportLog.reportlog_submit);
			} else {
				WebElement review_complete = LocalDriverManager.getDriver().findElement(By.xpath(
						"//span[contains(@class,'incomplete-button')]//following::button[contains(text(),'Review & Submit')]"));
				review_complete.click();
				TestResultsUtils.logger.log(LogStatus.PASS, "Review&Submit button is clicked");
				List<WebElement> edit = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[contains(@id,'cell_ReportReviewCollectionV2_Mashup')]/img"));
				for (WebElement editButton : edit) {
					editButton.click();
					usablemethods.sendText(ReportLog.reportlog_actualcases_value, "10");
					usablemethods.gClick(ReportLog.reportlog_selectlevel1);
					WebElement asset_name = LocalDriverManager.getDriver().findElement(
							By.xpath("(//div[contains(@class,'downtime-container')]//select)[1]/option[2]"));
					asset_name.click();
					usablemethods.gClick(ReportLog.reportlog_selectlevel2);
					WebElement level2_name = LocalDriverManager.getDriver().findElement(
							By.xpath("(//div[contains(@class,'downtime-container')]//select)[2]/option[2]"));
					level2_name.click();
					usablemethods.gClick(ReportLog.reportlog_selectlevel3);
					WebElement level3_name = LocalDriverManager.getDriver().findElement(
							By.xpath("(//div[contains(@class,'downtime-container')]//select)[3]/option[2]"));
					level3_name.click();
					usablemethods.gClick(ReportLog.reportlog_save);
				}
			}
		}
	}

	@Then("^User verify Review & Submit Button is displayed for floater$")
	public void user_verify_Review_Submit_Button_is_displayed_for_floater() throws Throwable {

		try {
			
			 //if (usablemethods.isElementPresentAndDisplayed(ReportLog.report_noreports))
					//TestResultsUtils.logger.log(LogStatus.FAIL, "Currently Floater has not subitted report to supervisor");

			 
				// if(usablemethods.isElementPresentAndDisplayed(ReportLog.reviewsubmit_floater))
				 //{
				List<WebElement> tr_collection = LocalDriverManager.getDriver().findElements(
						By.xpath("//table[contains(@class,'display row-border dataTable no-footer')]/tbody/tr"));

			
				int count = 0;

				for (WebElement trElement : tr_collection) {
				

					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
					String status = td_collection.get(7).getText();
					
					System.out.println(status);
					
					if(usablemethods.isElementPresentAndDisplayed(ReportLog.report_noreports))
					{
						
						String homescreenshot=usablemethods.takescreenshot("home page");
						TestResultsUtils.logger.log(LogStatus.FAIL, "No reports found in report history",TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
					}

					else if ((td_collection.get(8).getText().equalsIgnoreCase("Review & Submit"))
							&& (!(status.equalsIgnoreCase("incomplete")))) {
						String text1 = td_collection.get(0).getText();
						String text2 = td_collection.get(1).getText();
						String text3 = td_collection.get(2).getText();
						String text5 = td_collection.get(4).getText();
						String content1 = text1.concat(text2);
						String content2 = content1.concat(text3);
						String actual_text = content2.concat(text5);
						floater_text = actual_text;
						System.out.println(actual_text);
				

						if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
							usablemethods.gClick(PactivLogin.alarm_toast);
							Thread.sleep(2000);
							usablemethods.gClick(ReportLog.reviewsubmit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
							usablemethods.gClick(ReportLog.submit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater submits report");
							usablemethods.gClick(ReportLog.supervisor_confirm_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater confirms report");
						} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
							usablemethods.gClick(PactivLogin.alarm_toast_multiple);
							Thread.sleep(2000);
							usablemethods.gClick(ReportLog.reviewsubmit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
							usablemethods.gClick(ReportLog.submit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater submits report");
							usablemethods.gClick(ReportLog.supervisor_confirm_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater confirms report");
						} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
							usablemethods.gClick(PactivLogin.report_toast);
							Thread.sleep(2000);
							usablemethods.gClick(ReportLog.reviewsubmit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
							usablemethods.gClick(ReportLog.submit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater submits report");
							usablemethods.gClick(ReportLog.supervisor_confirm_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater confirms report");
						} else {
							usablemethods.gClick(ReportLog.reviewsubmit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "Review & Submit Button is clicked");
							usablemethods.gClick(ReportLog.submit_floater);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater submits report");
							usablemethods.gClick(ReportLog.supervisor_confirm_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "floater confirms report");
						}

						count++;

					}

					
					if (count == 1)
						break;

				}
				
				
		
			
		
			

		} 
		catch (PactivException e) {
			e.getMessage();
		}

	}

	@Then("^User Clicks on Moursville Report Icon for Supervisor$")
	
	public void user_clicks_report_icon() throws Throwable {
		usablemethods.gClick(ReportLog.supervisor_report_icon);
		TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor clicks on report log icon");

	}

	@Then("^User verify Review & Submit Button is displayed for supervisor$")
	public void user_verify_Review_Submit_Button_is_displayed() throws Throwable {

		try {

			if (usablemethods.isElementPresentAndDisplayed(ReportLog.reviewsubmit)) {

				List<WebElement> sup_tr_collection = LocalDriverManager.getDriver().findElements(
						By.xpath("//table[contains(@class,'display row-border dataTable no-footer')]/tbody/tr"));

				
		

				for (WebElement sup_trElement : sup_tr_collection)

				{

					// System.out.println("text="+trElement.getText());

					List<WebElement> sup_td_collection = sup_trElement.findElements(By.xpath("td"));
					
				
				 
					if (sup_td_collection.get(8).getText().equalsIgnoreCase("Review & Submit")) {
						String sup_text1 = sup_td_collection.get(0).getText();
						report_history_date = sup_text1;
						String sup_text2 = sup_td_collection.get(1).getText();
						String sup_text3 = sup_td_collection.get(2).getText();
						String sup_text5 = sup_td_collection.get(4).getText();
						String sup_content1 = sup_text1.concat(sup_text2);
						String sup_content2 = sup_content1.concat(sup_text3);
						String sup_actual_text = sup_content2.concat(sup_text5);
						 sup_report_text=sup_actual_text;
						if (sup_actual_text.equalsIgnoreCase(floater_text)) {

							System.out.println("sup text is:" + sup_actual_text);
							System.out.println("floater text:" + floater_text);
						
							sup_td_collection.get(8).click();
							LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(1000,
									TimeUnit.MILLISECONDS);

							TestResultsUtils.logger.log(LogStatus.PASS, "Review&Submit button is clicked");
							String shift_oee_text = usablemethods.gWebElementGetText(ReportLog.reportlog_shiftoee);

							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + shift_oee_text);
							String shift_oee_value = usablemethods
									.gWebElementGetText(ReportLog.reportlog_shiftoeevalue);
							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + shift_oee_value);
							String cases = usablemethods.gWebElementGetText(ReportLog.reportlog_cases);
							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + cases);
							String cases_value = usablemethods.gWebElementGetText(ReportLog.reportlog_casesvalue);
							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + cases_value);
							String reportlog_downtime = usablemethods.gWebElementGetText(ReportLog.reportlog_downtime);
							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + reportlog_downtime);
							String reportlog_downtimevalue = usablemethods
									.gWebElementGetText(ReportLog.reportlog_downtimevalue);
							TestResultsUtils.logger.log(LogStatus.PASS,
									"The text displayed on Report Log Page is:" + reportlog_downtimevalue);
							usablemethods.gClick(PactivLogin.report_toast);
							usablemethods.gClick(ReportLog.supervisor_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor submits report");
							usablemethods.gClick(ReportLog.supervisor_confirm_submit);
							TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor confirms report");
							

							/* calendar code */
							String[] parts = sup_text1.split(" ");
							String part2 = parts[1];
						
							String inputString = part2;
							// String inputString = "5/19/2009";

							SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yy");
							SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");

							try {
								Date dateFromUser = fromUser.parse(inputString);
								String dateMyFormat = myFormat.format(dateFromUser);
								System.out.println(dateMyFormat);
								String date_dd_MM_yyyy[] = (dateMyFormat.split(" "));
								String year = date_dd_MM_yyyy[2];
								String month = date_dd_MM_yyyy[1];
								String mon_format = month.concat(" ");
								String mon_year = mon_format.concat(year);
								System.out.println(mon_year);

								if (date_dd_MM_yyyy[0].startsWith("0"))

								{
									date_dd_MM_yyyy[0] = date_dd_MM_yyyy[0].substring(1);
								}

							} catch (ParseException e) {
								e.printStackTrace();
							}

							break;

						}
						else if (floater_text==null)
						{
							TestResultsUtils.logger.log(LogStatus.FAIL, "supervisor has not received report for floater");
							break;
						}
					}

				}
			}
			

		} 
		catch (PactivException e) {
			e.getMessage();
		}
		
		if (floater_text!=null)
		{
		usablemethods.gClick(ReportLog.reportlog_history);
		TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor clicks on report history");
		usablemethods.gClick(ReportLog.reportlog_datedropdown);
		TestResultsUtils.logger.log(LogStatus.PASS, "Supervisor clicks on date dropdown to select date");
		
		System.out.println("report log history"+report_history_date);
		String[] parts = report_history_date.split(" ");
		String part2 = parts[1];
		String inputString = part2;
		System.out.println("report date is"+inputString);
		SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");

		try {
			Date dateFromUser = fromUser.parse(inputString);
			String dateMyFormat = myFormat.format(dateFromUser);
			System.out.println(dateMyFormat);
			String date_dd_MM_yyyy[] = (dateMyFormat.split(" "));
			String year = date_dd_MM_yyyy[2];
			String month = date_dd_MM_yyyy[1];

			String mon_format = month.concat(" ");
			String mon_year = mon_format.concat(year);
			System.out.println(mon_year);
//		        System.out.println(date_dd_MM_yyyy[0]);
			if (date_dd_MM_yyyy[0].startsWith("0"))

			{
				date_dd_MM_yyyy[0] = date_dd_MM_yyyy[0].substring(1);
			}

	
			Thread.sleep(1000);

			String calendar_month_year = usablemethods.gWebElementGetText(ReportLog.calendar_monthyear);
			System.out.println(calendar_month_year);
			System.out.println(mon_year);

			if (calendar_month_year.equalsIgnoreCase(mon_year)) {
				System.out.println("current month");
				List<WebElement> date_list = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[contains(@class,'day toMonth valid')]"));

				int j = 0;

				for (WebElement calendar_date : date_list)

				{

					String calendar_date1 = date_list.get(j).getText();
					System.out.println(calendar_date1);
					System.out.println(date_dd_MM_yyyy[0]);

					if (calendar_date1.equalsIgnoreCase(date_dd_MM_yyyy[0])) {
						date_list.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

						date_list.get(Integer.parseInt(date_dd_MM_yyyy[0])).click();
						usablemethods.gClick(ReportLog.claendar_close);

						Thread.sleep(1000);
						List<WebElement> rep_tr_collection = LocalDriverManager.getDriver().findElements(
								By.xpath("//table[contains(@class,'display row-border dataTable no-footer')]/tbody/tr"));
						System.out.println("checking rows in report history");

					
					
						for (WebElement rep_trElement : rep_tr_collection)

						{
							//System.out.println(rep_tr_collection.get(0).getText());

							// System.out.println("text="+trElement.getText());

							List<WebElement> rep_td_collection = rep_trElement.findElements(By.xpath("td"));
							System.out.println(rep_td_collection.size());

							String rep_text1 = rep_td_collection.get(0).getText();
							String rep_text2 = rep_td_collection.get(1).getText();
							String rep_text3 = rep_td_collection.get(2).getText();
							String rep_text5 = rep_td_collection.get(4).getText();
							String rep_content1 = rep_text1.concat(rep_text2);
							String rep_content2 = rep_content1.concat(rep_text3);
							String rep_actual_text = rep_content2.concat(rep_text5);

							if (rep_actual_text.equalsIgnoreCase(sup_report_text)) {

								System.out.println("rep text is:" + rep_actual_text);
								System.out.println("supervisor text:" + sup_report_text);
								System.out.println("report found in report log history");
								TestResultsUtils.logger.log(LogStatus.PASS, "report found in report log history");
								break;

							}
							/*else if(usablemethods.isElementPresentAndDisplayed(ReportLog.report_noreports))
							{
								
								String homescreenshot=usablemethods.takescreenshot("home page");
								TestResultsUtils.logger.log(LogStatus.FAIL, "No reports found in report history",TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
								break;	
								
							}*/
						}


						break;
					}

					j++;

				}
			}

			else {

				usablemethods.gClick(ReportLog.claendar_previous);
				List<WebElement> date_list = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[contains(@class,'day toMonth valid')]"));

				int k = 0;

				for (WebElement calendar_date : date_list)

				{

					String calendar_date1 = date_list.get(k).getText();
					System.out.println(calendar_date1);
					System.out.println(date_dd_MM_yyyy[0]);
					if (calendar_date1.equalsIgnoreCase(date_dd_MM_yyyy[0])) {
						date_list.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

						date_list.get(Integer.parseInt(date_dd_MM_yyyy[0])).click();
						usablemethods.gClick(ReportLog.claendar_close);

						Thread.sleep(1000);
						List<WebElement> rep_tr_collection = LocalDriverManager.getDriver().findElements(
								By.xpath("//table[contains(@class,'display row-border dataTable no-footer')]/tbody/tr"));
						System.out.println("checking rows in report history");

					
						

						for (WebElement rep_trElement : rep_tr_collection)

						{
							//System.out.println(rep_tr_collection.get(0).getText());

							// System.out.println("text="+trElement.getText());

							List<WebElement> rep_td_collection = rep_trElement.findElements(By.xpath("td"));
							System.out.println(rep_td_collection.size());

							String rep_text1 = rep_td_collection.get(0).getText();
							String rep_text2 = rep_td_collection.get(1).getText();
							String rep_text3 = rep_td_collection.get(2).getText();
							String rep_text5 = rep_td_collection.get(4).getText();
							String rep_content1 = rep_text1.concat(rep_text2);
							String rep_content2 = rep_content1.concat(rep_text3);
							String rep_actual_text = rep_content2.concat(rep_text5);

							if (rep_actual_text.equalsIgnoreCase(sup_report_text)) {

								System.out.println("rep text is:" + rep_actual_text);
								System.out.println("supervisor text:" + sup_report_text);
								System.out.println("report found in report log history");
								break;

							}
							/*else if(usablemethods.isElementPresentAndDisplayed(ReportLog.report_noreports))
							{
								
								String homescreenshot=usablemethods.takescreenshot("home page");
								TestResultsUtils.logger.log(LogStatus.FAIL, "No reports found in report history",TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
								break;	
								
							}*/
						}


						break;
					}

					k++;

				}

				Thread.sleep(1000);
							}

		} 
		
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
	}
}
