package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._06_order.OrdBean;

public interface ContactUsOrdService {
	
	List<OrdBean> findOrdBeanById(Integer ordId);
}

