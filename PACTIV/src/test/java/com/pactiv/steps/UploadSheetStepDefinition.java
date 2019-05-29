package com.pactiv.steps;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.pactiv.config.DriverConfig;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.constants.Constants;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.UploadProcessSheet;
import com.pactiv.utils.DCTUtils;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class UploadSheetStepDefinition extends TestDataUtils {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	DCTUtils dc = new DCTUtils();
	PactivLogin PactivLogin = new PactivLogin();

	@When("^User Clicks on expand icon for Line (\\d+) on plant view$")
	public void user_Clicks_on_expand_icon_for_Line_on_plant_view(int arg1) throws Throwable {
		try {
			usablemethods.gClick(UploadProcessSheet.line4_expand);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 4");
			usablemethods.gClick(UploadProcessSheet.line4_expandicon);
			TestResultsUtils.logger.log(LogStatus.PASS, "User clicks on Line 4 expand icon");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@And("^User should land to Line View for Line (\\d+)$")
	public void user_should_land_to_Line_View_for_Line(int arg1) throws Throwable {
		String Line4Text = usablemethods.gWebElementGetText(UploadProcessSheet.line4_lineviewtext);
		TestResultsUtils.logger.log(LogStatus.PASS, "User lands on Line 4: " + Line4Text + " is displayed");
	}

	@And("^User clicks on Upload a Process sheet button$")
	public void user_clicks_on_Upload_a_Process_sheet_button() throws Throwable {
		try {
			if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast)) {
				usablemethods.gClick(PactivLogin.alarm_toast);
				usablemethods.gClick(UploadProcessSheet.uploadprocesssheet);
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload a process sheet");
			} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.alarm_toast_multiple)) {
				usablemethods.gClick(PactivLogin.alarm_toast_multiple);
				usablemethods.gClick(UploadProcessSheet.uploadprocesssheet);
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload a process sheet");
			} else if (usablemethods.isElementPresentAndDisplayed(PactivLogin.report_toast)) {
				usablemethods.gClick(PactivLogin.report_toast);
				usablemethods.gClick(UploadProcessSheet.uploadprocesssheet);
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload a process sheet");
			} else {
				usablemethods.gClick(UploadProcessSheet.uploadprocesssheet);
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload a process sheet");

			}
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@And("^User clicks on Upload New button$")
	public void user_clicks_on_Upload_New_button() throws Throwable {
		try {
			usablemethods.gClick(UploadProcessSheet.uploadnewbutton);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload New button");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@And("^User clicks on Choose File and selects corresponding \"([^\"]*)\"$")
	public void user_clicks_on_Choose_File_and_selects_corresponding(String arg1) throws Throwable {
		try {
			usablemethods.gClick(UploadProcessSheet.choosefile);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Choose file");
			String processSheet = LocalTestDataManager.getTestDataHashMap().get(arg1);
			System.out.println(processSheet);
			String filepath = baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH).concat(processSheet) + ".csv";
			System.out.println(filepath);
			StringSelection filelocation = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filelocation, null);
			Robot robot = new Robot();
			// using keyboard keystrokes below we can select the file in the windows prompt
			// and close the prompt
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@And("^User clicks on Upload button$")
	public void user_clicks_on_Upload_button() throws Throwable {
		try {
			Thread.sleep(5000);
			usablemethods.gClick(UploadProcessSheet.uploadbutton);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Upload Button");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User verify the message for successfull upload of file$")
	public void user_verify_the_message_for_successfull_upload_of_file() throws Throwable {
		try {
			String ProcessSheetMessage = usablemethods.gWebElementGetText(UploadProcessSheet.processsheetmessage);
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Process Sheet Message: " + ProcessSheetMessage + " is displayed");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on Save button$")
	public void user_Clicks_on_Save_button() throws Throwable {
		try {
			usablemethods.gClick(UploadProcessSheet.save_button);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Save button");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on Ok button$")
	public void user_Clicks_on_Ok_button() throws Throwable {
		OkButtonClick();
	}

	@When("^User renames the Process Sheet \"([^\"]*)\"$")
	public void user_renames_the_Process_Sheet(String arg1) throws Throwable {
		createFileRenameExisting(arg1);
	}

	@When("^User selects the \"([^\"]*)\" from the Line dropdown in Line View$")
	public void user_selects_the_from_the_Line_dropdown_in_Line_View(String arg1) throws Throwable {
		usablemethods.gClick(UploadProcessSheet.line13_dropdown_line);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown");
		String Value = LocalTestDataManager.getTestDataHashMap().get(arg1);
		List<WebElement> line = LocalDriverManager.getDriver()
				.findElements(By.xpath("//div[contains(@class,'objbox')]//div[contains(text(),'" + Value + "')]"));
		for (WebElement we : line) {
			String LineNumber = we.getText();
			we.click();
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Line dropdown: " + LineNumber + " is clicked");
		}

	}

	@When("^User verify the duplicate file error message$")
	public void user_verify_the_duplicate_file_error_message() throws Throwable {
		try {
			String DuplicateFileDataMessage = usablemethods
					.gWebElementGetText(UploadProcessSheet.duplicate_filedatamessage);
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Process Sheet Message: " + DuplicateFileDataMessage + " is displayed");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User verify the incorrect file error message$")
	public void user_verify_the_incorrect_file_error_message() throws Throwable {
		try {
			String IncorrectFileDataMessage = usablemethods
					.gWebElementGetText(UploadProcessSheet.incorrectproductname_message);
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Process Sheet Message: " + IncorrectFileDataMessage + " is displayed");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User verify the no file error message$")
	public void user_verify_the_no_file_error_message() throws Throwable {
		try {
			usablemethods.isElementPresentAndDisplayed(UploadProcessSheet.nofile_datamessage);
			TestResultsUtils.logger.log(LogStatus.PASS, "No file chosen message is displayed");
			String nofile_datamessage = usablemethods.gWebElementGetText(UploadProcessSheet.nofile_datamessage);
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Process Sheet Message: " + nofile_datamessage + " is displayed");
		} catch (PactivException e) {
			e.getMessage();
		}
	}

	@When("^User Clicks on Close button on the popup$")
	public void user_Clicks_on_Close_button_on_the_popup() throws Throwable {
		CloseButtonClick();
	}

	@When("^User verify the incorrect file upload message$")
	public void user_verify_the_incorrect_file_upload_message() throws Throwable {
		try {
			usablemethods.isElementPresentAndDisplayed(UploadProcessSheet.incorrect_filenumbermessage);
			TestResultsUtils.logger.log(LogStatus.PASS, "No file chosen message is displayed");
			String incorrectfile_numbermessage = usablemethods
					.gWebElementGetText(UploadProcessSheet.incorrect_filenumbermessage);
			TestResultsUtils.logger.log(LogStatus.PASS,
					"Process Sheet Message: " + incorrectfile_numbermessage + " is displayed");
		} catch (PactivException e) {
			e.getMessage();
		}
	}
	@When("^User clicks on Update button$")
	public void user_clicks_on_Update_button() throws Throwable {
		UploadButtonClick();
	}
	@When("^User renames the \"([^\"]*)\" in Process Sheet \"([^\"]*)\"$")
	public void user_renames_the_in_Process_Sheet(String arg1, String arg2) throws Throwable {
		usablemethods.gClick(UploadProcessSheet.choosefile);
		TestResultsUtils.logger.log(LogStatus.PASS, "Click on Choose file");
		String orPath = "";
		String processSheet = LocalTestDataManager.getTestDataHashMap().get(arg2);
		orPath = baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH).concat(processSheet) + ".csv";
		try {
			File inputFile = new File(orPath);

			// Read existing file
			CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
			List<String[]> csvBody = reader.readAll();
			// get CSV row column and replace with by using row and column
			for (int i = 0; i < csvBody.size(); i++) {
				String[] strArray = csvBody.get(i);
				for (int j = 0; j < strArray.length; j++) {
					String productName=LocalTestDataManager.getTestDataHashMap().get(arg1);
					if (strArray[j].equalsIgnoreCase(productName)) { // String to be replaced
						csvBody.get(i)[j] = productName.concat("_new"); // Target replacement
					}
				}
			}
			reader.close();

			// Write to CSV file which is open
			CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();

			StringSelection filelocation = new StringSelection(orPath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filelocation, null);
			Robot robot = new Robot();
			// using keyboard keystrokes below we can select the file in the windows prompt
			// and close the prompt
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
