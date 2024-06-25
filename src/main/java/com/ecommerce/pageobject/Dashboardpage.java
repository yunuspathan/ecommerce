package com.ecommerce.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.baseclass.baseclass;

public class Dashboardpage extends baseclass {

	WebDriver driver;

	public Dashboardpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='py-2 border-bottom ml-3']//input[@placeholder='search']")
	WebElement search;

	@FindBy(xpath = "//button[contains(@class, 'btn w-10 rounded')]")
	WebElement addToCartbtn;

	By toastmessage = By.cssSelector("#toast-container");
	
	
	By cartbutton= By.xpath ("//button[@routerlink='/dashboard/cart']");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartbtn;
	 

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	public Cartpage addProductToCart(String productname) throws InterruptedException {
	
		baseclass.sendKeys(search, productname +Keys.RETURN);	
		baseclass.waitElementToAppear(driver, cartbutton);
		baseclass.click(addToCartbtn);
		
		baseclass.waitElementToAppear(driver, toastmessage);
		baseclass.waitElementToDisappear(driver, spinner);
		baseclass.click(cartbtn);	
		return new Cartpage(driver);
	}
		
				
	
}


