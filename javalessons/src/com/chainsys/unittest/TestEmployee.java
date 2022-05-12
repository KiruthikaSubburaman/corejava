package com.chainsys.unittest;

import com.chainsys.classandmethods.Employee;

public class TestEmployee {
	public static void testName()
	{
		Employee firstEmployee=new Employee(1234);
		firstEmployee.setName("Kirthika");
		System.out.println(firstEmployee.getName());
	}
	public static void testCity()
	{
		Employee firstEmployee=new Employee(1234);
		firstEmployee.setCity("chennai");
		System.out.println(firstEmployee.getCity());
		
	}
	public static void testSalary()
	{
	Employee firstEmployee=new Employee(1234);
	firstEmployee.setSalary(50000);
	System.out.println(firstEmployee.getSalary());
	}

}
