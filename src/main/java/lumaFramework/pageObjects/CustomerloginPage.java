package lumaFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerloginPage {

	WebDriver driver;

	public CustomerloginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;

	public WebElement emailField() {

		return emailField;
	}

	@FindBy(xpath="(//input[@id='pass'])[1]")
	WebElement passwordfield;

	public WebElement passwordfield() {

		return passwordfield;
	}

	@FindBy(xpath="(//span[text()='Sign In'])[1]")
	WebElement signinbutton;

	public WebElement signinbutton() {

		return signinbutton;
	}

	@FindBy(xpath="//body/div/main/descendant::div[2]")
	WebElement mismatchwarningmsg;

	public WebElement mismatchwarningmsg() {

		return mismatchwarningmsg;
	}

	@FindBy(xpath="//div[@id='email-error']")
	WebElement emailerrormsg;

	public WebElement emailerrormsg() {

		return emailerrormsg;
	}

	@FindBy(xpath="//div[@id='pass-error']")
	WebElement passworderrormsg;

	public WebElement passworderrormsg() {

		return passworderrormsg;
	}

	@FindBy(xpath="//body/div/main/div[3]/descendant::div[19]/a")
	WebElement createanaccountoption;

	public WebElement createanaccountoption() {

		return createanaccountoption;
	}


}


