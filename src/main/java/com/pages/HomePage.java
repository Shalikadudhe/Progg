package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uikeywords.UIKeywords;

public class HomePage {
	
	private static final Logger log= (Logger) LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath ="//input[@class='desktop-searchBar']")
	public  WebElement searchBox;
	
	public HomePage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}
	  public void clickOnSearchBoxfield() {

		  Actions ac=new Actions(UIKeywords.driver);
		  ac.click(searchBox).build().perform();
		  
		  log.info("Clicked on searchBox...");
		  
	
	  }
	  
	 

}
