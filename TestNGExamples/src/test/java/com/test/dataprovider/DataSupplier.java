package com.test.dataprovider;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider()
	public String[] Dp1() {

		String[] data = new String[] {
				"Anil",
				"kumar",
				"Mandya"
		};
		return data;
	}
}
//We can store/have multiple dataprovider in dataprovider class
//We can have multiple dataprovider classes in project