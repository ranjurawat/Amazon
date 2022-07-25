package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class userPage {

	public userPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="versionx.threatleadtool:id/outlinedButton")
	private WebElement logout;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@text='YES']")
	private WebElement confirm;
	
	public WebElement getLogout() {
		return logout;
	}
	
	public WebElement getConfirm() {
		return confirm;
	}
}
