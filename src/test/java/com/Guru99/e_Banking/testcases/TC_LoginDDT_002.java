package com.Guru99.e_Banking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99.e_Banking.PageObjects.LoginPage;
import com.Guru99.e_Banking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	
	public void LoginDDT(String user,String pswd) throws Exception 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pswd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		logger.info("Login button clicked");
		if(IsAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			Thread.sleep(3000);
			lp.ClickLogout();
			driver.switchTo().alert().accept();//this will close the logout alert
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public boolean IsAlertPresent() //user defined method whether alert is present or not
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
		
	

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException 
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/Guru99/e_Banking/testdata/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colcount; j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);

			}
		}
		
		return logindata;
	}
	
	

	
}
