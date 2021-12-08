package j16.t03.springboot._01_model.service._03_rent.Impl;
//package j16.t03.springboot.m.service._03_rent.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._03_rent.RentItemBean;
//import j16.t03.springboot.m.entity._03_rent.pkClass.RentItemPK;
//import j16.t03.springboot.m.repository._03_rent.RentItemRepository;
//import j16.t03.springboot.m.service._03_rent.RentItemService;
//
//@Transactional
//@Service
//public class RentItemServiceImpl implements RentItemService {
//	
//	RentItemRepository rentItemRepository;
//	
//	@Autowired
//	public RentItemServiceImpl(RentItemRepository rentItemRepository) {
//		this.rentItemRepository = rentItemRepository;
//	}
//
////	使用複合主鍵查詢租賃細項
//	@Override
//	public RentItemBean getById(RentItemPK rentItemPK) {
//		return rentItemRepository.getById(rentItemPK);
//	}
//	
////	增/改租賃細項
//	@Override
//	public void save(RentItemBean rentItemBean) {
//		rentItemRepository.save(rentItemBean);
//	}
//	
//}