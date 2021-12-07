package j16.t03.springboot.m.entity._06_order;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import j16.t03.springboot.m.entity._02_customerService.ProblemBean;
import j16.t03.springboot.m.entity._03_rent.RentItemBean;
import j16.t03.springboot.m.entity._04_shop.BuyItemBean;
import j16.t03.springboot.m.entity._05_customer.CustomerBean;
import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
@Entity
@Table(name = "Ord")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId	
	private OrdPK ordPK;			//訂單編號(種類/編號)
	
	@Column(columnDefinition = "datetime")
	private Timestamp orderDate;	//訂單日期
	private String reciName;		//收件人姓名
	private String reciCity;		//收件人城市
	private String reciAddress;		//收件人地址
	private String reciPhone;		//收件人電話
	private Double ordTotal;		//訂單金額
	private String delivery;		//宅配方式
	private String payment;			//付款方式
	private String discountCode;	//折扣碼
	private Double discount;		//折扣金額
	private String orderStatus;		//訂單處理狀態
	@Column(columnDefinition = "datetime")
	private Timestamp shipDate;		//宅配到貨日
	private Clob orderMark;			//備註
	private String payPayment;		//金流串接Html
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ORD_CUSTID_FK")
	private CustomerBean customerBean;

	@OneToMany(mappedBy = "ordBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Builder.Default
	Set<RentItemBean> rentItems = new LinkedHashSet<>();

	@OneToMany(mappedBy = "ordBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Builder.Default
	Set<ProblemBean> problem = new LinkedHashSet<>();

	@OneToMany(mappedBy = "ordBean", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@Builder.Default
	Set<BuyItemBean> buyItems = new LinkedHashSet<>();

}