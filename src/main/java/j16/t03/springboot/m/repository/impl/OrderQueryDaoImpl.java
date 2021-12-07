//package j16.t03.springboot.m.repository.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._03_rent.RentItemBean;
//import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
//import j16.t03.springboot.m.repository.OrderQueryDao;
//
//@Repository
//public class OrderQueryDaoImpl implements OrderQueryDao {
//
//	SessionFactory factory;
//
//	@Autowired
//	public OrderQueryDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//
////	使用顧客編號和訂單類別查詢訂單
//	@Override
//	public List<OrdBean> findOrdBeanByCustIdAndCategory(Integer custId, String category) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM OrdBean ob WHERE ob.ordPK.category = :category AND ob.customerBean.custId = :cid ";
//		if (session.createQuery(hql, OrdBean.class).setParameter("category", category).setParameter("cid", custId).getResultList().size() > 0) {
//			return session.createQuery(hql, OrdBean.class).setParameter("category", category).setParameter("cid", custId).getResultList();
//		} else {
//			return null;
//		}
//	}
//
////	使用複合主鍵查詢訂單
//	@Override
//	public OrdBean findOrdBeanById(Integer custId, String category, Integer ordId) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM OrdBean ob WHERE ob.ordPK = :pk AND ob.customerBean.custId = :cid ";
//		if (session.createQuery(hql, OrdBean.class).setParameter("pk", new OrdPK(category, ordId))
//				.setParameter("cid", custId).getResultList().size() > 0) {
//			return session.createQuery(hql, OrdBean.class).setParameter("pk", new OrdPK(category, ordId))
//					.setParameter("cid", custId).getSingleResult();
//		} else {
//			return null;
//		}
//
//	}
//
////	使用訂單編號查詢購買細項
//	@Override
//	public List<BuyItemBean> findBuyItemByOrdId(Integer ordId) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM BuyItemBean WHERE ordBean = :ob ";
//		OrdBean ordBean = new OrdBean();
//		ordBean.setOrdPK(new OrdPK("B", ordId));
//		return session.createQuery(hql, BuyItemBean.class).setParameter("ob", ordBean)
//				.getResultList();
//	}
//
////	使用訂單編號查詢租賃細項
//	@Override
//	public List<RentItemBean> findRentItemByOrdId(Integer ordId) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM RentItemBean WHERE ordBean = :ob ";
//		OrdBean ordBean = new OrdBean();
//		ordBean.setOrdPK(new OrdPK("R", ordId));
//		return session.createQuery(hql, RentItemBean.class).setParameter("ob", ordBean)
//				.getResultList();
//	}
//
//}