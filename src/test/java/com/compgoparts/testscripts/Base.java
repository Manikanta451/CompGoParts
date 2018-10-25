package com.compgoparts.testscripts;

import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.compgoparts.pagefactory.AddToCart;
import com.compgoparts.pagefactory.CheckoutWithCC;
import com.compgoparts.pagefactory.CheckoutWithPayPal;
import com.compgoparts.pagefactory.CompareProducts;
import com.compgoparts.pagefactory.Contact;
import com.compgoparts.pagefactory.DriverHome;
import com.compgoparts.pagefactory.EmailProduct;
import com.compgoparts.pagefactory.Login;
import com.compgoparts.pagefactory.ProductReview;
import com.compgoparts.pagefactory.QRCode;
import com.compgoparts.pagefactory.WishList;



public class Base {
	
	public DriverHome driverhome;
	public Login login;
	public AddToCart addtocart;
	public CheckoutWithCC checkcc;
	public CheckoutWithPayPal checkpp;
	public Contact contact;
	public ProductReview prodreview;
	public EmailProduct emailprod;
	public WishList wishlist;
	public CompareProducts compare;
	public QRCode qr;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser) throws Exception {
		try {
			Reporter.log("=====Browser Session Started=====", true);
			driverhome = new DriverHome(browser, "test");
			
		} catch (WebDriverException e) {
			
			
		}
	}

	
	@AfterTest

	public void close() throws Exception {
		try {
			Thread.sleep(5000);
		    //driverhome.emailreport();
			//driverhome.quitDriver();
			Reporter.log("=====Browser Session End=========", true);
		} catch (WebDriverException e) {
			

		}
	}

}
