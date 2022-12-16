package Libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utility {

	public static WebDriver launchApplication(int browser,String baseUrl) {
	
		WebDriver driver;
		switch (browser) {
		case 1:
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");		
			driver = new ChromeDriver();
			break;

		case 2:
			System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\chromedriver_win32");		
			driver = new FirefoxDriver();
			break;

		case 3:
			System.setProperty("webdriver.ie.driver", "C:\\Softwares\\chromedriver_win32");		
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");		
			driver = new ChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}
	
	public static void loginToApplication(WebDriver driver,String uName,String passwd) {
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uName);				
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(passwd);
		driver.findElement(By.className("button")).click();
	}

	public static void captureScreenshot(WebDriver driver,String fileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\Screenshots\\" + fileName + ".png"));
	}
	
	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();				
	}
	
	public static void logout(WebDriver driver) {
		
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}

}
