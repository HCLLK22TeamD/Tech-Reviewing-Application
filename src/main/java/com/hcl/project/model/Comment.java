package com.hcl.project.model;

public class Comment {

	private String message;
	private int postId;
	private String user;
	
	
	public Comment() {
		super();
	}
	
	public Comment(String message, int postId, String user) {
		super();
		this.message = message;
		this.postId = postId;
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "Comment [message=" + message + ", postId=" + postId + ", user=" + user + "]";
	}

}
