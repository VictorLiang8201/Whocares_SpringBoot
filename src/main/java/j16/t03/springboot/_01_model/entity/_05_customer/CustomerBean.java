package j16.t03.springboot._01_model.entity._05_customer;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import j16.t03.springboot._01_model.entity._02_customerService.CommentBean;
import j16.t03.springboot._01_model.entity._02_customerService.ProblemBean;
import j16.t03.springboot._01_model.entity._03_rent.ReservationBean;
import j16.t03.springboot._01_model.entity._06_order.OrdBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT(8) ZEROFILL")
	Integer custId; // 會員編號
	String account; // 會員帳號
	String password; // 會員密碼
	String custName; // 會員姓名
	String nickName; // 暱稱
	String gender; // 性別
	String idNumber; // 會員身份證字號
	@Column(columnDefinition = "datetime")
	Date birthday; // 出生日期
	String phone; // 連絡電話
	String city; // 通訊城市
	String address; // 通訊地址
	String email; // 電子信箱
	Blob customerImage; // 會員圖片
	String fileName; // 圖片名稱
	String mimeType; // 圖片類型
	
	@Transient
	MultipartFile Image;

	@OneToMany(mappedBy = "customerBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<OrdBean> orders = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "customerBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<ReservationBean> reservations = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "customerBean", cascade = CascadeType.ALL)
	@Builder.Default
	Set<CommentBean> comments = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "customerBean", cascade = CascadeType.ALL )
	@Builder.Default
	Set<ProblemBean> problem = new LinkedHashSet<>();

}