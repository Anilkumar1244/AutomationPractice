package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static WebDriver driver;
	
	By txt_username = By.name("username");
	By txt_password = By.name("password");
	By btn_login = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String Username)
	{
		driver.findElement(txt_username).sendKeys(Username);
	}
	
	public void enterPassword(String Password)
	{
		driver.findElement(txt_password).sendKeys(Password);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
}
