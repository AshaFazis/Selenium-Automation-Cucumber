package org.luma.ecommerce.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common 
{

	public WebDriver driver;
	public String teeName = "Iris Workout Top";
	public String colour = "Red";
	public Actions action;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	@FindBy(xpath = "//img[@alt='Loading...']")
	public WebElement spinner;
	
	public Common(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void actionsBuild(WebElement moveElement)
	{
		 action = new Actions(driver);
		 action.moveToElement(moveElement).build().perform();
		
	}
	
	public void actionsClick(WebElement moveElements)
	{
		  action = new Actions(driver);
		  action.moveToElement(moveElements).click().perform();
		
	}
	public void waitForVisibilityOfElement(By options)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOfElementLocated(options));
		
	}
	
	public void waitForVisibilityOfElementLocated(WebElement elements)
	{
	    wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(elements));
		
    }
	
	public void javascriptExecutorScrollDown(WebDriver driver)
	{
	    js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,1000)"); 
		
	}
	
	public void javascriptExecutorScrollUp(WebDriver driver)
	{
		js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,-1000)"); 
		
	}
}
