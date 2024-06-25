package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.baseclass.baseclass;

public class LandingPage extends baseclass {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='email@example.com']")
	WebElement username;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	public Dashboardpage Login(String usernames, String passwords) throws InterruptedException {

		baseclass.explicitwait(driver, loginbtn);
		baseclass.sendKeys(username, usernames);
		baseclass.sendKeys(password, passwords);
		baseclass.click(loginbtn);
		return new Dashboardpage(driver);
	}

}
