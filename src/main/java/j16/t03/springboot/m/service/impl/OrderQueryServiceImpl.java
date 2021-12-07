//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._03_rent.RentItemBean;
//import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.repository.OrderQueryDao;
//import j16.t03.springboot.m.service.OrderQueryService;
//
//@Transactional
//@Service
//public class OrderQueryServiceImpl implements OrderQueryService {
//
//	OrderQueryDao orderQueryDao;
//
//	@Autowired
//	public OrderQueryServiceImpl(OrderQueryDao orderQueryDao) {
//		this.orderQueryDao = orderQueryDao;
//	}
//
//	@Override
//	public List<OrdBean> findOrdBeanByCustIdAndCategory(Integer custId, String category) {
//		return orderQueryDao.findOrdBeanByCustIdAndCategory(custId, category);
//	}
//	
//	@Override
//	public OrdBean findOrdBeanById(Integer custId, String category, Integer ordId) {
//		return orderQueryDao.findOrdBeanById(custId, category, ordId);
//	}
//
//	@Override
//	public List<BuyItemBean> findBuyItemByOrdId(Integer ordId) {
//		return orderQueryDao.findBuyItemByOrdId(ordId);
//	}
//
//	@Override
//	public List<RentItemBean> findRentItemByOrdId(Integer ordId) {
//		return orderQueryDao.findRentItemByOrdId(ordId);
//	}
//
//}