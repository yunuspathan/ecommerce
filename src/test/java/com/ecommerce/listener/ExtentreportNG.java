package com.ecommerce.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG {

	public static  ExtentReports getReportObject() {
		String filepath = System.getProperty("user.dir") + "\\SSreports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
		reporter.config().setReportName("Web Automation result");
		reporter.config().setDocumentTitle("Test Result");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yunus");
		return extent;
	}

}
