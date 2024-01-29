package org.luma.ecommerce.tests;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import org.luma.ecommerce.resources.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base_Tests implements ITestListener
{
	ExtentReports extent = Reporter.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();    //this ThreadLocal class is used to assign thread
	@Override
	public void onTestStart(ITestResult result) 
	{
		
		test = extent.createTest(result.getMethod().getMethodName()); //start of every testcase execution
		thread.set(test); //while tests starts running it will assign thread ID for every tests
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
		thread.get().log(Status.PASS, "Test passed"); //listens for the testcases passed
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); // to get driver to take screenshot
		} 
		catch (NoSuchFieldException | IllegalAccessException e) 
		{
		    e.printStackTrace();
		}
		
		
		String screenshotPath = null;
		try {
			screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		thread.get().fail(result.getThrowable()); //getThrowable to fetch the logs in report
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); // to get driver to take screenshot
		} 
		catch (NoSuchFieldException | IllegalAccessException e) 
		{
		    e.printStackTrace();
		}
		
		
		String screenshotPath = null;
		try {
			screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush(); //flushes the report with new data every time
	}
	

}
