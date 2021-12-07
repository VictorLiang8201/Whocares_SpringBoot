package j16.t03.springboot.m.repository.impl;

import javax.mail.MessagingException;

import j16.t03.springboot.m.entity.JavaMail;
import j16.t03.springboot.m.repository.MailSender;

//@Repository
public class MailSenderImpl implements MailSender {

	JavaMail javamail;			
	
//	@Autowired
	public MailSenderImpl(JavaMail javamail) {		
		this.javamail = javamail;
	}

	@Override
	public void sendRservationInformMail(JavaMail mail) throws MessagingException {
		
		javamail.sendMail();
	}
//	傳入信箱資料
	
}