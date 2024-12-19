package com.mailSender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class MailSendrApp {
	
	public void mailSender(String csvPath, String attPath, String message, String subject, final String from, final String pass) throws FileNotFoundException {

		
		String filePath=csvPath;
		ArrayList<String> email=new ArrayList<String>();
		if(!csvPath.equals("")) {
		File csvFile=new File(filePath);
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(csvFile);
		
//	     sc.useDelimiter(",");
	     while(sc.hasNext()) {
	    	 email.add(sc.next());
	     }
		}
	
		String host="smtp.gmail.com";
		
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
//		Path of Attchment
		
		MimeMessage m = new MimeMessage(session);
		MimeMultipart m1=new MimeMultipart();
		MimeBodyPart textMessage=new MimeBodyPart();
		
		if(attPath!=null) {
			MimeBodyPart fileMessage=new MimeBodyPart();
			String path=attPath;
			File file=new File(path);
			try {
				fileMessage.attachFile(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "File not found !");
				e.printStackTrace();
			} 
			try {
				m1.addBodyPart(fileMessage);
			} catch (MessagingException e) {
				JOptionPane.showMessageDialog(null, "Enter a valid message");
				e.printStackTrace();
			}
			}
			try {
				textMessage.setText(message);
				
				m1.addBodyPart(textMessage);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		
		try {
		
		m.setFrom(from);
		
		InternetAddress[] address = new InternetAddress[email.size()];
		for (int i = 0; i < email.size(); i++) {
		    address[i] = new InternetAddress(email.get(i));
		}
		m.addRecipients(Message.RecipientType.TO, address);
		m.setSubject(subject);
		m.setContent(m1);
		
		Transport.send(m);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
