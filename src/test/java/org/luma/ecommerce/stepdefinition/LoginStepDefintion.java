package org.luma.ecommerce.stepdefinition;

import java.io.IOException;


import org.luma.ecommerce.pages.HomePage;
import org.luma.ecommerce.pages.LoginPage;
import org.luma.ecommerce.pages.ProductsMenuPage;
import org.luma.ecommerce.tests.Base_Tests;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefintion extends Base_Tests
{
 public HomePage home;
 public LoginPage login;
 public ProductsMenuPage productmenupage;
 
   @Given("User launches the browser and application")
   public void launch() throws IOException
   {
	   home = launchApplication();
   }
   
   @When("User clicked on the SignIn link on homepage")
   public void signin_link()
   {
	   login = home.homePage();
   }
   
   @Then("Enter username {string} and password {string} and click on SignIn button")
   public void enter_credentials(String email,String password)
   {
	    productmenupage = login.loginDetails(email,password);
	    
   }
   
   @Then("Login page shows {string} message")
   public void error_message(String actualMessage)
   {
	   String expectedMessage = login.LoginError();
	   Assert.assertEquals(expectedMessage, actualMessage);
	   
   }
   
   @Then("Close the browser")
   public void tearDown() 
   { 
	  driver.close();
   }
   
   
   
   
}
