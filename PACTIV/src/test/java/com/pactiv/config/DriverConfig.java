/*
 *
 */
package com.pactiv.config;

import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.constants.Constants;
import com.pactiv.exception.PactivException;
import com.pactiv.utils.LocalTestDataManager;
import com.pactiv.utils.PropertyUtils;

/**
 * The Class DriverConfig.
 *
 */
public class DriverConfig {

	/** The driver. */
	// private static ChromeDriverService service;
	public WebDriver driver = null;
	

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The handle popups. */
	public static String handlePopups = configprops.getProperty(Constants.HANDLE_POPUP);

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);
	

	/**
	 * This method returns the driver object for the given browser type with the
	 * page loaded with the given url.
	 *
	 * @param browserType
	 *            the browser type
	 * @param url
	 *            the url
	 * @throws Throwable
	 *             the throwable
	 */

	// TODO remotesysname
	public void setUp(String browserType, String url) throws Throwable {
		try {
			LOG.info("Setting up the driver::" + browserType);

			switch (browserType) {
			case Constants.MOZILLA_FIREFOX:
				try {
					System.setProperty(Constants.GEKO_DRIVER, baseProjectPath.concat(Constants.GEKO_DRIVER_PATH));
					driver = ThreadGuard.protect(new FirefoxDriver());
					LocalDriverManager.setWebDriver(driver);
				} catch (Exception exception) {
					exception.printStackTrace();
					LOG.error("Error while loading Firefox driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Firefox driver::{}", throwable.getMessage());
				}
				break;
			case Constants.CHROME:
				try {
					System.setProperty(Constants.CHROME_WEBDRIVER,
							baseProjectPath.concat(Constants.CHROME_DRIVER_PATH));
					ChromeOptions options = new ChromeOptions();
					options.addArguments("enable-automation");
//					options.addArguments("--headless");
					options.addArguments("--window-size=1920,1080");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-extensions");
					options.addArguments("--dns-prefetch-disable");
					options.addArguments("--disable-gpu");
					options.addArguments("--disable-browser-side-navigation");
					options.addArguments("--disable-dev-shm-usage");
					options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					driver = ThreadGuard.protect(new ChromeDriver(options));
					LocalDriverManager.setWebDriver(driver);
				} catch (Exception exception) {
					LOG.error("Error while loading Chrome driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Chrome driver::{}", throwable.getMessage());
				}
				break;
			case "chrome headless":
				try {
					System.setProperty(Constants.CHROME_WEBDRIVER,
							baseProjectPath.concat(Constants.CHROME_DRIVER_PATH));
					ChromeOptions options = new ChromeOptions();
					options.addArguments("enable-automation");
					options.addArguments("--headless");
					options.addArguments("--window-size=1920,1080");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-extensions");
					options.addArguments("--dns-prefetch-disable");
					options.addArguments("--disable-gpu");
					options.addArguments("--disable-browser-side-navigation");
					options.addArguments("--disable-dev-shm-usage");
					options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					driver = ThreadGuard.protect(new ChromeDriver(options));
					LocalDriverManager.setWebDriver(driver);
				} catch (Exception exception) {
					LOG.error("Error while loading Chrome driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Chrome driver::{}", throwable.getMessage());
				}
				break;

			case Constants.IE:
				try {
					System.setProperty(Constants.IE_DRIVER, baseProjectPath.concat(Constants.IE_DRIVER_PATH));
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
					caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
					caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
					caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = ThreadGuard.protect(new InternetExplorerDriver(caps));
					LocalDriverManager.setWebDriver(driver);
					LocalDriverManager.getDriver().manage().window().maximize();
				} catch (Exception exception) {
					LOG.error("Error while loading Internet Explorer driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Internet Explorer driver::{}", throwable.getMessage());
				}

				break;

			case Constants.SAFARI:
				try {
				} catch (Exception exception) {
					LOG.error("Error while loading Safari driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Safari driver::{}", throwable.getMessage());
				}
				break;

			case Constants.EDGE:
				try {
					System.setProperty(Constants.EDGE_DRIVER, Constants.EDGE_PATH);
					DesiredCapabilities capabilities = DesiredCapabilities.edge();
					driver = new EdgeDriver(capabilities);
				} catch (Exception exception) {
					LOG.error("Error while loading Internet Explorer Edge driver::{}", exception.getMessage());
				} catch (Throwable throwable) {
					LOG.error("Error while loading Internet Explorer Edge driver::{}", throwable.getMessage());
				}
				break;

						}
			Thread.sleep(1000);
			LocalDriverManager.getDriver().get(url);
			LocalDriverManager.getDriver().manage().window().maximize();
			if (browserType.equals(Constants.IE)) {
				LocalDriverManager.getDriver().navigate()
						.to("javascript:document.getElementById('overridelink').click()");
			}
			
		
			System.out.println("flag"+LocalTestDataManager.getIsGalenScenario() + LocalTestDataManager.getTestingDevice() );
			

		} catch (TimeoutException timeOutException) {
			LOG.error("Driver Timeout Exception occured::{}", timeOutException.getMessage());
			timeOutException.printStackTrace();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE);
		} catch (Exception exception) {
			LOG.error("Exception occured in getting the driver::{}", exception.getMessage());
			throw new PactivException(exception);
		} catch (Throwable throwable) {
			LOG.error("Error Occured in Getting the driver object ::{}", throwable.getMessage());
			throw new PactivException(throwable);
		}

	}
	


	}
	
