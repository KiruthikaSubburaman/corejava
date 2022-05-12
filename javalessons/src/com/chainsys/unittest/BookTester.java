package com.chainsys.unittest;
/**
 * 
 */

import com.chainsys.classandmethods.Book;

public class BookTester {
	public static void testbook()
	{
		Book firstBook=new Book(3466);
		firstBook.setAuthorName("Abdulkalam");
		firstBook.setPageNo(233);
		firstBook.setYearOfPublishing(2022);
		firstBook.setTitle("Agnisiragugal");
	    System.out.println(firstBook.getBookNo());
		System.out.println(firstBook.getAuthorName());
		System.out.println(firstBook.getPageNo());
		System.out.println(firstBook.getYearOfPublishing());
		System.out.println(firstBook.getTitle());
	}

}
