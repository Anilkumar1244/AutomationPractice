package com.test.dependency;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyTest {

	String trackNum=null;

	//@Ignore--> If you want to ignore the dependent test method
	/*@Test
	public void CreateShipment()
	{
		System.out.println(5/0);
		System.out.println("CreateShipment");
		trackNum="asd123";
	}*/
	//ignoerMissingDependencies --> if you execute test method even though the dependent method is skipped/deleted
	//alwaysRun --> if you execute test method even though the dependent method is failed
	@Test(dependsOnMethods = {"CreateShipment"},alwaysRun=true,ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception
	{
		if(trackNum!=null)
			System.out.println("TrackShipment");
		else
			throw new Exception("invalid number");
	}

	@Test(dependsOnMethods = {"CreateShipment","TrackShipment"},ignoreMissingDependencies = true)
	public void CancelShipment() throws Exception
	{
		if(trackNum!=null)
			System.out.println("CancelShipment");
		else
			throw new Exception("invalid number");
	}

}
