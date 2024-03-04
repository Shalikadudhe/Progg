package com.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.uikeywords.UIKeywords;

public class WaitFor {

	private static FluentWait<WebDriver> wait = null;

	static {
		wait = new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("wait is finished and element is not loaded or available");
	}

	public static void ElementToPresent(By locator) {

		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void ElementToPresent(String locatorType, String LocatorValue) {

		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated((By) UIKeywords.getWebElement(locatorType, LocatorValue)));
	}

	public static void elementToBeClickable(WebElement element) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void time(int durationInSeconds) {

		long startTime = System.currentTimeMillis();
		long endsTime = startTime + (durationInSeconds * 1000);
		while (startTime <= endsTime) {
			startTime = System.currentTimeMillis();
		}
	}

}