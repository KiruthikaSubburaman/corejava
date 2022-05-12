package com.chainsys.variables;

public class Demo {
	public static int DataA;
	//static global variable
	public final int DataB; 
	//immutable global variable(not static)
	public final static int DataC=300; 
	//constant
	private int dataD;
	
	//constructor
	/*
	 * constructor is a special method
	 * The name of the constructor and the name of the class will be same
	 * constructor don't have return type
	 * constructors can take parameters
	 */
	public Demo(int dataB)
	{
		/*Assigning value to the global variable readonly field(this.DataB) */
		this.DataB=dataB;
    }
	/**
	 * static method can be called without an object
	 */
	public static void sayHello()
	{
		System.out.println("Hello Developer!!!");
	}
/*greet user is non static method
 * this is a member method
 */
	public void greetUser()
	{
		System.out.println("Greetings USER!!! ");
	}
}


