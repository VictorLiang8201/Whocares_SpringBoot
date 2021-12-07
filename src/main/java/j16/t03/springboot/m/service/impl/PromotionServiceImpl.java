//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.PromotionBean;
//import j16.t03.springboot.m.repository.PromotionDao;
//import j16.t03.springboot.m.service.PromotionService;
//
//@Transactional
//@Service
//public class PromotionServiceImpl implements PromotionService {
//
//	PromotionDao promotionDao;
//	
//	@Autowired
//	public PromotionServiceImpl(PromotionDao promotionDao) {
//		this.promotionDao = promotionDao;
//	}
//
//	// 取得所有優惠類別
//	@Override
//	public List<PromotionBean> getAllPromotions() {
//		return promotionDao.getAllPromotions();
//	}
//	
////	依主鍵查詢產品類別
//	@Override
//	public PromotionBean findPromotionBeanById(Integer promoteId) {
//		return promotionDao.findPromotionBeanById(promoteId);
//	}
//	
//}