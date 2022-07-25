package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {
	public loginPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter Email ID']")
	private WebElement email;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='LOGIN']")
	private WebElement login;
	
	
	public WebElement getEmailId() {
		System.out.println("Email Element" +','+email);
		return email;
	}
	
	public WebElement getLoginButton() {
		System.out.println("Login Element" +','+login);
		return login;
	}

}
