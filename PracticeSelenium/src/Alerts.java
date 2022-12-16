import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		// Instantiate a ChromeDriver class.
		 WebDriver driver = new ChromeDriver();
		 
		 driver.navigate().to("https://omayo.blogspot.com/");
		 
		 driver.findElement(By.id("prompt")).click();
		 
		 Alert acceptButton = driver.switchTo().alert();
		
		 acceptButton.accept();
		 
		 driver.findElement(By.id("confirm")).click();
		 
		 Alert confirmBox = driver.switchTo().alert();
		 
		System.out.println(confirmBox.getText());
		 confirmBox.dismiss();


	}

}
