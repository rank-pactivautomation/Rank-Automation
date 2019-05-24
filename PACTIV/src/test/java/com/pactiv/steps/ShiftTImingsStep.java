package com.pactiv.steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.DriverConfig;
import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;

public class ShiftTImingsStep {

	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();

	@Then("^User verifies the plant works in \"([^\"]*)\" a day$")
	public void verifyPlantShift(String shift) throws PactivException {
		PactivLogin login = new PactivLogin();
		int countShift = usablemethods.getWebElementsCount(login.plantShiftCount);
		if (LocalTestDataManager.getTestDataHashMap().get(shift).trim().equals(Integer.toString(countShift).trim()))
			TestResultsUtils.logger.log(LogStatus.PASS,
					"User is logged into the correct Plant with " + countShift + " Shift a day");
		else
			TestResultsUtils.logger.log(LogStatus.FAIL,
					"User is logged into the wrong Plant with " + countShift + " Shift a day");
	}

	@Then("^User verifies the ShiftTimings \"([^\"]*)\" for the Plant$")
	public void verifyShiftTimings(String shift) throws PactivException {
		PactivLogin login = new PactivLogin();
		List<WebElement> shiftTimingsApp = usablemethods.gGetLlist(login.plantShiftCount);
		String[] shiftTimings = LocalTestDataManager.getTestDataHashMap().get(shift).split(", ");
		boolean status = true;
		List<String> timingsStringApp = new ArrayList<String>();
		for (WebElement timingsApp : shiftTimingsApp) {
			timingsStringApp.add(usablemethods.getWebElementText(timingsApp));
			LOG.info("Timings in App ::" + timingsApp);
		}
		for (String timings : shiftTimings)
			if (!timingsStringApp.contains(timings))
				status = false;

		if (status)
			TestResultsUtils.logger.log(LogStatus.PASS,
					"User is logged into the correct Plant with correct shift timings displayed");
		else
			TestResultsUtils.logger.log(LogStatus.FAIL,
					"User is logged into the correct Plant with incorrect shift timings displayed");

	}

}
