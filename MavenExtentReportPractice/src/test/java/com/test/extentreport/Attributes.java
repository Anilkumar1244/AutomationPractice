package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Attributes {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		.createTest("Test 1")
		.assignAuthor("Anil")
		.assignCategory("Regression")
		.assignDevice("Chrome 99");
		
		extentReports
		.createTest("Test 2")
		.assignAuthor("kumar")
		.assignCategory("Smoke")
		.assignDevice("Chrome 100");
		
		extentReports
		.createTest("Test 3")
		.assignCategory("Sanity")
		.assignDevice("Chrome 98");
		
		extentReports
		.createTest("Test 4")
		.assignAuthor("ABC")
		.assignAuthor("XYZ")
		.assignCategory("Sanity")
		.assignCategory("Functional")
		.assignDevice("Chrome 96")
		.assignDevice("Chrome 97");
		
		extentReports
		.createTest("Test 5")
		.assignAuthor("kumar","Anil","Mandya")
		.assignCategory("Smoke","Sanity","Rgression")
		.assignDevice("Chrome 100","Chrome 101");
		
		extentReports
		.createTest("Test 6")
		.assignAuthor(new String[] {"kumar","Anil","Mandya"})
		.assignCategory(new String[] {"Smoke","Sanity","Rgression"})
		.assignDevice(new String[] {"Chrome 100","Chrome 101"});
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());
	}

}
