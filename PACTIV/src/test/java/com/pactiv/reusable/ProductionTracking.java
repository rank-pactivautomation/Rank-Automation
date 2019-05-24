package com.pactiv.reusable;

import com.pactiv.exception.PactivException;
import com.pactiv.utils.DriverUtilsImpl;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ProductionTracking {

	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	com.pactiv.pageobjects.ProductionTracking ProductionTracking = new com.pactiv.pageobjects.ProductionTracking();

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
}