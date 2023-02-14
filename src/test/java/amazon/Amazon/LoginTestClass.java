package amazon.Amazon;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.iRacsPage;
import Pages.locationSelectionPage;
import Pages.loginPage;
import io.appium.java_client.android.Activity;

public class LoginTestClass extends BaseTest {

	@BeforeMethod
	@Parameters({"tool", "act"})
	public void startHome(String tool, String act) {
		
		Activity activity = new Activity(tool, act);
		driver.startActivity(activity);
		iRacsPage iracs = new iRacsPage(driver);
		WebElement start = iracs.getStartButton();
		start.click();
		
	}

	@Test(dataProvider = "getEmails")
	public void loginTest(String Email) {
		loginPage loginScreen = new loginPage(driver);
		WebElement email = loginScreen.getEmailId();
		WebElement login = loginScreen.getLoginButton();
		locationSelectionPage selectLoc = new locationSelectionPage(driver);
		List<WebElement> loc = selectLoc.getLocList();
		WebElement okButton = selectLoc.clickOk();
		if (email.isDisplayed()) {
			email.sendKeys(Email);
			login.click();
			boolean toastisTrue = getToastMessage("Enter valid user Id");
			if (!toastisTrue) {
				if (loc.size() != 0) {
					System.out.println("Locations List" + ", " + loc.size());
					loc.get(2).click();
					okButton.click();
				} else {
					System.out.println("No locations" + ", " + loc.size());
				}
			} else {
				System.out.println("Enter valid address");
			}
		} else {
			System.out.println("User is already logged in");
		}
	}

	@DataProvider
	public Object[][] getEmails() {
		return new Object[][] {{ "jyoti@gmail.com" } };
		
		//return new Object[][] { { "monikagmail.in" }, { "monika@gmail" }, { "monika@gmail.com" } };
	}

	public boolean getToastMessage(String message) {
		long startTime = System.currentTimeMillis(); // fetch starting time
		boolean neededStatus;
		do {
			String xmlFormat = driver.getPageSource();
			neededStatus = xmlFormat.contains(message);

		} while (!(neededStatus) && (((System.currentTimeMillis() - startTime) <= (5 * 1000))));
		return neededStatus;
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
