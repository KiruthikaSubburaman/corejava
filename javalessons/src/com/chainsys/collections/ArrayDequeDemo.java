package com.chainsys.collections;

import java.util.ArrayDeque;
import java.util.Iterator;

class ArrayDequeDemo {

	public static void main(String[] args) {
		ArrayDeque<String>arraydeque=new ArrayDeque<String>();
		//Use an ArrayDeque like a stack
		arraydeque.push("A");
		arraydeque.push("B");
		arraydeque.push("X");
		arraydeque.push("Z");
		arraydeque.push("D");
		arraydeque.push("X");//duplicate value
		arraydeque.push("Z");//duplicate value
		arraydeque.push("E");
		arraydeque.push("F");
		//System.out.println("Before popping the stack:"+arraydeque.size());
		//while(arraydeque.peek()  !=null) 
			//System.out.println(arraydeque.pop() + " ");
		//System.out.println("After popping the stack:"+arraydeque.size());
        Iterator<String> striterator=arraydeque.iterator();
        while(striterator.hasNext())
        {
        	System.out.println("\t"+striterator.next());
        }
        Iterator<String> striterator1=arraydeque.descendingIterator();
        while(striterator1.hasNext())
        {
        	System.out.println("\t"+striterator1.next());
        }
        arraydeque.add("H");
        arraydeque.add("I");
        striterator=arraydeque.iterator();
        while(striterator.hasNext()) {
            System.out.println("\t"+striterator.next());
        }
//full first
//retrieves and rename the first element of this deque,or
//return null if this deque is empty    
System.out.println("*******peekFirst:"+arraydeque.pollFirst());    
System.out.println(arraydeque);
System.out.println("******peeklast:"+arraydeque.pollLast());
System.out.println(arraydeque);
//peek first
//retrieves and rename the first element of this deque,or
//return null if this deque is empty    
System.out.println("*******peekFirst:"+arraydeque.peekFirst());    
System.out.println(arraydeque);
System.out.println("******peeklast:"+arraydeque.peekLast());
System.out.println(arraydeque);
//RemoveFirst
//Retrieves and removes the first element of this deque.
//if this deque is empty.
//---
System.out.println("**Removefirst:"+arraydeque.removeFirst());    
System.out.println(arraydeque);
System.out.println("******peeklast:"+arraydeque.removeLast());
System.out.println(arraydeque);
//---
System.out.println("**RemovefirstOccurrence:"+arraydeque.removeFirstOccurrence("X"));    
System.out.println(arraydeque);
System.out.println("**removeFirstoccurrence:"+arraydeque.removeLastOccurrence("Z"));
System.out.println(arraydeque);
    }

	}


