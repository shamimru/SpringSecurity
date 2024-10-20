package com.Spring.security.webToken;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET="7B2686AED1BDEC158073C3E39E4681C7A6B89532F092A259BDAA1CB08882E2C61E607B74F0975D255687ED86D2E757233AF30CE4F7841175D56D4C7E3FF971C9";
	private static final long VALIDITY= TimeUnit.MINUTES.toMillis(30);
	
	public String generateToken(UserDetails userDetails) {
		
		Map<String, String> claims=new HashMap<>();
		
		claims.put("ias", "www.shamim.com");
		claims.put("user", userDetails.getUsername());
		
		return Jwts.builder()
				
		.claims(claims)
		.subject(userDetails.getUsername())
		.issuedAt(Date.from(Instant.now()))
		.expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
		.signWith(generateKey())
		.compact();
		
	}
	
	public SecretKey generateKey() {
		byte[] decodedKey = Base64.getDecoder().decode(SECRET);
		return Keys.hmacShaKeyFor(decodedKey);
		 
	}
	
	public  String extractUsername(String jwt) {
		Claims claims = Jwts.parser()
		.verifyWith(generateKey())
		.build()
		.parseSignedClaims(jwt)
		.getPayload();
		return claims.getSubject();
	}
	public  Claims getClaims(String jwt) {
		return Jwts.parser()
		.verifyWith(generateKey())
		.build()
		.parseSignedClaims(jwt)
		.getPayload();
	}

	public boolean isTokenValid(String jwt) {
		// TODO Auto-generated method stub
		Claims claims=getClaims(jwt);
		return claims.getExpiration().after(Date.from(Instant.now()));
	}

}
