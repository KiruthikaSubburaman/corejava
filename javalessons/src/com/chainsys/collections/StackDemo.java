package com.chainsys.collections;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer>st=new Stack<Integer>();
		System.out.println("Stack:"+st.size());
		st.push(42);
		st.push(66);
		st.push(99);
		System.out.println("Stack:"+st.size());
		Iterator<Integer>int_itr=st.iterator();
		while(int_itr.hasNext())
		{
			System.out.println(int_itr.next()+" ");
		}
		System.out.println();
		Integer a=st.peek();//Peek simply returns the value of what is on top of the stack. In contrast to this, pop will remove the value from the stack and then return it
		System.out.println(a);
		System.out.println("After POP stack:"+st.size());
		a=st.peek();
		System.out.println(a);
		System.out.println("After POP stack:"+st.size());
		a=st.peek();
		System.out.println(a);
		System.out.println("After POP stack:"+st.size());
		try
		{
			a=st.pop();
			System.out.println(a);
		}
		catch(EmptyStackException e) {
			System.out.println("empty stack"+e.getMessage());
		}
	}

}
