package j16.t03.springboot._01_model.entity._04_shop;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import j16.t03.springboot._01_model.entity._02_customerService.CommentBean;
import j16.t03.springboot._01_model.entity._02_customerService.PromotionBean;
import j16.t03.springboot._01_model.entity._04_shop.pkClass.BuyItemPK;
import j16.t03.springboot._01_model.entity._06_order.OrdBean;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BuyItem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyItemBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BuyItemPK buyItemPK;

	private Integer prodQTY; // 商品數量
	private Double itemSum; // 單項總額

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BUYTITEM_PRODTYPE_FK")
	private ProductTypeBean productTypeBean;

	@MapsId("OrdPK")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumns({ @JoinColumn(name = "category", referencedColumnName = "category"),
			@JoinColumn(name = "ordId", referencedColumnName = "ordId"), })
	private OrdBean ordBean;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUYTITEM_PROMOTEID_FK", referencedColumnName = "promoteId")
	private PromotionBean promotionBean;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BUYTITEM_PRODID_FK")
	private ProductBean productBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BUYITEM_COMMENTID_FK")
	private CommentBean commentBean;

}