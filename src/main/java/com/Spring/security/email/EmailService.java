package com.Spring.security.email;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;

	public void sendMailWithAttachement(String toEmail, String body, String subject, String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage() ;
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		
		helper.setFrom("sahammeedd@gmail.com");
		helper.setTo(toEmail);
		helper.setText(body);
		helper.setSubject(subject);
		helper.setBcc("abc@gmail.com");
		FileSystemResource fileResource=new FileSystemResource(new File(attachment));
		helper.addAttachment(fileResource.getFilename(), fileResource);
		
		javaMailSender.send(mimeMessage);
		System.out.println("successfully send sms ");
		
	}
}
