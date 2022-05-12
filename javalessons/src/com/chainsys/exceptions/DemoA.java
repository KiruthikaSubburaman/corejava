package com.chainsys.exceptions;

public class DemoA {
	public static void taskA()
	{
		System.out.println("Before try");
		try
		{
			System.out.println("Inside try");
		}
		catch(Exception err)
		{
			System.out.println("Inside catch");
		}
		finally
		{
			System.out.println("Inside finally");
		}
		System.out.println("Before try");
	}

}
