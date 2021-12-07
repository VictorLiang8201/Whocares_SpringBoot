package j16.t03.springboot.m.repository;


import java.util.List;

import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;

public interface ProblemSelectDao {
//	List<ProblemSelectBean> getAllProblemTypes(String problemType);
	
	List<ProblemSelectBean> getAllProblemTypes(String problemType);
	ProblemSelectBean getAllProblemType(Integer id);
	
}