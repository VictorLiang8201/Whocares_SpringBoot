package j16.t03.springboot.m.service._07_productType.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;
import j16.t03.springboot.m.repository._07_productType.ProductTypeRepository;
import j16.t03.springboot.m.service._07_productType.ProductTypeService;

@Transactional
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	ProductTypeRepository productTypeRepository;
	
	@Autowired
	public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
		this.productTypeRepository = productTypeRepository;
	}

//	取得所有產品類別
	@Override
	public List<ProductTypeBean> findAll() {
		return productTypeRepository.findAll();
	}
	
//	依主鍵查詢產品類別
	@Override
	public ProductTypeBean getById(String prodType) {
		return productTypeRepository.getById(prodType);
	}
	
}