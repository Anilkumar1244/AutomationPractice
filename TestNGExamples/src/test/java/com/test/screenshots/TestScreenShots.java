package com.test.screenshots;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestScreenShots extends BaseClass {

	@Test
	public void TestGoogle() throws InterruptedException
	{

		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium Tutorial",Keys.ENTER);
		String ExpectedTitle = "Selenium Tutorial - Google Search";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle,ExpectedTitle);

	}


	@Test
	public void TestFaceBook() throws InterruptedException
	{

		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Selenium tutorials",Keys.ENTER);


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


		softassert.assertAll();

	}

	@Test
	public void OrangeHRM() throws InterruptedException
	{

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed());

	}
}
