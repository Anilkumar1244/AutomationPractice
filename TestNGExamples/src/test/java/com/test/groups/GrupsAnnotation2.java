package com.test.groups;

import org.testng.annotations.Test;

public class GrupsAnnotation2 {

	@Test(groups = {"sanity","window.functinal","ios.smoke"})
	public void Test5()
	{
		System.out.println("Test5");
	}

	@Test(groups = {"functional","sanity","window.sanity","ios.regression"})
	public void Test6()
	{
		System.out.println("Test6");
	}

	@Test
	public void Test7()
	{
		System.out.println("Test7");
	}
}
