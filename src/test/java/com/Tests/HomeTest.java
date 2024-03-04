package com.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.configure.TestBase;
import com.pages.HomePage;
import com.uikeywords.UIKeywords;
import com.utility.Environment;

public class HomeTest extends TestBase{
	
	@Test
	public void checkSearchFunctionalityIsEnabled() {
		
		Environment env=new Environment();
		HomePage hm=new HomePage();
		UIKeywords.openUrl(env.getAppUrl());
		 hm.clickOnSearchBoxfield();
		boolean expect=hm.searchBox.isEnabled();
		
		Assert.assertEquals(true,expect,"Actual and expected are matches...");
	}
	

}
