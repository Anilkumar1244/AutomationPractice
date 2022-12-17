package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {

	public static WebDriver driver;
	
	@FindBy(name="username")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_login;
	
	
	public LoginPage_PF(WebDriver driver)
	{
		super();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterUserName(String Username)
	{
		txt_username.sendKeys(Username);
	}
	
	public void enterPassword(String Password)
	{
		txt_password.sendKeys(Password);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	
	
}
