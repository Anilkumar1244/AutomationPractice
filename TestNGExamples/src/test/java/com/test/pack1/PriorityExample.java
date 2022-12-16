package com.test.pack1;

import org.testng.annotations.Test;

//Default Priority ---> Zero.
//Can we add Negative values to the priority ---> Yes
//Can two test have Priority have same value ---> Yes

public class PriorityExample {

	@Test(priority=1)
	public void SignUp()
	{
		System.out.println("SignUp");
	}
	
	@Test(priority=2)
	public void Login()
	{
		System.out.println("Login");
	}
	
	
	@Test(priority=3)
	public void SearchForTheFlight()
	{
		System.out.println("SearchForTheFlight");
	}
	
	@Test(priority=4)
	public void BookTheFlight()
	{
		System.out.println("BookTheFlight");
	}
	
	@Test(priority=5)
	public void SaveTheFlight()
	{
		System.out.println("SaveTheFlight");
	}
	
	@Test(priority=6)
	public void LogOut()
	{
		System.out.println("LogOut");
	}
}
