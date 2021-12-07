//package j16.t03.springboot.m.repository.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._02_customerService.DmBean;
//import j16.t03.springboot.m.repository.DmDao;
//@Repository
//public class DmDaoImpl implements DmDao {
//
//	SessionFactory factory;
//	
//	@Autowired
//	public DmDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//	
//	@Override
//	public List<DmBean> getAllDms() {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM DmBean d ";
//		return session.createQuery(hql, DmBean.class).getResultList();
//	}
//
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<DmBean> getDmid(Integer dmId) {
//		Session session = factory.getCurrentSession();
//		String hql = " FROM DmBean d WHERE d.dmId = :did ";
//		List<DmBean> list = session.createQuery(hql)
//										.setParameter("did", dmId)
//										.getResultList();
//		return list;
//	}
//	
//}
