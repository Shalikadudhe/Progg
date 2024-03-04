package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uikeywords.UIKeywords;

public class BeautyPage {
	
	private static final Logger log= (Logger) LogManager.getLogger(BeautyPage.class);
	
	@FindBy(xpath = "//a[@href='/personal-care']")
	public WebElement beauty;

	@FindBy(xpath = "//a[@href='/makeup']")
	public WebElement makeup_link;

	@FindBy(xpath = "(//a[@href='/lipstick'])[2]")
	public WebElement lipstick;

	@FindBy(xpath = "//div[@class='sort-sortBy']")
	public WebElement sortBy;

	@FindBy(xpath = "//ul[@class='sort-list']/li[3]/label/input")
	public WebElement popularity;

	public BeautyPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public void clickOnlipstick_Lakme() {
		Actions ac = new Actions(UIKeywords.driver);
		ac.moveToElement(beauty).build().perform();
		log.info("move to beauty tab......");
		ac.click(lipstick).build().perform();
		log.info("click on lipstick item........");

	}

}
