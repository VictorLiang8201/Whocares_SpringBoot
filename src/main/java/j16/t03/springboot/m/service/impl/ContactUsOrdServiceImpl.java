//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.repository.ContactUsOrdDao;
//import j16.t03.springboot.m.service.ContactUsOrdService;
//
//@Service
//@Transactional
//public class ContactUsOrdServiceImpl implements ContactUsOrdService {
//	
//	@Autowired
//	ContactUsOrdDao contactUsOrdDao;
//
//	@Override
//	public List<OrdBean> findOrdBeanById(Integer ordId) {
//		
//		return contactUsOrdDao.findOrdBeanById(ordId);
//	}
//
//}