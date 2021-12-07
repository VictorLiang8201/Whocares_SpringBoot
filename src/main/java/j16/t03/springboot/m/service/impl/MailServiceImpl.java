package j16.t03.springboot.m.service.impl;

import javax.mail.MessagingException;

import j16.t03.springboot.m.entity.JavaMail;
import j16.t03.springboot.m.repository.MailSender;
import j16.t03.springboot.m.service.MailService;


//@Transactional
//@Service
public class MailServiceImpl implements MailService{

	MailSender mailSender;
	
//	@Autowired
	public MailServiceImpl(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendRservationInformMail(JavaMail mail) throws MessagingException {
		mailSender.sendRservationInformMail(mail);
	}
	
}