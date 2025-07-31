package com.springboot.Quitq_ecommerce_proj.Security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTutil {
	
	private final long EXPIRATION_TIME = 1000 * 60 * 60;
	private final String SECRET_KEY ="MySuperSecretKeyForJwtMySuperSecretKeyForJwt";
	
	private Key getsigningkey()
	{
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public String generateToken(String Username)
	{
		return Jwts.builder()
				.setSubject(Username)
				.setIssuer("QuitQApp")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(getsigningkey())
				.compact();
	}
	
	public String extractUsername(String token)
	{
		return Jwts.parserBuilder()
				.setSigningKey(getsigningkey())
				.build().parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public Boolean validateToken(String token)
	{
		try {
			
			Jwts.parserBuilder().setSigningKey(getsigningkey()).build().parseClaimsJws(token);
			return true;
		}
		
		catch(JwtException e){
			return false;
		}
		
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
	    final String username = extractUsername(token);
	    return (username.equals(userDetails.getUsername()) && validateToken(token));
	}

}
