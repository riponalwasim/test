package SeleniumTest;

//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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

public class LoginTest_DataDrivenTesting extends SeleniumTestCase_Common {
	@DataProvider(name = "LoginData")
	public Object[][] createLoginData_Consumer() throws Exception{
		System.out.println(System.getProperty("user.dir"));
		Object[][] retObjArr = getTableArray("D:\\JU Testing Lab\\SeleniumExample\\LoginData.xls", "Login_Data", "Login");
		
		return retObjArr;
	}
	
	  @Test(dataProvider = "LoginData")
	  public void testLogin(String userName, String password, String expectedMessage) throws Exception {
		  driver.get("http://www.testyou.in/Login.aspx");
		  
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys(userName);
		  
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys(password);
		  
		  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
		  
		  Thread.sleep(550);
		  String actualMessage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText();
		  assertEquals(actualMessage, expectedMessage);
		  Thread.sleep(400);
		  
	  }

}
