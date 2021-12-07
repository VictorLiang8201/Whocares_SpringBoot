package j16.t03.springboot.m.repository;

import java.util.List;

import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;

public interface ProductTypeDao {
	
	// 讀取全部產品分類
	List<ProductTypeBean> getAllProdTypes();
	
	//	依主鍵查詢產品類別
	ProductTypeBean findProductTypeBeanById(String prodType);

}