package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._03_rent.RentItemBean;
import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
import j16.t03.springboot.m.entity._06_order.OrdBean;

public interface OrderQueryService {
	
	List<OrdBean> findOrdBeanByCustIdAndCategory(Integer custId, String category);
	
	OrdBean findOrdBeanById(Integer custId, String category, Integer ordId);

	List<BuyItemBean> findBuyItemByOrdId(Integer ordId);

	List<RentItemBean> findRentItemByOrdId(Integer ordId);
	
}