package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Common
{
	
	
	
	public LoginPage (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}

	

	@FindBy(how = How.ID, using = "email") WebElement userEmail;
	@FindBy(how = How.ID, using = "pass") WebElement userPassword;
	@FindBy(how = How.XPATH, using = "//button[@class='action login primary']/span[text()='Sign In']") WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//div[@role='alert']/div/div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
	WebElement loginerror;
	
	public ProductsMenuPage loginDetails(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		signInButton.click();
		return new ProductsMenuPage(driver);
		
		
	}
	
	public String LoginError()
	{
		return loginerror.getText();
	}
	
	
	
}
