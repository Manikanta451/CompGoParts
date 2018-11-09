package com.compgoparts.pagefactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.compgoparts.datainitialization.DataInt;

public class CheckoutWithCC extends AddToCart implements reusable {

	public CheckoutWithCC(WebDriver driver) {
		super(driver);
	}
	
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[5]/a")
	public WebElement lifters;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li/div/div[1]/a/span/span/img")
	public WebElement lifterprodmouseover;
	
	@FindBy(how = How.XPATH, using = "//div[@class='product-item-inner']/div/div/form/button")
	public WebElement lifterprod;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/th")
	public WebElement visiblefield;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='checkout methods items checkout-methods-items']/li/button")
	public WebElement gocheckout;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody")
	public WebElement webtable;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"co-shipping-method-form\"]")
	public WebElement shipmethods;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"opc-shipping_method\"]/div/div[1]")
	public WebElement shipmethodslabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
	public WebElement nexttocc;

	@FindBy(how = How.XPATH, using = "//div[@id='checkout-payment-method-load']/div/div/div[3]/div[1]/input")
	public WebElement selauth;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"authorizenet_directpost_cc_number\"]")
	public WebElement ccnum;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"authorizenet_directpost_expiration\"]")
	public WebElement selexpmonth;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"authorizenet_directpost_expiration_yr\"]")
	public WebElement selexpyear;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"authorizenet_directpost_cc_cid\"]")
	public WebElement cvvnum;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button")
	public WebElement placeorder;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[2]/div/div[2]/p[1]/a")
	public WebElement ordernum;
	
	
	
	
	Login chlogin;
	
	@Override
	public void addCart(DataInt dataInt) {
		try {
		    home.click();
			implicitWait();
			chlogin = PageFactory.initElements(driver, Login.class);
			chlogin.checkLogin(dataInt);
			lifters.click();
			implicitWait();
			mouseOver(lifterprodmouseover);
			lifterprod.click();
			
		} catch (NoSuchElementException e) {
			mouseOver(lifterprodmouseover);
			lifterprod.click();
		}
		
	}
	
	public void cartPage() {
		try {
			miniCart();
			implicitWait();
			explicitWaitClickable(gocheckout);
			Thread.sleep(2000);
			gocheckout.click();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
		public void selectShipping() {
			try {
				implicitWait();
				explicitWaitVisible(shipmethodslabel);
				webTableContent(webtable);
				nexttocc.click();
				
			} catch (NoSuchElementException e) {
				webTableContent(webtable);
				nexttocc.click();
			}
		}	
		  
		  public void checkoutCC () {
			  try {
				    implicitWait();
					Thread.sleep(10000);
					selauth.click();
					ccnum.sendKeys("4111111111111111");
					selDropDown(selexpmonth, "10 - October");
					selDropDown(selexpyear, "2019");
					cvvnum.sendKeys("002");
					placeorder.click();
					explicitWaitVisible(ordernum);
		            System.out.println("Order Number" + "  " +ordernum.getText());	
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
