package com.ecommerce.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.baseclass.baseclass;

public class CheckOutPage extends baseclass {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='payment__info']//div[3]//div[1]//input[1]")
	WebElement Name;
	
	@FindBy(xpath="//div[@class='payment__cc']//div[2]//input[1]")
	WebElement cvv;
	
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement country;
	
	By results =By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	@FindBy(xpath=" //button[contains(@class,'ta-item ')][2]")
	WebElement selectcountry;
	
	
	
	
	
	public void Filldetails(String name, String CVV) {
		baseclass.sendKeys(Name, name);
		baseclass.sendKeys(cvv, CVV);
		baseclass.click(country);
		baseclass.sendKeys(country, "India");
		baseclass.waitElementToAppear(driver, results);
		Actions action = new Actions(driver);
		action.moveToElement(selectcountry).click().build().perform();
		
				
	}
	
	public ConfirmationPage submitOrder() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('btnn action__submit ng-star-inserted')[0].click()");
		return new ConfirmationPage(driver);
	}
	
	
	
	

}
