package z3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import z1.FirefoxDriverFactory;

public class VariousSitesTests
{
	WebDriver driver;
	GenericPage page;

	String exampleSite = "https://www.w3schools.com/html/html_form_input_types.asp";

	@BeforeEach
	public void setup()
	{
		// creating new driver for each test prevents potential cookies/cache interferences from previous tests
		driver = FirefoxDriverFactory.get();
		page = new GenericPage(driver);

	}

	@AfterEach
	public void teardown()
	{
		// it's recommended to 'close -> quit' instead of just 'quit' to avoid
		driver.quit();
	}

	@Test
	public void numberOfLinks()
	{
		driver.navigate().to(exampleSite);
		System.out.println("Number of links: " + page.getNumberOfLinks());
	}

	@Test
	public void numberOfImages()
	{
		driver.navigate().to(exampleSite);
		System.out.println("Number of images: " + page.getNumberOfImages());
	}

	@Test
	public void numberOfTextInputFIelds()
	{
		driver.navigate().to(exampleSite);
		System.out.println("Number of text input fields: " + page.getNumberOfTextInputs());
	}

	@Test
	public void openEachLinkAndGoBack()
	{

		int i = 0;
		driver.navigate().to("https://matjs.strony.ug.edu.pl/");
		while(i < page.getNumberOfLinks())
		{
			WebElement link = page.getAllLinks().get(i);
			try
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].target='_self';", link);
				link.click();
				driver.navigate().back();
			}
			catch (Exception e)
			{
				System.out.println(link.getAttribute("href") + " link cannot be clicked");
			}
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{}
			i++;
		}
	}
}
