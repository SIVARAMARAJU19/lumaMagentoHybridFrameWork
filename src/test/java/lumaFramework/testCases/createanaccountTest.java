package lumaFramework.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lumaFramework.pageObjects.CreateAnAccountPage;
import lumaFramework.pageObjects.HomePage;
import lumaFramework.pageObjects.myAccounthomePage;
import lumaFramework.resources.Base;

public class createanaccountTest extends Base {

	public WebDriver driver;
	public CreateAnAccountPage createanaccountpage;

	@BeforeMethod
	public void openBrowser() {

		driver = inilizeBrowser();
		driver.get("https://magento.softwaretestingboard.com/");
		HomePage homepage = new HomePage(driver);
		homepage.createaccountoption().click();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}



	@Test(priority=1)
	public void CreateanAccountWithOnlyMandatoryFields() {


		createanaccountpage = new CreateAnAccountPage(driver);
		createanaccountpage.firstnamefield().sendKeys("klaus");
		createanaccountpage.lastnamefield().sendKeys("akhil");
		createanaccountpage.emailaddressfield().sendKeys("klausakhil1919@gmail.com");
		createanaccountpage.passwordfield().sendKeys("akhil@19");
		createanaccountpage.passwordconfirmationfield().sendKeys("akhil@19");
		createanaccountpage.createanaccountbutton().click();

		myAccounthomePage myaccounthomepage = new myAccounthomePage(driver);
		Assert.assertTrue(myaccounthomepage.newaccountsucessmsg().isDisplayed());

		System.out.println("create an account sucessfully");
	}

	@Test(priority=2)
	public void CreateanAccountWithAllMandatoryFields() {


		createanaccountpage = new CreateAnAccountPage(driver);
		createanaccountpage.firstnamefield().sendKeys("king");
		createanaccountpage.lastnamefield().sendKeys("maker");
		createanaccountpage.newslettercheckbox().click();
		createanaccountpage.emailaddressfield().sendKeys("klausakhil1005@gmail.com");
		createanaccountpage.passwordfield().sendKeys("akhil@1919");
		createanaccountpage.passwordconfirmationfield().sendKeys("akhil@1919");
		createanaccountpage.createanaccountbutton().click();

		myAccounthomePage myaccounthomepage = new myAccounthomePage(driver);
		Assert.assertTrue(myaccounthomepage.newaccountsucessmsg().isDisplayed());

		System.out.println("create an account sucessfully");
	}

	@Test(priority=3)
	public void CreateanAccountWithWithoutEnteringDetailsIntoTheFields() {


		createanaccountpage = new CreateAnAccountPage(driver);
		createanaccountpage.firstnamefield().sendKeys("");
		createanaccountpage.lastnamefield().sendKeys("");
		createanaccountpage.newslettercheckbox().click();
		createanaccountpage.emailaddressfield().sendKeys("");
		createanaccountpage.passwordfield().sendKeys("");
		createanaccountpage.passwordconfirmationfield().sendKeys("");
		createanaccountpage.createanaccountbutton().click();

		Assert.assertEquals(createanaccountpage.firstnameerrormsg().getText(),"This is a required field.");
		Assert.assertEquals(createanaccountpage.lastnameerrormsg().getText(),"This is a required field.");
		Assert.assertEquals(createanaccountpage.emailerrormsg().getText(),"This is a required field.");
		Assert.assertEquals(createanaccountpage.passworderrormsg().getText(),"This is a required field.");
		Assert.assertEquals(createanaccountpage.confirmpassworderrormsg().getText(),"This is a required field.");


		System.out.println("create an account got error msgs");
	}


	@Test(priority=4)
	public void CreateanAccountWithExistingEmail() {

		createanaccountpage = new CreateAnAccountPage(driver);
		createanaccountpage.firstnamefield().sendKeys("klaus");
		createanaccountpage.lastnamefield().sendKeys("akhil");
		createanaccountpage.emailaddressfield().sendKeys("klausmikealson1919@gmail.com");
		createanaccountpage.passwordfield().sendKeys("akhil@1995");
		createanaccountpage.passwordconfirmationfield().sendKeys("akhil@19");
		createanaccountpage.createanaccountbutton().click();

		Assert.assertTrue(createanaccountpage.existingemailerrormsg().isDisplayed());

		System.out.println("existing email error msg displayed");

	}

}
