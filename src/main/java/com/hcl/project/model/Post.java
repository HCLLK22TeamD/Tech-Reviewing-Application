package com.hcl.project.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Post {
	
	private int id;

	private String title;
	private String content;
	private String category;
	private String subCategory;
	private String cover;
	
	private MultipartFile coverImage;
	
	private int author;
	private int likes;
	private int views;
	private List<Comment> comments;
	private boolean hasAirDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date airDate;
	
	private Date createdAt;
	

	public Post() {
		super();
		this.setCreatedAt(new Date());
	}

	public Post(int id, String title, String content, String category, String subCategory, String cover, int author,
			int likes, int views, boolean hasAirDate, Date airDate, Date createAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.subCategory = subCategory;
		this.cover = cover;
		this.author = author;
		this.likes = likes;
		this.views = views;
		this.hasAirDate = hasAirDate;
		this.airDate = airDate;
		this.createdAt = createAt;
	}
	
	public Post(String title, String content, String category, String subCategory, String cover, int author,
			boolean hasAirDate) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.subCategory = subCategory;
		this.cover = cover;
		this.author = author;
		this.hasAirDate = hasAirDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public boolean isHasAirDate() {
		return hasAirDate;
	}

	public void setHasAirDate(boolean hasAirDate) {
		this.hasAirDate = hasAirDate;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getAirDate() {
		return airDate;
	}

	public void setAirDate(Date airDate) {
		this.airDate = airDate;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public MultipartFile getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(MultipartFile coverImage) {
		this.coverImage = coverImage;
	}

	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", subCategory=" + subCategory + ", cover=" + cover + ", coverImage=" + coverImage + ", author="
				+ author + ", isLike=" + likes + ", views=" + views + ", comments="
				+ comments + ", hasAirDate=" + hasAirDate + ", airDate=" + airDate + ", createdAt=" + createdAt + "]";
	}

}
