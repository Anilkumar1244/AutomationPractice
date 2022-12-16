package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(how=How.ID,using = "ctl00_MainContent_username") WebElement txtUsername;
	@FindBy(how=How.NAME,using = "ctl00$MainContent$password") WebElement txtPassword;
	@FindBy(how=How.CSS,using = "input[value='Login']") WebElement cmdLogin;
	
	@CacheLookup
	@FindBy(id="ctl00_MainContent_username") WebElement username;

	public LoginPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String uName)
	{
		username.sendKeys(uName);
	}
	
	public void enterPassword(String passwd)
	{
		txtPassword.sendKeys(passwd);
	}
	
	public void clickLogin()
	{
		cmdLogin.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void loginToApplication(String uName,String passwd)
	{
		this.enterUsername(uName);
		this.enterPassword(passwd);
		this.clickLogin();
	}
	


}
