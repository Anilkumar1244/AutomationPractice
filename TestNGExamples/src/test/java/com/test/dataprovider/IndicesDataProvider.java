package com.test.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndicesDataProvider {

	@Test(dataProvider="loginData")
	public void IndicecExp(String s)
	{
		System.out.println(s);
	}

	@DataProvider(name="loginData",indices= {0,2})
	public String[] Dp1() {

		String[] data = new String[] {
				"Anil",
				"kumar",
				"Mandya"
		};
		return data;
	}
}