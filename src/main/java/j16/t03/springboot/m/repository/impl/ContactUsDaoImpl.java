//package j16.t03.springboot.m.repository.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.NoResultException;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._02_customerService.ProblemBean;
//import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;
//import j16.t03.springboot.m.entity._02_customerService.usPKClass.ProblemBeanPK;
//import j16.t03.springboot.m.repository.ContactUsDao;
//
//@Repository
//public class ContactUsDaoImpl implements ContactUsDao {
//
//	SessionFactory factory;
//	
//	@Autowired
//	public void setFactory(SessionFactory factory) {
//		this.factory = factory;
//	}
//	
//	public ContactUsDaoImpl() {
//		
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProblemBean> getProblems() {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM problemBean";
//		List<ProblemBean> list = new ArrayList<>();
//		list = session.createQuery(hql).getResultList();
//		return list;
//	}
//	
//	@Override
//	public Object save(ProblemBean bean) {
//		
//		Session session = factory.getCurrentSession();
//		return session.save(bean);
//	}
//	
//	@Override
//	public List<ProblemSelectBean> queryProblemSelect(String problemType){
//		String hql = "";
//		if (problemType.indexOf(",") != -1) {
//			String[] problemTypes = problemType.split(",");
//			problemType  = "";
//			for (String string : problemTypes) {
//				problemType += ",'" + string + "'";
//			}
//			hql = "FROM ProblemSelectBean WHERE problemType IN(" + problemType.substring(1) + ") ORDER BY problemType, sortPb";
//
//		}else {
//			hql = "FROM ProblemSelectBean WHERE problemType = " + problemType + "ORDER BY sortPb";
//
//		}
//		Session session = factory.getCurrentSession();
//		List<ProblemSelectBean> dataList = session.createQuery(hql, ProblemSelectBean.class).getResultList();
//		return dataList;
//	}
//
////	@Override
////	public ProblemBean getProblemById(int usId) {
////		
////		ProblemBean pb = null;
////		Session session = factory.getCurrentSession();
////		String hql = "FROM ProblemBean pb WHERE pb.usId = :id" ;
////		try {
////			pb = (ProblemBean) session.createQuery(hql).setParameter("id",usId).getSingleResult();
////		} catch (NoResultException e) {
////			; // 表示查無紀錄
////		}
////		
////		
////		
////		return pb;
////	}
//
//	public ProblemBean getProblemById(Integer replyId) {
//		ProblemBean bean = null;
//		Session session = factory.getCurrentSession();
//		String hql = "FROM ProblemBean cb WHERE cb.replyId = :replyId";
//		try {
//			bean = (ProblemBean) session.createQuery(hql).setParameter("replyId", replyId).getSingleResult();
//		} catch (NoResultException e) {
//			; // 表示查無紀錄
//		}
//		return bean;
//	}
//
//	
//	
//	
//
//
//	@Override
//	public List<ProblemBean> getProblemsById(Integer replyId) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM ProblemBean WHERE usId ";
//		
//		return session.createQuery(hql, ProblemBean.class)
//				 .setParameter("usId",(new ProblemBeanPK(replyId)))
//				 .getResultList();
//				
//	}
//	
//	
//
////	@Override
////	public ProblemBean get(Integer id) {
////		return factory.getCurrentSession().get(ProblemBean.class,id);
////	}
//
//	
//
//	
//}
