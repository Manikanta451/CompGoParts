package com.compgoparts.testscripts;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.compgoparts.datainitialization.DataInt;
//import com.compgoparts.utilities.ExcelSheetObjects;
//import com.compgoparts.utilities.SetupEnvironment;
import com.compgoparts.utilities.Util;
import com.compgoparts.utilities.Xls_Reader;

public class TestSuite extends Base {

	public static final Logger LOG = Logger.getLogger(TestSuite.class);
	String testDataPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\compgoparts\\test\\data\\TestData.xlsx";
	public Xls_Reader xls = new Xls_Reader(testDataPath);

	@Test(description = "Login CompCams", dataProvider = "getLogin", priority = 1)
	public void loginWithCredentials(DataInt dataInt) {
		try {
			login = driverhome.getLogin();
			login.signIn(dataInt);
			addtocart = driverhome.getAddtoCart();
			addtocart.addCart(dataInt);
			addtocart.editQuantity(dataInt);
			addtocart.continueShopping(dataInt);
			addtocart.editProduct(dataInt);
			addtocart.moveToWishList(dataInt);
			// SetupEnvironment.createXLSReport(ExcelSheetObjects.KEYWORD_PASS,
			// ExcelSheetObjects.LoginWithValidCredentials, "CompGoParts Scenarios");
		} catch (Exception e) {

			// TODO: handle exception
		}

	}

	@Test(description = "Checkout", dataProvider = "getLogin", priority = 2)
	public void Checkout(DataInt dataInt) {
		try {
			checkcc = driverhome.getCheckoutCc();
			checkcc.addCart(dataInt);
			checkcc.cartPage();
			checkcc.selectShipping();
			checkcc.checkoutCC();
		    checkpp = driverhome.getCheckoutPaypal();
		    checkpp.checkoutPayPal(dataInt);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(description = "eMail Products", dataProvider = "getLogin", priority = 3)
	public void emailProducts(DataInt dataInt) {
		try {
			emailprod = driverhome.getEmailProd();
			emailprod.mailProd(dataInt);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(description = "wishLIst", dataProvider = "getLogin", priority = 4)
	public void wishListItems(DataInt dataInt) {
		try {
			wishlist = driverhome.getWishlist();
			wishlist.addProdToWishList(dataInt);
			wishlist.wishlistActions(dataInt);
			wishlist.checkoutWishList(dataInt);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(description = "reviewProduct", dataProvider = "getLogin", priority = 5)
	public void reviewProd(DataInt dataInt) {
		try {
			prodreview = driverhome.getProdReview(); 
			prodreview.review(dataInt);
		} catch (Exception e) {
			
		}
	}

	@Test(description = "Login CompCams", dataProvider = "getLogin", priority = 6)
	public void prodCompare(DataInt dataInt) {
		try {
			compare = driverhome.getCompareProd();
			compare.compare();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(description = "QRCode", priority = 3)
	public void QRCode() {
		try {
			qr=driverhome.getqr();
			qr.barcode();
		} catch (Exception e) {
		}
	}

	@DataProvider
	public Iterator<Object[]> getLogin() {
		return Util.getLoginData("Login", xls).iterator();

	}

}
