package amazon.Amazon;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Pages.iRacsPage;
import Pages.threatRaisePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;

public class ThreatRaiseTestClass extends BaseTest {

	@BeforeMethod(alwaysRun=true)
	@Parameters({ "tool", "act" })
	public void startHome(String tool, String act) {
		Activity activity = new Activity(tool, act);
		driver.startActivity(activity);
		iRacsPage iracs = new iRacsPage(driver);
		WebElement start = iracs.getStartButton();
		start.click();
	}

	@Test
	public void mockDrillTest() {
		try {
			threatRaisePage raiseScrn = new threatRaisePage(driver);
			WebElement raiseScreen = raiseScrn.getRaiseScreen();

			if (raiseScreen.isDisplayed()) {

				List<WebElement> threat = raiseScrn.getThreat();
				WebElement stsButton = raiseScrn.getStatus();
				WebElement mockDrill = raiseScrn.getMockdrll();
				threat.get(0).click();
				stsButton.click();
				mockDrill.click();
				WebElement alertDialog = raiseScrn.getAlert();
				System.out.println("Alert is showing" + ", " + alertDialog.isDisplayed());
				if (alertDialog.isDisplayed()) {

					WebElement yesButton = raiseScrn.getYesBtn();
					yesButton.click();
					System.out.println("Yse button has been clicked");
					Thread.sleep(3000);

				} else {
					System.out.println("Alert box does not exists");
				}
			} else {
				System.out.println("Raise Screen Does not exists");
			}
		} catch (Exception e) {
			System.out.println("There is no threat Raise Screen" + ", " + e);
		}

	}

	@Test(groups="Smoke")
	public void threatRaiseTest() {
		try {

			threatRaisePage raiseScrn = new threatRaisePage(driver);
			WebElement raiseScreen = raiseScrn.getRaiseScreen();
			if (raiseScreen.isDisplayed()) {
				List<WebElement> threat = raiseScrn.getThreat();
				WebElement stsButton = raiseScrn.getStatus();
				WebElement raiseButton = raiseScrn.getRaiseButton();
				threat.get(0).click();
				stsButton.click();
				raiseButton.click();
				WebElement alertDialog = raiseScrn.getAlert();
				System.out.println("Alert is showing" + ", " + alertDialog.isDisplayed());
				if (alertDialog.isDisplayed()) {

					WebElement yesButton = raiseScrn.getYesBtn();
					yesButton.click();
					System.out.println("Yes button has been clicked");
					Thread.sleep(3000);
				} else {
					System.out.println("Alert box does not exists");
				}
			} else {
				System.out.println("Raise Screen Does not exists");
			}

		} catch (Exception e) {
			System.out.println("There is no threat Raise Screen" + ", " + e);
		}

	}
	

	
	@SuppressWarnings({})
	@Test(groups ="Sanity")
	public void ScrollThreatRaise() {
		threatRaisePage raiseScrn = new threatRaisePage(driver);
		WebElement raiseScreen = raiseScrn.getRaiseScreen();
		if (raiseScreen.isDisplayed()){
			WebElement threats = raiseScrn.getScrollThreats();
			WebElement stsButton = raiseScrn.getStatus();
			WebElement raiseButton = raiseScrn.getRaiseButton();	
			threats.click();
			stsButton.click();
			raiseButton.click();	
		}
	}

	@Test(dependsOnMethods = "threatRaiseTest")
	public void ListButtonTest(){
		threatRaisePage raiseScrn = new threatRaisePage(driver);
		WebElement menuIcon = raiseScrn.getMenu();
		menuIcon.click();
		System.out.println("This is Menu Button");

	}

}
