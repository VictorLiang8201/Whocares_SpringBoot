//package j16.t03.springboot.m.service.impl;
//
//import java.util.Set;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.PromotionBean;
//import j16.t03.springboot.m.entity._03_rent.RentItemBean;
//import j16.t03.springboot.m.entity._03_rent.RentProductBean;
//import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
//import j16.t03.springboot.m.repository.BuyItemDao;
//import j16.t03.springboot.m.repository.OrderDao;
//import j16.t03.springboot.m.repository.ProductDao;
//import j16.t03.springboot.m.repository.RentItemDao;
//import j16.t03.springboot.m.repository.RentProductDao;
//import j16.t03.springboot.m.service.OrderService;
//
//@Transactional
//@Service
//public class OrderServiceImpl implements OrderService {
//	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
//
//	BuyItemDao buyItemDao;
//	RentItemDao rentItemDao;
//	ProductDao productDao;
//	RentProductDao rentProductDao;
//	OrderDao orderDao;
//
//	@Autowired
//	public OrderServiceImpl(BuyItemDao buyItemDao, ProductDao productDao, OrderDao orderDao,RentItemDao rentItemDao,
//			RentProductDao rentProductDao) {
//		this.buyItemDao = buyItemDao;
//		this.productDao = productDao;
//		this.orderDao = orderDao;
//		this.rentProductDao = rentProductDao;
//		this.rentItemDao = rentItemDao;
//	}
//
//	@Override
//	public PromotionBean findByDiscountCode(String discountCode) {
//		return orderDao.findByDiscountCode(discountCode);
//	}
//
//	@Override
//	public void save(OrdBean ordBean) {
//		log.info("處理訂單之Service:檢查交易庫存量");
//		checkStock(ordBean);
//		log.info("處理訂單之Service:準備儲存訂單");
//		orderDao.save(ordBean);
//
////		orderDao.save(ordBean);
//	}
//
//	@Override
//	public OrdPK getCurrentOrdId() {
//		return orderDao.getCurrentOrdId();
//	}
//
//	@Override
//	public void checkStock(OrdBean ordBean) {
//		//判斷傳入的是rent還是buy
//		if(ordBean.getOrdPK().getCategory() == "B") {
//			Set<BuyItemBean> items = ordBean.getBuyItems();
//			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
//			for(BuyItemBean bib : items) {
//				int stock = productDao.getProductById(bib.getProductBean().getProdId()).getStock();
//				if(stock < bib.getProdQTY()) {
//					log.info("處理訂單之Service: 商品編號: " + bib.getProductBean().getProdId() + " 庫存不足");
//	
//				}else {
//					log.info("處理訂單之Service: 準備檢查並調整每項商品的庫存量, 商品編號: " + bib.getProductBean().getProdId()  + " 庫存足夠");
//					buyItemDao.updateProductStock(bib);
//				}
//			}
//		}else {
//			Set<RentItemBean> items = ordBean.getRentItems();
//			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
//			for(RentItemBean rib : items) {
//				RentProductBean rentBean = rentProductDao.getRentProductBeanByProdIdAndSeriaNumber(rib.getRentProductBean().getProdId(),
//																					rib.getRentProductBean().getSerialNumber());
//				if(rentBean.getStock() == 0) {
//					log.info("處理訂單之Service: 商品編號: " + rib.getRentProductBean().getProdId() + " 庫存不足");
//	
//				}else {
//					log.info("處理訂單之Service: 準備檢查並調整每項商品的庫存量, 商品編號: " + rib.getRentProductBean().getProdId()  + " 庫存足夠");
//					rentItemDao.updateRentProductStock(rib);
//				}
//			}
//		}
//		
//	}
//
//	@Override
//	public void updateOrderStatus(String category, Integer ordId, String orderStatus) {
//		orderDao.updateOrderStatus(category, ordId, orderStatus);
//	}
//
//}
