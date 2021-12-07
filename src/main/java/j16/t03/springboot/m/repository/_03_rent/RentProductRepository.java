//package j16.t03.springboot.m.repository._03_rent;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import j16.t03.springboot.m.entity._03_rent.RentProductBean;
//
//public interface RentProductRepository extends JpaRepository<RentProductBean, Integer> {
//	
//	@Query(" FROM RentProductBean rp GROUP BY rp.prodId ")
//	Page<RentProductBean> getGroupedProducts(Pageable pageable, Sort sort);
//}