import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				//WebElement on which drag and drop operation needs to be performed  
				 	WebElement from = driver.findElement(By.className("widget-content"));
				 	
				 	//WebElement to which the above object is dropped  
				 	WebElement to = driver.findElement(By.id("ta1"));
				 	
				 	//Creating object of Actions class to build composite actions  
				 	Actions act = new Actions(driver);
				 	
				 	//Performing the drag and drop action  
				 	act.dragAndDrop(from, to).build().perform();
				 	
	}

}
