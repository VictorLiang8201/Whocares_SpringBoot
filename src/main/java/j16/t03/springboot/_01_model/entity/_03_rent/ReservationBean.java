package j16.t03.springboot._01_model.entity._03_rent;

import java.io.Serializable;
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

import j16.t03.springboot._01_model.entity._05_customer.CustomerBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Reservation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT(8) ZEROFILL")
	private Integer reservationId;
	private String category;
	private Integer waitNum;
	private String classify;
	private Integer waitType;
	@Column(columnDefinition = "datetime")
	private Timestamp reserveDate;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumns({
		@JoinColumn(name = "RESERVE_PRODID_FK"),
		@JoinColumn(name = "RESERVE_PRODSN_FK"),
		})
	private RentProductBean rentProductBean;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "RESERVE_CUSTID_FK")
	private CustomerBean customerBean;

}