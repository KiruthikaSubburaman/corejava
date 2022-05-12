package com.chainsys.unittest;

import com.chainsys.classandmethods.Car;

/**
 * 
 * @author kiru3132
 *
 */

public class CarTester {
	public static void testCar()
	{
		
		Car firstCar=new Car("TN 10A 001");
		firstCar.setColor("Red");
		firstCar.setFuel("Petrol");
		firstCar.setYearOfPurchase(2022);
		System.out.println(firstCar.getRegNo());
		System.out.println(firstCar.getColor());
		System.out.println(firstCar.getFuel());
		System.out.println(firstCar.getYearOfPurchase());
	}

}
