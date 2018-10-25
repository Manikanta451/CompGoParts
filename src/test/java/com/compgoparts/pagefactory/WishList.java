package com.compgoparts.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.compgoparts.datainitialization.DataInt;

public class WishList extends Login {

	public WishList(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[8]/a")
	public WebElement pushrods;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[5]/div/div[1]/div/a[1]")
	public WebElement pushrodswish;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[5]/div/div[1]/a/span/span/img")
	public WebElement mouseoverele;
	
	@FindBy(how = How.XPATH, using = "//div[@class='product-item-inner']/div/fieldset/div/div/input")
	public WebElement editwishqty;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[1]")
	public WebElement updatewishlist;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[2]")
	public WebElement sharewishlist;
	
	@FindBy(how = How.ID, using = "email_address")
	public WebElement sharewishemail;
	
	@FindBy(how = How.ID, using = "message")
	public WebElement sharewishmsg;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"form-validate\"]/div/div[1]/button")
	public WebElement sharewishlistemail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	public WebElement getsuccesstext;
	
	public String wishsuccessmsg;
	
	@FindBy(how = How.XPATH, using = "//div[@class='product-item-inner']/div/a[1]")
	public WebElement editwishlist;
	
	@FindBy(how = How.ID, using = "qty")
	public WebElement edit;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div/a[1]/span[1]")
	public WebElement addeditwish;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[9]/a")
	public WebElement merchandise;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div[1]/a/span/span/img")
	public WebElement merchandiseprod;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div[1]/div/a[1]")
	public WebElement addwishmerchandiseprod;

	@FindBy(how = How.XPATH, using = "//div[@class='product-item-inner']/div/div/textarea")
	public WebElement commentwishitem;
	
	@FindBy(how = How.XPATH, using = "//div[@class='products-grid wishlist']/ol/li[2]/div/div[2]/div[3]/a[2]")
	public WebElement removeitem;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[2]")
	public WebElement addallcart;
	
	CheckoutWithCC checkcc;
	
	public void addProdToWishList(DataInt dataInt) {
		try {
			checkLogin(dataInt);
			pushrods.click();
			implicitWait();
			scrollPageDown();
			mouseOver(mouseoverele);
			explicitWaitVisible(pushrodswish);
			pushrodswish.click();
			checkWishTitle();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void wishlistActions(DataInt dataInt) {
		try {
			editwishqty.clear();
			editwishqty.sendKeys("2");
			updatewishlist.click();
			/*sharewishlist.click();
			implicitWait();
			textAreaData(sharewishemail, "tester4423@gmail.com, testerebiz2@gmail.com");
			textAreaData(sharewishmsg, "Sharing wishlist to friends");
			sharewishlistemail.click();
			implicitWait();
			wishsuccessmsg =  getsuccesstext.getText();
			Assert.assertEquals("Your wish list has been shared.", wishsuccessmsg);*/
			editwishlist.click();
			implicitWait();
			edit.clear();
			edit.sendKeys("1");
			addeditwish.click();
			implicitWait();
			checkWishTitle();
			merchandise.click();
			implicitWait();
			mouseOver(merchandiseprod);
			explicitWaitVisible(addwishmerchandiseprod);
			addwishmerchandiseprod.click();
			checkWishTitle();
			textAreaData(commentwishitem, "Wishlist comment");
			updatewishlist.click();
			implicitWait();
			removeitem.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkoutWishList(DataInt dataInt) {
		try {
			implicitWait();
			addallcart.click();
			implicitWait();
			checkcc=PageFactory.initElements(driver, CheckoutWithCC.class);
			checkcc.miniCart();
			implicitWait();
			explicitWaitClickable(checkcc.gocheckout);
			checkcc.gocheckout.click();
			checkcc.selectShipping();
			checkcc.checkoutCC();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
