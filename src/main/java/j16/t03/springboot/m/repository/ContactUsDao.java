package j16.t03.springboot.m.repository;

import java.util.List;

import j16.t03.springboot.m.entity._02_customerService.ProblemBean;
import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;



public interface ContactUsDao {
	
	
	List<ProblemBean> getProblems();
	Object save(ProblemBean bean);  //新增一筆聯絡我們記錄
//	ProblemBean get(Integer id);
	
	List<ProblemSelectBean> queryProblemSelect(String problemType);
//	ProblemBean findProblemById(int usId);
//	ProblemBean findProblemById(Integer usId);
	
	ProblemBean getProblemById(Integer replyId);
	List<ProblemBean> getProblemsById(Integer replyId);
	
	
}
