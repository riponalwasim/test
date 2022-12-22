package SeleniumTest;

//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

public class SimpleGoogleSearchTest_FF_TestNG extends SeleniumTestCase_Common {
	  
	  @Test
	  public void googleSearch() throws Exception {
	    driver.get("https://www.google.com/");
	    //driver.manage().window().setSize(new Dimension(1053, 816));
	    driver.manage().window().maximize();
	    driver.findElement(By.name("q")).sendKeys("Jahangirnagar University");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    Thread.sleep(1500);
	    assertTrue(driver.getTitle().contentEquals("Jahangirnagar University - Google Search"));
	    Thread.sleep(1200);
	    //assertEquals(driver.findElement(By.cssSelector("div:nth-child(2) > .tF2Cxc .LC20lb")).getText(), "Jahangirnagar University");
	    assertEquals(driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).getText(), "Jahangirnagar University");
	  }

}
