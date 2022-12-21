package com.test.practice;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
	int i;
	    Scanner sc = new Scanner(System.in);
		String rev="";
		System.out.println("Enter the String");
		String s=sc.nextLine();
		//int s=rev.length();
		for(i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		if(s.equals(rev))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a plandrome");
		}
	}

}
