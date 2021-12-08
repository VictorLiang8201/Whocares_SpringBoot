package j16.t03.springboot._01_model.service._04_shop;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;

public interface ProductService {

	// 讀取多筆產品資料
	List<ProductBean> findAll();
	
	// 讀取多筆產品資料並排序
	List<ProductBean> findAll(Sort sort);

	// 依分頁讀取多筆產品資料
	Page<ProductBean> findAll(Pageable pageable);

	// 依ProdType表格主鍵 載入分類的產品並分頁、排序
	Page<ProductBean> findByProductTypeBean(ProductTypeBean productTypeBean, Pageable pageable);

//	// 計算分類的商品總共有幾頁
//	int getTotalPagesByProdType(ProductTypeBean prodTypeBean);

	// 更新庫存
	void updateStock(int productId, int newQuantity);

	// 依主鍵讀取單筆產品資料
	public ProductBean getById(int prodId);
	
//	//抓取該商品目前租賃評論資料
//		public List<CommentBean> getCommentBeanByprodId(int prodId) ;

	// 新增單筆產品資料
	void save(ProductBean product);

//	// 新增我的最愛
//	Object addFavorite(FavoriteBean favoriteBean);

//	// 讀取多筆我的最愛
//	List<FavoriteBean> queryFavorite(int productId, int newQuantity);
	
//	// 刪除我的最愛
//	void deleteFavorite(FavoriteBean favoriteBean);
//	List<FavoriteBean> getFavorite(Integer FK_Customer_ID);
	
//	//依追蹤清單的產品ID 搜尋產品細項
//	@SuppressWarnings("rawtypes")
//	List<Query> queryFavoriteProduct(Integer FK_Customer_ID);
	
//	// 依傳入大分類代號取出該分類代號之名稱	
//		public List<ProductTypeBean> getProductTypeBeanBymaincategory(String maincategory);
	
}