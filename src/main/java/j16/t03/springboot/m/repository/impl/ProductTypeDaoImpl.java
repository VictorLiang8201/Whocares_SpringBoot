//package j16.t03.springboot.m.repository.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;
//import j16.t03.springboot.m.repository.ProductTypeDao;
//
//@Repository
//public class ProductTypeDaoImpl implements ProductTypeDao {
//
//	SessionFactory factory;
//
//	@Autowired
//	public ProductTypeDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//	
////	取得所有產品類別
//	@Override
//	public List<ProductTypeBean> getAllProdTypes() {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM ProductTypeBean";
//		return session.createQuery(hql, ProductTypeBean.class).getResultList();
//	}
//	
////	依主鍵查詢產品類別
//	@Override
//	public ProductTypeBean findProductTypeBeanById(String prodType) {
//		Session session = factory.getCurrentSession();
//		if (prodType != null) {
//			return session.get(ProductTypeBean.class, prodType);
//		} else {
//			return null;
//		}
//	}
//
//}