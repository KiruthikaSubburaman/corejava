package com.chainsys.test;
import java.util.Scanner;
public class Eight {

	public static void main(String[] args) {
		checkUserName();

	}
	public static void checkUserName()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name");
		String s=sc.next();
		sc.close();
		for(int i=0;i<s.length();i++)
		{
			 char c=s.charAt(i);
			if(c>='a'&&c<='z')
			{
			System.out.println(c+" is an albhabet");
					
			}
			else
			{
				
			System.out.println(c+" is not an albhabet");
			}
			
			}
	
		int lengthofCharArray=s.length();
		System.out.println("length of name is"+lengthofCharArray);
		if(lengthofCharArray<8)
		{
			System.out.println("Invalid value,Name must have atleast 8 characters");
			return;
		}
	}
}