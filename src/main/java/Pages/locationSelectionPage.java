package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class locationSelectionPage {
	
	public locationSelectionPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView")
	 private List<WebElement> location;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Ok']")
	private WebElement ok;
	
	public List<WebElement> getLocList() {
		return location;
		
	}
	
	public WebElement clickOk() {
		return ok;
	}

}
