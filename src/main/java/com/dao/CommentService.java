package com.dao;

import com.entity.Comment;

import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/10/31 0:42
 * Remark:
 */
public interface CommentService {
	boolean addComment(Comment comment);
	boolean deleteCommentById(int commentId); // delete comment by id
	boolean updateComment(Comment comment); // update comment

	List<Comment> selectCommentById(int userId); // select comment by id
	List<Comment> selectCommentByState(String userState); //  확진자 | 완치자 | 미확진자

}
