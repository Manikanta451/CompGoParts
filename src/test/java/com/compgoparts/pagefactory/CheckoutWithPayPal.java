package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.compgoparts.datainitialization.DataInt;

public class CheckoutWithPayPal extends CheckoutWithCC {

	public CheckoutWithPayPal(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='checkout-payment-method-load']/div/div/div[2]/div[1]/input")
	public WebElement selpaypal;
	
	@FindBy(how = How.ID, using = "paypal-express-in-context-button")
	public WebElement contlpaypal;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"loginSection\"]/div/div[2]/a")
	public WebElement paypallogin;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement paypalemail;
	
	@FindBy(how = How.ID, using = "password")
	public WebElement paypalpwd;
	
	@FindBy(how = How.ID, using = "btnLogin")
	public WebElement paypalsubmit;
	
	@FindBy(how = How.ID, using = "confirmButtonTop")
	public WebElement paynow;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[2]/div/div[2]/p[1]/a")
	public WebElement paypalordernum;
	
	
	
	public void checkoutPayPal(DataInt dataInt) {
		try {
			addCart(dataInt);
			cartPage();
			selectShipping();
			implicitWait();
			Thread.sleep(10000);
			selpaypal.click();
			contlpaypal.click();
			switchToNewWindow(driver.getTitle());
			implicitWait();
			//paypallogin.click();
			explicitWaitVisible(paypalsubmit);
			paypalemail.clear();
			paypalemail.sendKeys("ebiztest123-1@gmail.com");
			paypalpwd.sendKeys("ebiz12!@#");
			paypalsubmit.click();
			implicitWait();
			explicitWait(paynow);
			Thread.sleep(3000);
			paynow.click();
			switchbackToMainWindow();
			implicitWait();
			explicitWaitVisible(paypalordernum);
            System.out.println("Order Number" + "  " +paypalordernum.getText());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
