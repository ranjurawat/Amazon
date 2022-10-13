package amazon.Amazon;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.threatRaisePage;

public class ThreatRaiseTestClass extends Base {

	@Test
	public void mockDrillTest() {
		try {
			threatRaisePage raiseScrn = new threatRaisePage(driver);
			WebElement raiseScreen = raiseScrn.getRaiseScreen();

			if (raiseScreen.isDisplayed()) {

				WebElement stsButton = raiseScrn.getStatus();
				WebElement mockDrill = raiseScrn.getMockdrll();
				stsButton.click();
				mockDrill.click();
				WebElement alertDialog = raiseScrn.getAlert();
				System.out.println("Alert is showing" + ", " + alertDialog.isDisplayed());
				if (alertDialog.isDisplayed()) {

					WebElement yesButton = raiseScrn.getYseBtn();
					yesButton.click();

				} else {
					System.out.println("Alert box does not exists");
				}
			} else {
				System.out.println("Raise Screen Does not exists");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
