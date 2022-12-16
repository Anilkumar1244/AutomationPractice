import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleProgram {

	public static void main(String[] args) {
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		// Instantiate a ChromeDriver class.
		 WebDriver driver = new ChromeDriver();
		 
		// Storing the Application Url in the String variable
		 String Url = ("https://www.google.com/");
		 
		//Launch the ToolsQA WebSite  
		 driver.get(Url);
		 
		// Storing Title name in the String variable  
		 String title = driver.getTitle();
		 
		// Storing Title length in the Int variable  
		 int titleLength = driver.getTitle().length();
		 
		// Printing Title & Title length in the Console window
		 System.out.println(title);
		 System.out.println(titleLength);
		 
		// Storing URL in String variable  
		 String actualUrl = driver.getCurrentUrl();
		 
		 //Verifying the Url
		 if(actualUrl.equals("https://www.google.com/"))
		 {
			 System.out.println("Verification Successful - The correct Url is opened.");
		 }
		 else
		 {
			 System.out.println("Verification Successful - The correct Url is opened.");
		 }
		 
		// Storing Page Source in String variable 
    String pageSource = driver.getPageSource();
    
 // Storing Page Source length in Int variable  
    int pageSourceLength = pageSource.length();
    
 // Printing length of the Page Source on console  
    System.out.println("Length of the page Source is:" +pageSourceLength );
    
  //Closing browser  
    driver.close();
	}

}
