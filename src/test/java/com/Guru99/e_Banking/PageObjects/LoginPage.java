package com.Guru99.e_Banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)//Constructor taking driver as parameter
	{
		ldriver=rdriver;//Initiate driver
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement butonLogin;
	
	@FindBy(xpath="//*[@class='menusubnav']/li[15]//*[text()='Log out']")
	WebElement butonLogout;
	
	public void setUserName(String uname) {//action methods for webelement{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {//action methods for webelement{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		// TODO Auto-generated method stub
		butonLogin.click();	
	}
	
	public void ClickLogout() {
		butonLogout.click();
	}
	
}
