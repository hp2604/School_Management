package com.vps.management.utils.jwt;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.HashMap;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtService {
	private SecretKey secretkey;
	private String key;
	
	public JwtService()
	{
		key=getSecretKey();
		
	}
	
	//Generate Secret Key
	private String getSecretKey()
	{
		try {
			KeyGenerator keyGen=KeyGenerator.getInstance("hmacSHA256");
			secretkey=keyGen.generateKey();
			return Base64.getEncoder().encodeToString(secretkey.getEncoded()); 
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error in generating secret key");
	
		}
	}
	
	

	// Generating JWT token
	public String generateToken(String schoolId) {
		Map<String ,Object> claims=new HashMap<>();
		return Jwts.builder()
				   .claims(claims)
				   .subject(schoolId)
				   .issuedAt(new Date(System.currentTimeMillis()))
				   .expiration(new Date(System.currentTimeMillis()+1000*60*60))
				   .signWith(getSignkey())
				   .compact();

	}
	
	// Generating Sign Key
	public Key getSignkey()
	{
		byte keyBytes[]=Decoders.BASE64.decode(key);
		return Keys.hmacShaKeyFor(keyBytes);
	}


	// Extract Username
	public String extractUsername(String token) {
		
		return extractClaim(token,Claims::getSubject);
	}
	
	
	// Extract Claim
	private <T> T extractClaim(String token, Function<Claims,T>claimResolver)
	{
		final Claims claims=extractClaims( token);
		return claimResolver.apply(claims);
	}
	
	
	// Extract All Claims
	private Claims extractClaims(String token)
	{
		return Jwts.parser()
				   .verifyWith(secretkey)
				   .build()
				   .parseSignedClaims(token)
				   .getPayload();
	}
	
	
	public Date extractExpiration(String token)
	{
		return extractClaim(token,Claims::getExpiration);
	}
	
	public boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	
	//Validation of Token
	public boolean validateToken(String token, UserDetails userdetail) {
		final String username=extractUsername(token);
		return username.equals(userdetail.getUsername() )&& !isTokenExpired(token);
	}

}
