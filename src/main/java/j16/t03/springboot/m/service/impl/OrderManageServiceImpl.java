//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.repository.OrderManageDao;
//import j16.t03.springboot.m.service.OrderManageService;
//
//@Transactional
//@Service
//public class OrderManageServiceImpl implements OrderManageService {
//
//	OrderManageDao orderManageDao;
//	
//	@Autowired
//	public OrderManageServiceImpl(OrderManageDao orderManageDao) {
//		this.orderManageDao = orderManageDao;
//	}
//
//	@Override
//	public List<OrdBean> findOrdBeansByCategory(String category) {
//		return orderManageDao.findOrdBeansByCategory(category);
//	}
//	
////	管理者使用複合主鍵查詢訂單
//	@Override
//	public OrdBean findOrdBeanById(String category, Integer ordId) {
//		return orderManageDao.findOrdBeanById(category, ordId);
//	}
//
//}