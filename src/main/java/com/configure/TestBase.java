package com.configure;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uikeywords.UIKeywords;
import com.util.CaptureScreenShot;

@Listeners(CaptureScreenShot.class)
public class TestBase {
	
	private static final Logger log= (Logger) LogManager.getLogger(TestBase.class);
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("Chrome") String browserNm) throws Exception {
		browserNm = "Chrome";

		if (browserNm.isEmpty()) {
			browserNm = "Chrome";
			log.info("Setting default browser as chrome");

		}
		if (browserNm.equals(null)) {
			browserNm = "Chrome";
			log.info("Setting default browser as chrome");

		}
		UIKeywords.openBrowser(browserNm);
	}
	
	@Test
	public void onTestFailure() {
		CaptureScreenShot cs = new CaptureScreenShot();
		Assert.assertEquals(false, true);
	}

	@AfterMethod
	public void tearDown() {
		UIKeywords.closeBrowser();

	}
	


}
