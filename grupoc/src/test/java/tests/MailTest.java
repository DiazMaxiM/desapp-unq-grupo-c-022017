package tests;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import org.mockito.Mockito;

import model.Mail;

public class MailTest {

	@Test
	public void test() throws EmailException {
		SimpleEmail email = Mockito.mock(SimpleEmail.class);

		Mail mail = new Mail(email);
		mail.send("a@a.com", "hola", "Hola");
		Mockito.verify(email).addTo("a@a.com");
		Mockito.verify(email).setSubject("hola");
		Mockito.verify(email).setMsg("Hola");
		Mockito.verify(email).send();

	}

}
