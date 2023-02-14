package amazon.Amazon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.ThreatListPage;
import Pages.iRacsPage;
import Pages.loginPage;
import Pages.notificationPage;
import Pages.threatDetailPage;
import Pages.threatRaisePage;
import Pages.userPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ThreatListScreenTestClass extends BaseTest {

	@BeforeMethod
	@Parameters({ "tool", "act" })
	public void startHome(String tool, String act) {
		System.out.println("This is Start Home Method");
		Activity activity = new Activity(tool, act);
		driver.startActivity(activity);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		iRacsPage iracs = new iRacsPage(driver);
		WebElement start = iracs.getStartButton();
		wait.until(ExpectedConditions.visibilityOf(start)).click();
		threatRaisePage raiseScrn = new threatRaisePage(driver);
		WebElement menuIcon = raiseScrn.getMenu();
		if (menuIcon.isDisplayed()) {
			menuIcon.click();
			System.out.println("This is Menu Button after restart phone");
		}

	}

	@Test(dependsOnMethods = "searchTest")
	public void openItemDetails() throws InterruptedException {
		
			ThreatListPage listScreen = new ThreatListPage(driver);
			List<WebElement> threatList = listScreen.getItem();
			System.out.println("Threat list is display" + ", " + threatList.size());
			if (threatList.size() != 0) {
				System.out.println("List is more than 0 " + ", " + threatList.contains("Actioned"));
					
				listScreen.getState().click();
				
				Thread.sleep(3000);
				threatDetailPage detailScreen = new threatDetailPage(driver);
				WebElement detail = detailScreen.getDetail();
				detail.isDisplayed();
				System.out.println(detail.getText());
			} else {
				System.out.println("There is no Threat List");
			}
		} 
	

	@Test(dataProvider = "getData", dependsOnMethods = "locFilter")
	public void searchTest(String value) throws InterruptedException {
		ThreatListPage searchTst = new ThreatListPage(driver);
		WebElement src = searchTst.getSearch();
		src.sendKeys(value);
		WebElement view = searchTst.getListView();
		String val = view.getText();
		System.out.println("View Text" + ", " + val.isEmpty());
		Thread.sleep(3000);

	}

	@Test
	public void locFilter() {
		ThreatListPage locFilt = new ThreatListPage(driver);
		WebElement locSelect = locFilt.filterLoc();
		String isClickable = locSelect.getAttribute("clickable");

		if (isClickable == "true") {

			locSelect.click();
			List<WebElement> locList = locFilt.getElement();

			try {
				locList.get(0).click();
				WebElement okButton = locFilt.getOkButton();
				okButton.click();
				ThreatListPage listScreen = new ThreatListPage(driver);
				WebElement loc = listScreen.getLocNm();
				loc.isDisplayed();
				System.out.println(loc.getText());
			} catch (Exception e) {
				System.out.println("Catch Exception" + ", " + e);
			}
		} else {
			System.out.println("Only one location exists" + "," + locSelect.getText());
		}

	}
	
//	@Test(dependsOnMethods = "openItemDetails")
//	public void editStatus() {
//		ThreatListPage edit = new ThreatListPage(driver);
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//		WebElement locSelect = edit.getEditItem();
//		if(locSelect.isDisplayed()) {
//			System.out.println("Click on Edit Item");
//			//wait.until(ExpectedConditions.visibilityOf(locSelect)).click();
//			//locSelect.click();
//		}else {
//			System.out.println("No Edit Item");
//		}
//	}

	@Test
//	public void getNotify() {
//		try {
//			ThreatListPage getNot = new ThreatListPage(driver);
//			WebElement notification = getNot.getNotification();
//			notification.click();
//			notificationPage notPage = new notificationPage(driver);
//			WebElement notifications = notPage.checkNotication();
//			notifications.isDisplayed();
//			WebElement backButton = notPage.getNotBack();
//			backButton.click();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

//	@Test
//	public void getUser() {
//		ThreatListPage getUsr = new ThreatListPage(driver);
//		WebElement user = getUsr.getUser();
//		user.click();
//		userPage usrPage = new userPage(driver);
//		WebElement logOut = usrPage.getLogout();
//		logOut.click();
//		WebElement yesButton = usrPage.getConfirm();
//		yesButton.click();
//		loginPage loginPage = new loginPage(driver);
//		WebElement logButton = loginPage.getLoginButton();
//		iRacsPage iRacs = new iRacsPage(driver);
//		WebElement startButton = iRacs.getStartButton();
//		if (startButton.isDisplayed()) {
//			System.out.println("StartScreen After Logout");
//
//		} else {
//			System.out.println("Get Logout screen" + ", " + logButton.isDisplayed());
//		}
//	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "ter" }, { "pro" }, { "Bomb" } };
	}


}
