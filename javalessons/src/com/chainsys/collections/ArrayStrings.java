package com.chainsys.collections;

import java.util.ArrayList;

public class ArrayStrings {
	public static void usingStringArrayList()
	{
		ArrayList<String>stringArrayList=new ArrayList<String>();
		System.out.println("Initial size of StringArrayList:"+stringArrayList.size());
		try {
			stringArrayList.add("Car");
			stringArrayList.add("Auto");
			stringArrayList.add("Egg");
			stringArrayList.add("Box");
			stringArrayList.add("Doll");
			stringArrayList.add("Fan");
			//will insert a new value,
			//pushing the current value of index I to the next index
			stringArrayList.add(1,"Animal");
			stringArrayList.add("Girl");
			stringArrayList.add("Fan");
			System.out.println("Size of stringArrayList after additions: "+stringArrayList.size());
			System.out.println("contents of stringArrayList: " +stringArrayList);
			//will replace the value of index 2
			stringArrayList.set(2, "xenas");
			System.out.println("After Set(2): " +stringArrayList);
			System.out.println("Last Index of: 'Fan' " +stringArrayList.lastIndexOf("Fan"));
			//remove the first instance of 'Fan'
			stringArrayList.remove("Fan");
			stringArrayList.remove(2);
			System.out.println("Size after remove(2): " +stringArrayList.size());
			System.out.println("Contents of stringArrayList:"+stringArrayList);
			stringArrayList.trimToSize();
		}
		catch(Exception err)
		{
			System.out.println();
			
			
		}
	}
	public static void main(String[]args)
	{
		ArrayStrings. usingStringArrayList();
	}
}


