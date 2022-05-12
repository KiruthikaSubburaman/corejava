package com.chainsys.calculator_interface;

public class TestCalculator {
public static void main(String[] args) 
{
	Calculator c = new Calculator();
    int result=c.add(2,3);
    System.out.println(result);
	result=c.multiply(2,3);
	System.out.println(result);
	result=c.divide(10,5);
	System.out.println(result);
}

	public static void testMarker()
	{
		CalculatorB firstCalculator=new CalculatorB();
		if(firstCalculator instanceof ICalculator)
		{
			ICalculator contract=firstCalculator;
			int output=0;
			output=contract.add(10, 5);
			System.out.println(output);
			output=contract.multiply(10, 5);
			System.out.println(output);
			output=contract.divide(10, 5);
			System.out.println(output);
			}
		else 
			System.out.println(firstCalculator.getClass().getName()+"does not implement ICalculator");
	

}
}


