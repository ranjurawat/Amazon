package amazon.Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ThreatListPage;
import Pages.iRacsPage;
import Pages.loginPage;
import Pages.notificationPage;
import Pages.threatDetailPage;
import Pages.userPage;
import io.appium.java_client.android.Activity;

public class ThreatListScreenTest extends ValidLoginTest {
	

	@BeforeMethod
	public void startHome() {
		System.out.println("This is Start Home Method");
		Activity activity = new Activity("versionx.threatleadtool", "versionx.threatleadtool.Activity.StartActivity");
		driver.startActivity(activity);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		iRacsPage iracs = new iRacsPage(driver);
	    WebElement start = iracs.getStartButton();
	    wait.until(ExpectedConditions.visibilityOf(start)).click();

	}
	
	@Test(priority=3)
	public void openItemDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage listScreen = new ThreatListPage(driver);
		List<WebElement> list = listScreen.getItem();
		System.out.println(list);
		wait.until(ExpectedConditions.visibilityOf(list.get(1))).click();
		threatDetailPage detailScreen = new threatDetailPage(driver);
		WebElement detail = detailScreen.getDetail();
		wait.until(ExpectedConditions.visibilityOf(detail)).isDisplayed();
		System.out.println(detail.getText());
		
	}
	
	@Test(priority=4)
	public void searchTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage searchTst = new ThreatListPage(driver);
		 WebElement src = searchTst.getSearch();
		 wait.until(ExpectedConditions.visibilityOf(src)).sendKeys("ter");
		 WebElement view = searchTst.getListView();
		 String val = view.getText();
		 System.out.println("View Text"+", "+val.isEmpty());
		 
	}
	

	@Test(priority=5)
	public void locFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage locFilt = new ThreatListPage(driver);
		 WebElement locSelect = locFilt.filterLoc();
		 wait.until(ExpectedConditions.elementToBeClickable(locSelect)).click(); 
		 List<WebElement> locList = locFilt.getElement();
		 wait.until(ExpectedConditions.elementToBeClickable(locList.get(0))).click(); 
		 WebElement okButton = locFilt.getOkButton();
		 wait.until(ExpectedConditions.visibilityOf(okButton)).click();		
		 ThreatListPage listScreen = new ThreatListPage(driver);
		 WebElement loc = listScreen.getLocNm();
		 wait.until(ExpectedConditions.visibilityOf(loc)).isDisplayed();
		 System.out.println(loc.getText());
		
	}
	
	
	@Test(priority=6)
	public void getNotify() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage getNot = new ThreatListPage(driver);
		WebElement notification = getNot.getNotification();
		wait.until(ExpectedConditions.visibilityOf(notification)).click();
		notificationPage notPage = new notificationPage(driver);
		WebElement notifications = notPage.checkNotication();
		wait.until(ExpectedConditions.visibilityOf(notifications)).isDisplayed();
		WebElement backButton = notPage.getNotBack();
		wait.until(ExpectedConditions.visibilityOf(backButton)).click();
		
	}
	
	@Test(priority=7)
	public void getUser() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ThreatListPage getUsr = new ThreatListPage(driver);
		WebElement user = getUsr.getUser();
		wait.until(ExpectedConditions.visibilityOf(user)).click();	
		userPage usrPage = new userPage(driver);
		WebElement logOut = usrPage.getLogout();
		wait.until(ExpectedConditions.visibilityOf(logOut)).click();
		WebElement yesButton = usrPage.getConfirm();
		wait.until(ExpectedConditions.visibilityOf(yesButton)).click();
		loginPage loginPage = new loginPage(driver);
		WebElement logButton = loginPage.getLoginButton();
		wait.until(ExpectedConditions.visibilityOf(logButton)).isDisplayed();
	}
	
	

	
}