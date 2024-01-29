package org.luma.ecommerce.resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter 
{
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
 
  @BeforeTest
  public static ExtentReports getReport()
  {
	  String path = System.getProperty("user.dir")+"\\reports\\index.html";
	  reporter = new ExtentSparkReporter(path);
	  reporter.config().setReportName("Automation Results");
	  reporter.config().setDocumentTitle("Test results");
	  
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("QA", "Asha Fazis");
	  return extent;
  }
	
}
