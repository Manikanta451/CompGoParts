package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CompareProducts extends CommonBase {

	public CompareProducts(WebDriver driver) {
		super(driver);
	}
	
	public AddToCart addcart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[1]/div/div[1]/a/span/span/img")
	public WebElement valve1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[1]/div/div[1]/div/a[2]")
	public WebElement compareprod1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[2]/div/div[1]/a/span/span/img")
	public WebElement valve2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[2]/div/div[1]/div/a[2]")
	public WebElement compareprod2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header-account\"]/ul/div/a")
	public WebElement compareicon;
	
	public void compare() {
		try {
			addcart = PageFactory.initElements(driver, AddToCart.class);
			mouseOver(addcart.valvesprings);
			addcart.flathead.click();
			implicitWait();
			mouseOver(valve1);
			explicitWaitVisible(compareprod1);
			compareprod1.click();
			implicitWait();
			mouseOver(valve2);
			explicitWaitVisible(compareprod2);
			compareprod2.click();
			implicitWait();
			Thread.sleep(3000);
			compareicon.click();
			implicitWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
