package com.test.dependency;

import org.testng.annotations.Test;

public class DependencyGroups {
	
	@Test(groups="Smoke")
	public void test1()
	{
		System.out.println("smoke");
	}
	
	@Test(groups="Smoke")
	public void test2()
	{
		System.out.println("smoke");
	}
	
	@Test(groups="Smoke")
	public void test3()
	{
		System.out.println("smoke");
	}
	
	@Test(groups="Sanity")
	public void test4()
	{
		System.out.println("sanity");
	}
	
	@Test(groups="Sanity")
	public void test5()
	{
		System.out.println("sanity");
	}
	
	@Test(groups="Regression")
	public void test6()
	{
		System.out.println("regression");
	}
	
	@Test(groups="Regression")
	public void test7()
	{
		System.out.println("regression");
	}
	
	/*@Test(dependsOnGroups = {"Smoke","Sanity","Regression"})
	public void test0()
	{
		System.out.println("MainMethod");
	}*/
	
}
