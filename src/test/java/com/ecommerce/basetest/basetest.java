package com.ecommerce.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.ecommerce.baseclass.baseclass;
import com.google.common.io.Files;

public class basetest {
	public WebDriver driver;
	
	Properties prop;

	public void initializedriver() throws IOException {

		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\ecommerce\\resource\\config.properties";
		FileInputStream ip = new FileInputStream(path);
		prop.load(ip);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ed")) {

			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Browser Name is incorrect");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");
		// return driver;
	}

	@DataProvider(name = "dataprovider")
	public Object[][] searchDataProvider() throws IOException {
		String filename = System.getProperty("user.dir") + "\\Testdata\\dataset.xlsx";
		Object[][] serachData = getDataByExcel(filename, "Sheet1");
		return serachData;

	}

	public String[][] getDataByExcel(String filename, String sheetName) throws IOException {
		String data[][] = null;

		FileInputStream ip = new FileInputStream(filename);

		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet;
		sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum() + 1;
		int cell = sheet.getRow(0).getLastCellNum();
		data = new String[row][cell];
		for (int i = 1; i < row; i++) {

			for (int j = 0; j < cell; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();

		return data;

	}

	public static String getScreenshot(String testcaseName,WebDriver driver) {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\SSreports\\" + testcaseName + ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "\\SSreports\\" + testcaseName + ".png";

	}

	/*
	 * @AfterMethod(alwaysRun = true) public void teardown() { driver.close();
	 */
	// }
}
