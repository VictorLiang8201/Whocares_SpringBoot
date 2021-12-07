package j16.t03.springboot.m.entity._02_customerService;

import java.io.Serializable;
import java.sql.Blob;
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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import j16.t03.springboot.m.entity._05_customer.CustomerBean;
import j16.t03.springboot.m.entity._06_order.OrdBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Problem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replyId;
	private String ordId;
	private String email;
	private String phone;
	private String problemType;
	private String content;
	@Column(columnDefinition = "datetime")
	private Timestamp formDate;
	private String processState;
	@Column(columnDefinition = "datetime")
	private Timestamp replyDate;
	private String replyContent;
	private Blob attachFile;
	String fileName; // 圖片名稱
	String account;  //帳號
	@Transient
	MultipartFile ImageUs;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PROBLEM_CUSTID_FK")
    CustomerBean customerBean;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumns({
		@JoinColumn(name = "PROBLEM_ORDCID_FK"),
		@JoinColumn(name = "PROBLEM_ORDID_FK"),
		})
	private OrdBean ordBean;

}