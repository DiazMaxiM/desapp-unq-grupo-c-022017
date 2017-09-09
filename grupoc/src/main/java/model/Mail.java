package model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mail {

	private static Mail instance = null;
	private SimpleEmail mail = new SimpleEmail();

	public Mail() throws EmailException {
		mailConfiguration();

	}

	private void mailConfiguration() throws EmailException {
		mail.setHostName("smtp.gmail.com");
		// mail.setTLS(true);
		mail.setStartTLSEnabled(true);
		mail.setSmtpPort(587);
		// mail.setSSL(true);
		mail.setSSLOnConnect(true);
		mail.setAuthentication("MorfiYa2017@gmail.com", "2017Morf");
		mail.setFrom("MorfiYa2017@gmail.com");
	}

	public Mail(SimpleEmail email) throws EmailException {
		this.mail = email;
		mailConfiguration();

	} 

	public Mail getInstance() throws EmailException {
		if (instance == null) {
			instance = new Mail();
		}
		return instance;
	} 

	public void send(String to, String subject, String mensagge) throws EmailException {
		mail.addTo(to);
		mail.setSubject(subject);
		mail.setMsg(mensagge);
		mail.send(); 
	}

	public void sendMailDisabledProvider(String userEmailAddress) throws EmailException {
		this.send(userEmailAddress, "Proveedor Inactivo", "Estimado Usuario su cuenta a sido inhabilitada");
	}

	public void sendMailClientBuy(String userEmailAddress) throws EmailException {
		this.send(userEmailAddress, "Compra Exitosa", "Estimado Usuario su compra fue realizada con exito.");
	}

	public void sendMailProviderSale(String userEmailAddress) throws EmailException {
		this.send(userEmailAddress, "Venta Exitosa", "Estimado Usuario se realizo una venta de uno de sus menues.");
	}

	public void sendMailConfirmSaleProvider(String email) throws EmailException {
		this.send(email, "Venta Confirmada", "Estimado Usuario se confirmo una venta de uno de sus menues.");

	}

	public void sendMailConfirmSaleClient(String email) throws EmailException {
		this.send(email, "Compra Confirmada", "Estimado Usuario se confirmo su compra.");

	}

	public void sendMailCancelSaleProvider(String email) throws EmailException {
		this.send(email, "Venta Cancelada", "Estimado Usuario se Cancelo una de sus ventas.");

	}

	public void sendMailCancelSaleClient(String email) throws EmailException {
		this.send(email, "Compra Cancelada", "Estimado Usuario se cancelo su compra.");

	}
}
