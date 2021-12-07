//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;
//import j16.t03.springboot.m.repository.ProductTypeDao;
//import j16.t03.springboot.m.service.ProductTypeService;
//
//@Transactional
//@Service
//public class ProductTypeServiceImpl implements ProductTypeService {
//
//	ProductTypeDao productTypeDao;
//
//	@Autowired
//	public ProductTypeServiceImpl(ProductTypeDao productTypeDao) {
//		this.productTypeDao = productTypeDao;
//	}
//
////	取得所有產品類別
//	@Override
//	public List<ProductTypeBean> getAllProdTypes() {
//		return productTypeDao.getAllProdTypes();
//	}
//	
////	依主鍵查詢產品類別
//	@Override
//	public ProductTypeBean findProductTypeBeanById(String prodType) {
//		return productTypeDao.findProductTypeBeanById(prodType);
//	}
//	
//}