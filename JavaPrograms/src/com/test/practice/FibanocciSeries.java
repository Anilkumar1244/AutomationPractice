package com.test.practice;

import java.util.Scanner;

public class FibanocciSeries {

	public static void main(String[] args) {
		
		int n,a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		n=sc.nextInt();
		a=0;
		b=1;
		for(int i=1;i<=10;i++)
		{
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;
		}



	}

}
