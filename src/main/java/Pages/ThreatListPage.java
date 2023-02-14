package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ThreatListPage {
	
	public ThreatListPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="versionx.threatleadtool:id/constraintThreatListLayout")
	private List<WebElement> item;
	
	@AndroidFindBy(id="versionx.threatleadtool:id/search_threats")
	private WebElement search;
	
	@AndroidFindBy(className="androidx.recyclerview.widget.RecyclerView")
	private WebElement listView;
	
	@AndroidFindBy(id="versionx.threatleadtool:id/changed_location")
	private WebElement locFilter;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup")
	private WebElement locNm;
	
	@AndroidFindBy(className="android.widget.CheckedTextView")
	private List<WebElement> locEl;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Ok']")
	private WebElement ok;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='R']")
	private WebElement user;
	
	@AndroidFindBy(id="versionx.threatleadtool:id/notification")
	private WebElement notification;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='S O S']")
	 private WebElement sosButton;
	
	@AndroidFindBy(id="androidx.recyclerview.widget.RecyclerView")
	 private List<WebElement> list;
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()."
			+ "resourceId(“versionx.threatleadtool:id/rvChooseCategory”))")
	 private WebElement state;
	
//	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector().resourceId(\"versionx.threatleadtool:id/constraintThreatListLayout\"))."
//			+ "scrollIntoView(new UiSelector().text(\"Actioned\")")
//	 private WebElement state;
	
//	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Actioned\"))")
//	 private WebElement state;
	
//	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector().scrollable(true).instance(0))\" +\n"
//			+ "    \".scrollIntoView(new UiSelector().resourceId(\"versionx.threatleadtool:id/editImage\"))")
//    private WebElement editItem;	
	
				
	public List<WebElement> getItem() {
		System.out.println("This is List Screen"+','+item);
		return item;
	}
	
	public WebElement getSearch() {
		return search;
	}
	
	public WebElement getListView() {
		return listView;
	}
	
	public WebElement filterLoc() {
		return locFilter;
	}
	
	public WebElement getLocNm() {
		return locNm;
	}
	
	public List<WebElement> getElement(){
		return locEl;
	}
	
	public WebElement getOkButton() {
		return ok;
	}
	
	public WebElement getUser() {
		return user;
	}
	
	public WebElement getNotification() {
		return notification;
	}
	
	public WebElement getSOSBtn() {
		return sosButton;
	}
	
	public WebElement getState() {
		System.out.println("Get Scroll Text"+", "+state.getText());
		return state;
	}
	
	public List<WebElement> getList(){
		return list;
	}
	
//	public WebElement getEditItem() {
//		return editItem;
//	}
	

}
