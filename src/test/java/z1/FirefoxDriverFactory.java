package z1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverFactory
{
	public static WebDriver get()
	{
		String os = System.getProperty("os.name");
		if (os.contains("Windows"))
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		else
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver");

		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("intl.accept_languages","en-uk");
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.setProfile(ffprofile);
		options.addArguments("log-level=3");
		FirefoxDriver driver = new FirefoxDriver(options);
		// Implicity wait -> max czas na znalezienie elementu na stronie
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
