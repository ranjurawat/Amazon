package amazon.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ThreatListPage;
import Pages.iRacsPage;
import Pages.locationSelectionPage;
import Pages.loginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;


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
	public void validLoginTest() {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginPage loginScreen = new loginPage(driver);
	     WebElement email = loginScreen.getEmailId();
	     WebElement login = loginScreen.getLoginButton();
	     locationSelectionPage selectLoc = new locationSelectionPage(driver);
	     WebElement loc = selectLoc.getLocList();
	     WebElement okButton = selectLoc.clickOk();
	     wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("ranju@versionx.in");
	     wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	     wait.until(ExpectedConditions.elementToBeClickable(loc)).click();
	     wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
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
