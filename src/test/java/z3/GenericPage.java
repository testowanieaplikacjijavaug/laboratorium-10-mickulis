package z3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericPage
{
	// this avoids most of links to file downloads, buttons that execute javascript, etc.
	private By hyperlink = By.xpath("//a[contains(@href, 'http')] | //a[contains(@href, 'html')]");
	private By image = By.xpath("//img");
	private By input = By.xpath("//input[@type='text']");

	WebDriver driver;

	public GenericPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public List<WebElement> getAllLinks()
	{
		return driver.findElements(hyperlink);
	}

	public int getNumberOfLinks()
	{
		return getAllLinks().size();
	}

	public int getNumberOfImages()
	{
		return driver.findElements(image).size();
	}

	public int getNumberOfTextInputs()
	{
		return driver.findElements(input).size();
	}
}
