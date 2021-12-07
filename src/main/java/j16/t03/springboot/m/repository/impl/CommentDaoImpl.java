//package j16.t03.springboot.m.repository.impl;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._02_customerService.CommentBean;
//import j16.t03.springboot.m.repository.CommentDao;
//
//@Repository
//public class CommentDaoImpl implements CommentDao {
//
//	SessionFactory factory;
//	
//	@Autowired
//	public CommentDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//
////	使用評價編號尋找評價
//	@Override
//	public CommentBean findCommentById(Integer commentId) {
//		Session session = factory.getCurrentSession();
//		return session.get(CommentBean.class, commentId);
//	}
//
////	新增評價
//	@Override
//	public void addComment(CommentBean commentBean) {
//		Session session = factory.getCurrentSession();
//		session.save(commentBean);
//	}
//
////	更新評價
//	@Override
//	public void updateComment(CommentBean commentBean) {
//		Session session = factory.getCurrentSession();
//		session.update(commentBean);
//	}
//
//}