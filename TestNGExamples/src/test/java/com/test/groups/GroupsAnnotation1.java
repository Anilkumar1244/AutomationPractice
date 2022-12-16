package com.test.groups;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class GroupsAnnotation1 {

	@Test(groups = {"smoke"})
	public void Test1()
	{
		System.out.println("Test1");
	}

	@Test(groups = {"functional","regresiion","window.sanity","window.smoke"})
	public void Test2()
	{
		System.out.println("Test2");
	}

	@Test(groups = {"regression","sanity","ios.functional","ios.smoke"})
	public void Test3()
	{
		System.out.println("Test3");
	}

	@Test
	public void Test4()
	{
		System.out.println("Test4");
	}
}
