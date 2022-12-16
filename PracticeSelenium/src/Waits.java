//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class Waits {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 //PageLoadTimeouts
				 driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); 
				 
				 //implicit timeout
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				 Select TestDropDown = new Select(driver.findElement(By.id("drop1")));
				 TestDropDown.selectByVisibleText("doc 1");
	}

}
