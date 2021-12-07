//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.ProblemBean;
//import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;
//import j16.t03.springboot.m.repository.ContactUsDao;
//import j16.t03.springboot.m.service.ContactUsService;
//
//@Transactional
//@Service
//public class ContactUsServiceImpl implements ContactUsService {
//	
//	ContactUsDao contactUsDao;
//	
//	@Autowired
//	public void setContactUsDao(ContactUsDao contactUsDao) {
//		this.contactUsDao = contactUsDao;
//	}
//	
//	@Override
//	public List<ProblemBean> getProblems() {
//		return contactUsDao.getProblems();
//	}
//	
//	@Override
//	public Object save(ProblemBean bean) {
//		return contactUsDao.save(bean);
//	}
//
//	@Override
//	public List<ProblemSelectBean> queryProblemSelect(String problemType) {
//		return contactUsDao.queryProblemSelect(problemType) ;
//	}
//
////	@Override
////	public ProblemBean getProblemById(int usId) {
////		return contactUsDao.findProblemById(usId);   
////	}
//
//	@Override
//	public ProblemBean getProblemById(Integer replyId) {
//		return contactUsDao.getProblemById(replyId);   
//	}
//
//	@Override
//	public List<ProblemBean> getProblemsById(Integer replyId) {
//		return contactUsDao.getProblemsById(replyId);   
//	}
//
////	@Override
////	public ProblemBean get(Integer id) {
////
////		return contactUsDao.get(id);
////	}
//
//
//	
//
//}