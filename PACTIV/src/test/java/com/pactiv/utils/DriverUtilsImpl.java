package com.pactiv.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.config.*;
import com.pactiv.constants.*;
import com.pactiv.exception.PactivException;
import com.pactiv.utils.DCTUtils;
import com.pactiv.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

/**
 * The Class DriverUtilsImpl.
 *
 * @author skumargoureshetty
 * @author nigoyal
 */

/** The base project path. */
public class DriverUtilsImpl implements DriverUtils {
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverUtilsImpl.class);

	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The url. */
	private String URL;
	TestResultsUtils testResultUtils = new TestResultsUtils();

	/** The handle popups. */
	public static String handlePopups = configprops.getProperty(Constants.HANDLE_POPUP);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#isPageLoaded()
	 */
	@Override
	public boolean isPageLoaded() throws PactivException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

		/*
		 * try { LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000,
		 * TimeUnit.MILLISECONDS); return
		 * (LocalDriverManager.getDriver().getTitle().contains(pageTitle)); } catch
		 * (Exception exception) { throw new PactivException(exception); }
		 */
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#openPage(java.lang.String)
	 */
	@Override
	public void openPage(String webSiteUrl) throws PactivException {
		try {
			URL = webSiteUrl;
			addPageLoadTimeout();
			LocalDriverManager.getDriver().manage().timeouts().pageLoadTimeout(
					Integer.parseInt(configprops.getProperty(Constants.TIME_OUT_DURATION)), TimeUnit.SECONDS);

			LocalDriverManager.getDriver().get(webSiteUrl);
		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new PactivException(exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#getTitle()
	 */
	@Override
	public String getTitle() {
		return pageTitle;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#getURL()
	 */
	@Override
	public String getURL() {
		return URL;
	}

	/**
	 * Send text keys to the element that finds by cssSelector. It shortens
	 * "LocalDriverManager.getDriver().findElement(By.cssSelector()).sendKeys()".
	 *
	 * @param idSelector the id selector
	 * @param text       the text
	 * @return true, if successful
	 * @throws PactivException the avepoint exception
	 */
	@Override
	public boolean sendText(By idSelector, String text) throws PactivException {
		try {
			LOG.info("In sendText():: Entering " + text + " in " + idSelector);
			WebElement element = getWebElement(idSelector);
			waitUntilElementClickable(element);
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(text);
				return true;
			} else {
				return false;
			}
		} catch (Throwable t) {
			LOG.error("Printing error: " + t.getMessage());
			throw new PactivException("Send Text error");
		}
	}

	/**
	 * Send text keys to the element that finds by cssSelector. It shortens
	 * "LocalDriverManager.getDriver().findElement(By.cssSelector()).sendKeys()".
	 *
	 * @param by the by
	 * @return true, if is element present
	 * @throws AvepointException
	 */

	/** Is the Element in page. */
	@Override
	public boolean isElementPresent(By by) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			LocalDriverManager.getDriver().findElement(by);// if it does not
			// find the element
			// throw
			// NoSuchElementException, thus returns
			// false.
			return true;

		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * Number of elements present.
	 *
	 * @param by the by
	 * @return the int
	 * @throws PactivException the avepoint exception
	 */
	@Override
	public int numberOfElementsPresent(By by) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			return LocalDriverManager.getDriver().findElements(by).size();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * Send text keys to the element that finds by cssSelector. It shortens
	 * "LocalDriverManager.getDriver().findElement if the element is not present on
	 * the page then returns true
	 *
	 * @param by the by
	 * @return true, if is element not present
	 * @throws AvepointException the avepoint exception
	 */

	/** Is the Element in page. */
	@Override
	public boolean isElementNotPresent(By by) throws PactivException {
		// if it does not find the element then
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			if (LocalDriverManager.getDriver().findElements(by).size() < 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception exception) {
			LOG.error("Not Entered");
			return false;
		}
	}

	/**
	 * Is the Element present in the DOM.
	 *
	 * @param _cssSelector element locater
	 * @return WebElement
	 * @throws PactivException the avepoint exception
	 */

	@Override
	public boolean isElementPresent(String _cssSelector) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			LocalDriverManager.getDriver().findElement(By.cssSelector(_cssSelector));
			return true;

		} catch (NoSuchElementException exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * Checks if the element is in the DOM and displayed.
	 *
	 * @param by - selector to find the element
	 * @return true or false
	 * @throws PactivException the avepoint exception
	 */
	@Override
	public boolean isElementPresentAndDisplayed(By by) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			return LocalDriverManager.getDriver().findElement(by).isDisplayed();
		} catch (NoSuchElementException exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * Returns the first WebElement using the given method. It shortens
	 * "LocalDriverManager.getDriver().findElement(By)".
	 *
	 * @param by element locater.
	 * @return the first WebElement
	 * @throws PactivException the avepoint exception
	 */
	@Override
	public WebElement getWebElement(By by) throws PactivException {
		try {
			return LocalDriverManager.getDriver().findElement(by);
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// ***********************************************************************************************************************
	// 'Function Name : gGetLlist
	// 'Script Description : Returns the List of a given WebElement
	// 'Input Parameters :
	// 'Return Value :

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gGetLlist(org.openqa.selenium.By)
	 */
	@Override
	public List<WebElement> gGetLlist(By wElement) throws PactivException {

		try {
			WebDriverWait webDriverWait = new WebDriverWait(LocalDriverManager.getDriver(), 50);
			webDriverWait.until(
					ExpectedConditions.visibilityOfAllElements(LocalDriverManager.getDriver().findElements(wElement)));
			List<WebElement> strList = LocalDriverManager.getDriver().findElements(wElement);
			return strList;

		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	/**
	 * Gets the web elements count.
	 *
	 * @param wElement the w element
	 * @return the web elements count
	 * @throws PactivException the avepoint exception
	 */
	public int getWebElementsCount(By wElement) throws PactivException {
		addPageLoadTimeout();
		try {
			int count = LocalDriverManager.getDriver().findElements(wElement).size();
			return count;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	// ***********************************************************************************************************************
	// 'Function Name : gExplictWait
	// 'Script Description : To wait for a webelement in a application
	// 'Input Parameters : 1. elementLocator - Locator(By) of Element to be wait
	// for
	// 2. maxTimeOut - Integer value of max time out in second
	// 3. strConditionMode - Condition mode to apply on wait (possible values
	// are ,VISIBILITY,INVISIBILITY ,FRAME ,PRESENCE )
	// 4. strFrameLocator - Frame ID(String) , when strConditionMode selected as
	// FRAME
	// 'Return Value :

	/**
	 * The Enum conditionalWait.
	 */
	public enum conditionalWait {

		/** The visibility. */
		VISIBILITY,
		/** The invisibility. */
		INVISIBILITY,
		/** The frame. */
		FRAME,
		/** The presence. */
		PRESENCE,
		/** The popupalert. */
		POPUPALERT;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gExplicitWait(org.openqa.selenium.By, int,
	 * java.lang.String, java.lang.String)
	 */
	/*
	 * @Override public void gExplicitWait(By elementLocator, int maxTimeOut, String
	 * strConditionMode, String strName) throws AvepointException {
	 *
	 * try {
	 *
	 * conditionalWait mode =
	 * conditionalWait.valueOf(strConditionMode.toUpperCase()); //
	 * Reporter.log("'gExplicitWait' function called for "+ // strConditionMode);
	 *
	 * switch (mode) { case VISIBILITY: (new
	 * WebDriverWait(LocalDriverManager.getDriver(), maxTimeOut))
	 * .until(ExpectedConditions.visibilityOfElementLocated(elementLocator)); break;
	 *
	 * case INVISIBILITY: (new WebDriverWait(LocalDriverManager.getDriver(),
	 * maxTimeOut))
	 * .until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
	 * break;
	 *
	 * case FRAME: // Reporter.log("gExplicitWait is called to wait for element :"+
	 * // strName); (new WebDriverWait(LocalDriverManager.getDriver(), maxTimeOut))
	 * .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strName)); new
	 * WebDriverWait(LocalDriverManager.getDriver(), 10).until(
	 * ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "//*[contains(text(),'Deloitte')]"))); break;
	 *
	 * case PRESENCE: (new WebDriverWait(LocalDriverManager.getDriver(),
	 * maxTimeOut))
	 * .until(ExpectedConditions.presenceOfElementLocated(elementLocator)); break;
	 *
	 * case POPUPALERT: List<WebElement> popupElements =
	 * LocalDriverManager.getDriver().findElements(elementLocator); int count =
	 * popupElements.size(); if (count > 0) { (new
	 * WebDriverWait(LocalDriverManager.getDriver(), maxTimeOut))
	 * .until(ExpectedConditions.visibilityOfElementLocated(elementLocator)); for
	 * (int j = 0; j < count; j++) { popupElements.get(j).click();
	 * Thread.sleep(1500); } break; } } } catch (Exception exception) { throw new
	 * AvepointException(exception); }
	 *
	 * }
	 */

	// '**************************************************************************************************************
	// 'Function Name : gElementFocus
	// 'Script Description : To Focus on a particular Element
	// 'Input Parameters : strXpath - Xpath of the Element to be focused.
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gElementFocus(org.openqa.selenium.By)
	 */
	// 'Return Value : true/false
	@Override
	public boolean gElementFocus(By wElement) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			// create a WebElement for a given object using it's Xpath/Id
			WebElement strElement = LocalDriverManager.getDriver().findElement(wElement);

			// Focus on given element
			new Actions(LocalDriverManager.getDriver()).moveToElement(strElement).perform();

			return true;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// '***********************************************************************************************************************
	// 'Function Name : gClickLinkOrButton
	// 'Script Description : To perform link click based on class name and text
	// properties
	// 'Input Parameters :
	// ' 1. strLink - Id/Name/linktext/Xpath of the link/button
	// 2. index - position of the link that you want to click(Ex: 0,1)
	// 'Return Value : true

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gClickLinkOrButton(org.openqa.selenium.
	 * By, int)
	 */
	@Override
	public boolean gClickLinkOrButton(By strLink, int index) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> lstLinks = LocalDriverManager.getDriver().findElements(strLink);
			addPageLoadTimeout();
			lstLinks.get(index).click();
			Thread.sleep(2000);
			return true;

		} catch (Exception exception) {
			hitEscapeKeyForPopups();
			throw new PactivException(exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gClick(org.openqa.selenium.By)
	 */
	/*
	 * *************************************************************************
	 * *********************************************** Function Name: click on any
	 * element
	 *
	 * Description : To perform click operation on button or link and etc
	 */
	@Override
	public boolean gClick(By elementLocator) throws PactivException {
		try {
			LOG.info("in gclick ::{}", elementLocator);
			if (getWebElement(elementLocator).isEnabled()) {
				addPageLoadTimeout();
				waitUntilElementClickable(getWebElement(elementLocator));
				getWebElement(elementLocator).click();
				hitEscapeKeyForPopups();
				return true;
			} else {
				LOG.info("Element is not enabled::{}", elementLocator);
				return false;
			}
		} catch (Throwable t) {
			LOG.error("Printing error : " + t.getMessage());
//			String homescreenshot = takescreenshot("home page");
//			TestResultsUtils.logger.log(LogStatus.FAIL, "Field is not clicked",
//					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
			;
			throw new PactivException("gClick Exception");

		}
	}

	public boolean sendData(By elementLocator, String text) throws PactivException {
		try {
			if (LocalDriverManager.getDriver().findElement(elementLocator).isEnabled()) {
				LocalDriverManager.getDriver().findElement(elementLocator).sendKeys(text);
				return true;
			} else {
				return false;
			}
		} catch (Throwable t) {
			LOG.error("Printing error: " + t.getMessage());
			throw new PactivException("Send Text error");
		}
	}

	/*
	 * *************************************************************************
	 * *********************************************** Function Name: click on any
	 * element using javascript executor
	 *
	 * Description : To perform click operation on button or link and etc
	 */
	public boolean jClick(By elementLocator) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			if (LocalDriverManager.getDriver().findElement(elementLocator).isEnabled()) {
				LOG.info(LocalDriverManager.getDriver().findElement(elementLocator).getText());
				WebElement element = LocalDriverManager.getDriver().findElement(elementLocator);
				JavascriptExecutor executor = (JavascriptExecutor) LocalDriverManager.getDriver();
				executor.executeScript("arguments[0].click();", element);
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * G click.
	 *
	 * @param elementLocator the element locator
	 * @param text           the text
	 * @return true, if successful
	 * @throws PactivException the avepoint exception
	 */
	public boolean gClick(By elementLocator, String text) throws PactivException {
		try {
			String xPath = elementLocator.toString();
			if (xPath.contains("dummy")) {
				xPath = buildXpath(xPath, text);
			} else {
				return false;
			}
			By element = By.xpath(xPath);
			if (LocalDriverManager.getDriver().findElement(element).isEnabled()) {
				LocalDriverManager.getDriver().findElement(element).click();
				Thread.sleep(5000);
				hitEscapeKeyForPopups();
				LOG.info("after escape");
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/**
	 * J click.
	 *
	 * @param elementLocator the element locator
	 * @param text           the text
	 * @return true, if successful
	 * @throws PactivException the avepoint exception
	 */
	public boolean jClick(By elementLocator, String text) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			String xPath = elementLocator.toString();
			if (xPath.contains("dummy")) {
				xPath = buildXpath(xPath, text);
			} else {
				return false;
			}
			By element = By.xpath(xPath);
			LOG.info("dummy" + element);
			if (LocalDriverManager.getDriver().findElement(element).isEnabled()) {
				WebElement jelement = LocalDriverManager.getDriver().findElement(element);
				JavascriptExecutor executor = (JavascriptExecutor) LocalDriverManager.getDriver();
				executor.executeScript("arguments[0].click();", jelement);
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// '**********************************************************************************************************************
	// 'Function Name : gEditTextbox
	// 'Script Description : To perform enter text in a textbox based on name
	// property
	// 'Input Parameters :
	// ' 1. strName - Name of the Textbox
	// 2. strValue - Value of the Textbox
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gEditTextbox(org.openqa.selenium.By,
	 * java.lang.String, int)
	 */
	// 'Return Value : true
	@Override
	public boolean gEditTextbox(By txtKeywords, String strValue, int index) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> ls = LocalDriverManager.getDriver().findElements(txtKeywords);
			ls.get(index).clear();
			ls.get(index).sendKeys(strValue);
			return true;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	// '**************************************************************************************************************
	// 'Function Name : gRadioSelectValue
	// 'Script Description : To set the value of a Radio Button
	// 'Input Parameters : 1. strName 2. strRadioValue - Value to be selected in
	// the Radiobutton(Ex: 0,1, etc...)
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gRadioSelectValue(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	// 'Return Value : true
	@Override
	public boolean gRadioSelectValue(By strName, String strRadioValue) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			// List<WebElement> strRadioList =
			// LocalDriverManager.getDriver().findElements(By.name(strName));
			addPageLoadTimeout();
			List<WebElement> strRadioList = LocalDriverManager.getDriver().findElements(strName);
			for (WebElement indRadio : strRadioList) {
				if (strRadioValue.equalsIgnoreCase(indRadio.getAttribute("value"))) {
					indRadio.click();
					break;
				}
			}
			return true;
		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
			return true;
		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// '**************************************************************************************************************
	// 'Function Name : gListGetValue
	// 'Script Description : To Get the value in a List box
	// 'Input Parameters : strId - Id property of the List Box
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gListGetValue(org.openqa.selenium.By)
	 */
	// 'Return Value : strText - Value(Text) of the list box which is selected
	@Override
	public String gListGetValue(By strId) throws PactivException {
		return URL;
		/*
		 * try { LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000,
		 * TimeUnit.MILLISECONDS); String strText = null; Select selectListBox = new
		 * Select(LocalDriverManager.getDriver().findElement(strId)); strText =
		 * selectListBox.getFirstSelectedOption().getText(); return strText; } catch
		 * (Exception exception) {
		 * 
		 * throw new PactivException(exception); }
		 */
	}

	// '**************************************************************************************************************
	// 'Function Name : gRadioGetValue
	// 'Script Description : To Get the value of a Radio Button
	// 'Input Parameters : strName - Name property of the Radiobutton
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gRadioGetValue(org.openqa.selenium.By)
	 */
	// 'Return Value : strText - Value of the Radiobutton(Ex: 0,1, etc..)
	@Override
	public String gRadioGetValue(By strName) throws PactivException {
		try {
			String strText = null;
			List<WebElement> radiostrDocHeader = LocalDriverManager.getDriver().findElements(strName);
			for (WebElement indRadioradiostrDocHeader : radiostrDocHeader) {
				if (indRadioradiostrDocHeader.isSelected() == true) {
					strText = indRadioradiostrDocHeader.getAttribute("value");
					break;
				}
			}

			return strText;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// '**************************************************************************************************************
	// 'Function Name : gCheckBoxSelect
	// 'Script Description : To Set a value in a CheckBox (On/OFF)
	// 'Input Parameters : 1. strId - ID property of the list box to be selected
	// 2. strChkBoxValue - Value to be selected (ON/OFF)
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gCheckBoxSelect(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	// 'Return Value : boolean(true/false)
	@Override
	public boolean gCheckBoxSelect(By strId, String strChkBoxValue) throws PactivException {

		try {

			boolean strFlag = LocalDriverManager.getDriver().findElement(strId).isSelected();
			if ((strFlag == false && strChkBoxValue == "ON") || (strFlag == true && strChkBoxValue == "OFF")) {
				LocalDriverManager.getDriver().findElement(strId).click();
				Thread.sleep(1000);
			}
			return true;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// '**************************************************************************************************************
	// 'Function Name : gMouseHover
	// 'Script Description : To Hover the Mouse on a given link
	// 'Input Parameters : 1. strXpath - ID property of the link to hover
	// 'Return Value : boolean(true/false)

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gMouseHover(org.openqa.selenium.By)
	 */
	@Override
	public boolean gMouseHover(By strXpath) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			Actions builder = new Actions(LocalDriverManager.getDriver());
			WebElement MenuElement = LocalDriverManager.getDriver().findElement(strXpath);
			builder.moveToElement(MenuElement).build().perform();
			Thread.sleep(2000);
			return true;
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// '**************************************************************************************************************
	// 'Function Name : gIsDisplayed
	// 'Script Description : To Verfiy the Object is Displayed or not
	// 'Input Parameters : WebElement (Object)
	// 'Return Value :

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gIsDisplayed(org.openqa.selenium.By)
	 */
	@Override
	public void gIsDisplayed(By wElement) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			LocalDriverManager.getDriver().findElement(wElement).isDisplayed();
		} catch (Exception exception) {
			throw new PactivException(exception);

		}

	}

	// '**************************************************************************************************************
	// 'Function Name : gWebElementGetText
	// 'Script Description : To Get the Text of any web element (ex: link, Page
	// title)
	// 'Input Parameters : WebElement (Object)
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gWebElementGetTexts(org.openqa.selenium.
	 * By, int)
	 */
	// 'Return Value : true/false
	@Override
	public String gWebElementGetTexts(By wElement, int index) throws PactivException {
		// TODO check
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> lstWebElement = LocalDriverManager.getDriver().findElements(wElement);
			if (lstWebElement.size() > 0) {
				String strText = lstWebElement.get(index).getText();
				return strText;
			} else {
				throw new Exception();
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gWebElementGetText(org.openqa.selenium.
	 * By)
	 */
	@Override
	public String gWebElementGetText(By wElement) throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			WebElement element = LocalDriverManager.getDriver().findElement(wElement);
			String text = element.getText();
			return text;
		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	// '**************************************************************************************************************
	// 'Function Name : gListSelect
	// 'Script Description : Select the given value from a list box
	// 'Input Parameters : listName(Name of the list box), listValue(Value to be
	// selected)
	// 'Return Value : true/false

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gListSelect(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	@Override
	public boolean gListSelect(By lstPracArea, String lstValue) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			new Select(LocalDriverManager.getDriver().findElement(lstPracArea)).selectByVisibleText(lstValue);
			Thread.sleep(3000);
			return true;

		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gVerifyText
	// 'Script Description : To Verify the Text is present or not in a page.
	// 'Input Parameters : 1. wElement - WebElement of a page to get the text.
	// 2. strVerifyText - Text to be validated.
	// 'Return Value :

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gVerifyText(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	@Override
	public void gVerifyText(By wElement, String strVerifyText) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			if (!LocalDriverManager.getDriver().findElement(wElement).getText().trim().contains(strVerifyText)) {
				throw new Exception();
			}

		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gVerifyContainsText
	// 'Script Description : To Verify the Text is present or not in a page.
	// 'Input Parameters : 1. strToCompare - Text to compare.
	// 2. strVerifyText - Text to be validated.
	// 'Return Value :

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gVerifyContainsText(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void gVerifyContainsText(String strToCompare, String strVerifyText) throws PactivException {
		try {
			if (!strToCompare.contains(strVerifyText)) {
				throw new Exception();
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gVerifyAttributeValue
	// 'Script Description : To Verify the Tool Tip of a given Object
	// 'Input Parameters : 1. webElement - Object property
	// 2.strProperty - Property value (Ex: alt, title)
	// 3. strText - Expected Tool Tip
	// 'Return Value :
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gVerifyAttributeValue(org.openqa.selenium
	 * .By, java.lang.String, java.lang.String)
	 */
	// TODO check
	@Override
	public Boolean gVerifyAttributeValue(By webElement, String strProperty, String strText) throws PactivException {

		Boolean isAttributePresent = false;
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			String attributevalue = LocalDriverManager.getDriver().findElement(webElement).getAttribute(strProperty);
			if (!attributevalue.trim().equalsIgnoreCase(strText)) {
				throw new Exception();
			} else {
				isAttributePresent = true;
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
		return isAttributePresent;
	}

	// ***********************************************************************************************************************
	// 'Function Name : gVerifySelectedOrDeselected
	// 'Script Description : To verify webelement/s is selected or deselected
	// 'Input Parameters : wel - WebElement name
	// strSelect - possible parameters("selected", "deselected")
	// 'Return Value : true
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#isSelected(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	// TODO check
	@Override
	public boolean isSelected(By wel, String strSelection) throws PactivException {

		try {
			if (strSelection.equalsIgnoreCase("selected")) {
				List<WebElement> lstTaxTypes = gGetLlist(wel);
				for (int i = 0; i <= lstTaxTypes.size() - 1; i++) {
					if (!lstTaxTypes.get(i).isSelected()) {
						throw new Exception();
					}

				}

			}
			if (strSelection.equalsIgnoreCase("deselected")) {
				List<WebElement> lstTaxTypes = gGetLlist(wel);
				for (int i = 0; i <= lstTaxTypes.size() - 1; i++) {
					if (lstTaxTypes.get(i).isSelected()) {
						throw new Exception();
					}

				}
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
		return true;
	}

	// ***********************************************************************************************************************
	// 'Function Name : gVerifyEnabledOrDisabled
	// 'Script Description : To verify webelement/s is enabled or disabled
	// 'Input Parameters : wel - WebElement name
	// strSelect - possible parameters("enabled", "disabled")
	// 'Return Value : true
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#isEnabled(org.openqa.selenium.By,
	 * java.lang.String)
	 */
	// TODO check
	@Override

	public boolean isEnabled(By wel, String strSelection) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			if (strSelection.equalsIgnoreCase("enabled")) {
				List<WebElement> lstTaxTypes = gGetLlist(wel);
				for (int i = 0; i <= lstTaxTypes.size() - 1; i++) {
					if (!lstTaxTypes.get(i).isEnabled()) {
						throw new Exception();
					}

				}

			}
			if (strSelection.equalsIgnoreCase("disabled")) {
				List<WebElement> lstTaxTypes = gGetLlist(wel);
				for (int i = 0; i <= lstTaxTypes.size() - 1; i++) {
					if (lstTaxTypes.get(i).isEnabled()) {
						throw new Exception();
					}

				}
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
		return true;
	}

	// '**************************************************************************************************************
	// 'Function Name : gSwitchFrame
	// 'Script Description : To switch one frame to other frame
	// 'Input Parameters : 1. strFrameid-Property of the frame /Id(or) Name of
	// the frame 2. strFrameType -
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gSwitchFrame(java.lang.String,
	 * java.lang.String)
	 */
	// 'Return Value : true
	@Override
	public boolean gSwitchFrame(String strFrameid, String strFrameType) throws PactivException {
		return false;

		/*
		 * try { LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000,
		 * TimeUnit.MILLISECONDS); String srtUpperCase =
		 * String.valueOf(strFrameType.toUpperCase()); switch (srtUpperCase) { case
		 * "INT": // To handle if entered frame Id is number int typeInt =
		 * Integer.parseInt(strFrameid);
		 * LocalDriverManager.getDriver().switchTo().frame(typeInt); break; case
		 * "STRING": // To handle if entered frame Id is string
		 * LocalDriverManager.getDriver().switchTo().frame(strFrameid); break; case
		 * "WEBELEMENT": // To handle if entered frame Id is webelement
		 * LocalDriverManager.getDriver().switchTo().frame(strFrameid); break; case
		 * "DEFAULT": // To switch default frame
		 * LocalDriverManager.getDriver().switchTo().defaultContent(); break; } return
		 * true; } catch (Exception exception) { throw new PactivException(exception); }
		 */

	}

	// **************************************************************************************************************
	// 'Function Name : gVerifyCloseWindow
	// 'Script Description : Click on the element in nested iframe.
	// 'Input Parameters : searchText - Search Text
	// searchFlag - Flag to indicate for searching the text
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gVerifyCloseWindow(java.lang.String,
	 * java.lang.String)
	 */
	// 'Return Value :
	@Override
	public void gVerifyCloseWindow(String searchText, String searchFlag) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			Set<String> winID = LocalDriverManager.getDriver().getWindowHandles();
			Iterator<String> it = winID.iterator();
			String mainWin = it.next();
			String popUpWin = it.next();

			LocalDriverManager.getDriver().switchTo().window(popUpWin);
			Thread.sleep(2000);
			if (searchFlag.equalsIgnoreCase("yes")) {
				// LocalDriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'"+searchText+"')]")).isDisplayed();
				gIsDisplayed(By.xpath("//*[contains(text(),'" + searchText + "')]"));
			}

			LocalDriverManager.getDriver().close();
			LocalDriverManager.getDriver().switchTo().window(mainWin);

		} catch (InterruptedException exception) {

			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gGetAttributeValue
	// 'Script Description : To get text from attribute
	// 'Input Parameters : 1. webElement - Object property
	// 2.strProperty - Property value (Ex: alt, title)
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gGetAttributeValue(org.openqa.selenium.
	 * By, java.lang.String)
	 */
	// 'Return Value :
	@Override
	public String gGetAttributeValue(By webElement, String strProperty) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> lstWebElement = LocalDriverManager.getDriver().findElements(webElement);
			if (lstWebElement.size() > 0) {
				String strAttributeValue = LocalDriverManager.getDriver().findElement(webElement)
						.getAttribute(strProperty);
				/*
				 * if(!strAppToolTip.trim().equalsIgnoreCase(strText)){ throw new Exception();
				 */
				return strAttributeValue;
			} else {
				throw new Exception();
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	// '***********************************************************************************************************************
	// 'Function Name : gEditTextboxWithOutClear
	// 'Script Description : To perform enter text in a textbox based on name
	// property
	// 'Input Parameters :
	// ' 1. strName - Name of the Textbox
	// 2. strValue - Value of the Textbox
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gEditTextboxWithOutClear(org.openqa.
	 * selenium.By, java.lang.String, int)
	 */
	// 'Return Value : true
	@Override
	public boolean gEditTextboxWithOutClear(By txtKeywords, String strValue, int index) throws PactivException {

		try {
			List<WebElement> ls = LocalDriverManager.getDriver().findElements(txtKeywords);
			ls.get(index).sendKeys(strValue);
			return true;

		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	// '**************************************************************************************************************
	// 'Function Name : gGetAllOptions
	// 'Script Description : to get all Options from list box.
	// 'Input Parameters : By lstofOptions (Web element)
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gGetAllOptions(org.openqa.selenium.By)
	 */
	// 'Return Value : true
	@Override
	public List<WebElement> gGetAllOptions(By strWebElement) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			Select strList = new Select(LocalDriverManager.getDriver().findElement(strWebElement));
			List<WebElement> lstOptions = strList.getOptions();
			return lstOptions;
		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	// **************************************************************************************************************
	// 'Function Name : gScrollPageDown
	// 'Script Description : Scrolling the page down
	// 'Input Parameters : None
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gScrollPage(int, int)
	 */
	// 'Return Value :

	public void gScrollPageDown() throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			JavascriptExecutor jse = (JavascriptExecutor) LocalDriverManager.getDriver();
			jse.executeScript("window.scrollBy(0,250)", "");
			jse.executeScript("scroll(0, 250);");

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// **************************************************************************************************************
	// 'Function Name : gScrollPageUp
	// 'Script Description : Scrolling the page down
	// 'Input Parameters : None
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gScrollPage(int, int)
	 */
	// 'Return Value :

	public void gScrollPageUp() throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			JavascriptExecutor jse = (JavascriptExecutor) LocalDriverManager.getDriver();
			jse.executeScript("window.scrollBy(0,-250)", "");
			jse.executeScript("scroll(0, -250);");

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gValidateTextAndReutrn
	// 'Script Description : To Verify the Text is present or not in a page and
	// return boolean value.
	// 'Input Parameters : 1. wElement - WebElement of a page to get the text.
	// 2. strVerifyText - Text to be validated.
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gVerifyTextAndReturn(org.openqa.selenium.
	 * By, java.lang.String)
	 */
	// 'Return Value :
	@Override
	public boolean gVerifyTextAndReturn(By by, String strVerifyText) throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> list = LocalDriverManager.getDriver().findElements(by);
			if (list.size() > 0 && list.get(0).getText().trim().contains(strVerifyText)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception exception) {

			throw new PactivException(exception);
		}
	}

	// ******************************************************************************************************************
	// 'Function Name : gNavBackBrowser
	// 'Script Description : To navigate back browser
	// 'Input Parameters :
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gNavBackBrowser()
	 */
	// 'Return Value :
	@Override
	public void gNavBackBrowser() throws PactivException {
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			addPageLoadTimeout();
			LocalDriverManager.getDriver().navigate().back();

		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	// **************************************************************************************************************
	// 'Function Name : gPageReload
	// 'Script Description : Reload the Page.
	// 'Input Parameters :
	//
	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gPageReload()
	 */
	// 'Return Value :
	@Override

	public void gPageReload() throws PactivException {

		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			LocalDriverManager.getDriver().switchTo().defaultContent();

			addPageLoadTimeout();
			LocalDriverManager.getDriver().navigate().refresh();
			// (or)((JavascriptExecutor)
			// LocalDriverManager.getDriver()).executeScript("location.reload();");

		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#gListOfValues(org.openqa.selenium.By)
	 */
	/*
	 * Function Name:gListOfValues
	 *
	 * Description: This will return the values of checkbox/radio buttons/links and
	 * etc
	 */
	@Override
	public List<String> gListOfValues(By elementLocator) throws PactivException {
		List<String> values = new ArrayList<String>();
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			for (int i = 0; i < LocalDriverManager.getDriver().findElements(elementLocator).size(); i++) {
				values.add(LocalDriverManager.getDriver().findElements(elementLocator).get(i).getText().trim());
			}
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
		return values;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#getTableData(org.openqa.selenium.By,
	 * org.openqa.selenium.By, org.openqa.selenium.By)
	 */
	/*
	 * Function Name=getTableData
	 *
	 * Description:Used to get the data from html table
	 */
	@Override
	public String[] getTableData(By tableElementLocator, By tableRowLocator, By tableDataLocator)
			throws PactivException {
		String[] tableData = null;
		try {
			// Get All Items from Cart
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			WebElement table_element = LocalDriverManager.getDriver().findElement(tableElementLocator);
			List<WebElement> tr_collection = table_element.findElements(tableRowLocator);
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(tableDataLocator);
				for (WebElement tdElement : td_collection) {
					LOG.info("{}", tdElement.getText().split("[\\r\\n]+"));
					tableData = tdElement.getText().split("[\\r\\n]+");
				}
			}
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
		return tableData;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#getHtmlTableData(org.openqa.selenium.By)
	 */
	/*
	 * Function Name: getHtmlTableData
	 *
	 * Description: Used to get the table data with single parameter
	 */
	@Override

	public List<String> getHtmlTableData(By tableLocator) throws PactivException {
		List<String> tableData = new ArrayList<String>();
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> tbl_element = LocalDriverManager.getDriver().findElements(tableLocator);

			for (int i = 0; i < tbl_element.size(); i++) {
				tableData.add(tbl_element.get(i).getText());
			}
		} catch (Exception exception) {
			throw new PactivException();
		}
		return tableData;
	}

	/*
	 * Function Name=getListOfWindows
	 *
	 * Description:It will return the list of windows as set object
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#getListWindows()
	 */
	@Override
	public Set<String> getListWindows() {
		return LocalDriverManager.getDriver().getWindowHandles();
	}

	/*
	 * Function Name=switchToNewWindow
	 *
	 * Description:It will return the list of windows as set object
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#switchToNewWindow()
	 */
	@Override
	public boolean switchToNewWindow() throws PactivException {
		try {
			addPageLoadTimeout();

			LocalDriverManager.getDriver().switchTo().window(LocalDriverManager.getDriver().getWindowHandle());
			return true;
		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
			return true;
		} catch (Exception exception) {
			throw new PactivException();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#switchToNewWindow(java.lang.String)
	 */
	/*
	 * Function Name=switchToNewWindow
	 *
	 * Description:It will return the list of windows as set object
	 *
	 */
	@Override
	public boolean switchToNewWindow(String newWindowHandle) throws PactivException {
		try {
			addPageLoadTimeout();
			LocalDriverManager.getDriver().switchTo().window(newWindowHandle);
			return true;
		} catch (TimeoutException timeout) {
			hitEscapeKeyForPopups();
			return true;
		} catch (Exception exception) {
			throw new PactivException(exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.util.DriverUtils#takescreenshot(java.lang.String)
	 */
	@Override
	public String takescreenshot(String scenario) throws PactivException {
		try {
			String startedAt = "";
			String screenshotPath = "";
			// String[] s = DCTUtils.timeStamp().split(Constants.COLON);
			String s = DCTUtils.timeStamp().split(Constants.SPACE)[1];
			s = s.replaceAll(":", " ");
			startedAt = s.split("\\.")[0];
			/*
			 * LOG.info(Arrays.toString(s)); for (int i = 0; i < s.length - 1; i++) {
			 * startedAt = startedAt + "-" + s[i]; }
			 */

			// startedAt = startedAt.substring(1, startedAt.length());
			// startedAt = startedAt.replace(" ", Constants.UNDERSCORE);

			File srcfile = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile,
					new File(TestResultsUtils.screenshotDirectory + "\\sc-" + scenario + startedAt + ".png"));
			screenshotPath = TestResultsUtils.screenshotDirectory + "\\sc-" + scenario + startedAt + ".png";
			return screenshotPath;

		} catch (IOException exception) {
			throw new PactivException(exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.applnlibrary.ReusableMethods#sendKeysAction(org.openqa.
	 * selenium.Keys)
	 *
	 */
	@Override
	public void sendKeysAction(Keys Key) throws PactivException {
		try {
			Actions action = new Actions(LocalDriverManager.getDriver());
			action.sendKeys(Key);
		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.applnlibrary.ReusableMethods#addPageLoadTimeout() This
	 * Method is to override the default pageload timeout of selenium
	 */
	@Override
	public void addPageLoadTimeout() {
		try {
			if (Boolean.valueOf(handlePopups)) {
				LocalDriverManager.getDriver().manage().timeouts().pageLoadTimeout(
						Integer.parseInt(configprops.getProperty(Constants.TIME_OUT_DURATION)), TimeUnit.SECONDS);
			}
		} catch (NumberFormatException exception) {
			LOG.info("Error while resetting the pageload timeout");
		}

	}

	/**
	 * Builds the xpath.
	 *
	 * @param xPath the x path
	 * @param text  the text
	 * @return the string
	 */
	public String buildXpath(String xPath, String text) {
		if (xPath.contains("dummy")) {
			xPath = xPath.replace("dummy", text);
		}
		return xPath;
	}

	/**
	 * Builds the xpath.
	 *
	 * @param elemlocator the elemlocator
	 * @param text        the text
	 * @return the string
	 */
	public String buildXpath(By elemlocator, String text) {
		String xPath = elemlocator.toString();
		if (xPath.contains("dummy")) {
			xPath = xPath.replace("dummy", text);
		}
		xPath = xPath.split("By.xpath:")[1].trim();
		LOG.info("After split" + xPath);
		return xPath;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.avepoint.applnlibrary.ReusableMethods#hitEscapeKeyForPopups() This
	 * method is used to hit escape key for the Windows popup
	 */
	@Override
	public void hitEscapeKeyForPopups() {
		try {
			if (Boolean.valueOf(handlePopups)) {
				sendKeysAction(Keys.ESCAPE);
			}
		} catch (PactivException exception) {
			LOG.error("Error in hitting Escape key for pupup");
		}

	}

	/*
	 * This methods performs an action on a particular element. Parameter passed are
	 * : key like Enter and xpath of any element
	 */

	public void sendKeysAction(Keys Key, By element) throws PactivException {
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			Action action = actions.moveToElement(LocalDriverManager.getDriver().findElement(element)).sendKeys(Key)
					.build();
			action.perform();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	/*
	 * This method closes the browser
	 *
	 */
	public void closeTheBrowser() throws PactivException {
		try {
			LocalDriverManager.getDriver().close();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	/*
	 * Function Name : gDropdownGetValues Script Description Input Parameters :
	 * WebElement Return Value : List
	 */

	public List<String> gDropdownGetValues(By strWebElement) throws PactivException {

		try {
			Select strList = new Select(LocalDriverManager.getDriver().findElement(strWebElement));
			List<WebElement> lstOptions = strList.getOptions();
			System.out.println("Size of page dropdown: " + lstOptions.size());
			List<String> dropDownValues = new ArrayList<String>();
			for (int i = 0; i < lstOptions.size(); i++) {
				dropDownValues.add(lstOptions.get(i).getText());
			}
			return dropDownValues;
		} catch (Exception exception) {

			throw new PactivException(exception);
		}

	}

	/****
	 * This method takes the input as list of expected values, reads the actual
	 * values send true / false
	 **/
	public boolean verifyWebElementsText(By Element, List<String> expectedvalues) {
		List<WebElement> list = LocalDriverManager.getDriver().findElements(Element);
		ArrayList<String> actualvalues = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String element = list.get(i).getText();
			actualvalues.add(element);
		}
		if (expectedvalues.size() == actualvalues.size()) {
			@SuppressWarnings("rawtypes")
			Collection diff = CollectionUtils.subtract(expectedvalues, actualvalues);
			if (diff.isEmpty()) {
				LOG.info("Scenario::{} - Expected values are equal to Actual values",
						LocalTestDataManager.getScenarioname());
			} else {
				LOG.info("Scenario::{} - Expected values are not equal to Actual values::{}",
						LocalTestDataManager.getScenarioname(), diff);
				return false;
			}
		}
		return true;
	}

	public void sendKeyAction(Keys Key, By element) throws PactivException {
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			Action action = actions.moveToElement(LocalDriverManager.getDriver().findElement(element)).sendKeys(Key)
					.build();
			action.perform();
		} catch (Exception exception) {
			throw new PactivException(exception);
		}

	}

	public String getWebElementText(WebElement ele) throws PactivException {
		waitUntilElementEnabled(ele);
		return ele.getText();
	}

	public void waitUntilElementEnabled(WebElement element) {
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitByTime(long t) throws PactivException {
		try {
			LOG.info("In waitByTime for " + t + " seconds");
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("Printing exception :: " + e.getMessage());
			throw new PactivException(e);
		}
	}

	public void enterTab() throws PactivException {
		LOG.info("Before Pressing Tab");
		sendKeysAction(Keys.TAB);
		LOG.info("After Pressing Tab");
	}

	public boolean selectOption(WebElement element, String option) {
		LOG.info("In selectOption on " + element + " with options as " + option);
		Select dropdown = new Select(element);
		addPageLoadTimeout();
		dropdown.selectByVisibleText(option);
		if (dropdown.getFirstSelectedOption().getText().equals(option))
			return true;
		else
			return false;
	}

	public void selectOption(WebElement element) throws PactivException {
		try {
			LOG.info("In selectOption on " + element);
			waitUntilElementClickable(element);
			Select dropdown = new Select(element);
			dropdown.selectByIndex(1);
			dropdown.getFirstSelectedOption();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new PactivException("Printing exception ::" + e.getMessage());
		}
	}
	
	public boolean gClick(WebElement elementLocator) throws PactivException {
		try {
			LOG.info("in gclick ::{}", elementLocator);
			if (elementLocator.isEnabled()) {
				waitUntilElementClickable(elementLocator);
				(elementLocator).click();
				hitEscapeKeyForPopups();
				return true;
			} else {
				LOG.info("Element is not enabled::{}", elementLocator);
				return false;
			}
		} catch (Throwable t) {
			LOG.error("Printing error : " + t.getMessage());
//			String homescreenshot = takescreenshot("home page");
//			TestResultsUtils.logger.log(LogStatus.FAIL, "Field is not clicked",
//					TestResultsUtils.logger.addBase64ScreenShot(homescreenshot));
			;
			throw new PactivException("gClick Exception");

		}
	}

}
