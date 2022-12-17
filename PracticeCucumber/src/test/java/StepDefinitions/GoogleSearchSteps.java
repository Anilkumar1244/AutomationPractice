package StepDefinitions;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
	   
		driver.navigate().to("https://www.google.co.in/");
	}

	@When("user enters the text in search box")
	public void user_enters_the_text_in_search_box() {
	   driver.findElement(By.name("q")).sendKeys("Selenium tutorials");
	}

	@When("hits enter")
	public void hits_enter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
	    
		driver.getPageSource().contains("Selenium Tutorial - Javatpoint");
		
		driver.quit();
	}
}
