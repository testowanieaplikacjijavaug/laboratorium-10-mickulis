package z1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleTest
{

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
		driver.get("https://duckduckgo.com/");
	}

	@Test
	public void testTitlePage()
	{
		assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
	}

	@Test
	public void testSource()
	{
		String source = driver.getPageSource();
		assertTrue(source.contains("DuckDuckGo"));
	}

	@Test
	public void testClick()
	{
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		assertEquals("Mateusz Miotk at DuckDuckGo", driver.getTitle());
	}

}
