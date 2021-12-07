package j16.t03.springboot.m.entity._05_customer;

import javax.persistence.Column;
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
@Table(name = "CitySelect")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitySelectBean {
	
	@Column(name = "id", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String groupCity;
	String sortCity;
	String city;

}