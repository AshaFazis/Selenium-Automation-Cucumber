package org.luma.ecommerce.pages;
import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Common
{

	//WebDriver driver;
	public HomePage(WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='panel header']//a[contains(text(),'Sign In')]")  //ELEMENTS for Home page
	WebElement home;
	
	
	public LoginPage homePage()
	{
		home.click(); //action perform for Homepage
		return new LoginPage(driver);
		
	}
	
	
	
	
}
	


