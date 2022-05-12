package com.chainsys.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

class ListIteratorDemo {
	public static void main(String[]args)
	{
		ArrayList<String> StringArrayList=new ArrayList<String>();
		String s1="B";
		StringArrayList.add("C");
		StringArrayList.add(s1);
		StringArrayList.add("A");
		StringArrayList.add("E");
		StringArrayList.add(s1);
		StringArrayList.add("D");
		StringArrayList.add("F");
		StringArrayList.add(s1);
		Iterator<String> String_itr=StringArrayList.iterator();
		while(String_itr.hasNext())
		{
			System.out.println(String_itr.next()+ " ");
		}
		System.out.println();
		ListIterator<String> String_list_itr = StringArrayList.listIterator();
		while(String_list_itr.hasNext())
		{
			String element=String_list_itr.next();
			String_list_itr.set(element+"--");
		}
		String_itr=StringArrayList.iterator();
		while(String_itr.hasNext())
		{
			Object element=String_itr.next();
			System.out.println(element+" ");
		}
		System.out.println();
		while(String_list_itr.hasPrevious())
		{
			String element=String_list_itr.previous();
			System.out.println(element+" ");
		}
		
	}

}
//iterator cannot be modified =limitations but it can be loop through
