package lumaFramework.resources;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver inilizeBrowser() {
		
		String BrowserName = "edge";
		
		if(BrowserName.equalsIgnoreCase("edge")) {
			
			 driver = new EdgeDriver();
			
		}else if(BrowserName.equalsIgnoreCase("chrome")) {
			
			 driver = new ChromeDriver();
			
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		
		return driver;
		
	}
	
	public String takescreenshot(String testname,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testname+".png"; 
		FileUtils.copyFile(SourceFile,new File(destinationFilePath)); 
		return destinationFilePath;
	}

		

}
