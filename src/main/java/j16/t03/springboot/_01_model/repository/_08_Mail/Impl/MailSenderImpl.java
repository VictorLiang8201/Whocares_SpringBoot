package j16.t03.springboot._01_model.repository._08_Mail.Impl;

import javax.mail.MessagingException;

import j16.t03.springboot._01_model.entity._08_Mail.JavaMail;
import j16.t03.springboot._01_model.repository._08_Mail.MailSender;

public class MailSenderImpl implements MailSender {

	JavaMail javamail;			
	
	public MailSenderImpl(JavaMail javamail) {		
		this.javamail = javamail;
	}

//	傳入信箱資料
	@Override
	public void sendRservationInformMail(JavaMail mail) throws MessagingException {
		javamail.sendMail();
	}

}