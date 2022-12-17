package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.LoginPage_PF;

public class LoginStepsPageFactory {

	public static WebDriver driver = null;
	LoginPage_PF login;

	@Given("User is on browser")
	public void user_is_on_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("login page is opened")
	public void login_page_is_opened() throws Exception {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String Username,String Password) throws Exception {
		login = new LoginPage_PF(driver);
		login.enterUserName(Username);
		login.enterPassword(Password);
		//driver.findElement(By.name("username")).sendKeys(Username);
		//driver.findElement(By.name("password")).sendKeys(Password);
		Thread.sleep(1000);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		login.clickLogin();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Then("user is navigated to Home page")
	public void user_is_navigated_to_Home_page() {
		//driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed();
		//WebElement element = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		//assertTrue(element.isDisplayed());
		//assertTrue(element.getText().startsWith("Dashboard"));
		System.out.println("Home Page");
		driver.quit();
	}
}
