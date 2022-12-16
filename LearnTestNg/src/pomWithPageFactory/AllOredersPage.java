package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AllOredersPage {
 
	public WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Check All") WebElement linkCheckAll;
	@FindBy(how=How.LINK_TEXT,using="Uncheck All") WebElement linkUncheckAll;
	@FindBy(how=How.LINK_TEXT,using="Logout") WebElement linkLogout;
	@FindBy(how=How.XPATH,using="//input[@type='submit']") WebElement cmdDelete;
	public AllOredersPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickCheckAll()
	{
		linkCheckAll.click();
	}
	
	public void clickUnCheckAll()
	{
		linkUncheckAll.click();
	}
	
	public void clickLogout() throws InterruptedException
	{
		linkLogout.click();
		Thread.sleep(500);
		driver.quit();
	}
	
	public void clickDelete()
	{
		cmdDelete.click();
	}
}
