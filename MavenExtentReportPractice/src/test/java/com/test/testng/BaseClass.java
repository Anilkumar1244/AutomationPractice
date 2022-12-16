package com.test.testng;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	@Parameters("browserName")
	@BeforeTest
	public void SetUp(ITestContext context,@Optional("chrome") String browserName)
	{
		switch(browserName.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("BrowserName is Invalid");
			break;
		}
		driver.manage().window().maximize();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + " " + capabilities.getBrowserVersion().substring(0,capabilities.getBrowserVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getParameter("author");
		
		extentTest= extentReports.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
		
	}
	
	@BeforeSuite
	public static void InitializeExtentReports()
	{
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		sparkReporter_all.config().setReportName("All Tests Report");
		ExtentSparkReporter sparkReporter_failedTests = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failedTests.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_failedTests.config().setReportName("Failed Tests Report");
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(sparkReporter_all,sparkReporter_failedTests);
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
	@AfterSuite
	public static void GenerateExtentReports() throws Exception
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	}
	
	@AfterMethod
	public  void CheckStatus(Method m,ITestResult result)
	{
		if(result.getStatus() == result.FAILURE)
		{
			String ScreenshotPath = null;
			ScreenshotPath = CaptureScreenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
			extentTest.addScreenCaptureFromPath(ScreenshotPath);
			extentTest.fail(result.getThrowable());
		}
		else if(result.getStatus() == result.SUCCESS)
		{
			extentTest.pass(m.getName()+ "is passed");
			}
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
		}

	@AfterMethod
	public void ScreenshotCapture(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
			CaptureScreenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
	}

	@AfterTest
	public void teardown() 
	{
		driver.quit();
	}

	public String CaptureScreenShot(String filename)
	{
		if(screenshotsSubFolderName == null)
		{
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

			screenshotsSubFolderName = myDateObj.format(myFormatObj);

		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+filename);
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
