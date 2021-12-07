package j16.t03.springboot.m.repository._07_productType;

import org.springframework.data.jpa.repository.JpaRepository;

import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;

public interface ProductTypeRepository extends JpaRepository<ProductTypeBean, String> {

}