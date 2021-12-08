package j16.t03.springboot._01_model.repository._04_shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;

public interface ProductRepository extends JpaRepository<ProductBean, Integer> {
	
	Page<ProductBean> findByProductTypeBean(ProductTypeBean productTypeBean, Pageable pageable);
	
}