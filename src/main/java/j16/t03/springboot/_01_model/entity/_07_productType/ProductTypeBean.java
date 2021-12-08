package j16.t03.springboot._01_model.entity._07_productType;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import j16.t03.springboot._01_model.entity._03_rent.RentProductBean;
import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ProductType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String prodType; // 商品分類代碼 A~H商品種類
	private String prodName; // 分類名稱

	@OneToMany(mappedBy = "productTypeBean", cascade = { CascadeType.ALL })
	@Builder.Default
	private Set<RentProductBean> rentProducts = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "productTypeBean", cascade = { CascadeType.ALL })
	@Builder.Default
	private Set<ProductBean> product = new LinkedHashSet<>();

}