package com.chainsys.introduction;

public class Fourth {

	public static void main(String[] args) {
		taskD();
		}
public static void taskA() {
	java.util.Scanner sc=new java.util.Scanner(System.in); 
	System.out.println("What is your name");
	String name=sc.next();
	sc.close();
	System.out.println(name);
	
}
public static void taskB() {
	java.util.Scanner sc=new java.util.Scanner(System.in); 
	System.out.println("Enter a number");
	int firstvalue=sc.nextInt();
	int result=firstvalue*100;
	System.out.println(result);
	sc.close();
	}
public static void taskC() {
	String s1="100";
	String s2="25";
	System.out.println(s1+s2);
	int x=Integer.parseInt(s1);
	int y=Integer.parseInt(s2);
	int z=x+y;
	System.out.println(z);
}
public static void taskD()
{

	java.util.Scanner sc=new java.util.Scanner(System.in); 
	System.out.println("Is it raining?");
	String s=sc.next();
	boolean b=true;
	if(b==true)
	{
		System.out.println("Bring Umbrella");
	}
	
		System.out.println("Enter the temp:");
		int temp=sc.nextInt();
	if(temp<32)
	{
		System.out.println("Bring light jacket");
	}
	
	else if(temp>32&&temp<=50)
	{
		System.out.println("Bring heavy jacket");
	}
	
	else
	{
		System.out.println("Bring no jacket");
	}
	}
	
	
}

	
	



	