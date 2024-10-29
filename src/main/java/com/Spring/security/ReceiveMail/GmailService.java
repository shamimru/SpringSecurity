package com.Spring.security.ReceiveMail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.InternetAddress;

@Service
public class GmailService {
	
	@Value("${spring.mail.imap.host}")
	private String host;

	@Value("${spring.mail.imap.port}")
	private String port;

	@Value("${spring.mail.imap.user}")
	private String username;

	@Value("${spring.mail.imap.password}")
	private String password;

	public void fetchEmails() {
		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", port);
		properties.put("mail.imap.ssl.enable", "true");

		try {
			Session session = Session.getInstance(properties);
			Store store = session.getStore("imaps");
			store.connect(host, username, password);

			// Access the inbox folder
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			// Fetch messages from the inbox
			Message[] messages = inbox.getMessages();
			System.out.println("Total Messages: " + messages.length);

			for (Message message : messages) {
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + InternetAddress.toString(message.getFrom()));
				System.out.println("Received Date: " + message.getReceivedDate());
				System.out.println("Content: " + message.getContent().toString());
				System.out.println("---------------------------------");
			}

			// Close the connections
			inbox.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
