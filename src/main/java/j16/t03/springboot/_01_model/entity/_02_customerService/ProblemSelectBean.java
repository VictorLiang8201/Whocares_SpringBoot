package j16.t03.springboot._01_model.entity._02_customerService;

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
@Table(name = "ProblemSelect")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemSelectBean {

	@Column(name = "id", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String problemType;
	String qroupPb;
	String sortPb;
	
}