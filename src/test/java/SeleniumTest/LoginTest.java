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

public class LoginTest extends SeleniumTestCase_Common {
	  @Test()
	  public void testLogin() throws Exception {
		  driver.get("http://www.testyou.in/Login.aspx");
		  
		  //========== UserName & Password both are blank
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("");//UserName
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("");//Password
		  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();//LOGIN Button
		  
		  Thread.sleep(550);
		  String actualMessage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText();
		  String expectedMessage = "Userid or Password did Not Match !!";
		  assertEquals(actualMessage, expectedMessage);
		  Thread.sleep(400);
		  
		  //========== UserName & Password both are Invalid
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("abcd@tt.com");//UserName
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Invalid");//Password
		  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();//LOGIN Button
		  
		  Thread.sleep(550);
		  actualMessage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText();
		  //String expectedMessage = "Userid or Password did Not Match !!";
		  assertEquals(actualMessage, expectedMessage);
		  Thread.sleep(400);
		  
		  //========== UserName is Blank & Password is Invalid
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("");//UserName
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Invalid");//Password
		  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();//LOGIN Button
		  
		  Thread.sleep(550);
		  actualMessage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText();
		  //String expectedMessage = "Userid or Password did Not Match !!";
		  assertEquals(actualMessage, expectedMessage);
		  Thread.sleep(400);
		  
		  //========== UserName is Invalid & Password is Blank
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("ttt@ddd.com");//UserName
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		  driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("");//Password
		  driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();//LOGIN Button
		  
		  Thread.sleep(550);
		  actualMessage = driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText();
		  //String expectedMessage = "Userid or Password did Not Match !!";
		  assertEquals(actualMessage, expectedMessage);
		  Thread.sleep(400);
		  
	  }
}
