package com.hcl.project.model;

public class UserPost {
	private int userId;
	private int postId;
	private boolean isLike;
	private boolean isFavorite;
	
	
	public UserPost() {
		super();
	}
	
	public UserPost(int userId, int postId, boolean isLike, boolean isFavorite) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.isLike = isLike;
		this.isFavorite = isFavorite;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}
	public boolean getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public String toString() {
		return "UserPost [userId=" + userId + ", postId=" + postId + ", isLike=" + isLike + ", isFavorite=" + isFavorite
				+ "]";
	}

}
