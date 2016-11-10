package com.indochino.mail;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.net.ssl.SSLSocketFactory;;

public class MailClient {
	
	public String sendNotification(String to, 
								String from, 
								String user, 
								String password,
								int port,
								String host,
								String protocol,
								String severity,
								String exception_message,
								String source,
								String summary){
		
		String content = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>" +
				"<html xmlns='http://www.w3.org/1999/xhtml'>" +
					"<head>" +
						"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />" +
						"<title>Notification Failure Email</title>" +
						"<meta name='viewport' content='width=device-width, initial-scale=1.0'/>" +
				"</head>" +
				"<body>" +
					"<table border='0' cellpadding='0' cellspacing='0' width='100%'>" +
						"<tr>" +
							"<td>" +
								"<h3>Severity:</h3>" +
							"</td>" +
							"<td style='color: #ff0000'>" +
								severity +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" +
								"<h3>Message:</h3>" +
							"</td>" +
							"<td>" +
								exception_message +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" +
								"<h3>Source:</h3>" +
							"</td>" +
							"<td>" +
								source +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" +
								"<h3>Summary:</h3>" +
							"</td>" +
							"<td>" +
								summary +
							"</td>" +
					"	</tr>" +
					"</table>" +
				"</body>" +
			"</html>";
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.user", user);
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.transport.protocol", protocol);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.socketFactory.port", port);
		prop.put("mail.smtp.socketFactory.class", SSLSocketFactory.class);
		prop.put("mail.smtp.socketFactory.fallback", false);
				
		Session session = Session.getDefaultInstance(prop);
	
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, to);
			message.setSubject("Google Product Feed Failure Notification");
			message.setContent(content, "text/html");
			
			Transport transport = session.getTransport();
			transport.connect(user, password);
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Notification sent.....");
			
		} catch (MessagingException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
	
}
