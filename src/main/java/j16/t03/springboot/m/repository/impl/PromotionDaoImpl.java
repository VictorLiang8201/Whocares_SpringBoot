package j16.t03.springboot.m.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import j16.t03.springboot.m.entity._02_customerService.PromotionBean;
import j16.t03.springboot.m.repository.PromotionDao;

@Repository
public class PromotionDaoImpl implements PromotionDao {

	SessionFactory factory;

	@Autowired
	public PromotionDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

//	取得所有優惠類別
	@Override
	public List<PromotionBean> getAllPromotions() {
		Session session = factory.getCurrentSession();
		String hql = " FROM PromotionBean ";

		return session.createQuery(hql, PromotionBean.class).getResultList();
	}
	
//	依主鍵查詢產品類別
	@Override
	public PromotionBean findPromotionBeanById(Integer promoteId) {
		Session session = factory.getCurrentSession();
		if (promoteId != null) {
			return session.get(PromotionBean.class, promoteId);
		} else {
			return null;
		}
	}
	
}