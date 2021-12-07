//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;
//import j16.t03.springboot.m.repository.ProblemSelectDao;
//import j16.t03.springboot.m.service.ProblemSelectService;
//
//
//@Service
//@Transactional
//public class ProblemSelectServiceImpl implements ProblemSelectService {
//
//	@Autowired
//	ProblemSelectDao problemSelectDao;
//	
//	
//
////	@Override
////	public List<ProblemSelectBean> getAllProblemTypes(String problemType){
////		return problemSelectDao.getAllProblemTypes(problemType);
////		}
//	
//	@Override
//	public List<ProblemSelectBean> getAllProblemTypes(String problemType){
//		return problemSelectDao.getAllProblemTypes(problemType);
//		}
//
//	@Override
//	public ProblemSelectBean getAllProblemType(Integer id){
//	return problemSelectDao.getAllProblemType(id);
//	}
//
//}