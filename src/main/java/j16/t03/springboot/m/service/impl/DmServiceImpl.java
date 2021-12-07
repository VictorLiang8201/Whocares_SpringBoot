//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.DmBean;
//import j16.t03.springboot.m.repository.DmDao;
//import j16.t03.springboot.m.service.DmService;
//
//@Transactional
//@Service
//public class DmServiceImpl implements DmService {
//
//	DmDao dmDao;
//	
//	@Autowired
//	public DmServiceImpl(DmDao dmDao) {
//		this.dmDao = dmDao;
//	}
//
//	@Override
//	public List<DmBean> getAllDms() {
//		return dmDao.getAllDms();
//	}
//
//	@Override
//	public List<DmBean> getDmid(Integer dmId) {
//		return dmDao.getDmid(dmId);
//	}
//
//}