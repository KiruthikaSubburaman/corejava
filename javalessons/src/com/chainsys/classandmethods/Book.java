package com.chainsys.classandmethods;
/**
 * 
 * @author kiru3132
 *
 */

public class Book {
	private  final int bookNo;
	private int yearOfPublishing;
	private String authorName;
	private int pageNo;
	private String title;
	
	public Book(int bNo)
	{
		this.bookNo=bNo;
	}
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}
	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBookNo() {
		return bookNo;
	}

}
