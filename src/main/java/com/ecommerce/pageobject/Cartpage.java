package com.ecommerce.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.baseclass.baseclass;

public class Cartpage extends baseclass {
	
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[ @class='cartSection']/h3")
	WebElement ExpectedprodName;
	
	
	

	By Checkoutbtn = By.xpath("//button[text()='Buy Now' ] ");
	
	@FindBy(xpath="//button[text()='Buy Now' ]")
	WebElement checkout;
	
	
	
	public CheckOutPage verifyproduct(String ActualProductName) {
		
	String actual= 	ExpectedprodName.getText();
	Assert.assertEquals(actual, ActualProductName);
	baseclass.click(checkout);
	return new CheckOutPage(driver);

	}
	
	

}
