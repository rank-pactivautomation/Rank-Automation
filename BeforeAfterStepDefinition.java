package com.pactiv.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.exception.PactivException;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.TestDataUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * The Class BeforeAfterStepDefinition.
 */
public class BeforeAfterStepDefinition extends TestDataUtils {

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(BeforeAfterStepDefinition.class);
	TestResultsUtils testResultUtils = new TestResultsUtils();

	/**
	 * Beforetest.
	 *
	 * @param scenario the scenario
	 * @throws LCBOException the lcbo exception
	 * @throws Throwable     the throwable
	 */
	@Before
	public void beforetest(Scenario scenario) throws PactivException, Throwable {
		try {

			TestResultsUtils.outputFolder();
			TestResultsUtils.extentReportInitialize();
			TestResultsUtils.logger = TestResultsUtils.extent.startTest(scenario.getName());
			LOG.info("In before step definition for scenario::{}", scenario.getName());
			readTestData(scenario);

		} catch (Exception exception) {
			LOG.error("Scenario::{}-Error in execution of before testException is ::{}", scenario.getName(),
					exception.getMessage());
		}
	}

	@After(order = 1)
	public void afterScenarioFinish() throws PactivException {
		tearDown();
		TestResultsUtils.extentReportFlush();
//		try {
//			if (scenario.isFailed()) {
//				DriverUtilsImpl driverUtilsImpl = new DriverUtilsImpl();
//				TestResultsUtils.logger.log(LogStatus.FAIL, "Failed Screenshot", TestResultsUtils.logger
//						.addBase64ScreenShot(driverUtilsImpl.takescreenshot(scenario.getName())));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			LOG.error("Exception in taking Screenshot", e.getMessage());
//			throw new PactivException(e);
//		}

	}

	/**
	 * Close.
	 * 
	 * @throws Throwable
	 *
	 * @throws LCBOException the lcbo exception
	 */
	@After(order = 0)
	public void close() throws Throwable {
		try {
			LOG.info("Current scenario status is::{}", LocalTestDataManager.getScenarioStatus());
			TestResultsUtils.extentReportClose();
			// Destination File
			Thread.sleep(10000);
			TestResultsUtils.copyReport();
			TestResultsUtils.takeDashboardScreenshot();
			TestResultsUtils.zipTheReport();
		} catch (Exception exception) {
			LOG.error("Error in In After Block execution::{}", exception.getMessage());
			throw new PactivException(exception);
		}
	}

	/*
	 * @AfterSuite public static void closeReport() throws Throwable {
	 * System.out.println("AfterSuite is being executed now!!");
	 * LOG.info("Creating the report"); TestResultsUtils.extentReportClose();
	 * tearDown(); // Destination File Thread.sleep(10000);
	 * TestResultsUtils.copyReport(); TestResultsUtils.takeDashboardScreenshot(); }
	 */

}
