package z2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import z1.FirefoxDriverFactory;

public class DuckDuckGoTests
{
	WebDriver driver;
	DuckDuckGoPage page;

	// alternative click -> DuckDuckGoPage.searchFor() method

	@BeforeEach
	public void setup()
	{
		// creating new driver for each test prevents potential cookies/cache interferences from previous tests
		driver = FirefoxDriverFactory.get();
		page = new DuckDuckGoPage(driver);
	}

	@AfterEach
	public void teardown()
	{
		// it's recommended to 'close -> quit' instead of just 'quit' to avoid
		driver.quit();
	}

	@Test
	public void searchForSomethingAndOpenFirstResult()
	{
		page.searchFor("duck").clickOnNthResult(1);
	}

	@Test
	public void searchForSomethingAndOpenThirdResult()
	{
		page.searchFor("duck").clickOnNthResult(3);
	}

	@Test
	public void searchForSomethingAndOpenNonExistingResult()
	{
		int numberOfResults = page.searchFor("duck").getNumberOfResults();
		Assertions.assertThrows(NotFoundException.class, () -> page.clickOnNthResult(numberOfResults+1));
	}

	@Test
	public void findSomethingThatDoesntExist()
	{
		Assertions.assertThrows(NotFoundException.class, () -> driver.findElement(By.linkText("asdfghjhgfdsasdfgh")));
	}
}
