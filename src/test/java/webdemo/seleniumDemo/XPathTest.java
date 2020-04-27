package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class XPathTest
{

	//Przykłady znajdowania elementów na stronie www z wykorzystaniem xpath

	private static WebDriver driver;

	@BeforeAll
	public static void setUpDriver()
	{
		driver = FirefoxDriverFactory.get();
	}

	@AfterAll
	public static void tearDown() throws Exception
	{
		driver.quit();
	}

	@BeforeEach
	public void setUp() throws Exception
	{
		driver.get("https://www.google.pl");
	}

	@Test
	public void testNameNode()
	{
		//Pobiera element html
		WebElement html = driver.findElement(By.xpath("html"));
		assertNotNull(html);
	}

	@Test
	public void testSlashNode()
	{
		WebElement element = driver.findElement(By.xpath("html/body/div"));
		assertNotNull(element);
	}

	@Test
	public void testDoubleSlashNode()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//input"));
		for (WebElement element : elements)
		{
			System.out.println(element.getSize());
		}
		assertNotNull(elements);
	}

	@Test
	public void testSecondInputNode()
	{
		WebElement element = driver.findElement(By.xpath("//input[2]"));
		assertNotNull(element);
	}

	@Test
	public void testDoubleDotsNode()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//input/.."));
		for (WebElement element : elements)
		{
			System.out.println(element.getTagName());
		}
		assertNotNull(elements);
	}

	@Test
	public void testAtributeNode()
	{
		List<WebElement> elements = driver.findElements(By.xpath("//input[@value]"));
		for (WebElement element : elements)
		{
			System.out.println(element.getAttribute("value"));
		}
		assertNotNull(elements);
	}

	@Test
	public void testExactAtributeNode()
	{
		WebElement element = driver.findElement(By.xpath("//input[@value = 'Google Search']"));
		System.out.println(element.getAttribute("value"));
		assertNotNull(element);
	}

}
