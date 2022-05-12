package com.chainsys.test;

import java.util.Scanner;

public class Five {
	public static void main(String[]args)
	{
		testMath();
		
	}
	public static void testMath()
	{
		int x=0;
		double y=2*x*x+5;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter x:");
		x= sc.nextInt();
		System.out.println("value of y:"+y);
	}
		
		
	}


