package org.luma.ecommerce.pages;

import java.util.List;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Common
{
	
	
	public ProductPage (WebDriver driver) //this will be executing first in a class
	{
		super(driver);
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ol[@class='products list items product-items']/li")
	List<WebElement> teesList;
	
	@FindBy(how = How.XPATH, using = "//div[@class='block-content filter-content']/div/div[2]")
	WebElement size;
	
	@FindBy(xpath = "//div[normalize-space()='Color']")
	WebElement color;
	
	@FindBy(xpath = "//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a")
	List<WebElement> teesNames;
	
	@FindBy(xpath = "//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='Iris Workout Top']")
	WebElement item;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement addedMessage;
	
    By sizeOption = By.xpath("//div//div[@class='swatch-attribute-options clearfix']//a[@class='swatch-option-link-layered']/div[text()='M']");
	
	By colorOption = By.xpath("//div//div[@class='swatch-attribute-options clearfix']//a[@class='swatch-option-link-layered']/div[@option-label='"+colour+"']");
	
	By productsList = By.xpath("//ol[@class='products list items product-items']/li");
	
	By allProducts = By.xpath("//ol[@class='products list items product-items']");
	
	By itemWait = By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='"+teeName+"']");
	
	By addToCart = By.xpath("//div[@class='product-item-info']/div[@class='product details product-item-details']/strong/a[normalize-space()='"+teeName+"']/following::div[@class='actions-primary']/form[@data-role='tocart-form']/button/span");
	
	//div[normalize-space()='Size']
	public void shoppingOptionsSize()
	{
		
		waitForVisibilityOfElementLocated(size);
		actionsClick(size);
		size.findElement(sizeOption).click();
	}
	
	public void shoppingOptionsColor()
	{
		actionsClick(color);
		color.findElement(colorOption).click();
	}
	
	public List<WebElement> getProductsList()
	{
		waitForVisibilityOfElement(productsList);
		System.out.println(teesList.size());
		return teesList;
	}
	
	public String getProductNames(String tee)
	{
		
		for(int i=0 ; i < teesList.size(); i++)
		{
			String names = teesNames.get(i).getText();
			System.out.println(names);
			if(names.contains(tee))
			{
				javascriptExecutorScrollDown(driver);
				actionsBuild(item);
				waitForVisibilityOfElement(itemWait);
			}
					
			
		}
		return tee;
	
    }
	
	public void addToCart()
	{
		item.findElement(addToCart).click();
		javascriptExecutorScrollUp(driver);
		
		
	}
	
	
	public CartIcon itemAddedMessage()
	{
		System.out.println(addedMessage.getText());
		return new CartIcon(driver);
	}
	
	
	
}
