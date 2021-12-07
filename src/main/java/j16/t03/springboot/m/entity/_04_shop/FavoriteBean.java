package j16.t03.springboot.m.entity._04_shop;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="favorite")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer FavoriteID;
	private Integer FK_Customer_ID;
	private Integer FK_Product_ID;
	
}