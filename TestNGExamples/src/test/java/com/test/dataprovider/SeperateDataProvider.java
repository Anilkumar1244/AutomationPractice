package com.test.dataprovider;

import org.testng.annotations.Test;

public class SeperateDataProvider {

	@Test(dataProvider="Dp1",dataProviderClass = DataSupplier.class)
	public void IndicecExp(String s)
	{
		System.out.println(s);
	}
}
