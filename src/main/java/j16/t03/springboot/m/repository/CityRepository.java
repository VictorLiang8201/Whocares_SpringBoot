package j16.t03.springboot.m.repository;

import java.util.List;

import j16.t03.springboot.m.entity._05_customer.CitySelectBean;


public interface CityRepository {
	List<CitySelectBean> getAllCitys(String groupCity);
	CitySelectBean getCity(Integer id);
}
