package j16.t03.springboot.m.repository;

import javax.mail.MessagingException;

import j16.t03.springboot.m.entity.JavaMail;

public interface MailSender {

//	傳入信箱資料
	public void sendRservationInformMail(JavaMail mail) throws MessagingException ;

}