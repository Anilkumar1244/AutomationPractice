import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectors {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				/*driver.findElement(By.id("ta1")).sendKeys("Practice selenium for future");
				 
				driver.findElement(By.name("textboxn")).sendKeys("Selenium Learning");
				 
				driver.findElement(By.className("feed-link")).click();
				 
				driver.findElement(By.tagName("input")).sendKeys("Anil kumar");*/

			  // driver.findElement(By.linkText("Posts (Atom)")).click();
			   
			   //driver.findElement(By.partialLinkText("Posts")).click();
				 
				// Css Seelectors--->TagANDId
				 //driver.findElement(By.cssSelector("textarea#ta1")).sendKeys("Learning CSS selector");
				 
				 //TagANDClass
				 //driver.findElement(By.cssSelector("input.classone")).sendKeys("Learning Selenium");
				 
				 //TagANDAttribute
				 //driver.findElement(By.cssSelector("textarea[id=ta1]")).sendKeys("Learning CSS selector");
				 //driver.findElement(By.cssSelector("input[class=classone]")).sendKeys("Learning Selenium");

				 //Tag,Class And Attribute
				 //driver.findElement(By.cssSelector("input.classone[type=text]")).sendKeys("Learning CSS selector");

				 //Substring Matches
				 driver.findElement(By.cssSelector("textarea[id^=ta1]")).sendKeys("Learning CSS selector");

				 //driver.close();
				 
				 

	}

}
