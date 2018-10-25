package com.compgoparts.pagefactory;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.compgoparts.datainitialization.DataInt;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class AddToCart extends CommonBase implements reusable {

	public AddToCart(WebDriver driver) {
		super(driver);
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[1]/a/span")
	public WebElement home;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[2]/a/span[1]")
	public WebElement valvesprings;
	
	@FindBy(how = How.LINK_TEXT, using = "Flathead")
	public WebElement flathead;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[1]/div/div[2]/div[3]/div/div/form/button")
	public WebElement addproduct;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"minicart\"]/div[1]/span/span[3]")
	public WebElement cart;
	
	@FindBy(how = How.LINK_TEXT, using = "View and Edit Cart")
	public WebElement viewandedit;
	
	@FindBy(how = How.XPATH, using = "//div[@class='field qty']/div/input")
	public WebElement editqty;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"form-validate\"]/div[2]/button[2]/span")
	public WebElement updatecart;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue Shopping")
	public WebElement contshop;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mainmenu\"]/ul/li[7]/a")
	public WebElement ohvcams;
	
	@FindBy(how = How.LINK_TEXT, using = "Stock")
	public WebElement stock;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/ol/li[2]/div/div[2]/div[3]/div/div/form/button")
	public WebElement flatheadprod;   
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[2]/div/div[2]/div[3]/div/div/form/button")
	public WebElement stockprod;     
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[2]")
	public WebElement editprod;
	
	@FindBy(how = How.ID, using = "qty")
	public WebElement qty;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-updatecart-button\"]")
	public WebElement reupdatecart; 
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"empty_cart_button\"]")
	public WebElement clearcart; 
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[1]")
	public WebElement movetowish; 
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"minicart\"]/div[1]/span/span[2]/span[1]")
	public WebElement dispcartnum; 
	
	public void addCart(DataInt dataInt) {
		try {
			home.click();
			mouseOver(valvesprings);
	        flathead.click();
	        implicitWait();
	        LOG.info("Loading FlatHead Page...");
	        flatheadprod.submit();
	        LOG.info("Product Added");
	       
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}	
		public void editQuantity(DataInt dataInt) {
			try {
			        miniCart();
			        editqty.clear();
			        editqty.sendKeys("2");
			        LOG.info("Product Quantity Updated");
			        updatecart.click();
			} catch (ElementNotVisibleException | NoSuchElementException e) {
				System.out.println("ElementNotVisibleException");
			}
		}

	
	
	public void continueShopping(DataInt dataInt) {
		try {
			contshop.click();
			implicitWait();
			LOG.info("HomePage after clicking continue shopping....");
			mouseOver(ohvcams);
			stock.click();
			implicitWait();
			LOG.info("Stock Page Loaded");
			stockprod.submit();
			LOG.info("Stock prod added");
			explicitWaitVisible(dispcartnum);
			LOG.info("Element is visible");
			miniCart();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
   public void moveToWishList(DataInt dataInt) {
	   try {
		   movetowish.click();
		   LOG.info("Product Added To Wishlist");
		   implicitWait();
		   clearcart.click();
			LOG.info("Cart is empty");
	} catch (ElementNotFoundException e) {
		System.out.println("ElementNotFoundException");
	}
   }
	public void editProduct(DataInt dataInt) {
		try {
			editprod.click();
			implicitWait();
			LOG.info("Edit Product Page Loaded..");
			qty.clear();
			qty.sendKeys("2");
			reupdatecart.click();
			implicitWait();
			LOG.info("Cart re updated..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void miniCart() {
		try {
			LOG.info("Minicart Page");
			implicitWait();
			explicitWaitVisible(dispcartnum);
			scrollPageUp();
	  	    mouseOver(cart);
	  	    implicitWait();
	        explicitWait(viewandedit);
	        Thread.sleep(2000);
	        viewandedit.click();
	        implicitWait();
	        LOG.info("Displaying Cart Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }

}
