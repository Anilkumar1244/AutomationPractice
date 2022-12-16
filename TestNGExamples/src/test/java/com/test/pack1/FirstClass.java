package com.test.pack1;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass {

	@Test
	public void TestGoogle() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium Tutorial",Keys.ENTER);
		String ExpectedTitle = "Selenium Tutorial - Google Search";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle,ExpectedTitle);
		Thread.sleep(200);
		driver.quit();
		
	}
	
	
	@Test
	public void TestFaceBook() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Selenium tutorials",Keys.ENTER);
		Thread.sleep(200);
		
		SoftAssert softassert = new SoftAssert();
		
		//Title Assertion
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Log in to Facebook";
		softassert.assertEquals(ActualTitle,ExpectedTitle,"Title is Missmatced");
		
		//Url Assertion
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://www.facebook.com/";
		softassert.assertNotEquals(ActualUrl,ExpectedUrl,"Url is Missmatced");
		
		//Text Assertion
		String ActualText = driver.findElement(By.id("email")).getAttribute("value");
		String ExpectedText = "wel";
		softassert.assertEquals(ActualText,ExpectedText,"Username is Missmatced");

		//Border Assertion
		String ActualBorder = driver.findElement(By.id("email")).getCssValue("border");
		String ExpectedBorder = "1px solid rgb(240, 40, 73)";
		softassert.assertEquals(ActualBorder,ExpectedBorder,"Border is Missmatced");

		//ErrorMessage Assertion
		String ActualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String ExpectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softassert.assertEquals(ActualErrorMessage,ExpectedErrorMessage,"ErrorMessage is Missmatced");

		driver.quit();
		softassert.assertAll();
		
	}
	
	@Test
	public void TestUdemy() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("anilkumar28p06@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Vaibhu@2820");
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		Thread.sleep(200);
		driver.quit();
		
	}
}
