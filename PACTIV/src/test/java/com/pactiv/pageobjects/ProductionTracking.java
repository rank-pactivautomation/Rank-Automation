package com.pactiv.pageobjects;

import org.openqa.selenium.By;

import com.pactiv.constants.Constants;
import com.pactiv.utils.PropertyUtils;

public class ProductionTracking {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.PACTIV_PRODUCTIONTRACKING_OBJECTREPOSITORY_PROPERTY));
	public static By productiontracking_pending = By.xpath(repository.getProperty("PRODUCTIONTRACKING_PENDING"));
	public static By productiontracking_actualcases = By.xpath(repository.getProperty("PRODUCTIONTRACKING_ACTUALCASES"));
	public static By productiontracking_adddiagnosis = By.xpath(repository.getProperty("PRODUCTIONTRACKING_ADDDIAGNOSIS"));
	public static By productiontracking_dropdown1 = By.xpath(repository.getProperty("PRODUCTIONTRACKING_DROPDOWN1"));
	public static By productiontracking_selectrows = By.xpath(repository.getProperty("PRODUCTIONTRACKING_SELECTROWS"));
	public static By productiontracking_1trow = By.xpath(repository.getProperty("PRODUCTIONTRACKING_1TROW"));
	public static By productiontracking_update = By.xpath(repository.getProperty("PRODUCTIONTRACKING_UPDATE"));
	public static By productiontracking_selectlevel1_option = By.xpath(repository.getProperty("PRODUCTIONTRACKING_SELECTLEVEL1_OPTION"));
	public static By productiontracking_selectlevel2_option = By.xpath(repository.getProperty("PRODUCTIONTRACKING_SELECTLEVEL2_OPTION"));
	public static By productiontracking_selectlevel3_option = By.xpath(repository.getProperty("PRODUCTIONTRACKING_SELECTLEVEL3_OPTION"));
	public static By productiontracking_timedropdown = By.xpath(repository.getProperty("PRODUCTIONTRACKING_TIMEDROPDOWN"));
	public static By productiontracking_time1 = By.xpath(repository.getProperty("PRODUCTIONTRACKING_TIME1"));
	public static By productiontracking_time2 = By.xpath(repository.getProperty("PRODUCTIONTRACKING_TIME2"));
	public static By productiontracking_resolve=By.xpath(repository.getProperty("PRODUCTIONTRACKING_RESOLVE"));
	public static By productiontracking_resolvetick=By.xpath(repository.getProperty("PRODUCTIONTRACKING_RESOLVETICK"));
	public static By productiontracking_resolvecomment=By.xpath(repository.getProperty("PRODUCTIONTRACKING_RESOLVECOMMENT"));
	public static By productiontracking_1row = By.xpath(repository.getProperty("PRODUCTIONTRACKING_1ROW"));
	public static By productiontracking_2trow = By.xpath(repository.getProperty("PRODUCTIONTRACKING_2TROW"));
	public static By downtime_reason_drop_bycases = By.xpath(repository.getProperty("DOWNTIMEREASON_DROP_BY_CASES"));
	public static By downtime_reason_drop= By.xpath(repository.getProperty("DOWNTIMEREASON_DROP"));;
	public final By prodTrackIconDashboard = By.xpath(repository.getProperty("PRODCUTIONTRACK_ICON"));
	public final By prodTrackTitle = By.xpath(repository.getProperty("PRODUCTIONTRACK_TITLE"));
	public final By PRODUCTIONTRACK_PENDING = By.xpath(repository.getProperty("PRODUCTIONTRACK_PENDING"));
	public final By PRODUCTIONTRACK_GOLDENHOUR = By.xpath(repository.getProperty("PRODUCTIONTRACK_GOLDENHOUR"));
	public final By PRODUCTIONTRACK_SAVE = By.xpath(repository.getProperty("PRODUCTIONTRACK_SAVE"));
	public final By PRODUCTIONTRACK_TIMEDROPDOWN_CPT = By
			.id(repository.getProperty("PRODUCTIONTRACK_TIMEDROPDOWN_CPT"));
	public final By PRODUCTIONTRACK_DOWNTIME_L1_DRPDWN = By
			.id(repository.getProperty("PRODUCTIONTRACK_DOWNTIME_L1_DRPDWN"));
	public final By PRODUCTIONTRACK_DOWNTIME_L2_DRPDWN = By
			.id(repository.getProperty("PRODUCTIONTRACK_DOWNTIME_L2_DRPDWN"));
	public final By PRODUCTIONTRACK_DOWNTIME_L3_DRPDWN = By
			.id(repository.getProperty("PRODUCTIONTRACK_DOWNTIME_L3_DRPDWN"));
	public static By hourly_pendingboxes= By.xpath(repository.getProperty("MVR_HOURLYBOXES_PENDING"));
	
}
