package j16.t03.springboot._01_model.entity._05_customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 登出時需要做的事寫在這裡，如session.invalidate()
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogoutBean {
	
	private static Logger log = LoggerFactory.getLogger(LogoutBean.class);
	HttpSession session;

	public Integer getLogout() {
		CustomerBean cb = (CustomerBean)session.getAttribute("LoginOK");
		String userAccount = null;
		if (cb != null) {
			userAccount = cb.getAccount();
		} 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.info("使用者:" + userAccount + "已於 " + sdf.format(new Date())  + " 登出...");
		session.invalidate();
		return 0;
	}
	
}