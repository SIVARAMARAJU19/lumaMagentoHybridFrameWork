package lumaFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

	WebDriver driver;

	public  CreateAnAccountPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstnamefield;

	public WebElement firstnamefield() {

		return firstnamefield;
	}

	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastnamefield;

	public WebElement lastnamefield() {

		return lastnamefield;
	}

	@FindBy(xpath="//input[@id='email_address']")
	WebElement emailaddressfield;

	public WebElement emailaddressfield() {

		return emailaddressfield;
	}

	@FindBy(xpath="//input[@id='password']")
	WebElement passwordfield;

	public WebElement passwordfield() {

		return passwordfield;
	}

	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement passwordconfirmationfield;

	public WebElement passwordconfirmationfield() {

		return passwordconfirmationfield;
	}

	@FindBy(xpath="(//span[text()='Create an Account'])[1]")
	WebElement createanaccountbutton;

	public WebElement createanaccountbutton() {

		return createanaccountbutton;
	}

	@FindBy(xpath="//input[@id='is_subscribed']")
	WebElement newslettercheckbox;

	public WebElement newslettercheckbox() {

		return newslettercheckbox;
	}

	@FindBy(xpath="//body/div/main/descendant::div[5]")
	WebElement existingemailerrormsg;

	public WebElement existingemailerrormsg() {

		return existingemailerrormsg; 
	}

	@FindBy(xpath="//div[@id='firstname-error']")
	WebElement firstnameerrormsg;

	public WebElement firstnameerrormsg() {

		return firstnameerrormsg;
	}

	@FindBy(xpath="//div[@id='lastname-error']")
	WebElement lastnameerrormsg;

	public WebElement lastnameerrormsg() {

		return lastnameerrormsg;
	}

	@FindBy(xpath="//div[@id='email_address-error']")
	WebElement emailerrormsg;

	public WebElement emailerrormsg() {

		return emailerrormsg;
	}

	@FindBy(xpath="//div[@id='password-error']")
	WebElement passworderrormsg;

	public WebElement passworderrormsg() {

		return passworderrormsg;
	}

	@FindBy(xpath="//div[@id='password-confirmation-error']")
	WebElement confirmpassworderrormsg;

	public WebElement confirmpassworderrormsg() {

		return confirmpassworderrormsg;
	}


}
