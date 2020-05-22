package com.Guru99.e_Banking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.Guru99.e_Banking.Utilities.ReadConfig;



public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	//Common variables used
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getuname();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{
		
		logger=Logger.getLogger("Grur99_e-Banking_Project");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chromepath"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver=new ChromeDriver();
		
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver=new FirefoxDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	
}
