package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class notificationPage {
	
	public notificationPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Notifications']")
	private WebElement ntfy;
	
	@AndroidFindBy(id="versionx.threatleadtool:id/imgBack")
	private WebElement backNtfy;
	
	public WebElement checkNotication() {
		return ntfy;
	}
	
	public WebElement getNotBack() {
		return backNtfy;
	}
	


}
