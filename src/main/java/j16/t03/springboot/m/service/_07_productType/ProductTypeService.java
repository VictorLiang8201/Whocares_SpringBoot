package j16.t03.springboot.m.service._07_productType;

import java.util.List;

import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;

public interface ProductTypeService {

	// 讀取全部產品分類
	List<ProductTypeBean> findAll();
	
	//	依主鍵查詢產品類別
	ProductTypeBean getById(String prodType);

}