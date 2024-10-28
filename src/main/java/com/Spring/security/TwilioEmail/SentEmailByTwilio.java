package com.Spring.security.TwilioEmail;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Spring.security.TwilioEmail.model.EmailDetails;
import com.Spring.security.TwilioEmail.model.EmailInfo;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SentEmailByTwilio {
	@Value("${spring.sendgrid.api-key}")
	private String sendGridApiKey;
	
	public String sendEmail( EmailDetails emailDetails) throws IOException {
		EmailInfo fromAddress = emailDetails.getFromAddress();
		Email fromEmail= setEmail(fromAddress.getName(), fromAddress.getEmailAddress());
		
		EmailInfo toAddress = emailDetails.getToAddress();

		Email toEmail= setEmail(toAddress.getName(), toAddress.getEmailAddress());
		Content content =new Content("text/plain",emailDetails.getEmailBody());
		
		Mail email= new Mail(fromEmail,emailDetails.getSubject(), toEmail,content);
		SendGrid grid=new SendGrid(sendGridApiKey);
		
		Request request =new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(email.build());
		
		grid.api(request);
		
		return "";
		
		

	}
	
	private Email setEmail (String name, String emailAddress) {
		
		
		Email email=new Email();
		email.setEmail(emailAddress);
		email.setName(name);
		return null;
	}

}