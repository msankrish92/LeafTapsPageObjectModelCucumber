package org.servicenow.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.servicenow.utils.ReadExcel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src\\test\\java\\org\\servicenow\\features\\ChangeManagement.feature", glue = {"org\\servicenow\\pages","org\\servicenow\\steps"}, monochrome = true 
					, tags = "@TC003")
public class ServiceNowProjectSpecificMethods extends AbstractTestNGCucumberTests {
	
	public static String excelPath;

	public static RemoteWebDriver driver;
	public static Properties prop;
	@BeforeClass
	public void loadProFile() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream("./eng.properties"));
		
	}
	
	@Parameters({"url"})
	@BeforeMethod
	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivers.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public String[][] getCellValue() throws IOException {
		ReadExcel obj = new ReadExcel();
		return obj.readCell(excelPath);
	}
	
}
