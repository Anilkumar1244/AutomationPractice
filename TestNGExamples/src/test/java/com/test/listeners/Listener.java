package com.test.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ITestListenersClass.class})
public class Listener {
	
	
	@Test()
	public void Test1()
	{
		System.out.println("Test1");
	}

	@Test()
	public void Test2()
	{
		System.out.println("Test2");
		Assert.assertTrue(false);
	}

	@Test(timeOut=1000)
	public void Test3() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("Test3");
	}

	@Test(dependsOnMethods = "Test3")
	public void Test4()
	{
		System.out.println("Test4");
	}
}
