package j16.t03.springboot.m.repository;

import java.util.List;

import j16.t03.springboot.m.entity._06_order.OrdBean;

public interface ContactUsOrdDao {

	List<OrdBean> findOrdBeanById(Integer ordId);

}
