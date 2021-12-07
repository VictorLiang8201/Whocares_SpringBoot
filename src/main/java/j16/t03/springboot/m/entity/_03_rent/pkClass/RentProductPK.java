package j16.t03.springboot.m.entity._03_rent.pkClass;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentProductPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer prodId;
	private String serialNumber;

}