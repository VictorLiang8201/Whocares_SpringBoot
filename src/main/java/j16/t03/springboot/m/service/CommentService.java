package j16.t03.springboot.m.service;

import j16.t03.springboot.m.entity._02_customerService.CommentBean;

public interface CommentService {

	//	使用評價編號尋找評價
	CommentBean findCommentById(Integer commentId);

	//	新增評價
	void addComment(CommentBean commentBean);

	//	更新評價
	void updateComment(CommentBean commentBean);

}