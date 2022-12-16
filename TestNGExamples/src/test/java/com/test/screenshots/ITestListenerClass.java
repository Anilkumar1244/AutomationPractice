package com.test.screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		CaptureScreenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
		
	}
	
}
