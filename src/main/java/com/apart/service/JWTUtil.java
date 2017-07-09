package com.apart.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.apart.util.Helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private final int	 JWT_TOKEN_LIVE = 15;
	private final String JWT_ISSUER = "https://url5.xyz/";
	private final String JWT_SECRET = "yKEjhewHZ190Z4ZAswCLAP4AjD8yCGiI";
	
	public String generateTokenWithJWT(Long userId,String username){

		Date expDate = Helper.dateAddMinute(new Date(),JWT_TOKEN_LIVE);
		long iat = expDate.getTime() / 1000l; 
		long exp = iat + 10L; 

		HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("iss", JWT_ISSUER);
		claims.put("exp", exp); 
		claims.put("iat", iat);
		claims.put("username",username);
		claims.put("userId",userId);

		String compactJws = Jwts.builder()		 
		  //.setPayload(arg0)("Denem")
		  .setClaims(claims)		
		  .setHeaderParam("loginTime","")
		  .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
		  .compact();
		
		
		
		return compactJws;
	}
	
	public String parseToken(String token,String fieldName){
		String result = "-1";
		try {
		    JwtParser parser = Jwts.parser();
		    parser.setSigningKey(JWT_SECRET);		    
		    Jwt<JwsHeader,Claims> jwt = parser.parseClaimsJws(token);
		    
		    result = String.valueOf(jwt.getBody().getOrDefault(fieldName,"-1"));
		    
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			result = "-1"; 
		}
		return result;
	}
	public boolean verifyToken(String token){
		boolean valid = false;
		try {
		    JwtParser parser = Jwts.parser();
		    parser.setSigningKey(JWT_SECRET);		    
		    Jwt<JwsHeader,Claims> jwt = parser.parseClaimsJws(token);
		    
		    Date expDate = jwt.getBody().getExpiration();
		    Date now = new Date();
		    double diff = Helper.dateDifferent(now,expDate,Calendar.SECOND);
		    System.out.println("now..:" + now + " exp..:" + expDate +" diff..:" + diff);
		    valid = diff>0;
		    
		}catch (ExpiredJwtException e) {
			valid = false;
		}catch (Exception e) {
			Helper.errorLogger(getClass(), e,"[Token]:" + token);
		}
		return valid;
	}
}
