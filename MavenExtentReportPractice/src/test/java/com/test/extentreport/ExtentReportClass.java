package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		//Absolute Path
		//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Capgemini\\MavenExtentReportPractice\\Report.html");
		extentReports.attachReporter(sparkReporter);
		
		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("This test is passes");
		
		ExtentTest test2 = extentReports.createTest("Test 2");
		test2.log(Status.FAIL, "This test is failed");
		
		extentReports.createTest("Test 3").skip("This test is skipped");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());
	}

}
