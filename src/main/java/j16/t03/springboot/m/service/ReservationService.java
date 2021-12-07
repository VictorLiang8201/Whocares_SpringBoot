package j16.t03.springboot.m.service;

import java.util.List;

import j16.t03.springboot.m.entity._03_rent.ReservationBean;

public interface ReservationService {

	//	使用顧客編號查詢預約紀錄
	List<ReservationBean> findReservationBeanByCustId(Integer custId);
	
	//	使用預約編號查詢預約紀錄
	ReservationBean findReservationBeanById(Integer custId, Integer reservationId);

}