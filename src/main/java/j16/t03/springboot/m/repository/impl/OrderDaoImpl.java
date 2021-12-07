//package j16.t03.springboot.m.repository.impl;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.c.controller.BuyCheckoutController;
//
//import j16.t03.springboot.m.entity._02_customerService.PromotionBean;
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
//import j16.t03.springboot.m.repository.OrderDao;
//
//@Repository
//public class OrderDaoImpl implements OrderDao {
//	
//	public static final int orderOffset = 0;
//	public static final int lastOrder = 1;
//	private static Logger log = LoggerFactory.getLogger(BuyCheckoutController.class);
//	
//	SessionFactory factory;
//	
//	@Autowired
//	public OrderDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//	
//	
//	@Override
//	public PromotionBean findByDiscountCode(String discountCode) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM PromotionBean pb WHERE pb.discountCode = :dc ";
//		
//		return session.createQuery(hql,PromotionBean.class)
//					  .setParameter("dc", discountCode)
//					  .getSingleResult();
//	}
//
//
//	@Override
//	public void save(OrdBean ordBean) {
//		Session session = factory.getCurrentSession();
//		session.save(ordBean);
//	}
//
//
//	@Override
//	public OrdPK getCurrentOrdId() {
//		Session session = factory.getCurrentSession();
//		String hql = "SELECT ob.ordPK FROM OrdBean ob ORDER BY ob.orderDate DESC "; 
//		OrdPK ord = session.createQuery(hql,OrdPK.class)
//							 .setFirstResult(orderOffset)
//							 .setMaxResults(lastOrder)
//							 .getSingleResult();
//		log.info("HQL查詢目前資料庫最新一筆訂單:"+ ord);
//		return  ord;
//	}
//
//	//更新訂單狀態
//	@Override
//	public void updateOrderStatus(String category, Integer ordId,String orderStatus) {
//		Session session = factory.getCurrentSession();
//		log.info("更新訂單狀態");
//		String hql = "UPDATE OrdBean SET orderStatus = :status WHERE ordPK = :pk";
//		
//		session.createQuery(hql)
//			   .setParameter("status",orderStatus)
//			   .setParameter("pk", new OrdPK(category, ordId))
//			   .executeUpdate();
//	}
//
//
//
//	
//	
//
//}
