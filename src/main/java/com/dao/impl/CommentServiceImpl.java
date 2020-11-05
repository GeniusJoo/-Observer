package com.dao.impl;

import com.dao.CommentService;
import com.dao.ManagerService;
import com.entity.Comment;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/10/31 0:54
 * Remark:
 */
public class CommentServiceImpl implements CommentService{
	@Override
	public boolean addComment(Comment comment) {
		String sql = "insert into Comment(user_id,username,comment_date,text,state) values(?,?,?,?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(conn == null){

				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,comment.getUserId());
			ps.setString(2,comment.getUsername());
			ps.setTimestamp(3,new Timestamp(comment.getCommentDate().getTime()));
			ps.setString(4,comment.getText());
			ps.setString(5,comment.getUserState());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean deleteCommentById(int commentId) {
		String sql = "delete from Comment where comment_id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,commentId);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean updateComment(Comment comment) {
		String sql = "update comment set user_id=?, username=?,text=?" +
				",state=? where comment_id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,comment.getUserId());
			ps.setString(2,comment.getUsername());
			ps.setString(3,comment.getText());
			ps.setString(4,comment.getUserState());
			ps.setInt(5,comment.getCommentId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public List<Comment> selectCommentById(int userId) {
		List<Comment> listId = new ArrayList<>();
		String sql = "select * from comment where id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return null;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,userId);
			rs = ps.executeQuery();
			while (rs.next()){
				int commentId = rs.getInt("comment_id");
				String username = rs.getString("username");
				Timestamp commentDate = rs.getTimestamp("comment_date");
				String text = rs.getString("text");
				String state = rs.getString("state");
				listId.add(new Comment(userId,commentId,username,new Date(commentDate.getTime()),text,state));
			}
			return listId;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return null;
	}

	@Override
	public List<Comment> selectCommentByState(String userState) {
		List<Comment> listState = new ArrayList<>();
		String sql = "select * from comment where state = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return null;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1,userState);
			rs = ps.executeQuery();
			while (rs.next()){
				int userId = rs.getInt("user_Id");
				int commentId = rs.getInt("comment_id");
				String username = rs.getString("username");
				Timestamp commentDate = rs.getTimestamp("comment_date");
				String text = rs.getString("text");
				listState.add(new Comment(userId,commentId,username,new Date(commentDate.getTime()),text,userState));
			}
			return listState;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return null;
	}
}
