package TestNgLearning;

import org.testng.annotations.Test;

//import Libraries.Utility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase2 {
	
	String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	String expectedTitle="Web Orders Login";
	String actualTitle=null;
	WebDriver driver;
	
  @Test
  public void VerifyLoginPage() {
	  
	  actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @BeforeTest
  public void Initialization() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get(baseUrl);
  }

  @AfterTest
  public void stop() {
	  
	  driver.quit();
  }

}
