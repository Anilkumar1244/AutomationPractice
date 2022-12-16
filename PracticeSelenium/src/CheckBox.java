import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {

		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				 //boolean Status = driver.findElement(By.name("accessories")).isSelected();
				 //System.out.println(Status);
				 
				   driver.findElement(By.name("accessories")).click();
				   
				   driver.close();
				 
	}

}
