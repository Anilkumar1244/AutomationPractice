package com.test.practice;

import java.util.Scanner;

public class NumberPalindrome {

	public static void main(String[] args) {

		int n,r,rev=0,num;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		n=sc.nextInt();
		num=n;
		while(n>0)
		{
			r=n%10;
			n=n/10;
			rev=rev*10+r;
			
		}
		if(num==rev)
		{
		System.out.print(rev+ "is palindrome");
		}
		else
		{
			System.out.print(rev+ "is not a palindrome");	
		}
	}

}
