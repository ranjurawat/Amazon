package amazon.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ThreatListPage;
import io.appium.java_client.android.Activity;

public class SearchTest extends Base {

	
	@Test(priority=3)
	public void searchTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage searchTst = new ThreatListPage(driver);
		 WebElement src = searchTst.getSearch();
		 wait.until(ExpectedConditions.elementToBeClickable(src)).sendKeys("pro");	 
	}
	

	@Test(priority=4)
	public void locFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage locFilt = new ThreatListPage(driver);
		 WebElement locSelect = locFilt.filterLoc();
		 wait.until(ExpectedConditions.elementToBeClickable(locSelect)).click(); 
		 List<WebElement> locList = locFilt.getElement();
		 wait.until(ExpectedConditions.elementToBeClickable(locList.get(0))).click(); 
		 WebElement okButton = locFilt.getOkButton();
		 wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();		 
		
	}
}
