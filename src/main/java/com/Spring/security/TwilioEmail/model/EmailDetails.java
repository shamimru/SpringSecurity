package com.Spring.security.TwilioEmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
	private EmailInfo fromAddress;
	private EmailInfo toAddress;
	private String subject;
	private String emailBody;

}
