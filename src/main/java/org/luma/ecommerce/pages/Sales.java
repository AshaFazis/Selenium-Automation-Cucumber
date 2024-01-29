package org.luma.ecommerce.pages;

import org.luma.ecommerce.base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Sales extends Common
{
	public Sales(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//main[@id='maincontent']//ul[1]//li[3]//a[1]")
	WebElement sale_tees;
	
	public ProductPage sales_tees()
	{
		waitForVisibilityOfElementLocated(sale_tees);
		actionsClick(sale_tees);
		return new ProductPage(driver);
	}
}
