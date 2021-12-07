package j16.t03.springboot.m.service;


import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
import j16.t03.springboot.m.entity._04_shop.pkClass.BuyItemPK;

public interface BuyItemService {

	BuyItemBean findBuyItemByPK(BuyItemPK buyItemPK);

	void updateBuyItem(BuyItemBean buyItemBean);
	
}