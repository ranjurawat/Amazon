package amazon.Amazon;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;


public class BaseTest extends Base {

	@BeforeSuite(alwaysRun=true)
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
