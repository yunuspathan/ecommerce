package com.ecommerce.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.ecommerce.basetest.basetest;
import com.ecommerce.pageobject.Cartpage;
import com.ecommerce.pageobject.CheckOutPage;
import com.ecommerce.pageobject.ConfirmationPage;
import com.ecommerce.pageobject.Dashboardpage;
import com.ecommerce.pageobject.LandingPage;
					//End to End Test "SUBMIT ORDER /SUCCESS SCREEN"
public class LandingpageTest extends basetest {

	LandingPage landingpage;
	Dashboardpage dashboard;
	Cartpage cartpage;
	CheckOutPage checkoutpage;
	ConfirmationPage confirmationpage;

	@BeforeTest
	public void setup() throws IOException {
		initializedriver();

	}
	public String productname="ZARA COAT 3";
	@Test(dataProvider = "dataprovider")
	public void login(String username, String Password) throws InterruptedException {
		landingpage = new LandingPage(driver);
		dashboard=landingpage.Login(username, Password);
		cartpage=dashboard.addProductToCart(productname);
		Thread.sleep(10000);
		checkoutpage=cartpage.verifyproduct(productname);
		checkoutpage.Filldetails("Yunus", "ABC");
		confirmationpage=checkoutpage.submitOrder();
		
		
		
		

	}

}
