package com.vo;

import java.awt.Image;

public class Book {
	private String bookname;
	private String imagename;
	private String author;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(String bookname,String imagename,String author){
		this.author=author;
		this.bookname=bookname;
		this.imagename=imagename;
		
	}

}
