package j16.t03.springboot._02_controller._04_shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;
import j16.t03.springboot._01_model.repository.ShoppingCart;
import j16.t03.springboot._01_model.service._04_shop.ProductService;
import j16.t03.springboot._01_model.service._07_productType.ProductTypeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/buyMenu")
public class BuyMenuController {

	ProductService productService;
	ProductTypeService productTypeService;
//	PromotionService promotionService;
	HttpSession httpSession;
//	FavoriteBean favoriteBean;

//	@Autowired
//	CustomerService customerService;
	@Autowired
	HttpServletRequest request;

//	@Autowired
//	public FavoriteBean getFavoriteBean() {
//		return favoriteBean;
//	}

//	public void setFavoriteBean(FavoriteBean favoriteBean) {
//		this.favoriteBean = favoriteBean;
//	}

//	@Autowired
//	public BuyMenuController(ProductService productService, ProductTypeService productTypeService,
//			PromotionService promotionService, HttpSession httpSession) {
//		this.productService = productService;
//		this.productTypeService = productTypeService;
////		this.promotionService = promotionService;
//		this.httpSession = httpSession;
//	}

//	進入商城目錄頁(含分頁及排序)
	@GetMapping({ "", "/" })
	public String buyProductMenu(Model model) {
		ShoppingCart shoppingCart = (ShoppingCart) httpSession.getAttribute("ShoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			httpSession.setAttribute("ShoppingCart", shoppingCart);
		}

		Page<ProductBean> pagedProducts = null;
		Pageable pageable = null;
		int totalPages = 0;

		pageable = PageRequest.of(0, 12);
		model.addAttribute("sortType", null);
		pagedProducts = productService.findAll(pageable);
		totalPages = pagedProducts.getTotalPages();
		List<ProductBean> products = pagedProducts.getContent();
		List<ProductTypeBean> productTypes = productTypeService.findAll();
//		List<PromotionBean> promotions = promotionService.getAllPromotions();

		model.addAttribute("products", products);
		model.addAttribute("productTypes", productTypes);
//		model.addAttribute("promotions", promotions);
		model.addAttribute("pageNo", 1);
		model.addAttribute("totalPages", totalPages);

		return "_04_buyProductMenu";
	}

	// 進入商城目錄頁(含分頁及排序)
	@GetMapping({ "/filter", "/promote{promoteId}" })
	public @ResponseBody Map<String, Object> buyProductMenu(
			@PathVariable(name = "promoteId", required = false) Integer promoteId,
			@RequestParam(name = "prodType", required = false) String prodType,
			@RequestParam(name = "sortType", required = false) String sortType,
			@RequestParam(name = "pageNo", defaultValue = "1") int pageNo
	) {
		ShoppingCart shoppingCart = (ShoppingCart) httpSession.getAttribute("ShoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			httpSession.setAttribute("ShoppingCart", shoppingCart);
		}
		Map<String, Object> map = new HashMap<>();
		Page<ProductBean> pagedProducts = null;
		Pageable pageable = null;
		String[] sort = null;
		int totalPages = 0;

		if (prodType != null) {
			if (sortType != null) {
				sort = sortType.split(" ");
				if (sort[1].equals("ASC")) {
					pageable = PageRequest.of((pageNo - 1), 12, Sort.by(sort[0]).ascending());
				} else {
					pageable = PageRequest.of((pageNo - 1), 12, Sort.by(sort[0]).descending());
				}
			} else {
				pageable = PageRequest.of((pageNo - 1), 12);
			}
			pagedProducts = productService.findByProductTypeBean(ProductTypeBean.builder().prodType(prodType).build(),
					pageable);
			totalPages = pagedProducts.getTotalPages();
		} else {
			if (sortType != null) {
				sort = sortType.split(" ");
				if (sort[1].equals("ASC")) {
					pageable = PageRequest.of((pageNo - 1), 12, Sort.by(sort[0]).ascending());
				} else {
					pageable = PageRequest.of((pageNo - 1), 12, Sort.by(sort[0]).descending());
				}
			} else {
				pageable = PageRequest.of((pageNo - 1), 12);
			}
			pagedProducts = productService.findAll(pageable);
			totalPages = pagedProducts.getTotalPages();

		}
		List<ProductBean> products = pagedProducts.getContent();
		List<ProductTypeBean> productTypes = productTypeService.findAll();
//		List<PromotionBean> promotions = promotionService.getAllPromotions();
		
		map.put("products", products);
		map.put("productTypes", productTypes);
//		map.put("promotions", promotions);
		map.put("totalPages", totalPages);
		
		return map;
	}

//	// 新增追蹤清單
//	@PostMapping(value = "/addFavorite")
//	@ResponseBody
//	public void addFavorite(@ModelAttribute("favorite") FavoriteBean favoriteBean) {
//		List<FavoriteBean> allFavorite = productService.queryFavorite(favoriteBean.getFK_Customer_ID(),
//				favoriteBean.getFK_Product_ID());
//		if (allFavorite.size() == 0)
//			productService.addFavorite(favoriteBean);
//	}
//
//	// 刪除追蹤清單
//	@PostMapping(value = "/deleteFavorite")
//	@ResponseBody
//	public void deleteFavorite(@ModelAttribute("favorite") FavoriteBean favoriteBean) {
//		productService.deleteFavorite(favoriteBean);
//	}

//	// 搜尋追蹤清單
//	@PostMapping(value = "/quereyFavoriteBYCustomerID")
//	@ResponseBody
//	public List<FavoriteBean> quereyFavoriteBYCustomerID(@ModelAttribute("favorite") FavoriteBean favoriteBean) {
//		return productService.getFavorite(favoriteBean.getFK_Customer_ID());
//	}

//	// 追蹤清單頁面查詢
//	@GetMapping(value = "/_04_favoriteList/{id}", produces = { "text/html" })
//	public String checkFavoriteFindView(@PathVariable Integer id, Model model) {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("LoginOK") == null) {
//			return "index";
//		}
//		CustomerBean customer = customerService.getCustomerById(id);
//		model.addAttribute("customer", customer);
//		model.addAttribute("id", id);
//		return "_04_favoriteList";
//	}

//	// 追蹤清單
//	@SuppressWarnings("rawtypes")
//	@PostMapping(value = "/quereyFavorite")
//	@ResponseBody
//	public List<Query> quereyFavorite(Integer FK_Customer_ID, Model model) {
//		List<Query> fb = productService.queryFavoriteProduct(FK_Customer_ID);
//		return fb;
//	}

}