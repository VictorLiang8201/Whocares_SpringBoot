package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._02_customerService.ProblemBean;
import j16.t03.springboot.m.entity._02_customerService.ProblemSelectBean;



public interface ContactUsService {
	ProblemBean getProblemById(Integer replyId);        //依主鍵找客服編號
	List<ProblemBean> getProblemsById(Integer replyId);  // 找全部資料
	
	List<ProblemBean> getProblems(); //讀取多筆聯絡我們記錄
	Object save(ProblemBean bean);  //新增一筆聯絡我們記錄
//	ProblemBean get(Integer id);
	List<ProblemSelectBean> queryProblemSelect(String problemType);
//	ProblemBean getProblemById(int usId);
}
