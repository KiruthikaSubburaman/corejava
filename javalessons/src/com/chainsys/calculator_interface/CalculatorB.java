package com.chainsys.calculator_interface;

public class CalculatorB implements ICalculator {
	public Object getClass;
	public int add(int v1,int v2)
	{
		return v1+v2;
	}
	public int multiply(int v1,int v2)
	{
		return v1*v2;
	}
	public int divide(int v1,int v2) {
		return v1/v2;
	}

}
