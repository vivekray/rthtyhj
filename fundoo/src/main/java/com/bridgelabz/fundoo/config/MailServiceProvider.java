package com.bridgelabz.fundoo.config;
//package com.fundoo.config;
//
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Component;
//
////@Component
//public class MailServiceProvider {
//	
//	@Autowired
//	private static JavaMailSender javaMailSender;
//	//private static JavaMailSender javaMailSender = new JavaMailSenderImpl();
//	
//	public MailServiceProvider() {
//		
//	}
//
//	public  void sendEmail(String toEmail, String subject, String body) {
//
//		String fromEmail = "bridgelab123@gmail.com";
//		String password =  "Bridgelab@123";
//
//		Properties prop = new Properties();
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.starttls.enable", "true");
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.port", "587");
//
//		Authenticator auth = new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(fromEmail, password);
//			}
//		};
//		Session session = Session.getInstance(prop, auth);
//		send(session, fromEmail, toEmail, subject, body);
//	}
//
//	private  void send(Session session, String fromEmail, String toEmail, String subject, String body) {
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(fromEmail, "VivekRay"));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			message.setSubject(subject);
//			message.setText(body);
//			Transport.send(message);
//			 //javaMailSender.send(message);
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("exception occured while sending mail");
//
//		}
//	}
//}