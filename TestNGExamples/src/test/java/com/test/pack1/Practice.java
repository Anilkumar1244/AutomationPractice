package com.test.pack1;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void InitializeBroswer(@Optional("chrome") String browserName)
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
	}

	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

	//@Parameters("url")
	@SuppressWarnings("deprecation")
	@Test
	public void LaunchApp()
	{
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	//@Parameters({"username","password"})
	@Test
	public void LoginDetails() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test
	public void NavigateMyInfo()
	{
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}

	
	@Test
	public void VerifyMyInfo()
	{
		boolean actualValue = driver.findElement(By.xpath("//a[text()='Personal Details']")).isDisplayed();
		assertTrue(actualValue);
	}

	@Test
	public void VerifyLogin()
	{
		//driver.findElement(By.xpath("//div[@class='oxd-brand-banner']"));
		WebElement element = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Dashboard"));
	}

}
