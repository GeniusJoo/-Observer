package com.dao.impl;

import com.dao.CommentService;
import com.dao.ManagerService;
import com.entity.Comment;

import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/10/31 0:54
 * Remark:
 */
public class CommentServiceImpl implements CommentService{
	@Override
	public boolean addComment(Comment comment) {
		return false;
	}

	@Override
	public boolean deleteCommentById(int commentId) {
		return false;
	}

	@Override
	public boolean updateComment(Comment comment) {
		return false;
	}

	@Override
	public List<Comment> selectCommentById(int userId) {
		return null;
	}

	@Override
	public List<Comment> selectCommentByState(String userState) {
		return null;
	}
}
