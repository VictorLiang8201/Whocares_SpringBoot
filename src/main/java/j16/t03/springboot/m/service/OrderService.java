package j16.t03.springboot.m.service;

import j16.t03.springboot.m.entity._02_customerService.PromotionBean;
import j16.t03.springboot.m.entity._06_order.OrdBean;
import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;

public interface OrderService {
	
	
	//使用discountCode找到優惠
	public PromotionBean findByDiscountCode(String discountCode);
	
	//儲存訂單
	public void save(OrdBean ordBean);
	
	//找尋目前訂單編號
	public OrdPK getCurrentOrdId();
	
	//確認庫存
	public void checkStock(OrdBean ordBean);
	
	//更改訂單狀態
	public void updateOrderStatus(String category, Integer ordId,String orderStatus);
}
