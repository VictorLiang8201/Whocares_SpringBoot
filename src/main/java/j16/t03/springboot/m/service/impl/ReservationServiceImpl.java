//package j16.t03.springboot.m.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._03_rent.ReservationBean;
//import j16.t03.springboot.m.repository.ReservationDao;
//import j16.t03.springboot.m.service.ReservationService;
//
//@Transactional
//@Service
//public class ReservationServiceImpl implements ReservationService {
//
//	ReservationDao reservationDao;
//	
//	@Autowired
//	public ReservationServiceImpl(ReservationDao reservationDao) {
//		this.reservationDao = reservationDao;
//	}
//	
////	使用顧客編號查詢預約紀錄
//	@Override
//	public List<ReservationBean> findReservationBeanByCustId(Integer custId) {
//		return reservationDao.findReservationBeanByCustId(custId);
//	}
//	
////	使用預約編號查詢預約紀錄
//	@Override
//	public ReservationBean findReservationBeanById(Integer custId, Integer reservationId) {
//		return reservationDao.findReservationBeanById(custId, reservationId);
//	}
//
//}