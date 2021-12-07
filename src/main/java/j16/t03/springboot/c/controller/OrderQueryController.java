//package j16.t03.springboot.c.controller;
//
//import java.sql.Clob;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.sql.rowset.serial.SerialClob;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import j16.t03.springboot.m.entity._02_customerService.CommentBean;
//import j16.t03.springboot.m.entity._03_rent.RentItemBean;
//import j16.t03.springboot.m.entity._03_rent.ReservationBean;
//import j16.t03.springboot.m.entity._03_rent.pkClass.RentItemPK;
//import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
//import j16.t03.springboot.m.entity._04_shop.pkClass.BuyItemPK;
//import j16.t03.springboot.m.entity._05_customer.CustomerBean;
//import j16.t03.springboot.m.entity._06_order.OrdBean;
//import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
//import j16.t03.springboot.m.service.BuyItemService;
//import j16.t03.springboot.m.service.CommentService;
//import j16.t03.springboot.m.service.CustomerService;
//import j16.t03.springboot.m.service.OrderQueryService;
//import j16.t03.springboot.m.service.ProductService;
//import j16.t03.springboot.m.service.RentItemService;
//import j16.t03.springboot.m.service.RentProductService;
//import j16.t03.springboot.m.service.ReservationService;
//
//@Controller
//public class OrderQueryController {
//
//	CustomerService customerService;
//	OrderQueryService orderQueryService;
//	ReservationService reservationService;
//	CommentService commentService;
//	ProductService productService;
//	BuyItemService buyItemService;
//	RentProductService rentProductService;
//	RentItemService rentItemService;
//	HttpSession httpSession;
//	@Autowired
//	HttpServletRequest request;
//	
//	@Autowired
//	public OrderQueryController(CustomerService customerService, OrderQueryService orderQueryService,
//			ReservationService reservationService, CommentService commentService, ProductService productService,
//			BuyItemService buyItemService, RentProductService rentProductService, RentItemService rentItemService,
//			HttpSession httpSession) {
//		this.customerService = customerService;
//		this.orderQueryService = orderQueryService;
//		this.reservationService = reservationService;
//		this.commentService = commentService;
//		this.productService = productService;
//		this.buyItemService = buyItemService;
//		this.rentProductService = rentProductService;
//		this.rentItemService = rentItemService;
//		this.httpSession = httpSession;
//	}
//
////	進入商城訂單查詢頁(含查詢字串)
//	@GetMapping("/orderQuery/{custId}")
//	public String orderQuery(@PathVariable Integer custId,
//			@RequestParam(name = "category", required = false) String category,
//			@RequestParam(name = "ordId", defaultValue = "0", required = false) Integer ordId, Model model) {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("LoginOK") == null) {
//			return "index";
//		}
//		CustomerBean customerBean = customerService.getCustomerById(custId);
//		List<OrdBean> ordBeans = orderQueryService.findOrdBeanByCustIdAndCategory(custId, "B");
//		model.addAttribute(customerBean);
//		if (ordBeans != null) {
//			model.addAttribute(ordBeans);
//		}
//		if (custId != null && category != null && ordId != null) {
//			OrdBean ordBean = orderQueryService.findOrdBeanById(custId, category, ordId);
//			List<BuyItemBean> buyItems = orderQueryService.findBuyItemByOrdId(ordId);
//			if (ordBean != null) {
//				model.addAttribute(ordBean);
//				try {
//					Clob orderMarkClob = ordBean.getOrderMark();
//					String orderMark = orderMarkClob.getSubString(1L, (int) orderMarkClob.length());
//					model.addAttribute("orderMark", orderMark);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				model.addAttribute("buyItems", buyItems);
//				String[] commentList = new String[buyItems.size()];
//				for (int i = 0; i < buyItems.size(); i++) {
//					if (buyItems.get(i).getCommentBean() != null) {
//						Clob tempComment = buyItems.get(i).getCommentBean().getComment();
//						try {
//							commentList[i] = tempComment.getSubString(1L, (int) tempComment.length());
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//				if (commentList != null) {
//					model.addAttribute("commentList", commentList);
//				}
//			} else {
//				model.addAttribute("orderNotFound", "查無此訂單，請重新輸入正確的訂單編號");
//			}
//		}
//
//		return "_06_orderQuery";
//	}
//	
//
////	輸入購買商品評價
//	@PostMapping("/orderQuery/addComment")
//	public String orderQueryComment(@RequestParam("custId") Integer custId,
//			@RequestParam(name = "category", defaultValue = "B", required = false) String category,
//			@RequestParam(name = "ordId", required = false) Integer ordId,
//			@RequestParam(name = "prodSerialNum", required = false) Integer prodSerialNum,
//			@RequestParam(name = "rate", required = false) Integer rate,
//			@RequestParam(name = "comment", required = false) String commentString,
//			Model model
//	) {
//		Clob comment = null;
//		try {
//			comment = new SerialClob(commentString.toCharArray());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		BuyItemBean buyItemBean = buyItemService
//				.findBuyItemByPK(new BuyItemPK(new OrdPK(category, ordId), prodSerialNum));
//		CommentBean tempCommentBean = buyItemBean.getCommentBean();
//		if (tempCommentBean == null) {
//			Timestamp commentDate = new Timestamp(System.currentTimeMillis());
//			CommentBean commentBean = new CommentBean(null, category, rate, null, commentDate, comment);
//			commentBean.setCustomerBean(customerService.getCustomerById(custId));
//			commentBean.setProductBean(buyItemBean.getProductBean());
//			buyItemBean.setCommentBean(commentBean);
//			commentService.addComment(commentBean);
//			buyItemService.updateBuyItem(buyItemBean);
//		} else {
//			tempCommentBean.setRate(rate);
//			tempCommentBean.setComment(comment);
//			commentService.updateComment(tempCommentBean);
//		}
//
//		return "redirect:/orderQuery/" + custId + "/?category=" + category + "&ordId=" + ordId;
//	}
//
////	進入租賃訂單查詢頁(含查詢字串)
//	@GetMapping("/rentOrderQuery/{custId}")
//	public String rentOrderQuery(@PathVariable Integer custId,
//			@RequestParam(name = "category", required = false) String category,
//			@RequestParam(name = "ordId", defaultValue = "0", required = false) Integer ordId, Model model) {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("LoginOK") == null) {
//			return "index";
//		}
//		CustomerBean customerBean = customerService.getCustomerById(custId);
//		List<OrdBean> ordBeans = orderQueryService.findOrdBeanByCustIdAndCategory(custId, "R");
//		model.addAttribute(customerBean);
//		if (ordBeans != null) {
//			model.addAttribute(ordBeans);
//		}
//		if (custId != null && category != null && ordId != null) {
//			OrdBean ordBean = orderQueryService.findOrdBeanById(custId, category, ordId);
//			List<RentItemBean> rentItems = orderQueryService.findRentItemByOrdId(ordId);
//			if (ordBean != null) {
//				model.addAttribute(ordBean);
//				try {
//					Clob orderMarkClob = ordBean.getOrderMark();
//					String orderMark = orderMarkClob.getSubString(1L, (int) orderMarkClob.length());
//					model.addAttribute("orderMark", orderMark);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				model.addAttribute("rentItems", rentItems);
//				String[] commentList = new String[rentItems.size()];
//				for (int i = 0; i < rentItems.size(); i++) {
//					if (rentItems.get(i).getCommentBean() != null) {
//						Clob tempComment = rentItems.get(i).getCommentBean().getComment();
//						try {
//							commentList[i] = tempComment.getSubString(1L, (int) tempComment.length());
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//				if (commentList != null) {
//					model.addAttribute("commentList", commentList);
//				}
//			} else {
//				model.addAttribute("orderNotFound", "查無此訂單，請重新輸入正確的訂單編號");
//			}
//		}
//
//		return "_06_rentOrderQuery";
//	}
//
////	輸入租賃設備評價
//	@PostMapping("/rentOrderQuery/addComment")
//	public String rentOrderQueryComment(@RequestParam("custId") Integer custId,
//			@RequestParam(name = "category", defaultValue = "R", required = false) String category,
//			@RequestParam(name = "ordId", required = false) Integer ordId,
//			@RequestParam(name = "prodSerialNum", required = false) Integer prodSerialNum,
//			@RequestParam(name = "rate", required = false) Integer rate,
//			@RequestParam(name = "comment", required = false) String commentString,
//			Model model
//	) {
//		Clob comment = null;
//		try {
//			comment = new SerialClob(commentString.toCharArray());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		RentItemBean rentItemBean = rentItemService
//				.findRentItemByPK(new RentItemPK(new OrdPK(category, ordId), prodSerialNum));
//		CommentBean tempCommentBean = rentItemBean.getCommentBean();
//		if (tempCommentBean == null) {
//			Timestamp commentDate = new Timestamp(System.currentTimeMillis());
//			CommentBean commentBean = new CommentBean(null, category, rate, null, commentDate, comment);
//			commentBean.setCustomerBean(customerService.getCustomerById(custId));
//			commentBean.setRentProductBean(rentItemBean.getRentProductBean());
//			rentItemBean.setCommentBean(commentBean);
//			commentService.addComment(commentBean);
//			rentItemService.updateRentItem(rentItemBean);
//		} else {
//			tempCommentBean.setRate(rate);
//			tempCommentBean.setComment(comment);
//			commentService.updateComment(tempCommentBean);
//		}
//
//		return "redirect:/rentOrderQuery/" + custId + "/?category=" + category + "&ordId=" + ordId;
//	}
//
////	進入租賃訂單查詢頁(含查詢字串)
//	@GetMapping("/reservationQuery/{custId}")
//	public String reservationQuery(@PathVariable Integer custId,
//			@RequestParam(name = "reservationId", required = false) Integer reservationId,
//			Model model
//	) {
//		CustomerBean customerBean = customerService.getCustomerById(custId);
//		List<ReservationBean> reservationBeans = reservationService.findReservationBeanByCustId(custId);
//		model.addAttribute(customerBean);
//		if (reservationBeans != null) {
//			model.addAttribute(reservationBeans);
//		}
//		if (reservationId != null) {
//			ReservationBean reservationBean = reservationService.findReservationBeanById(custId, reservationId);
//			if (reservationBean != null) {
//				int totalStock = rentProductService.getTotalStockByProdId(reservationBean.getRentProductBean().getProdId());
//				model.addAttribute("reservation", reservationBean);
//				model.addAttribute("totalStock", totalStock);
//			
//			} else {
//				model.addAttribute("reservationNotFound", "查無此訂單，請重新輸入正確的訂單編號");
//			}
//		}
//
//		return "_06_reservationQuery";
//	}
//	
//}