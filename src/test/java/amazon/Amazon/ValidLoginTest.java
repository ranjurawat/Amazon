package amazon.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.iRacsPage;
import Pages.locationSelectionPage;
import Pages.loginPage;
import io.appium.java_client.android.Activity;


public class ValidLoginTest extends BaseTest {
	
	@BeforeMethod
	public void startHome() {
		System.out.println("This is Start Home Method");
		Activity activity = new Activity("versionx.threatleadtool", "versionx.threatleadtool.Activity.StartActivity");
		driver.startActivity(activity);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		iRacsPage iracs = new iRacsPage(driver);
	    WebElement start = iracs.getStartButton();
	    wait.until(ExpectedConditions.elementToBeClickable(start)).click();

	}
	
	@Test(priority=1)
	public void validLoginTest(){	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginPage loginScreen = new loginPage(driver);
	     WebElement email = loginScreen.getEmailId();
	     WebElement login = loginScreen.getLoginButton();
	     locationSelectionPage selectLoc = new locationSelectionPage(driver);
	     List<WebElement> loc = selectLoc.getLocList();
	     WebElement okButton = selectLoc.clickOk();
	     
	    if(email.isDisplayed()) {
	    	wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("ranju@versionx.in");
		    wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	    
	     
	     long startTime = System.currentTimeMillis(); //fetch starting time
	     boolean neededStatus;
	     do{
	    	 String xmlFormat = driver.getPageSource();
	     neededStatus = xmlFormat.contains("Enter valid user Id");
	     }while(!(neededStatus) && (((System.currentTimeMillis()-startTime) <= (5*1000))));
	     
	     System.out.println("Toast message"+", "+neededStatus);
	     if (!neededStatus) {
	     if(loc.size()!=0) {
	    	System.out.println("Locations List"+", "+loc.size());
	       wait.until(ExpectedConditions.elementToBeClickable(loc.get(1))).click();
	       wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
	     }else {
	    	 System.out.println("No locations"+", "+loc.size());
	     }
	     }else {
	    	 System.out.println("Login Failed");
	     }
	   }else {
		   System.out.println("User is already logged in");
	   }
	}
	
//	@Test(priority=2)
//	public void openItemDetails() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		ThreatListPage listScreen = new ThreatListPage(driver);
//		List<WebElement> list = listScreen.getItem();
//		System.out.println(list);
//		wait.until(ExpectedConditions.elementToBeClickable(list.get(1))).click();
//		
//	}
	
	
	
}
