package com.Guru99.e_Banking.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99.e_Banking.PageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass
{
	
	@Test
	public void LoginTest() throws Exception
	{
		
		driver.get(baseURL);
		
		logger.info("URL Opnened");
		
		LoginPage lpg=new LoginPage(driver);
	
		lpg.setUserName(username);
		logger.info("username entered");
	
		lpg.setPassword(password);
		logger.info("Password entered");
		lpg.clickSubmit();
		logger.info("Submit button clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePag"))
				{
					
					Assert.assertTrue(true);
					logger.info("Test case PASS");
				}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case FAIL");
		}
		
	}
}
