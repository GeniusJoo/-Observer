package com.entity;

import java.util.Date;

/**
 * Author: XianDaLi
 * Date: 2020/10/30 23:52
 * Remark:
 */
public class Comment {
	private int commentId;
	private int userId;
	private String username;
	private Date commentDate;
	private String text;
	private String userState;

	public Comment() {
	}

	public Comment(int commentId, int userId, String username, Date commentDate, String text, String userState) {
		this.commentId = commentId;
		this.userId = userId;
		this.username = username;
		this.commentDate = commentDate;
		this.text = text;
		this.userState = userState;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}
}
