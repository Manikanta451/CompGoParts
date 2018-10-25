package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.compgoparts.datainitialization.DataInt;

public class ProductReview extends CheckoutWithCC {

	public ProductReview(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[4]/a")
	public WebElement tools;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div[1]/a/span/span/img")
	public WebElement toolsprod;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-label-reviews-title\"]")
	public WebElement reviewtab;
	
	@FindBy(how = How.ID, using = "nickname_field")
	public WebElement reviewname;
	
	@FindBy(how = How.ID, using = "summary_field")
	public WebElement summary;
	
	@FindBy(how = How.ID, using = "review_field")
	public WebElement reviewtext;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"review-form\"]/div/div/button")
	public WebElement submitreview;
	
	public void review(DataInt dataInt) {
		try {
			home.click();
			implicitWait();
			tools.click();
			implicitWait();
			toolsprod.click();
			implicitWait();
			reviewtab.click();
			reviewname.sendKeys("Ebiz Test");
			summary.sendKeys("Reviewing Product");
			reviewtext.sendKeys("Ebiz Test Reviewing Product");
			submitreview.click();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
