package com.Tests;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.configure.TestBase;
import com.pages.BeautyPage;
import com.uikeywords.UIKeywords;
import com.utility.Environment;

public class BeautyTest extends TestBase {
	
	private static final Logger log= (Logger) LogManager.getLogger(BeautyTest.class);	
	
	@Test
	public void get_lipstick_Brand_Name() {

		BeautyPage bp = new BeautyPage();
		Environment env = new Environment();
		UIKeywords.openUrl(env.getAppUrl());
		bp.clickOnlipstick_Lakme();
		//ul[@class='results-base']/li/a/div/h3
		List<WebElement> li = UIKeywords.driver.findElements(By.xpath("//ul[@class='results-base']/li/a/div/h3"));
		for (WebElement ele : li) {
			String actual = ele.getText();
			if(actual.equalsIgnoreCase("Lakme")) {
		     //	log.info("Brand name is : " + actual);
			Assert.assertEquals(actual, "Lakme", "Actual and expected are  matching..... ");
		}}

	}

}
