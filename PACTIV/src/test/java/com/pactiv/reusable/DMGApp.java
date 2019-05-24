package com.pactiv.reusable;

import com.pactiv.exception.PactivException;
import com.pactiv.utils.DriverUtilsImpl;

public class DMGApp {

	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	com.pactiv.pageobjects.DMGApp dmg = new com.pactiv.pageobjects.DMGApp();

	public boolean verifyLandingScreenAsDMGHome() throws PactivException {
		if (usablemethods.isElementPresent(dmg.DMG_HOME_LOGO) && usablemethods.isElementPresent(dmg.DMG_HOME_LOGOTEXT))
			return true;
		return false;
	}

	public boolean verifyLandingScreenAsAddPlant() throws PactivException {
		if (usablemethods.isElementPresent(dmg.DMG_ADDPLANT_HOME_LOGO))
			return true;
		return false;
	}
}
