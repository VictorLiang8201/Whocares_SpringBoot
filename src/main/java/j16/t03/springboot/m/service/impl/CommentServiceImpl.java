//package j16.t03.springboot.m.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.CommentBean;
//import j16.t03.springboot.m.repository.CommentDao;
//import j16.t03.springboot.m.service.CommentService;
//
//@Transactional
//@Service
//public class CommentServiceImpl implements CommentService {
//	
//	CommentDao commentDao;
//	
//	@Autowired
//	public CommentServiceImpl(CommentDao commentDao) {
//		this.commentDao = commentDao;
//	}
//	
////	使用評價編號尋找評價
//	@Override
//	public CommentBean findCommentById(Integer commentId) {
//		return commentDao.findCommentById(commentId);
//	}
//	
////	新增評價
//	@Transactional
//	@Override
//	public void addComment(CommentBean commentBean) {
//		commentDao.addComment(commentBean);
//	}
//
////	更新評價
//	@Transactional
//	@Override
//	public void updateComment(CommentBean commentBean) {
//		commentDao.updateComment(commentBean);
//	}
//
//}