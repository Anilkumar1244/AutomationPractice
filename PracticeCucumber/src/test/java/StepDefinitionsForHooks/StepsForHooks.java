package StepDefinitionsForHooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsForHooks {

	public static WebDriver driver;
	
	@Before
	public void broswerSetUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeStep
	public void beforeSteps()
	{
		System.out.println("BeforeSteps Method is Executed");
	}
	
	@AfterStep
	public void afterSteps()
	{
		System.out.println("AfterSteps Method is Executed");
	}
	
	@Given("browser is open")
	public void browser_is_open() {
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
	}

	@When("user enters the text in search box")
	public void user_enters_the_text_in_search_box() {
	}

	@And("hits enter")
	public void hits_enter() {
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
	}

}
