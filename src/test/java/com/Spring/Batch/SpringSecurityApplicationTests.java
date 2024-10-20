package com.Spring.Batch;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

@SpringBootTest
@ContextConfiguration(classes = {SpringSecurityApplicationTests.class})

class SpringSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void createSecreteGeneration() {
		SecretKey secretKey = Jwts.SIG.HS512.key().build();
		String printHexBinary = DatatypeConverter.printHexBinary(secretKey.getEncoded());
		System.out.println("\n key is " + printHexBinary);
	}

}
