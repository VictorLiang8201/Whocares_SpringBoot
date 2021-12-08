package j16.t03.springboot._01_model.entity._02_customerService;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import j16.t03.springboot._01_model.entity._03_rent.RentProductBean;
import j16.t03.springboot._01_model.entity._04_shop.ProductBean;
import j16.t03.springboot._01_model.entity._05_customer.CustomerBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Comment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT(8) ZEROFILL")
	private Integer commentId;
	private String classify;
	private Integer rate;
	private Integer visits;
	private Timestamp commentDate;
	private Clob comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "COMMENT_RENTPRODID_FK"),
		@JoinColumn(name = "COMMENT_RENTPRODSN_FK"),
		})
	private RentProductBean rentProductBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMMENT_CUSTID_FK")
	private CustomerBean customerBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMMENT_PRODID_FK")
	private ProductBean productBean;

}