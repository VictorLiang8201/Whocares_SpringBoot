package j16.t03.springboot._01_model.entity._03_rent;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import j16.t03.springboot._01_model.entity._02_customerService.CommentBean;
import j16.t03.springboot._01_model.entity._02_customerService.PromotionBean;
import j16.t03.springboot._01_model.entity._03_rent.pkClass.RentProductPK;
import j16.t03.springboot._01_model.entity._07_productType.ProductTypeBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RentProduct")
@IdClass(RentProductPK.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentProductBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer prodId;
	@Id
	private String serialNumber;
	private String classify;
	private String prodName;
	private Double price;
	private Blob coverImage1;
	private Blob coverImage2;
	private Blob coverImage3;
	private String mimeType;
	private String mimeType2;
	private String mimeType3;
	private Integer stock;
	private String fileName;
	private String fileName2;
	private String fileName3;
	private Clob description;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "RENTPROD_PROMOTEID_FK")
	private PromotionBean promotionBean;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "RENTPROD_PRODTYPE_FK")
	private ProductTypeBean productTypeBean;

	@OneToMany(mappedBy = "rentProductBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<RentItemBean> rentItems = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "rentProductBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<ReservationBean> reservations = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "rentProductBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<CommentBean> comments = new LinkedHashSet<>();

}