package j16.t03.springboot.m.entity._02_customerService.usPKClass;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemBeanPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer replyId;

}