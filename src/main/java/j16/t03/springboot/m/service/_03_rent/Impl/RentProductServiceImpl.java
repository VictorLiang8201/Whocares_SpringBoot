//package j16.t03.springboot.m.service._03_rent.Impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import j16.t03.springboot.m.entity._03_rent.RentProductBean;
//import j16.t03.springboot.m.repository._03_rent.RentProductRepository;
//import j16.t03.springboot.m.service._03_rent.RentProductService;
//
//@Transactional
//@Service
//public class RentProductServiceImpl implements RentProductService {
//
//	RentProductRepository rentProductRepository;
//
//	@Autowired
//	public RentProductServiceImpl(RentProductRepository rentProductRepository) {
//		this.rentProductRepository = rentProductRepository;
//	}
//
////	取得所有租賃設備
//	@Override
//	public List<RentProductBean> findAll() {
//		return rentProductRepository.findAll();
//	}
//
////	取得所有租賃設備並群組同產品不同項次之設備(含頁碼及排序判斷)
//	@Override
//	public Page<RentProductBean> getGroupedProducts(Pageable pageable, Sort sort) {
//		return rentProductRepository.getGroupedProducts(pageable, sort);
//	}
//
//////	取得所有租賃設備的總庫存
////	@Override
////	public List<Long> getGroupedStockSum(ProductTypeBean prodTypeBean, int pageNo, String sortType) {
////		return rentProductRepository.getGroupedStockSum(prodTypeBean, pageNo, sortType);
////	}
//
//////	取得租賃設備群組後的總頁數
////	@Override
////	public int getGroupedPages(ProductTypeBean prodTypeBean) {
////		return rentProductRepository.getGroupedPages(prodTypeBean);
////	}
//
////	// 依主鍵讀取租賃設備總庫存
////	@Override
////	public int getTotalStockByProdId(int prodId) {
////		return rentProductRepository.getTotalStockByProdId(prodId);
////	}
//
//	@Override
//	public RentProductBean getById(int prodId) {
//		return rentProductRepository.getById(prodId);
//	}
//
////	// 抓取該商品目前預約資料
////	@Override
////	public List<ReservationBean> getReservationBeanByprodId(int prodId) {
////
////		return rentProductDao.getReservationBeanByprodId(prodId);
////	}
//
////	// 抓取該商品目前租賃評論資料
////	@Override
////	public List<CommentBean> getCommentBeanByprodId(int prodId) {
////
////		return rentProductDao.getCommentBeanByprodId(prodId);
////	}
//
//	// 更新租賃設備
//	@Override
//	public void save(RentProductBean rentProductBean) {
//		rentProductRepository.save(rentProductBean);
//	}
//
////	// 新增單筆預約資料
////	@Override
////	public void addReservation(ReservationBean reservation) {
////		rentProductDao.addReservation(reservation);
////	}
//
////	// 依session中使用者帳號讀取目前使用者資料
////	@Override
////	public List<CustomerBean> getCustomerInfoByLoginAccount(String account) {
////		return rentProductRepository.getCustomerInfoByLoginAccount(account);
////	}
//
////	// 依會員編號取出該會員所有預約的設備資料
////	@Override
////	public List<ReservationBean> getMyReservationByCustId(int mycustId) {
////		return rentProductDao.getMyReservationByCustId(mycustId);
////	}
//
////	// 依傳入大分類代號取出該分類代號之名稱
////	@Override
////	public List<ProductTypeBean> getProductTypeBeanBymaincategory(String maincategory) {
////		return rentProductDao.getProductTypeBeanBymaincategory(maincategory);
////	}
//
////	@Override
////	public List<RentProductBean> getAllSerialStocksByprodId(int prodId) {
////		return rentProductDao.getAllSerialStocksByprodId(prodId);
////	}
//
//}