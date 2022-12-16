import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) {

 System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();
 
 driver.navigate().to("https://www.google.com/");
 
 driver.findElement(By.name("q")).sendKeys("Flipkart");
 
//System.out.println(SampleText);
 
 driver.findElement(By.name("btnK")).click();
 
 driver.quit();
 
 
	}

}
