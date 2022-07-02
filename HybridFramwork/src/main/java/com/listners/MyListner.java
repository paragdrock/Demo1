package com.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilities.DriverUtils;

public class MyListner extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {//ITestResult= holds all info about test cases( come from testNG)
		test = reports.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TC passed with name "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TC failed with name "+result.getName());
		String path=DriverUtils.getScreenShot(result.getName());
		//result.getName()=gives name of test case
		test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"TC skipped with name "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		
	}

}
