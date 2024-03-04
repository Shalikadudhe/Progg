package com.uikeywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.core.Logger;
import com.configure.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords extends TestBase{
	public static RemoteWebDriver driver;
	
	private static final Logger log= (Logger) LogManager.getLogger(UIKeywords.class);
	
	public static void openBrowser(String browserNm) {
		if (browserNm.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("-disable-notifications");
			driver = new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			log.info("Chrome browser is open successfully");

		} else if (browserNm.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions op = new EdgeOptions();
			op.addArguments("-disable-notifications");
			driver = new EdgeDriver(op);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			log.info("edge browser is open successfully");

		} else if (browserNm.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions op = new FirefoxOptions();
			op.addArguments("-disable-notifications");
			driver = new FirefoxDriver(op);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			log.info("firefox browser is open successfully");

		}
	}

	public static void openUrl(String url) {
		driver.get(url);
		log.info(url + " url is open successfully");

	}

	public static void closeBrowser() {
		driver.close();
		log.info("browser is closed successfully");
	}

	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (driver.switchTo().window(win).getTitle().equals(byTitle)) {
				log.info("Switched on window " + byTitle);
				break;
			}

		}
	}

	public static void enterText(By ele, String text) {

		driver.findElement(ele).sendKeys(text);

	}

	public static void hitButton(int keyCode) {

		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robo.keyPress(keyCode);
		robo.keyRelease(keyCode);

	}

	public static List<String> getTexts(By element) {

		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList();
		for (WebElement ele : elements) {
			texts.add(ele.getText());
		}
		return texts;
	}

	public static void mouseMove(By element) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(element)).click().build().perform();

	}

	public static void clickOn(By xpath) {

		driver.findElement(xpath).click();
	}

	public static By getWebElement(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
