import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingWebPage {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
				
				// Instantiate a ChromeDriver class.
				 WebDriver driver = new ChromeDriver();
				 
				 driver.navigate().to("https://omayo.blogspot.com/");
				 
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("scrollBy(0,5000)");
	}

}
