package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExp {

	@Test(dataProvider="loginData")
	public void TestString(String[] s)
	{
		//System.out.println(username+" >> "+passwd);
		/*for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
	}
	System.out.println(">>>>");*/
		System.out.println(s[0]+" >> "+s[1]);
	}

	@DataProvider(name="loginData")
	public Iterator<String[]> Dp1() {

		//when we have combination of string and integer we have to use Object[] as the return type
		/*Object[][] data = new Object[][] {
					{"abcg",123},
					{"ertydn",345},
					{"rtcv",456}
				};
				return data;*/

		//return tyep -- >Single dimensional array ---> Object[]
		/*String[] data = new String[] {
				"abcg",
				"ertydn",
				"rtcv"
		};
		return data;*/

		//return type --> two dimensional array ---> Object[][]
		/*String[][] data = new String[][] {
			{"abcg","123"},
			{"ertydn","345"},
			{"rtcv","456"}
		};
		return data;*/

		//When we have jagged array
		/*String[][] data = new String[][] {
			{"abcg","123","thydf","567"},
			{"ertydn","345"},
			{"rtcv","456","346"}
		};
		return data;*/

		//return type --> iterator(Object)
		/*List<String> data = new ArrayList<>();
		data.add("anil");
		data.add("kumar");
		return data.iterator();*/

		//return type --> iterator(Object[])
		List<String[]> data = new ArrayList<>();
		data.add(new String[] {"anil","kumar"});
		data.add(new String[] {"xyz","abc"});
		return data.iterator();
	}
}
