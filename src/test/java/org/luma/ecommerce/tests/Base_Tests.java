package org.luma.ecommerce.tests;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.luma.ecommerce.pages.HomePage;
import org.luma.ecommerce.utils.DataReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Tests 
{
	public WebDriver driver;
	
	public HomePage home;
	
	
	
	public WebDriver startDriver() throws IOException
	{
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Selenium-Automation\\src\\main\\java\\org\\luma\\ecommerce\\resources\\GlobalConfiguration.properties");
		property.load(file);
		String browserName = property.getProperty("browser");
		String url = property.getProperty("URL");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException
	{
		driver = startDriver();
		home = new HomePage(driver);
		return home;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		
		
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //taking screenshot of DOM
	    File destFile = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
	    FileUtils.copyFile(sourceFile, destFile);
	    return System.getProperty ("user.dir")+"//reports//" + testCaseName + ".png";
		
		
	}
	
	/*
	 * @DataProvider public String[][] testData() throws IOException { return
	 * DataReader.getExcelDdata(); }
	 */
	
    @AfterMethod(alwaysRun = true)
	public void tearDown() 
	{ 
		  driver.close();
    }
	 
}
