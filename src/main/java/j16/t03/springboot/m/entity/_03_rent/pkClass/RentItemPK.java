package j16.t03.springboot.m.entity._03_rent.pkClass;

import java.io.Serializable;

import javax.persistence.Embeddable;

import j16.t03.springboot.m.entity._06_order.pkClass.OrdPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private OrdPK ordPK;
	private Integer prodSerialNum;

}