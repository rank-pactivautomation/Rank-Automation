package com.pactiv.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.pactiv.config.LocalDriverManager;
import com.pactiv.config.SeleniumNGSuite;
import com.pactiv.constants.Constants;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.pageobjects.UploadProcessSheet;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;

/**
 * The Class TestDataUtils.
 */
public class TestDataUtils extends SeleniumNGSuite {

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(TestDataUtils.class);

	/** The repoistory. */
	public static PropertyUtils repoistory = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	DCTUtils dc=new DCTUtils();
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	PactivLogin PactivLogin = new PactivLogin();
		
	public static ArrayList<String> list = new ArrayList<String>();
	/**
	 * Close Button
	 *
	 * @param scenario
	 *            the scenario
	 * @throws PactivException 
	 * @throws IOException
	 *             the IOException
	 */
	public void CloseButtonClick() {
		try {
			usablemethods.gClick(UploadProcessSheet.popup_closebutton);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Close Button");
		} catch (PactivException e) {
			e.getMessage();
		}
	}
	/**
	 * Ok Button
	 *
	 * @param scenario
	 *            the scenario
	 * @throws PactivException 
	 * @throws IOException
	 *             the IOException
	 */
	public void OkButtonClick()
	{
		try {
			usablemethods.gClick(UploadProcessSheet.ok_buttonmessage);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Ok button");
		} catch (PactivException e) {
			e.getMessage();
		}
	}
	/**
	 * UploadButtonClick
	 *
	 * @param scenario
	 *            the scenario
	 * @throws PactivException 
	 * @throws IOException
	 *             the IOException
	 */
	public void UploadButtonClick()
	{
		try {
			usablemethods.gClick(UploadProcessSheet.updatebutton);
			TestResultsUtils.logger.log(LogStatus.PASS, "Click on Update Button");
			}
			catch(PactivException e) {
				e.getMessage();
			}
	}
	
