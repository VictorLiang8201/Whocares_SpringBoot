package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._06_order.OrdBean;

public interface OrderManageService {
	
	//	管理者查詢所有訂單
	List<OrdBean> findOrdBeansByCategory(String category);
	
	//	管理者使用複合主鍵查詢訂單
	OrdBean findOrdBeanById(String category, Integer ordId);

}