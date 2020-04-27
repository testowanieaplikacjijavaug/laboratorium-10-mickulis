package webdemo.seleniumDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

public class FindTest
{

	//Przykłady znajdowania elementów na stronie www bez elementów xpath

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
	public void findById()
	{
		WebElement element = driver.findElement(By.id("searchform"));
		assertNotNull(element);
	}

	@Test
	public void findByName()
	{
		WebElement element = driver.findElement(By.name("q"));
		assertNotNull(element);
	}

	@Test
	public void findByClass()
	{
		WebElement element = driver.findElement(By.className("gsfi"));
		assertNotNull(element);
	}

	@Test
	public void findBylinkText()
	{
		WebElement element = driver.findElement(By.linkText("Gmail"));
		assertNotNull(element);
	}

	@Test
	public void findByPartiallinkText()
	{
		WebElement element = driver.findElement(By.partialLinkText("ma"));
		assertNotNull(element);
	}

	@Test
	public void findByTagName()
	{
		WebElement element = driver.findElement(By.tagName("div"));
		assertNotNull(element);
	}

	@Test
	public void findByCssSelector()
	{
		WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
		assertNotNull(element);
	}


}
