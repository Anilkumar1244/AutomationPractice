import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement {

	public static void main(String[] args) {

		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				 boolean status = driver.findElement(By.name("userid")).isDisplayed();
				 System.out.println(status);
				 
				 boolean status1 = driver.findElement(By.name("userid")).isEnabled();
				 System.out.println(status1);
				 
				 boolean status2 = driver.findElement(By.id("checkbox1")).isSelected();
				 System.out.println(status2);
				 
				 String status3 = driver.findElement(By.className("title")).getText();
				 System.out.println(status3);
				 
				 String status4 = driver.findElement(By.className("title")).getTagName();
				 System.out.println(status4);
				 
				 String status5 = driver.findElement(By.className("title")).getAttribute("className");
				 System.out.println(status5);
				
				 
				 
	}

}
