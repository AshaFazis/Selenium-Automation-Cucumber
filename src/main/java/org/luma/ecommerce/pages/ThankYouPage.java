package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends Common
{
	

	public ThankYouPage (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h1[@class='page-title']/span[text()='Thank you for your purchase!']")
	WebElement thankYouMessage;
	
	@FindBy(xpath = "//div[@class='checkout-success']")
	WebElement orderNumber;
	
	public void thankYouMessage()
	{
		System.out.println(thankYouMessage.getText());
		System.out.println(orderNumber.getText());
	}
}
