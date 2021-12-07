//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._05_customer.CitySelectBean;
//import j16.t03.springboot.m.repository.CityRepository;
//import j16.t03.springboot.m.service.CityService;
//
//@Transactional
//@Service
//public class CityServiceImpl implements CityService {
//
//	@Autowired
//	CityRepository cityRepository;
//
//	@Override
//	public List<CitySelectBean> getAllCitys(String groupCity) {
//		return cityRepository.getAllCitys(groupCity);
//	}
//
//	@Override
//	public CitySelectBean getCity(Integer id) {
//		return cityRepository.getCity(id);
//	}
//
//}