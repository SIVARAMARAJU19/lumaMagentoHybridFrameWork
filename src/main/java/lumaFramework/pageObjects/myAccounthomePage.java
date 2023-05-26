package lumaFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccounthomePage {

	WebDriver driver;

	public myAccounthomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="(//span[@class='logged-in'])[1]")
	WebElement signinsucessmsg;

	public WebElement signinsucessmsg() {

		return signinsucessmsg;
	}
	
	@FindBy(xpath="(//button[@class='action switch'])[1]")
	WebElement dropdownbutton;

	public WebElement dropdownbutton() {

		return dropdownbutton;
	}

	@FindBy(xpath="(//a[contains(text(),'Sign Out')])[1]")
	WebElement signoutoption;

	public WebElement signoutoption() {

		return signoutoption;
	}
	
	@FindBy(xpath="(//body/div/main/descendant::div[5])")
	WebElement newaccountsucessmsg;
	
	public WebElement newaccountsucessmsg() {
		
		return newaccountsucessmsg;
	}


}
