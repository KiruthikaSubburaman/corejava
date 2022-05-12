package com.chainsys.unittest;

import com.chainsys.variables.Demo;

/**
 * Tester class for global variables
 * @author kiru3132
 * @category To test Demo class,its fields, and methods
 * date:Mar 24 2022
 */

public class VariableTester {
	
	 /***Test static,constant,immutable variable*/
	public static void testGlobalVariables()
	{
		//display the value of static field
		//value is Zero(default value)
		//DataA is accessed without creating an object 
		System.out.println("DataA: "+Demo.DataA);
		/**
		*display the value of immutable field
		*this is not possible without an object
		*system.out.println("DataB: "+Demo.DataB);
		*display the value of constant field
		**/
		
		System.out.println("DataC: "+ Demo.DataC);
		//modifying value of the static field DataA
		Demo.DataA=2345;
		System.out.println("DataA: "+ Demo.DataA);
		/**
		*modifying value of the static field DataC
	    *ERROR:</b>The final field Demo.DataC cannot be assigned
	    */
		//Demo.DataC=2345;
	}
	public static void testImmutableVariables()
	{
		/*cannot make a static reference to the nonstatic field demo.DataB*/
		//Demo.DataB=123;
		/**
		 * first create an object or the class
		 * pass an int value a an argument to use constructor
		 * access the immutable instance field using the object reference
		 */
		Demo firstObject=new Demo(123);
		System.out.println(firstObject.DataB);
		/**
		 * value assigned to an immutable field cannot be changed
		 * value for the immutable field can be assigned only through the constructor
		 **/
		//firstObject.DataB=567;
	}
	/**calling static method using class name
	 * without creating an object
	 * created on :25 March 2022
	 */
    public static void testStaticMethod()
    {
    	Demo.sayHello();
    }
    public static void testNonStaticMethod()
    {
    	//ERROR
    	//Demo.greetUSer();
    	Demo firstObject=new Demo(111);
    	//call the nonstatic method
    	firstObject.greetUser();
    }
}


