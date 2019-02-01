package Library;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		
		System.out.println("====Test Started====");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("m.tauseef@progos.org", "Xabialonso14"));
		email.setSSLOnConnect(true);
		email.setFrom("m.tauseef@progos.org");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("humna.malik@progos.org");
		email.send();
		
		System.out.println("====Email Sent====");

	}

}
