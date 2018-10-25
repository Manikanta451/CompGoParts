package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.compgoparts.datainitialization.DataInt;

public  class Login extends CommonBase{

	public Login(WebDriver driver) {
		super(driver);
	}
	
	
	
	
	@FindBy(how = How.LINK_TEXT, using = "Log In")
	public WebElement login;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement email;
	
	@FindBy(how = How.ID, using = "pass")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"send2\"]/span")
	public WebElement signin;
	
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	public WebElement signout;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[1]/a/span")
	public WebElement home;
	
	
	
	public void signIn(DataInt dataInt) {
		try {
			LOG.info("Clicking Login");
			login.click();
			LOG.info("Enter Email and Password");
			email.sendKeys(dataInt.getEmail());
			password.sendKeys(dataInt.getPassword());
			signin.click();
			if (isElementExist(signout) == false) {
				LOG.info("Login is not successful");
				Assert.assertTrue(false);
				} else {
				LOG.info("Login is Successful");
					}
		} catch (NullPointerException e) {
			LOG.info(e.toString() + "Null");
		} 
	}
	
	public void checkLogin(DataInt dataInt) {
		try {
			if (driver.getPageSource().contains("Sign Out")) {
				LOG.info("Already in Login");
			} else {
				LOG.info("Need to Login");
				signIn(dataInt);
			}
			/*if (isElementExist(signout)==true) {
				LOG.info("Already in Login");
			} else {
				LOG.info("Need to Login");
				signIn(dataInt);
			}*/
		} catch (Exception e) {
			LOG.info(e.toString());
		}
		
	}

}
