package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class MvrMaterialControl {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.MOORESVILLE_MATERIALCONTROLVIEW_OBJECTREPOSITORY_PROPERTY));
	public static By blender1b_text = By.xpath(repository.getProperty("BLENDER1B_TEXT"));
	public static By blender1c_text = By.xpath(repository.getProperty("BLENDER1C_TEXT"));
	public static By blender1d_text = By.xpath(repository.getProperty("BLENDER1D_TEXT"));
	public static By hoppertrain_text = By.xpath(repository.getProperty("HOPPERTRAIN_TEXT"));
	public static By mainhopper_text = By.xpath(repository.getProperty("MAINHOPPER_TEXT"));
	public static By vacuumpump1_text = By.xpath(repository.getProperty("VACUUMPUMP1_TEXT"));
	public static By vacuumpump2_text = By.xpath(repository.getProperty("VACUUMPUMP2_TEXT"));
	public static By vacuumpump3_text = By.xpath(repository.getProperty("VACUUMPUMP3_TEXT"));
	public static By vacuumpump4_text = By.xpath(repository.getProperty("VACUUMPUMP4_TEXT"));
	public static By regrindbin_text = By.xpath(repository.getProperty("REGRINDBIN_TEXT"));
	public static By bha_text = By.xpath(repository.getProperty("BHA_TEXT"));	
	public static By activealarms_warningstext = By.xpath(repository.getProperty("ACTIVEALARMS_WARNINGSTEXT"));
	public static By allassemblies_text = By.xpath(repository.getProperty("ALLASSEMBLIES_TEXT"));
	public static By description_text = By.xpath(repository.getProperty("DESCRIPTION_TEXT"));
	public static By duration_text = By.xpath(repository.getProperty("DURATION_TEXT"));
	public static By status_header = By.xpath(repository.getProperty("STATUS_HEADER"));
	public static By blender12b_text = By.xpath(repository.getProperty("BLENDER12B_TEXT"));
	public static By blender13b_text = By.xpath(repository.getProperty("BLENDER13B_TEXT"));
	public static By blender14b_text = By.xpath(repository.getProperty("BLENDER14B_TEXT"));
	public static By blender14c_text = By.xpath(repository.getProperty("BLENDER14C_TEXT"));
	public static By blender15b_text = By.xpath(repository.getProperty("BLENDER15B_TEXT"));
	public static By blender15c_text = By.xpath(repository.getProperty("BLENDER15C_TEXT"));
	public static By blender16b_text = By.xpath(repository.getProperty("BLENDER16B_TEXT"));
	public static By blender16c_text = By.xpath(repository.getProperty("BLENDER16C_TEXT"));
	public static By blender16d_text = By.xpath(repository.getProperty("BLENDER16D_TEXT"));
	public static By blender17b_text = By.xpath(repository.getProperty("BLENDER17B_TEXT"));
	public static By blender18b_text = By.xpath(repository.getProperty("BLENDER18B_TEXT"));
	public static By blender18c_text = By.xpath(repository.getProperty("BLENDER18C_TEXT"));
	public static By blender19b_text = By.xpath(repository.getProperty("BLENDER19B_TEXT"));
	public static By blender20b_text = By.xpath(repository.getProperty("BLENDER208_TEXT"));
	public static By blender21b_text = By.xpath(repository.getProperty("BLENDER21B_TEXT"));
	public static By blender21c_text = By.xpath(repository.getProperty("BLENDER21C_TEXT"));
	public static By blender21d_text = By.xpath(repository.getProperty("BLENDER21D_TEXT"));
	public static By blender22b_text = By.xpath(repository.getProperty("BLENDER22B_TEXT"));
	public static By blender22a_text = By.xpath(repository.getProperty("BLENDER22A_TEXT"));
	public static By blender23b_text = By.xpath(repository.getProperty("BLENDER23B_TEXT"));
	public static By blender23a_text = By.xpath(repository.getProperty("BLENDER23A_TEXT"));
	public static By line1_text = By.xpath(repository.getProperty("LINE1_TEXT"));
	public static By line12_text = By.xpath(repository.getProperty("LINE12_TEXT"));
	public static By line13_text = By.xpath(repository.getProperty("LINE13_TEXT"));
	public static By line14_text = By.xpath(repository.getProperty("LINE14_TEXT"));
	public static By line15_text = By.xpath(repository.getProperty("LINE15_TEXT"));
	public static By line16_text = By.xpath(repository.getProperty("LINE16_TEXT"));
	public static By line17_text = By.xpath(repository.getProperty("LINE17_TEXT"));
	public static By line18_text = By.xpath(repository.getProperty("LINE18_TEXT"));
	public static By line19_text = By.xpath(repository.getProperty("LINE19_TEXT"));
	public static By line20_text = By.xpath(repository.getProperty("LINE20_TEXT"));
	public static By line21_text = By.xpath(repository.getProperty("LINE21_TEXT"));
	public static By line22_text = By.xpath(repository.getProperty("LINE22_TEXT"));
	public static By line23_text = By.xpath(repository.getProperty("LINE23_TEXT"));
	
}
