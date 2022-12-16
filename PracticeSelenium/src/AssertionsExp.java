//import org.apache.http.util.Asserts;
import org.apache.http.util.Asserts;
import org.testng.Assert;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertionsExp {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		// Instantiate a ChromeDriver class.
		 WebDriver driver = new ChromeDriver();
		 
		 driver.navigate().to("https://omayo.blogspot.com/");
		 
		 /*Assert.assertFalse(driver.findElement(By.name("accessories")).isSelected());
		 System.out.println(driver.findElement(By.name("accessories")).isSelected());
		 
		 Assert.assertFalse(true);
		 System.out.println(driver.findElement(By.name("accessories")).isSelected());*/
		 
		 /*driver.findElement(By.name("accessories")).click();
		 
		 Assert.assertTrue(driver.findElement(By.name("accessories")).isSelected());
		 System.out.println(driver.findElement(By.name("accessories")).isSelected());*/
		 
		 //Assert.assertEquals("omayo (QAFox.com)", driver.findElement(By.className("title")).getText());
		 //System.out.println(driver.findElement(By.className("title")).getText());
		 
		 //Assert.assertNotEquals("hello", "how are you");
		 //System.out.println("Test case pass");
		 
		 //Assert.assertNotEquals("hello", "hello");
		 //System.out.println("Test case fail");
		 
		 /*Assert.assertNull(null);  
		 System.out.println("...Hello...");
		 
		 Assert.assertNull(5);  
		 System.out.println("...Hello...");*/
		 
		 Assert.assertNotNull(5);  
		 System.out.println("...Hello...");
		 
		 Assert.assertNotNull(null);  
		 System.out.println("...Hello...");
	}

}
