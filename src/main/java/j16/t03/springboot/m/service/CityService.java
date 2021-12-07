package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._05_customer.CitySelectBean;

public interface CityService {
	List<CitySelectBean> getAllCitys(String groupCity);
	CitySelectBean getCity(Integer id);
}

