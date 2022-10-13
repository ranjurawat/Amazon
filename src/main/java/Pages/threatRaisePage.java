package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class threatRaisePage {

	public threatRaisePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "versionx.threatleadtool:id/rvChooseCategoryLL")
	private WebElement raiseScreen;

//	@AndroidFindBy(id="versionx.threatleadtool:id/liBg")
//	 private List<WebElement> threats;

	// @AndroidFindBy(xpath="//android.widget.TextView[@text='Protest']")
	@AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement threat;

	@AndroidFindBy(id = "versionx.threatleadtool:id/button3")
	private WebElement status;

	@AndroidFindBy(id = "versionx.threatleadtool:id/mock_drill")
	private WebElement mckdrl;

	@AndroidFindBy(id = "versionx.threatleadtool:id/alertTitle")
	private WebElement alert;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement yesBtn;

	public WebElement getRaiseScreen() {
		System.out.println(raiseScreen.isDisplayed());
		return raiseScreen;
	}

//	public List<WebElement> getThreats() {
//		System.out.println(threats);
//		return threats;
//	}

	public WebElement getThreat() {
		return threat;
	}

	public WebElement getStatus() {
		return status;
	}

	public WebElement getMockdrll() {
		return mckdrl;
	}

	public WebElement getAlert() {
		return alert;
	}

	public WebElement getYseBtn() {
		return yesBtn;
	}
}
