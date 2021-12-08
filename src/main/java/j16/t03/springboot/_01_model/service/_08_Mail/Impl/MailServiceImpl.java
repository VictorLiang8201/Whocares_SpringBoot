package j16.t03.springboot._01_model.service._08_Mail.Impl;

import javax.mail.MessagingException;

import j16.t03.springboot._01_model.entity._08_Mail.JavaMail;
import j16.t03.springboot._01_model.repository._08_Mail.MailSender;
import j16.t03.springboot._01_model.service._08_Mail.MailService;


public class MailServiceImpl implements MailService {

	MailSender mailSender;
	
	public MailServiceImpl(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendRservationInformMail(JavaMail mail) throws MessagingException {
		mailSender.sendRservationInformMail(mail);
	}
	
}