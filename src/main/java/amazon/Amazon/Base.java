package amazon.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AndroidDriver driver;

	@SuppressWarnings("deprecation")
	public static AndroidDriver Capabilities(String app) throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/amazon.properties");
		DesiredCapabilities cap = new DesiredCapabilities();

		Properties prop = new Properties();
		prop.load(file);
		prop.get(app);
		File appDir = new File("src");
		File fs = new File(appDir, (String) prop.getProperty(app));

		String device1 = (String) prop.get("DEVICE_NAME");
		String auto = (String) prop.get("automationName");

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device1);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, auto);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		// cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		 cap.setCapability(MobileCapabilityType.NO_RESET, true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Base Class" + ',' + cap);

		return driver;
	}
}
