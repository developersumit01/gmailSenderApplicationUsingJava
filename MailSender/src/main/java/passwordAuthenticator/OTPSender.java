package passwordAuthenticator;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public final class OTPSender {
	private OTPSender() {
		
	}
	public static String otpSend() {
			String otp=new DecimalFormat("000000").format(new Random().nextInt(999999));
		return otp;
	}
	public static void oTPSender(String Subject,String oTP,final String from,final String pass,String to) {

		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication(from, pass);
			}
		});
		
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(Subject);
	
		
		//adding text to message
		m.setText(oTP);
		
		//send 
	
		Transport.send(m);
		
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Password !");

		}
		
		
	}
	
}
