package com.hcl.project.model;

import java.util.Date;

public class CalendarItem {
	
	private String title;
	private String category;
	private String subCategory;
	private String author;
	private int postId;
	private Date airDate;
	private String month;
	private int year;
	

	public CalendarItem() {}
	
	public CalendarItem(String title, String category, String subCategory, String author, int postId, Date airDate) {
		super();
		this.title = title;
		this.category = category;
		this.subCategory = subCategory;
		this.author = author;
		this.postId = postId;
		this.airDate = airDate;
	}

	public CalendarItem(String title, String category, String subCategory, String author, int postId, Date airDate,
			String month, int year) {
		super();
		this.title = title;
		this.category = category;
		this.subCategory = subCategory;
		this.author = author;
		this.postId = postId;
		this.airDate = airDate;
		this.month = month;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getAirDate() {
		return airDate;
	}

	public void setAirDate(Date airDate) {
		this.airDate = airDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "CalendarItem [title=" + title + ", category=" + category + ", subCategory=" + subCategory
				+ ", author=" + author + ", postId=" + postId + ", month=" + month + ", year=" + year + "]";
	}

}
