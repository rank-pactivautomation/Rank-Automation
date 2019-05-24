package com.pactiv.utils;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pactiv.constants.Constants;

import cucumber.api.cli.Main;



public class ReadExcelSheet {

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static void main(String args[]) throws Exception {
		

		List<String> tags = new ArrayList<String>();
		String filepath = baseProjectPath.concat(Constants.CONFIG_TEST_DATA_PATH);
		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(filepath);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Read sheet inside the workbook by its name

		Sheet ProcessSheet = workbook.getSheet("Execution_Configuration");

		// Create a loop over all the rows of excel file to read it

		for (Row row : ProcessSheet) {

			if (row.getRowNum() != 0) {
				if (row.getRowNum() < 4) {
					continue;
				}
				if (row.getCell(8) != null) {
					if (row.getCell(8).toString() != null) {
						if (row.getCell(8).toString().equalsIgnoreCase("Yes")) {
							tags.add(ProcessSheet.getRow(row.getCell(8).getRowIndex()).getCell(5).toString());
						
						}

					}
					System.out.println(tags);
				}
				for(String tag:tags) {
				String[] argv=new String[] {"-g","","src\\test\\resources\\features","-t","@"+tag};
				ClassLoader contextClassLoader=Thread.currentThread().getContextClassLoader();
						byte exitstatus=Main.run(argv, contextClassLoader);
						System.out.println("Test Case Result"+exitstatus);
				}
			}
		}
	}
}
