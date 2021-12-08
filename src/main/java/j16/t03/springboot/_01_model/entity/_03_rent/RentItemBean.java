package j16.t03.springboot._01_model.entity._03_rent;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import j16.t03.springboot._01_model.entity._03_rent.pkClass.RentItemPK;
import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import j16.t03.springboot._01_model.entity._06_order.OrdBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RentItem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentItemBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RentItemPK rentItemPK;

	private Integer rentPeriod;				//租賃天數
	private Integer prodQty;				//租賃數量(預設1)
	@Column(columnDefinition = "datetime")	
	private Date startDate;			//租賃起始日
	@Column(columnDefinition = "datetime")
	private Date returnDate;				//租賃結束日
	private Double prodTotal;				//金額小計
	private String rentStatus;				//租賃設備的狀態(可出租/租賃中)

	@MapsId("OrdPK")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumns({ @JoinColumn(name = "category", referencedColumnName = "category"),
			@JoinColumn(name = "ordId", referencedColumnName = "ordId"), })
	private OrdBean ordBean;

	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "RENTITEM_PROMOTEID_FK")
	private PromotionBean promotionBean;

	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "RENTITEM_RENTPRODID_FK"), @JoinColumn(name = "RENTITEM_RENTPRODSN_FK"), })
	private RentProductBean rentProductBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RENTITEM_COMMENTID_FK")
	private CommentBean commentBean;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RENTITEM_PRODID_FK")
	private ProductBean productBean;

}