	/**
	 * launch the App
	 *
	 * @param scenario
	 *            the scenario
	 * @throws PactivException 
	 * @throws IOException
	 *             the IOException
	 */
	public void LaunchApp(String url) throws PactivException {
		try {
			SeleniumNGSuite seleniumObj = new SeleniumNGSuite();
			seleniumObj.setUpSuite(url);
			LOG.info("Access the PACTIV URL::PASS");

		} catch (Exception exception) {
			LOG.error("Access the PACTIV URL::FAIL::{}", exception.getMessage());
			String homescreenshot = usablemethods.takescreenshot("home page");
			TestResultsUtils.logger.log(LogStatus.FAIL, "Application launch failed",
					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));

		} catch (Throwable throwable) {
			throwable.printStackTrace();
			LOG.error("Access the PACTIV URL::FAIL::{}", throwable.getMessage());
			String homescreenshot = usablemethods.takescreenshot("home page");
			TestResultsUtils.logger.log(LogStatus.FAIL, "Application launch failed",
					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
		}
	}
	/**
	 * logout from the App
	 *
	 * @param scenario
	 *            the scenario
	 * @throws PactivException 
	 * @throws IOException
	 *             the IOException
	 */
	public void Logout() throws PactivException {
		if (usablemethods.isElementPresentAndDisplayed(PactivLogin.logout_button)) {
			usablemethods.gClick(PactivLogin.logout_button);
			TestResultsUtils.logger.log(LogStatus.PASS, "User is able to click on logout button");
		} else {
			String homescreenshot = usablemethods.takescreenshot("home page");
			TestResultsUtils.logger.log(LogStatus.FAIL, "User is NOT able to click on logout button",
					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
		}
	}
	
	/**
	 * read a CSV file
	 *
	 * @param scenario
	 *            the scenario
	 * @throws IOException
	 *             the IOException
	 */
	public void readCSV(String fileName) throws Exception {

		// This will load csv file
		String orPath = baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH);
		CSVReader reader = new CSVReader(new FileReader(orPath));
		// this will load content into list
		List<String[]> li = reader.readAll();
		System.out.println("Total rows which we have is " + li.size());

		// create Iterator reference
		Iterator<String[]> i1 = li.iterator();

		// Iterate all values
		while (i1.hasNext()) {

			String[] str = i1.next();
			System.out.print(" Values are ");
			for (int i = 0; i < str.length; i++) {
				System.out.print(" " + str[i]);
			}
			System.out.println("   ");
		}
		reader.close();
		}
	/**
	 * get the json response
	 *
	 * @param scenario
	 *            the scenario
	 * @throws Exception 
	 * @throws Throwable 
	 * @throws IOException
	 *             the IOException
	 */
	public List<String> jsonResponse(String arg1, String arg2) throws Exception 
	{
		StringBuilder result = new StringBuilder();
		String url = Constants.ASSET_APIURL.concat(arg1).concat(Constants.PART_APIURL).concat(arg2);
		URL obj = new URL(url);
		System.out.println(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("appkey", "f2b08a9d-259f-49ee-bc92-c65590ba6645");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.connect();
		int responseCode = conn.getResponseCode();

		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		System.out.println(result.toString());
		JSONObject jsonObject = new JSONObject(result.toString());
		JSONArray jsonarr_1 = jsonObject.getJSONArray("rows");
		LinkedHashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		List<String> list = new ArrayList<String>();
		for (int l = 0; l < jsonarr_1.length(); l++) {
			org.json.JSONObject jsonobj_1 = jsonarr_1.getJSONObject(l);
			list.add(jsonobj_1.getString("PropertyName").replaceAll("\\s{2,}", " ").trim());
			try {
				list.add(String.valueOf(jsonobj_1.getInt("ProcessSetPoint")));
			} catch (Exception e) {
				list.add("--");
			}
			list.add(String.valueOf(jsonobj_1.getInt("MachineSetPoint")));
			if(jsonobj_1.getString("ActualValue").equals("0.00")) {
				list.add("--");
			}
			else {
			list.add(jsonobj_1.getString("ActualValue"));
			}
			map.put(jsonobj_1.getString("PropertyName"), new ArrayList<String>(list));
		}
		System.out.println(list);
		int l=list.size();
		System.out.println(l);
		return list;
	}
	/**
	 * write in a CSV file
	 *
	 * @param scenario
	 *            the scenario
	 * @throws IOException
	 *             the IOException
	 */
	/**
	 * read the Process Sheet data in UI
	 *
	 * @param scenario
	 *            the scenario
	 * @throws Exception 
	 * @throws Throwable 
	 * @throws IOException
	 *             the IOException
	 */
	public List<String> readDataUI() throws Exception {
		try {
		 List<WebElement> tags = LocalDriverManager.getDriver()
					.findElements(By.xpath("//div[@class='customAssetProcessSheet-content']//h3"));
			LinkedHashMap<String, List<String>> map1 = new LinkedHashMap<String, List<String>>();
			List<String> list1 = new ArrayList<String>();
			List<WebElement> division = null;
			List<WebElement> data = null;
			String search = null;
			for (int i = 1; i <= tags.size(); i++) {
				division = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div"));
				for (int j = division.size(); j >0; j--) {
					data = LocalDriverManager.getDriver().findElements(By
							.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div[" + j + "]/span"));
					for (int k = 1; k <= data.size() - 1; k++) {
						Thread.sleep(3000);
						search = LocalDriverManager.getDriver()
								.findElement(By.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div["+ j + "]/span[" + k + "]")).getText();
						list1.add(search);
						map1.put(search, new ArrayList<String>(list1));	
						
					}	
					}	
			}
			int l=list1.size();
			System.out.println(l);
			return list1;
		}
			catch(Exception e)
			{
				List<WebElement> tags = LocalDriverManager.getDriver()
						.findElements(By.xpath("//div[@class='customAssetProcessSheet-content']//h3"));
				LinkedHashMap<String, List<String>> map1 = new LinkedHashMap<String, List<String>>();
				List<String> list1 = new ArrayList<String>();
				List<WebElement> division = null;
				List<WebElement> data = null;
				String search = null;
				for (int i = 1; i <= tags.size(); i++) {
					division = LocalDriverManager.getDriver()
							.findElements(By.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div"));
					for (int j = division.size(); j >0; j--) {
						data = LocalDriverManager.getDriver().findElements(By
								.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div[" + j + "]/span"));
						for (int k = 1; k <= data.size() - 1; k++) {
							
							search = LocalDriverManager.getDriver()
									.findElement(By.xpath("//div[@class='customAssetProcessSheet-content']//div[" + i + "]/div["+ j + "]/span[" + k + "]")).getText();
							list1.add(search);
							map1.put(search, new ArrayList<String>(list1));	
							
						}	
						}	
				}
				int l=list1.size();
				System.out.println(l);
				return list1;
			}
	}
	public void writeCSV(String fileName) throws Exception
	   {
		  String orPath = baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH);
	          // specified by filepath 
	          File file = new File(orPath); 
	          try { 
	              // create FileWriter object with file as parameter 
	              FileWriter outputfile = new FileWriter(file,true); 
	        
	              // create CSVWriter object filewriter object as parameter 
	              CSVWriter writer = new CSVWriter(outputfile); 
	      
	              // add data to csv 
	              String[] data1 = {"Product", "xyz"}; 
	              writer.writeNext(data1);
	              // closing writer connection 
	              writer.close(); 
	          } 
	       catch (IOException e) { 
	              // TODO Auto-generated catch block 
	              e.printStackTrace(); 
	          } 
	      } 
	
	public  void createFileRenameExisting(String arg1) throws Exception
    {
		String orPath = "";
		String processSheet = LocalTestDataManager.getTestDataHashMap().get(arg1);
		orPath = baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH).concat(processSheet) + ".csv";
		// create a new file
		File file = new File(orPath);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File is created");
			} else {
				usablemethods.gClick(UploadProcessSheet.choosefile);
				TestResultsUtils.logger.log(LogStatus.PASS, "Click on Choose file");
				File backupFile = new File(baseProjectPath.concat(Constants.PROCESSSHEET_DATA_PATH).concat(processSheet)
						+ "_new" + ".csv");
				System.out.println("File already exist and backup file is created");
				Thread.sleep(5000);
				file.renameTo(backupFile);
				String filepath = backupFile + " ";
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * Read test data.
	 *
	 * @param scenario
	 *            the scenario
	 * @throws Throwable
	 *             the throwable
	 */
	public void readTestData(Scenario scenario) throws Throwable {
		LOG.info("===== Reading Feature Details====");
		LOG.info("Scenario::{}", scenario);
		LOG.info("Scenario name::{}", scenario.getName());
		String scenarioName = scenario.getName();
		LocalTestDataManager.setScenarioname(scenario.getName());
		LOG.info("****************");
		LOG.info("Scenario Name:" + scenarioName);
		String featureName = scenario.getId().split(";")[0];
		LOG.info("feature file Name:" + featureName);
		readFromFile(featureName, scenarioName);
		LocalTestDataManager.setFeaturename(featureName);
	}

	/**
	 * Read from file.
	 *
	 * @param featureName
	 *            the feature name
	 * @param scenarioName
	 *            the scenario name
	 * @throws Throwable
	 *             the throwable
	 */
	public void readFromFile(String featureName, String scenarioName) throws Throwable {

		HashMap<String, String> hmap = new HashMap<String, String>();

		LocalTestDataManager.setScenarioID(scenarioName.split(Constants.COLON)[0]);
		LOG.info("------------");
		LOG.info("Scenario_id:" + LocalTestDataManager.getScenarioID());
		int rowNum = 0;
		int colNum = 0;
		int numberofcells = 0;
		int numberofrows = 0;
		boolean scenariofound = false;
		DataFormatter formatter = new DataFormatter();
		ArrayList<String> header = new ArrayList<String>();
		String filepath = baseProjectPath.concat(Constants.TEST_DATA_PATH);
		FileInputStream inputstream = new FileInputStream(new File(filepath));
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(inputstream);
		Sheet firstsheet = workbook.getSheet(featureName);
		Iterator<Row> iterator = firstsheet.iterator();
		LOG.info("SheetName is: " + firstsheet.getSheetName());
		while (iterator.hasNext()) {
			Row nextrow = iterator.next();
			Iterator<Cell> celliterator = nextrow.cellIterator();
			while (celliterator.hasNext()) {
				Cell nextcell = celliterator.next();
				String value = formatter.formatCellValue(nextcell);

				if (value.equalsIgnoreCase(LocalTestDataManager.getScenarioID())) {
					rowNum = nextcell.getRowIndex();
					colNum = nextcell.getColumnIndex();
					LOG.info("Row is: " + rowNum + "Column is: " + colNum);
					rowNum++;
					Row headerrow = iterator.next();
					numberofcells = headerrow.getPhysicalNumberOfCells();
					LOG.info("no of cells 1::" + numberofcells);
					scenariofound = true;
					break;
				}
			}
		}

		if (scenariofound == true) {
			Row row = firstsheet.getRow(rowNum);
			for (int p = 0; p < numberofcells; p++) {
				Cell cell = row.getCell(p);
				header.add(formatter.formatCellValue(cell));
			}
			LOG.info("header::" + header);
			rowNum++;
			for (int j = rowNum; j <= firstsheet.getLastRowNum(); j++) {
				if (firstsheet.getRow(j) == null) {
					break;
				} else {
					numberofrows++;
				}
			}
			LOG.info("no of rows::" + numberofrows);
		} else {
			LOG.info("Scenario not found: " + LocalTestDataManager.getScenarioID());
		}
		String key;
		String value;
		int count = 1;
		for (int b = 1; b <= numberofrows; b++)

		{
			for (int c = 0; c < numberofcells; c++) {
				key = header.get(c).concat(Constants.UNDERSCORE + count);
				LOG.info("key is ::" + key);
				value = formatter.formatCellValue(firstsheet.getRow(rowNum).getCell(c));
				LOG.info("value is ::" + value);
				hmap.put(key, value);
			}
			count++;
			rowNum++;
		}
		LocalTestDataManager.setTestDataHashMap(hmap);
	}



		/**
	 * Gets the current scenario ID.
	 *
	 * @return the current scenario ID
	 */
	public static String getCurrentScenarioID() {
		return LocalTestDataManager.getScenarioID();
	}

	
}
