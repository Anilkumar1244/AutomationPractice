package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {
		
		String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		String expectedTitle="Web Orders";
		String actualTitle=null;
		
		WebDriver driver=Utility.launchApplication(1,baseUrl);
		LoginPage loginPage=null;
		AllOredersPage allOredersPage=null;
		
		loginPage=new LoginPage(driver);
		PageFactory.initElements(driver,loginPage);//method1
		
		//PageFactory.initElements(driver,AllOredersPage.class);//method2
		
	  allOredersPage=new AllOredersPage(driver);//method3 refer the constructor definition
	  
		loginPage.loginToApplication("Tester","test");
		
		actualTitle=loginPage.getPageTitle();
		
		if(actualTitle.contentEquals(expectedTitle))
				{
			allOredersPage.clickCheckAll();
			Thread.sleep(500);
			allOredersPage.clickUnCheckAll();
			Thread.sleep(500);
			allOredersPage.clickLogout();

				}
		else
		{
			driver.quit();
		}
		

	}

}
