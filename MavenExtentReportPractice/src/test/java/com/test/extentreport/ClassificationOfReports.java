package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ClassificationOfReports {

	public static void main(String[] args) throws Exception {

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter_allTests = new ExtentSparkReporter("AllTests.html");
		ExtentSparkReporter sparkReporter_failedTests = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failedTests.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter sparkReporter_SkippedandWarning = new ExtentSparkReporter("SkippedandWarningTests.html");
		sparkReporter_SkippedandWarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				}).apply();
		
		extentReports.attachReporter(sparkReporter_allTests,sparkReporter_failedTests,sparkReporter_SkippedandWarning);
		
		
		extentReports
		.createTest("Test 1")
		.assignAuthor("Anil")
		.assignCategory("Regression")
		.assignDevice("Chrome 99")
		.pass("This is passed test");
		
		extentReports
		.createTest("Test 2")
		.assignAuthor("kumar")
		.assignCategory("Smoke")
		.assignDevice("Chrome 100")
		.pass("This is passed test");
		
		extentReports
		.createTest("Test 3")
		.assignCategory("Sanity")
		.assignDevice("Chrome 98")
		.fail("This is fail test");
		
		extentReports
		.createTest("Test 4")
		.assignAuthor("ABC")
		.assignAuthor("XYZ")
		.assignCategory("Sanity")
		.assignCategory("Functional")
		.assignDevice("Chrome 96")
		.assignDevice("Chrome 97")
		.skip("This is skipped test");
		
		extentReports
		.createTest("Test 5")
		.assignAuthor("kumar","Anil","Mandya")
		.assignCategory("Smoke","Sanity","Rgression")
		.assignDevice("Chrome 100","Chrome 101")
		.warning("This is warning test");
		
		extentReports
		.createTest("Test 6")
		.assignAuthor(new String[] {"kumar","Anil","Mandya"})
		.assignCategory(new String[] {"Smoke","Sanity","Rgression"})
		.assignDevice(new String[] {"Chrome 100","Chrome 101"})
		.pass("This is passed test");
		
		Throwable t = new Throwable("This is Throwable Exception");
		extentReports
		.createTest("Exception")
		.fail(t);
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkippedandWarningTests.html").toURI());
	}

}
