package j16.t03.springboot.m.repository._08_Mail;

import javax.mail.MessagingException;

import j16.t03.springboot.m.entity._08_Mail.JavaMail;

public interface MailSender {

//	傳入信箱資料
	public void sendRservationInformMail(JavaMail mail) throws MessagingException ;

}