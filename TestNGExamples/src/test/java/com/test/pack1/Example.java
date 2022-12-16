package com.test.pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example 
{
	@SuppressWarnings("deprecation")
	@Test
	public void Learn() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("anilkumar28p06@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Vaibhu@2820");
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		Thread.sleep(200);
		driver.quit();
		
	}
	

}
