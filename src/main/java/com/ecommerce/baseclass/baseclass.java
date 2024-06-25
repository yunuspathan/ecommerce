package com.ecommerce.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseclass {
	public WebDriver driver;

	public baseclass(WebDriver driver) {
		this.driver = driver;

	}

	public static void implicitwait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));

	}

	public static void explicitwait(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}

	public static boolean isDiplayed(WebElement ele) {
		boolean flag = false;
		if (ele.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static void sendKeys(WebElement ele, String text) {
		ele.sendKeys(text);

	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void waitElementToAppear(WebDriver driver,By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public static void waitElementToDisappear(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
}
