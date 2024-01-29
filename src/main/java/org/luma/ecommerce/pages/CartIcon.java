package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartIcon extends Common
{
	
	
	
	public CartIcon (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header content']/div[@class='minicart-wrapper']")
	WebElement minicart;
	
	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	WebElement checkout;
	
	
	
	public void cart()
	{
		waitForVisibilityOfElementLocated(minicart);
		actionsClick(minicart);
	}
	
	public AddressPage checkOutButton()
    {
		actionsClick(checkout);
		waitForVisibilityOfElementLocated(spinner);
		return new AddressPage(driver);
	}
	
	
}
