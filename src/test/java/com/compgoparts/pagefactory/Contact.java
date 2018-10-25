package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.compgoparts.datainitialization.DataInt;

public class Contact extends CommonBase{

	public Contact(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Contact")
	public WebElement contlink;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact-form\"]/fieldset/div[1]/table/tbody/tr[4]/td/span/b")
	public WebElement emailtext;
	
	@FindBy(how = How.ID, using = "whereto")
	public WebElement sendmsgto;
	
	@FindBy(how = How.ID, using = "name")
	public WebElement contname;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement contemail;
	
	@FindBy(how = How.ID, using = "telephone")
	public WebElement contphone;
	
	public void techCont(DataInt dataInt) {
		try {
			contlink.click();
			explicitWaitVisible(emailtext);
			selDropDown(sendmsgto, "Tech Support");
			if (contname.getAttribute("value").isEmpty()) {
				contname.sendKeys("Ebiz Test");
				contemail.sendKeys("tester4423@gmail.com");
			}
			contphone.sendKeys("9866454539");
			
			
			
		} catch (Exception e) {
		}
	}

}
