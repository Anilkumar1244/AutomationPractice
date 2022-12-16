package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		String base64Code = CaptureScreenShot();
		String path = CaptureScreenShot("Google.jpg");
		
		
		extentReports
		.createTest("Screenshot Test1","This is for attaching the screenshot")
		.info("This is a info message")
		.addScreenCaptureFromBase64String(base64Code);
		
		extentReports
		.createTest("Screenshot Test2","This is for attaching the screenshot")
		.info("This is a info message")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page");
		
		//Multiple Screenshot
		extentReports
		.createTest("Screenshot Test3","This is for attaching the screenshot")
		.info("This is a info message")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page1")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page2")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page3")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page4")
		.addScreenCaptureFromBase64String(base64Code,"Google Home Page5");
		
		extentReports
		.createTest("Screenshot Test4","This is for attaching the screenshot")
		.info("This is a info message")
		.addScreenCaptureFromPath(path);
		
		extentReports
		.createTest("Screenshot Test5","This is for attaching the screenshot to the Test Level")
		.info("This is a info message")
		.addScreenCaptureFromPath(path,"Google Home Page");
		
		//Multiple Screenshot
		extentReports
		.createTest("Screenshot Test6","This is for attaching the screenshot")
		.info("This is a info message")
		.addScreenCaptureFromPath(path,"Google Home Page1")
		.addScreenCaptureFromPath(path,"Google Home Page2")
		.addScreenCaptureFromPath(path,"Google Home Page3")
		.addScreenCaptureFromPath(path,"Google Home Page4")
		.addScreenCaptureFromPath(path,"Google Home Page5");

		extentReports
		.createTest("Screenshot Test7","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Googlr Home Page").build());
		
		extentReports
		.createTest("Screenshot Test8","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"Googlr Home Page").build());
		
		extentReports
		.createTest("Screenshot Test9","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail("Media Example",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail("Media Example",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Googlr Home Page").build());
		
		extentReports
		.createTest("Screenshot Test10","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail("Media Example",MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("Media Example",MediaEntityBuilder.createScreenCaptureFromPath(path,"Googlr Home Page").build());
		
		Throwable t = new Throwable("This is Throwable Exception");
		extentReports
		.createTest("Screenshot Test11","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Googlr Home Page").build());
		
		extentReports
		.createTest("Screenshot Test12","This is for attaching the screenshot to the Log Level")
		.info("This is a info message")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path,"Googlr Home Page").build());
		

		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("Report.html").toURI());
	}

	public static String CaptureScreenShot()
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return base64Code;
	}


	public static String CaptureScreenShot(String filename)
	{

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" +filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
}

