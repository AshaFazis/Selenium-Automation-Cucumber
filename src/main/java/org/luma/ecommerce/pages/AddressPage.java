package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends Common

{
  

	public AddressPage (WebDriver driver) //this will be executing first in a class
	{
	   super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//table[@class='table-checkout-shipping-method']//input[@name='ko_unique_1']")
	WebElement shipping;
	
	@FindBy(xpath = "//div[@class='primary']/button/span[text()='Next']")
	WebElement nextButton;
	
	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement placeOrderButton;
	
	
	
	public void shippingMethods()
	{
		shipping.click();
		actionsClick(nextButton);
		waitForVisibilityOfElementLocated(spinner);
	}
	
	public ThankYouPage paymentMethods() throws InterruptedException
	{
		Thread.sleep(5000);
		actionsClick(placeOrderButton);
		waitForVisibilityOfElementLocated(spinner);
		return new ThankYouPage(driver);
	}
}
