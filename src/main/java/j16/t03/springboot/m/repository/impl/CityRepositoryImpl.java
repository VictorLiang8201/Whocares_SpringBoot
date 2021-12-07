//package j16.t03.springboot.m.repository.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import j16.t03.springboot.m.entity._05_customer.CitySelectBean;
//import j16.t03.springboot.m.repository.CityRepository;
//
//@Repository
//public class CityRepositoryImpl implements CityRepository {
//
//	@Autowired
//	SessionFactory factory;
//
//	@Override
//	public List<CitySelectBean> getAllCitys(String groupCity) {
//		String hql = "";
//		if (groupCity.indexOf(",") != -1) {
//			String[] groupCitys = groupCity.split(",");
//			groupCity = "";
//			for (String string : groupCitys) {
//				groupCity += ",'" + string + "'";
//			}
//			hql = "FROM CitySelectBean WHERE groupCity IN(" + groupCity.substring(1) + ") ORDER BY groupCity, sortCity";
//		} else {
//			hql = "FROM CitySelectBean WHERE groupCity = " + groupCity + "ORDER BY sortCity";
//		}
//		Session session = factory.getCurrentSession();
//		List<CitySelectBean> dataList = session.createQuery(hql, CitySelectBean.class).getResultList();
//		return dataList;
//	}
//
//	public Session getSession() {
//		return factory.getCurrentSession();
//	}
//
//	@Override
//	public CitySelectBean getCity(Integer id) {
//		Session session = getSession();
//		return session.get(CitySelectBean.class, id);
//	}
//
//}
