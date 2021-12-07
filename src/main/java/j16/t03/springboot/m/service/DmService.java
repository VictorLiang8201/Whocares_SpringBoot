package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._02_customerService.DmBean;

public interface DmService {

	List<DmBean> getAllDms();
	
	List<DmBean> getDmid(Integer dmId);
}
