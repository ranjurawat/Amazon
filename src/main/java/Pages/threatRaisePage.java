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

	
	@AndroidFindBy(id="versionx.threatleadtool:id/liBg")
	 private List<WebElement> threats;
	
	public List<WebElement> getThreats() {
		System.out.println(threats);
		return threats;
	}
}
