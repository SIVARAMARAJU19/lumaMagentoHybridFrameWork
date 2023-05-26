package lumaFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
	WebElement signinoption;

	public WebElement signinoption() {

		return signinoption;
	}

	@FindBy(xpath="(//a[contains(text(),'Create an Account')])[1]")
	WebElement createaccountoption;

	public WebElement createaccountoption() {

		return createaccountoption;
	}
	

	@FindBy(xpath="(//input[@class='input-text'])[1]")
	WebElement searchfield;
	
	public WebElement searchfield() {
		
		return searchfield;
	}
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement searchbutton;
	
	public WebElement searchbutton() {
		
		return searchbutton;
	}

	@FindBy(xpath="//body/div/main/descendant::span[1]")
	WebElement validproductresult;

	public WebElement validproductresult() {

		return validproductresult;
	}

	@FindBy(xpath="//body/div/main/descendant::div[8]")
	WebElement invalidproductresult;

	public WebElement invalidproductresult() {

		return invalidproductresult;
	}

}
