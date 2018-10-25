package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.compgoparts.utilities.PropertiesFileReader;



public class DriverHome extends CommonBase {
	
	public static final String prod_url = PropertiesFileReader.readvalueOfKey("app.url");
	

	public DriverHome(WebDriver driver) {
		super(driver);

	}

	public DriverHome(String browser, String text) {
		super(prod_url, browser);
	}

	public DriverHome(String url) {
		super(url, "test");

	}
	
	public Login getLogin() {
		return PageFactory.initElements(driver, Login.class);
		
	}
	
	public AddToCart getAddtoCart( ) {
		return PageFactory.initElements(driver, AddToCart.class);
		
	}
	
	
	public CheckoutWithCC getCheckoutCc() {
		return PageFactory.initElements(driver, CheckoutWithCC.class);
		
	}
	
	public CheckoutWithPayPal getCheckoutPaypal() {
		return PageFactory.initElements(driver, CheckoutWithPayPal.class);
		
	}
	
	public Contact getContact() {
		return PageFactory.initElements(driver, Contact.class);
		
	}
	
	public ProductReview getProdReview() {
		return PageFactory.initElements(driver, ProductReview.class);
		
	}
	
	public EmailProduct getEmailProd() {
		return PageFactory.initElements(driver, EmailProduct.class);
	}
	
	public WishList getWishlist() {
		return PageFactory.initElements(driver, WishList.class);
		
	}
	
	public CompareProducts getCompareProd() {
		return PageFactory.initElements(driver, CompareProducts.class);
		
	}
	
	public QRCode getqr() {
		return PageFactory.initElements(driver, QRCode.class);
		
	}
}
