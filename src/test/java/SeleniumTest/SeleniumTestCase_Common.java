package SeleniumTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class SeleniumTestCase_Common {
	public WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  int startRow, startCol, endRow, endCol, ci, cj;
	  
	  @BeforeClass
	  @Parameters("browser")
	  public void setUp(String browser) throws Exception {
		  //System.setProperty("webdriver.chrome.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
		  //System.setProperty("webdriver.edge.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		  //System.setProperty("webdriver.gecko.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\geckodriver-v0.32.0-win64\\geckodriver.exe");
	    //driver = new ChromeDriver();
		  //driver = new FirefoxDriver();
	    //driver = new EdgeDriver();
		  if(browser.equalsIgnoreCase("firefox")){
			  System.setProperty("webdriver.gecko.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\geckodriver-v0.32.0-win64\\geckodriver.exe");
			  driver = new FirefoxDriver();
			  driver.manage().window().maximize();
			  
		  }
		  else if(browser.equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
		  }
		  else if(browser.equalsIgnoreCase("edge")){
			  System.setProperty("webdriver.edge.driver", "D:\\JU Testing Lab\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
			  driver = new EdgeDriver();
			  driver.manage().window().maximize();
		  }
		  else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
	    driver.manage().window().maximize();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @AfterClass
	  public void tearDown() {
	    driver.quit();
	  }
	  protected String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
			String[][] tabArray = null;
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			  
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();
			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);
			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			//System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol + ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;
			
			for(int i = startRow + 1; i < endRow; i++, ci++){
				cj = 0;
				for(int j = startCol + 1; j < endCol; j++, cj++){
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
			return (tabArray);
		}
}
