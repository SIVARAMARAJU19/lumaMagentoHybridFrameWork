package lumaFramework.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lumaFramework.pageObjects.HomePage;
import lumaFramework.resources.Base;


//updated comment
public class searchTest extends Base {

	public WebDriver driver;
	public HomePage homepage;

	@BeforeMethod
	public void openbrowser() {

		driver = inilizeBrowser();
		driver.get("https://magento.softwaretestingboard.com/");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority=1)
	public void SearchWithValidProductFromApplicationURL() {

		homepage = new HomePage(driver);
		homepage.searchfield().sendKeys("men's watch");
		homepage.searchbutton().click();

		if(homepage.validproductresult().isDisplayed()) {

			System.out.println("Valid product displayed");

		} else {

			System.out.println("Valid product displayed failure");
		}





	}


	@Test(priority=2)
	public void SearchWithInValidProductFromApplicationURL() {

		homepage = new HomePage(driver);
		homepage.searchfield().sendKeys("yamaha");
		homepage.searchbutton().click();

		Assert.assertEquals(homepage.invalidproductresult().getText(),"Your search returned no results.");

		System.out.println("error test failure");







	}



}
