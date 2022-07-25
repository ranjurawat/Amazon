package amazon.Amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.iRacsPage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;


public class BaseTest extends Base {

	@BeforeSuite
	public void openAppTest() throws IOException, InterruptedException { 
		
		System.out.println("Run Driver");
        AndroidDriver andDr=Capabilities("App");  
        System.out.println("Driver"+", "+andDr);
        driver = andDr; 
        driver.unlockDevice();
//        System.out.println("Click on Start button");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		iRacsPage iracs = new iRacsPage(driver);
//	    WebElement start = iracs.getStartButton();
//	    wait.until(ExpectedConditions.elementToBeClickable(start)).click();

        
    }
	
//	@BeforeTest
//	public void startApp() {
//		System.out.println("Click on Start button");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		iRacsPage iracs = new iRacsPage(driver);
//	    WebElement start = iracs.getStartButton();
//	    wait.until(ExpectedConditions.elementToBeClickable(start)).click();
//	    
//	}
	
	
	
	
	
}
