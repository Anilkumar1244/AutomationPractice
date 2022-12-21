package com.test.practice;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		int n,i,j,k,temp,flag=0;

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		n=sc.nextInt();
		int[] a =new int[n];
		System.out.println("Enter the array:");
		for (i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		for(i=0; i<a.length; i++)
		{
			for(j=i; j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for (i=0;i<n;i++)
		{
			System.out.println(a[i]+ "");
		}
	}
}
