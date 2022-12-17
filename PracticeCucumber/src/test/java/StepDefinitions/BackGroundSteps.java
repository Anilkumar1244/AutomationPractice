package StepDefinitions;

import io.cucumber.java.en.*;

public class BackGroundSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("User should be on login page");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("User should be entered username and password");
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("User should be clicked on login button");
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		System.out.println("User should be navigated to page");
	}

	@When("user clicks on welcome link")
	public void user_clicks_on_welcome_link() {
		System.out.println("User should be clicked on welcome link");
	}

	@Then("logout link is displayed")
	public void logout_link_is_displayed() {
		System.out.println("Logout link should be displayed");
	}
	@When("user clicks on dashboard link")
	public void user_clicks_on_dashboard_link() {
		System.out.println("User should be clicked on dashboard link");
	}

	@Then("quick launch toolbar is dispalyed")
	public void quick_launch_toolbar_is_dispalyed() {
		System.out.println("Quick launch toolbar should be dispalyed");
	}
}
