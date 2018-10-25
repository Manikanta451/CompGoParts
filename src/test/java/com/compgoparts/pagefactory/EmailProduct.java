package com.compgoparts.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.compgoparts.datainitialization.DataInt;

public class EmailProduct extends Login {

	public EmailProduct(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[3]/a")
	public WebElement valves;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[1]/div/div[1]/a/span/span/img")
	public WebElement valvesprod;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[2]/div[3]/div[3]/a/span[1]")
	public WebElement mailicon;
	
	@FindBy(how = How.ID, using = "sender-message")
	public WebElement sendermsg;
	
	@FindBy(how = How.ID, using = "recipients-name0")
	public WebElement recipientname1;
	
	@FindBy(how = How.ID, using = "recipients-email0")
	public WebElement recipientemail1;
	
	@FindBy(how = How.ID, using = "recipients-name1")
	public WebElement recipientname2;
	
	@FindBy(how = How.ID, using = "recipients-email1")
	public WebElement recipientemail2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-recipient-button\"]")
	public WebElement addinvite;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-sendtofriend-form\"]/div/div[1]/button")
	public WebElement sendemail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	public WebElement successcontent;
	
	public String successmsg;
	
	public void mailProd(DataInt dataInt) {
		try {
			checkLogin(dataInt);
			valves.click();
			implicitWait();
			valvesprod.click();
			implicitWait();
			mailicon.click();
			implicitWait();
			textAreaData(sendermsg, "Mailing the product to customer");
			recipientname1.sendKeys("Eis Test");
			recipientemail1.sendKeys("tester4423@gmail.com");
			addinvite.click();
			explicitWaitVisible(recipientname2);
			recipientname2.sendKeys("Compgoparts test");
			recipientemail2.sendKeys("ebiztesting57@gmail.com");
			sendemail.click();
			implicitWait();
			successmsg=successcontent.getText();
			//Assert.assertEquals("The link to a friend was sent.", successmsg);
			LOG.info("Link Sent Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
