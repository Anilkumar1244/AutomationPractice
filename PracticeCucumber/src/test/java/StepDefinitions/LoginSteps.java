package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("User is on login page")
	public void user_is_on_login_page() {
	    System.out.println("User should be on login page");
	}

	@When("Enter Username and Passowrd")
	public void enter_Username_and_Passowrd() {
		System.out.println("User should be Enter Username and Passowrd Successfully");
	}

	@And("User Clicks on Login button")
	public void user_Clicks_on_Login_button() {
		System.out.println("User should be Clicked Login Button Successfully");
	}

	@Then("User Navigate to Home Page")
	public void user_Navigate_to_Home_Page() {
		System.out.println("User should be Navigate to Successfully");
	}

	
}
