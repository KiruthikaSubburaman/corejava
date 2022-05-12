package com.chainsys.exceptions.ex1;
import java.util.Scanner;

public class DemoA {

	public static void main(String[] args)
	{
		m4();

	}
	/*public static void m0() 
	{
		int x=0;
	}
		public static void m1() 
			public static void m3() */
				public static void m4() 
			

{
	System.out.println("Before try");
	int x=0,y=0,z=0;
	String s1=null,s2=null;
	java.util.Scanner sc=null;
	try
	{
		sc=new Scanner(System.in);
		System.out.println("Inside Try");
		System.out.println("Enter value for x");
		s1=sc.nextLine();
		x=Integer.parseInt(s1);
		y=Integer.parseInt(s2);
		z=x/y;
		System.out.println("Result"+z);
		
	}
	/*catch(Exception err)
	 {
	  System.out.println("Inside catch3"+err.getMessage());
	  System.out.println("ErrorType"+err.getClass().getName());
	  }*/
	catch(ArithmeticException err)
	{
		System.out.println("Inside Catch1"+err.getMessage());
		System.out.println("ErrorType"+err.getClass().getName());
	}
	catch(NumberFormatException err)
	{
		System.out.println("Inside Catch2"+err.getMessage());
		System.out.println("ErrorType"+err.getClass().getName());
	}
	catch(Exception err)
	{
		System.out.println( "Inside Catch3"+err.getMessage());
		System.out.println("ErrorType"+err.getClass().getName());
	}
	finally
	{
		System.out.println("Inside Finally");
		sc.close();
	}
	 
	
}
}