package com.chainsys.unittest;

import com.chainsys.variables.Calculator;

public class TestCalculator{
	public static void add()
	{
		System.out.println("result is"+Calculator.add(5,4));
	}
	public static void multiply()
	{
		System.out.println(Calculator.multiply(5,4));
	}
	public static void subtract()
	{
		System.out.println(Calculator.subtract(5,4));
	}
	public static void divide()
	{
		System.out.println(Calculator.divide(5,4));
	}

}
