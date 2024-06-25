package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ecommerce.baseclass.baseclass;

public class ConfirmationPage extends baseclass {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement cnfmessage;
	
	
	
	public void confirmMessagepage() {
		String actualmessage= cnfmessage.getText();
		Assert.assertEquals(cnfmessage, "THANKYOU FOR THE ORDER.");
	}
}
