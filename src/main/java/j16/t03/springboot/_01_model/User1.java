package j16.t03.springboot._01_model;

import javax.mail.MessagingException;

import j16.t03.springboot._01_model.entity._08_Mail.JavaMail;

public class User1 {

	public static void main(String[] args) throws MessagingException {
		JavaMail mail = new JavaMail("java016030924@gmail.com","odoayywtzmaexumf",
				"使用者名稱@gmail.com","1測試信件","嗨華晏 請問您您您有看到嘛! This is a test Mail!");
		mail.sendMail();
	}

}