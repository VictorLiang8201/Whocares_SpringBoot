package j16.t03.springboot.m.service._08_Mail;

import javax.mail.MessagingException;

import j16.t03.springboot.m.entity._08_Mail.JavaMail;

public interface MailService {

	//	傳入信箱資料
	void sendRservationInformMail(JavaMail mail) throws MessagingException;
}