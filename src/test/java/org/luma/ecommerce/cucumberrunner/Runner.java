package org.luma.ecommerce.cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Selenium\\LumaEcommerceCucumber\\src\\test\\java\\org\\luma\\ecommerce\\cucumber", glue = "org.luma.ecommerce.stepdefinition",
monochrome = true, publish = true, plugin = {"html:reports/cucumber-reports.html"})
public class Runner extends AbstractTestNGCucumberTests
{

	

}
