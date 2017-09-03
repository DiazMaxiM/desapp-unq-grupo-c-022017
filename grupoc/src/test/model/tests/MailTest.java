package tests;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import model.Mail;

public class MailTest {

	@Test
	public void test() throws EmailException {
		Mail mail = new Mail().getInstance();
		mail.send("diazmaxi@gmail.com", "hola2", "Hola Maxi2");
	}

}
