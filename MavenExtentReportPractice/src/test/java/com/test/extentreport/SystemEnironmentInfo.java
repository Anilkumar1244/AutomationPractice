package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemEnironmentInfo {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		//Usng Java
		/*ExtentSparkReporterConfig config = sparkReporter.config();
		config.setTheme(Theme.DARK);
		config.setDocumentTitle("Doctilte");
		config.setTimeStampFormat("DD-MM-YYYY HH:MM:SS");
		config.setCss(".badge-primary{background-color:#65dfa9}");
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");*/

		//Using JSON
		//sparkReporter.loadJSONConfig(new File("C:\\Capgemini\\MavenExtentReportPractice\\src\\test\\resources\\Extent-report-config.json"));

		//Using JSON
		sparkReporter.loadXMLConfig(new File("C:\\Capgemini\\MavenExtentReportPractice\\src\\test\\resources\\Extent-report-config.xml"));

		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("os", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser", capabilities.getBrowserName() + capabilities.getBrowserVersion());
		extentReports.setSystemInfo("App URL", "https://www.google.co.in/");
		extentReports.setSystemInfo("Username", "Anil kumar");
		extentReports.setSystemInfo("Password", "Anil123");
		
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
		driver.quit();
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
