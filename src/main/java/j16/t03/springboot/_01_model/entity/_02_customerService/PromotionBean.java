package j16.t03.springboot._01_model.entity._02_customerService;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import j16.t03.springboot._01_model.entity._03_rent.RentItemBean;
import j16.t03.springboot._01_model.entity._03_rent.RentProductBean;
import j16.t03.springboot._01_model.entity._04_shop.BuyItemBean;
import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Promotion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT(8) ZEROFILL")
	private Integer promoteId;
	private String promotion;
	private String promoContent;
	private String promoTag;
	@Column(columnDefinition = "datetime")
	private Timestamp promoStartDate;
	@Column(columnDefinition = "datetime")
	private Timestamp promoEndDate;
	private String discountCode;
	private Double discount;

	@OneToMany(mappedBy = "promotionBean", cascade = CascadeType.ALL)
	@Builder.Default
	@JsonIgnore
	Set<RentItemBean> rentItems = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "promotionBean", cascade = CascadeType.ALL)
	@Builder.Default
	@JsonIgnore
	Set<RentProductBean> rentProducts = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "promotionBean", cascade = CascadeType.ALL)
	@Builder.Default
	@JsonIgnore
	Set<ProductBean> products = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "promotionBean", cascade = CascadeType.ALL)
	@Builder.Default
	@JsonIgnore
	Set<BuyItemBean> buyItems = new LinkedHashSet<>();

}