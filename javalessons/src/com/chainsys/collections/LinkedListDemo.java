package com.chainsys.collections;
import java.util.LinkedList;
import java.util.Iterator;
class LinkedListDemo {
    public static void main(String[] args) {
		LinkedList<String> StringLinkedList=new LinkedList();
		StringLinkedList.add("F");
		StringLinkedList.add("B");
		StringLinkedList.add("D");
		StringLinkedList.add("E");
		StringLinkedList.add("C");
		StringLinkedList.add("F");
		StringLinkedList.add("B");
		StringLinkedList.add("D");
		StringLinkedList.add("E");
		StringLinkedList.add("C");
		StringLinkedList.addLast("Z");
		StringLinkedList.addFirst("A");
		StringLinkedList.add(1,"A2");
		Iterator<String> StringIterator=StringLinkedList.iterator();
		while(StringIterator.hasNext())
		{
			System.out.print(StringIterator.next()+" ");
		}
		System.out.println();
		StringLinkedList.remove("F");
		StringLinkedList.remove(2);
		StringIterator=StringLinkedList.iterator();
		while(StringIterator.hasNext())
		{
			System.out.print(StringIterator.next()+" ");
		}
		System.out.println();
		StringLinkedList.removeFirst();
		StringLinkedList.removeLast();
		StringIterator=StringLinkedList.iterator();
		while(StringIterator.hasNext())
		{
			System.out.print(StringIterator.next()+" ");
		}
	}

}
