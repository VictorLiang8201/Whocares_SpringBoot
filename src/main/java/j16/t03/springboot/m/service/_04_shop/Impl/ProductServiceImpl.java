package j16.t03.springboot.m.service._04_shop.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import j16.t03.springboot.m.entity._04_shop.ProductBean;
import j16.t03.springboot.m.entity._07_productType.ProductTypeBean;
import j16.t03.springboot.m.repository._04_shop.ProductRepository;
import j16.t03.springboot.m.service._04_shop.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

//	取得所有商品
	@Override
	public List<ProductBean> findAll() {
		return productRepository.findAll();
	}
	
//	讀取多筆產品資料並排序
	@Override
	public List<ProductBean> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

//	透過頁碼取得商品
	@Override
	public Page<ProductBean> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
//	透過頁碼以及產品類別取得商品並排序
	@Override
	public Page<ProductBean> findByProductTypeBean(ProductTypeBean productTypeBean, Pageable pageable) {
		return productRepository.findByProductTypeBean(productTypeBean, pageable);
	}

////	透過產品類別取得總頁數
//	@Override
//	public int getTotalPagesByProdType(ProductTypeBean prodTypeBean) {
//		return productRepository.getTotalPagesByProdType(prodTypeBean);
//	}

	@Override
	public void updateStock(int productId, int newQuantity) {
	}

	@Override
	public ProductBean getById(int prodId) {
		return productRepository.getById(prodId);
	}

	
//	//抓取該商品目前租賃評論資料
//	@Override
//	public List<CommentBean> getCommentBeanByprodId(int prodId) {
//		return productRepository.getCommentBeanByprodId(prodId);
//	}
	
	// 新增&修改商品
	@Override
	public void save(ProductBean product) {
		productRepository.save(product);
	}

//	// 新增追蹤項目
//	@Override
//	public Object addFavorite(FavoriteBean favoriteBean) {
//		return productRepository.addFavorite(favoriteBean);
//	}

//	// 查詢追蹤項目
//	@Override
//	public List<FavoriteBean> queryFavorite(int productId, int newQuantity) {
//		return productRepository.queryFavorite(productId, newQuantity);
//	}

//	// 刪除追蹤項目
//	@Override
//	public void deleteFavorite(FavoriteBean favoriteBean) {
//		productRepository.deleteFavorite(favoriteBean);
//	}

//	@Override
//	public List<FavoriteBean> getFavorite(Integer FK_Customer_ID) {
//		return productRepository.getFavorite(FK_Customer_ID);
//	}

//	@Override
//	@SuppressWarnings("rawtypes")
//	public List<Query> queryFavoriteProduct(Integer FK_Customer_ID) {
//		return productRepository.queryFavoriteProduct(FK_Customer_ID);
//	}
	
//	// 依傳入大分類代號取出該分類代號之名稱	
//		@Override
//		public List<ProductTypeBean> getProductTypeBeanBymaincategory(String maincategory) {
//			
//			return productRepository.getProductTypeBeanBymaincategory(maincategory);
//		}
		
}