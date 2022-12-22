package SeleniumTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleGoogleSearchTest_Chrome_JUnit {
	public WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe"); 
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void googleSearch() throws Exception {
		  
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	    //driver.manage().window().setSize(new Dimension(1053, 816));
	    driver.findElement(By.name("q")).sendKeys("Jahangirnagar University");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    Thread.sleep(1500);
	    assertThat(driver.getTitle(), is("Jahangirnagar University - Google Search"));
	    {
	      List<WebElement> elements = driver.findElements(By.cssSelector("div:nth-child(2) > .tF2Cxc .LC20lb"));
	      assert(elements.size() > 0);
	    }
	    //assertThat(driver.findElement(By.cssSelector("div:nth-child(2) > .tF2Cxc .LC20lb")).getText(), is("Jahangirnagar University"));
	    assertThat(driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).getText(), is("Jahangirnagar University"));
	  }

}
