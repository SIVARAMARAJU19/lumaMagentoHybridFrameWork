package lumaFramework.testCases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lumaFramework.pageObjects.CustomerloginPage;
import lumaFramework.pageObjects.HomePage;
import lumaFramework.pageObjects.myAccounthomePage;
import lumaFramework.resources.Base;
import lumaFramework.utils.Utility;

public class signinTest extends Base {

	public WebDriver driver;
	public CustomerloginPage customerloginpage;

	@BeforeMethod
	public void openbrowser() {

		driver = inilizeBrowser();
		driver.get("https://magento.softwaretestingboard.com/");
		HomePage homepage = new HomePage(driver);
		homepage.signinoption().click();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority=1)
	public void SigninWithValidCredentials() {


		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys("klausmikealson1919@gmail.com");
		customerloginpage.passwordfield().sendKeys("klaus@1919");
		customerloginpage.signinbutton().click();

		myAccounthomePage myaccounthomepage = new myAccounthomePage(driver);
		if(myaccounthomepage.signinsucessmsg().isDisplayed()) {
			
			System.out.println("signin sucessfully");
		} else {
			
			System.out.println("signin failure");
		}

		


	}

	@Test(priority=2)
	public void SigninWithInValidCredentials() {

		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys("klausmikealson1919"+generatetimestamp()+"@gmail.com");
		customerloginpage.passwordfield().sendKeys("klaus@005");
		customerloginpage.signinbutton().click();

		Assert.assertEquals(true, customerloginpage.mismatchwarningmsg().isDisplayed() );

		System.out.println("signin failure");

	}

	@Test(priority=3)
	public void SigninWithValidEmailAndInValidPassword() {

		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys("klausmikealson1919@gmail.com");
		customerloginpage.passwordfield().sendKeys("klaus@005");
		customerloginpage.signinbutton().click();

		Assert.assertEquals(true,customerloginpage.mismatchwarningmsg().isDisplayed());

		System.out.println("mismatch credentials for invalid email");
	}

	@Test(priority=4)
	public void SigninWithInValidEmailAndValidPassword() {

		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys(Utility.generateemailwithtimestamp());
		customerloginpage.passwordfield().sendKeys("klaus@1919");
		customerloginpage.signinbutton().click();

		Assert.assertEquals(true,customerloginpage.mismatchwarningmsg().isDisplayed());

		System.out.println("mismatch credentials for invalid password");
	}

	@Test(priority=5)
	public void SigninWithoutCredentials() {

		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys("");
		customerloginpage.passwordfield().sendKeys("");
		customerloginpage.signinbutton().click();

		Assert.assertEquals(true, customerloginpage.emailerrormsg().isDisplayed());

		System.out.println("email error msg shown");

		Assert.assertEquals(true, customerloginpage.passworderrormsg().isDisplayed());

		System.out.println("password error msg shown");

	}

	public String generatetimestamp() {

		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");

	}
}
