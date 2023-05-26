package lumaFramework.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lumaFramework.pageObjects.CustomerloginPage;
import lumaFramework.pageObjects.HomePage;
import lumaFramework.pageObjects.myAccounthomePage;
import lumaFramework.resources.Base;

public class signinoutTest extends Base {

	public WebDriver driver;
	public CustomerloginPage customerloginpage;
	public myAccounthomePage myaccounthomepage;

	@BeforeMethod
	public void openbrowser() {

		driver = inilizeBrowser();
		driver.get("https://magento.softwaretestingboard.com/");
		HomePage homepage = new HomePage(driver);
		homepage.signinoption().click();

		customerloginpage = new CustomerloginPage(driver);
		customerloginpage.emailField().sendKeys("klausmikealson1919@gmail.com");
		customerloginpage.passwordfield().sendKeys("klaus@1919");
		customerloginpage.signinbutton().click();
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

	@Test(priority=1)
	public void SignoutFromAccountClickSignoutOption() {


		myaccounthomepage = new myAccounthomePage(driver);
		myaccounthomepage.dropdownbutton().click();
		myaccounthomepage.signoutoption().click();

		System.out.println("signout sucessfully");

	}

	@Test(priority=2)
	public void SignoutAccountWithoutClickSignoutOptionWithCloseBrowser() {

		driver.get("https://magento.softwaretestingboard.com/");

		System.out.println("reopen sitelink ");

		myaccounthomepage = new myAccounthomePage(driver);
		myaccounthomepage.dropdownbutton().click();

		System.out.println("user should be in myAccounthomePage");


	}



}
