package com.pactiv.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pactiv.constants.Constants;
import com.pactiv.exception.PactivException;
import com.pactiv.utils.PropertyUtils;

/**
 * The Class SeleniumNGSuite.
 */
public class SeleniumNGSuite {

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(SeleniumNGSuite.class);

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The browser type. */
	public static String browserType = configprops.getProperty("browser_name");
	

	/** The urlNew. */
	public static String urlNew = configprops.getProperty(Constants.APPURL);
	
	/** The urlNew. */
	public static String urlStag = configprops.getProperty(Constants.STAGURL);
	
	public final String urlDMG = configprops.getProperty(Constants.DMGURL);

	/** The current suite. */
	public static String currentSuite = "";

	/** The config. */
	public DriverConfig config = new DriverConfig();

	/**
	 * Sets the up suite.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	public void setUpSuite(String url) throws Throwable {
		switch (url) {
		case "CPT-DMG":
			config.setUp(browserType, urlDMG);
			break;
		case "CPT":
			config.setUp(browserType, urlNew);
			break;
		default:
			config.setUp(browserType, urlNew);
			break;
		}
		
	}

	/**
	 * Tear down.
	 *
	 */
	public static void tearDown() throws PactivException {

		try {
			if (LocalDriverManager.getDriver() != null) {
				LocalDriverManager.getDriver().quit();
			}
			LOG.info("Successfully closed the browser ");
		}catch (Exception exception) {
			LOG.error("Error in closing the browser:: {}", exception.getMessage());
			exception.printStackTrace();
			throw new PactivException(exception);
		}

	}
}
