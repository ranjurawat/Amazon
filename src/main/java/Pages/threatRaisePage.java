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
	@AndroidFindBy(id = "versionx.threatleadtool:id/liBg")
	private List<WebElement> threat;

	@AndroidFindBy(id = "versionx.threatleadtool:id/button2")
	private WebElement status;

	@AndroidFindBy(id = "versionx.threatleadtool:id/mock_drill")
	private WebElement mckdrl;

	@AndroidFindBy(id = "versionx.threatleadtool:id/alertTitle")
	private WebElement alert;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement yesBtn;
	
	@AndroidFindBy(id = "versionx.threatleadtool:id/img_list")
	private WebElement menuIcon;
	
	@AndroidFindBy(id = "versionx.threatleadtool:id/btn_raise")
	private WebElement raiseButton;
	
//	@AndroidFindBy(id="new UiScrollable(new UiSelector().resourceId(\"versionx.threatleadtool:id/liBg\")).scrollIntoView(text(\"Employee Death Emergency\"))")
//	private WebElement scrollThreats;

	@AndroidFindBy(id="versionx.threatleadtool:id/tvCategory[@text='Employee Death Emergency']")
	private WebElement scrollThreats;
	
	public WebElement getRaiseScreen() {
		System.out.println(raiseScreen.isDisplayed());
		return raiseScreen;
	}	
	
	

//	public List<WebElement> getThreats() {
//		System.out.println(threats);
//		return threats;
//	}

	public List<WebElement> getThreat() {
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

	public WebElement getYesBtn() {
		return yesBtn;
	}
	
	public WebElement getMenu() {
		return menuIcon;
		
	}
	
	public WebElement getRaiseButton() {
		return raiseButton;
	}
	
	public WebElement getScrollThreats() {
		return scrollThreats;
	}
}
