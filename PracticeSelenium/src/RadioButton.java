import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButton {

	public static void main(String[] args) {

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		// Instantiate a ChromeDriver class.
		 WebDriver driver = new ChromeDriver();
		 
		 driver.navigate().to("https://omayo.blogspot.com/");
		 
		 //driver.findElement(By.xpath("//input[@value='Bike']")).click(); 
		 
		 int a = driver.findElements(By.xpath("//input[@name='vehicle']")).size();
		 System.out.println(a);  
	        for(int i=1;i<=a;i++)  
	        {  
	            driver.findElements(By.xpath("//input[@name='vehicle']")).get(2).click();  
	        }  
	}

}
