//package j16.t03.springboot.m.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
//import j16.t03.springboot.m.entity._04_shop.pkClass.BuyItemPK;
//import j16.t03.springboot.m.repository.BuyItemDao;
//import j16.t03.springboot.m.service.BuyItemService;
//
//@Transactional
//@Service
//public class BuyItemServiceImpl implements BuyItemService {
//	
//	BuyItemDao buyItemDao;
//	
//	@Autowired
//	public BuyItemServiceImpl(BuyItemDao buyItemDao) {
//		this.buyItemDao = buyItemDao;
//	}
//
////	使用複合主鍵查詢購買細項
//	@Override
//	public BuyItemBean findBuyItemByPK(BuyItemPK buyItemPK) {
//		return buyItemDao.findBuyItemByPK(buyItemPK);
//	}
//
////	更新購買細項
//	@Override
//	public void updateBuyItem(BuyItemBean buyItemBean) {
//		buyItemDao.updateBuyItem(buyItemBean);
//	}
//
//
//
//	
//}