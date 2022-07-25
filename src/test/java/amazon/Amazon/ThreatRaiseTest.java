package amazon.Amazon;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ThreatRaiseTest extends BaseTest {
	@Test
	public void raiseThreat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}

}
