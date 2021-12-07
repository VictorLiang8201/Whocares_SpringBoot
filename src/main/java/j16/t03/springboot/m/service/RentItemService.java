package j16.t03.springboot.m.service;

import j16.t03.springboot.m.entity._03_rent.RentItemBean;
import j16.t03.springboot.m.entity._03_rent.pkClass.RentItemPK;

public interface RentItemService {

	RentItemBean findRentItemByPK(RentItemPK rentItemPK);

	void updateRentItem(RentItemBean rentItemBean);

}