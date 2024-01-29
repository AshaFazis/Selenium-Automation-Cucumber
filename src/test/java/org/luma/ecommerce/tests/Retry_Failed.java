package org.luma.ecommerce.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Failed implements IRetryAnalyzer
{
     int count = 0;
     int retry = 3; //to retry how much time failed testcases have to run
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count < retry)
		{
		     count++;
		     return true;
		}
		return false;
	}

	

}
