package j16.t03.springboot.m.entity._02_customerService;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

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
@Table(name = "Dm")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DmBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dmId;
	private String dmName;
	private String category;
	private Blob dmImage;
	private String mimeType;
	@Column(columnDefinition = "datetime")	
	private Timestamp addDate;
	private String dmdate;
	
}