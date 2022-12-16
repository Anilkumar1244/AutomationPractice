package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogExp {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		//Absolute Path
		//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Capgemini\\MavenExtentReportPractice\\Report.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		.createTest("Test 3")
		.log(Status.INFO, "Info")
		.log(Status.PASS, "Pass")
		.log(Status.SKIP, "Skip")
		.log(Status.WARNING, "Warning")
		.log(Status.FAIL, "fail");
		//Info
		//Pass
		//Skip
		//Warning
		//fail
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
