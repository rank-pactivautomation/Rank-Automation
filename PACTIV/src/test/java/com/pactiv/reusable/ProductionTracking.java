package com.pactiv.reusable;

import com.pactiv.exception.PactivException;
import com.pactiv.pageobjects.PactivLogin;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ProductionTracking {

	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	com.pactiv.pageobjects.ProductionTracking ProductionTracking = new com.pactiv.pageobjects.ProductionTracking();
	PactivLogin PactivLogin = new PactivLogin();

	public boolean verifyLandingScreenAsPT() throws PactivException {
		if (usablemethods.isElementPresent(ProductionTracking.prodTrackTitle))
			return true;
		return false;
	}

	public boolean verifyLandingScreenHasPTIcon() throws PactivException {
		if (usablemethods.isElementPresent(ProductionTracking.prodTrackIconDashboard))
			return true;
		return false;
	}

	public void clearOldDiagnosis() throws PactivException {
		int i = 0;
		while (usablemethods.isElementPresent(ProductionTracking.productiontracking_resolve) && i > 3) {
			usablemethods.gClick(ProductionTracking.productiontracking_resolve);
			TestResultsUtils.setTrue("Resolve button is clicked");
			usablemethods.sendData(ProductionTracking.productiontracking_resolvecomment, "Resolve the diagnosis");
			TestResultsUtils.setTrue("User adds the comment 'Resolve the diagnosis");
			usablemethods.gClick(ProductionTracking.productiontracking_resolvetick);
			TestResultsUtils.setTrue("Resolve Tick Mark is clicked");
			usablemethods.gClick(ProductionTracking.productiontracking_adddiagnosis);
			TestResultsUtils.setTrue("Add Diagnosis button is clicked");
			usablemethods.gClick(ProductionTracking.productiontracking_dropdown1);
			TestResultsUtils.setTrue("User selects the diagnosis value"
					+ usablemethods.gWebElementGetText(ProductionTracking.productiontracking_dropdown1));
			i++;
		}
	}

	public boolean searchForPendingPTBoxes() throws PactivException {
		boolean status = searchForPendingBoxesShiftWise();
		int lineCount = usablemethods.getWebElementsCount(PactivLogin.plant_line_no);
		if (status)
			return true;
		else {
			while (!status && lineCount > 0) {
				usablemethods.gClick(usablemethods.gGetLlist(PactivLogin.plant_line_no).get(--lineCount));
				TestResultsUtils.setTrue("User changes the Line No");
				status = searchForPendingBoxesShiftWise();
			}
			if (status)
				return true;
			else
				return false;
		}
	}

	public boolean searchForPendingBoxesShiftWise() throws PactivException {
		boolean status = !usablemethods.isElementNotPresent(ProductionTracking.PRODUCTIONTRACK_PENDING);
		int shiftCount = usablemethods.getWebElementsCount(PactivLogin.plantShiftCount);
		while (!status && shiftCount > 0) {
			usablemethods.gClick(ProductionTracking.PRODUCTIONTRACK_TIMEDROPDOWN_CPT);
			TestResultsUtils.setTrue("User clicks on Production Tracking Time Dropdown");
			usablemethods.gClickLinkOrButton(PactivLogin.plantShiftCount, --shiftCount);
			TestResultsUtils.setTrue("User clicks on Production Tracking Time DropDown Value");

			status = !usablemethods.isElementNotPresent(ProductionTracking.PRODUCTIONTRACK_PENDING);
		}
		return status;
	}

	public void addDiagnosis() throws PactivException {
		if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.productiontracking_adddiagnosis)) {
			usablemethods.gClick(ProductionTracking.productiontracking_adddiagnosis);
			TestResultsUtils.logger.log(LogStatus.PASS, "Add Diagnosis button is clicked");
			usablemethods.gClickLinkOrButton(ProductionTracking.PRODUCTIONTRACK_SCRAPPEDROWS_DRPDWN, 0);
			TestResultsUtils.logger.log(LogStatus.PASS, "User selects the diagnosis value"
					+ usablemethods.gWebElementGetText(ProductionTracking.PRODUCTIONTRACK_SCRAPPEDROWS_DRPDWN));
		}
	}

	public void addScrappingDetails(String text) throws PactivException {
		if (usablemethods.isElementPresentAndDisplayed(ProductionTracking.PRODUCTIONTRACK_SCRAPPEDROWS_DETAILS)) {
			usablemethods.gClick(ProductionTracking.PRODUCTIONTRACK_SCRAPPEDROWS_DETAILS);
			TestResultsUtils.logger.log(LogStatus.PASS, "Add Scrapping Details button is clicked");
			usablemethods.sendText(ProductionTracking.PRODUCTIONTRACK_SCRAPPEDROWS_DETAILS_TXTAREA, text);
			TestResultsUtils.setTrue("User enters the scrapping details");
			clickOnSave();
		}
	}

	public boolean enterActualCases(String cases) throws PactivException {
		String goldenCases = usablemethods.gWebElementGetText(ProductionTracking.PRODUCTIONTRACK_GOLDENHOUR);
		boolean status = false;
		switch (cases.toUpperCase()) {
		case "GOLDEN":
			try {
				usablemethods.sendText(ProductionTracking.productiontracking_actualcases, goldenCases);
				status = true;
			} catch (PactivException e) {
				// TODO: handle exception
				e.printStackTrace();
				status = false;
			}
			break;
		case "MORE THAN GOLDEN":
			try {
				String largeGoldenCases = (Integer.valueOf(goldenCases) + 5) + "";
				usablemethods.sendText(ProductionTracking.productiontracking_actualcases, largeGoldenCases);
				status = true;
			} catch (PactivException e) {
				// TODO: handle exception
				e.printStackTrace();
				status = false;
			}
			break;
		case "LESS THAN GOLDEN":
			try {
				String lessGoldenCases = (Integer.valueOf(goldenCases) - 5) + "";
				usablemethods.sendText(ProductionTracking.productiontracking_actualcases, lessGoldenCases);
				status = true;
			} catch (PactivException e) {
				// TODO: handle exception
				e.printStackTrace();
				status = false;
			}
			break;
		default:
			status = false;
			break;
		}
		usablemethods.gClick(ProductionTracking.PRODUCTIONTRACK_PTBOX_POPUP);
		return status;
	}

	public boolean clickOnSave() {
		try {
			usablemethods.gClick(ProductionTracking.PRODUCTIONTRACK_SAVE);
			return true;
		} catch (PactivException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
