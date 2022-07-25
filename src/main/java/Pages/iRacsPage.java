package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class iRacsPage {
	
	public iRacsPage(AppiumDriver driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Start']")
	private WebElement startButton;
	
	public WebElement getStartButton() {
		return startButton;
	}
	
	
	
    
}
