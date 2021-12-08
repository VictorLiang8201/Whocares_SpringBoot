package j16.t03.springboot._01_model.entity._04_shop;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import j16.t03.springboot._01_model.entity._02_customerService.CommentBean;
import j16.t03.springboot._01_model.entity._02_customerService.PromotionBean;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer prodId;// 商品編號
	private String classify;// 租買分類
	private String prodName;// 商品名稱
	private Double price;// 商品售價
	private Blob coverImage1;// 圖片1
	private Blob coverImage2;// 圖片2
	private Blob coverImage3;// 圖片3
	private String mimeType;// 圖片類型
	private String mimeType2;// 圖片類型
	private String mimeType3;// 圖片類型
	private Integer stock;// 庫存數量
//	private String prodType;// 商品分類代碼 --ProductTypeBean取代此建構子--
	private String fileName;// 圖片名稱
	private String fileName2;// 圖片名稱
	private String fileName3;// 圖片名稱
	private Clob description;// 商品敘述
//	private Integer promoteId;// 活動編號

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PRODUCT_PRODTYPE_FK")
	private ProductTypeBean productTypeBean;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PRODUCT_PROMOTEID_FK")
	PromotionBean promotionBean;

	@OneToMany(mappedBy = "productBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<BuyItemBean> buyItems = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "productBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<CommentBean> comments = new LinkedHashSet<>();

	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "favorite",  
//        joinColumns = {   // 在Join Table中，儲存本類別之主鍵值的外鍵欄位名稱
//            @JoinColumn(name = "FK_Product_ID", referencedColumnName = "prodId") 
//        }, 
//        inverseJoinColumns = { // 在Join Table中，儲存對應對照類別之主鍵值的外鍵欄位名稱
//            @JoinColumn(name = "FK_Customer_ID",    referencedColumnName = "custId") 
//        }
//    )

//	private Set<CustomerBean> custmers = new HashSet<CustomerBean>(0);
	

}