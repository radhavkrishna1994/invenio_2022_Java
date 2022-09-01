package com.client;

//File Name SendEmail.java

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
public boolean sendEmail(String to,String from,String subject,String text)
{    
	boolean status=false;
   // Recipient's email ID needs to be mentioned.
  // String to = "saankhya2003@gmail.com";

   // Sender's email ID needs to be mentioned
   //String from = "radhavkrishna1994@gmail.com";

   // Assuming you are sending email from localhost
   String host = "smtp.gmail.com";

   // Get system properties
   Properties props = System.getProperties();

   // Setup mail server
   props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");

   // Get the default Session object.
   Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {

       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication("radhavkrishna1994","----");
       }
   });

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject(subject);

      // Now set the actual message
      message.setText(text);

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
      status=true;
   }catch (MessagingException mex) {
      mex.printStackTrace();
      
   }
   finally{
	   return status;
   }
}
}